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
public final class Hailstone1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                System.out.print(n);
            } else {
                n = (3 * n) + 1;
                System.out.print(n);
            }
        }

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

        System.out.print("Enter a positive integer: ");
        int n = in.nextInteger();
        generateSeries(n, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
