import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree2;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class Homework13 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework13() {
        // no code needed here
    }

    static final NaturalNumber NINE = new NaturalNumber2(9);

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        int remainder, productInt = 1;
        NaturalNumber product = new NaturalNumber2(1);

        if (n.compareTo(NINE) == 1) {
            remainder = n.divideBy10();
            productInt = productInt * remainder;
            product = new NaturalNumber2(productInt);
            product.multiply(productOfDigits1(n));
        } else {
            remainder = n.divideBy10();
            productInt = productInt * remainder;
            product = new NaturalNumber2(productInt);
        }

        n.clear();

        return product;
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {

        int remainder, productInt = 1;
        NaturalNumber product = new NaturalNumber2(1);
        NaturalNumber n2 = new NaturalNumber2(n);

        if (n.compareTo(NINE) == 1) {
            remainder = n2.divideBy10();
            productInt = productInt * remainder;
            product = new NaturalNumber2(productInt);
            product.multiply(productOfDigits1(n2));
        } else {
            remainder = n.divideBy10();
            productInt = productInt * remainder;
            product = new NaturalNumber2(productInt);
        }

        return product;
    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {

        if (n.canConvertToInt()) {
            return n.toInt();
        } else {
            return -1;
        }
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures <pre>
     * findTag =
     *    [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        boolean found = false;

        // the most inefficient loop, but i'm tired
        if (xml.numberOfChildren() > 0) {
            for (int i = 0; i < xml.numberOfChildren(); i++) {
                if (xml.child(i).label().equals(tag)) {
                    found = true;
                } else if (!found && xml.child(i).numberOfChildren() > 0) {
                    found = findTag(xml.child(i), tag);
                }
            }

        }

        return found;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        NaturalNumber x = new NaturalNumber2(44);
        NaturalNumber y = new NaturalNumber2(482);
        NaturalNumber z = new NaturalNumber2(35);

        System.out.println("Test 1");
        System.out.println("Expected: 16 and 44");
        System.out.println("Actual:   " + productOfDigits2(x) + " and " + x);

        System.out.println("Test 2");
        System.out.println("Expected: 64 and 482");
        System.out.println("Actual:   " + productOfDigits2(y) + " and " + y);

        System.out.println("Test 3");
        System.out.println("Expected: 15 and 35");
        System.out.println("Actual:   " + productOfDigits2(z) + " and " + z);

        System.out.println("Test 4");
        System.out.println("Expected: 16 and 0");
        System.out.println("Actual:   " + productOfDigits1(x) + " and " + x);

        System.out.println("Test 5");
        System.out.println("Expected: 64 and 0");
        System.out.println("Actual:   " + productOfDigits1(y) + " and " + y);

        System.out.println("Test 6");
        System.out.println("Expected: 15 and 0");
        System.out.println("Actual:   " + productOfDigits1(z) + " and " + z);

        x = new NaturalNumber2(44);
        y = new NaturalNumber2(482);
        z = new NaturalNumber2(35);

        System.out.println("Test 7");
        System.out.println("Expected: 44 and 44");
        System.out.println("Actual:   " + toInt(x) + " and " + x);

        System.out.println("Test 8");
        System.out.println("Expected: 482 and 482");
        System.out.println("Actual:   " + toInt(y) + " and " + y);

        System.out.println("Test 9");
        System.out.println("Expected: 35 and 35");
        System.out.println("Actual:   " + toInt(z) + " and " + z);

        XMLTree xml = new XMLTree2("https://www.yahoo.com/news/rss/");

        System.out.println("Test 10");
        System.out.println("Expected: true");
        System.out.println("Actual:   " + findTag(xml, "item"));

        System.out.println("Test 11");
        System.out.println("Expected: false");
        System.out.println("Actual:   " + findTag(xml, "sdmfnksdfiodwf"));

        System.out.println("Test 12");
        System.out.println("Expected: true");
        System.out.println("Actual:   " + findTag(xml, "title"));

        out.close();
    }

}
