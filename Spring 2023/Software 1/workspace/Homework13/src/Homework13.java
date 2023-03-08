import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

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

    	NaturalNumber NINE = new NaturalNumber2(9);
    	int remainder, productInt = 1;
    	
        if (n.compareTo(NINE) == 1) {
        	remainder = n.divideBy10();
        	productInt = productInt * remainder;
        	productOfDigits1(n);
        }
        
        NaturalNumber product = new NaturalNumber2(productInt);
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
    	
    	NaturalNumber NINE = new NaturalNumber2(9);
    	NaturalNumber n2 = new NaturalNumber2(n);
    	int remainder, productInt = 1;
    	
        if (n.compareTo(NINE) == 1) {
        	remainder = n2.divideBy10();
        	productInt = productInt * remainder;
        	productOfDigits2(n2);
        }
        
        NaturalNumber product = new NaturalNumber2(productInt);
        
        
        return product;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
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
    }

}
