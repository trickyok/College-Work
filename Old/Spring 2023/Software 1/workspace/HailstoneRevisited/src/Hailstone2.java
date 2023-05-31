import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Hailstone2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone2() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        NaturalNumber len = new NaturalNumber1L(1);
        NaturalNumber one = new NaturalNumber1L(1);
        NaturalNumber two = new NaturalNumber1L(2);
        NaturalNumber three = new NaturalNumber1L(3);
        NaturalNumber temp = new NaturalNumber1L();
        NaturalNumber workVar = new NaturalNumber1L(n);

        // Hailstone series
        while (workVar.compareTo(one) != 0) {
            temp = new NaturalNumber1L(workVar);
            if (temp.divide(two).isZero()) {
                workVar.divide(two);
                System.out.print(workVar + " ");
            } else {
                workVar.multiply(three);
                workVar.add(one);
                System.out.print(workVar + " ");
            }

            // Length adder
            len.increment();
        }

        // output length, max
        System.out.println(" ");
        System.out.println("Length: " + len);
        return;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        System.out.print("Enter a number greater than 0: ");
        NaturalNumber num = new NaturalNumber1L(in.nextInteger());

        generateSeries(num, out);
        System.out.print("Original Value: " + num);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
