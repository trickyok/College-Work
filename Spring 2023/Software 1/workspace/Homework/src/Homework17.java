import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class Homework17 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework17() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("Hello World!");
        NaturalNumber testOne = new NaturalNumber2(3);
        NaturalNumber testTwo = new NaturalNumber2(2);
        out.println("Greater than: " + testOne.compareTo(testTwo));
        out.println("Less than: " + testTwo.compareTo(testOne));
        out.println("Equal to: " + testOne.compareTo(testOne));
        out.close();
    }

}
