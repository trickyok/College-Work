import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Generates Hailstone series from user input integer
 *
 * @author Gage Farmer
 *
 */
public final class Hailstone5 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone5() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     *
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int len = 1;
        int max = -1;

        // Hailstone series
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                System.out.print(n + " ");
            } else {
                n = (3 * n) + 1;
                System.out.print(n + " ");
            }

            // Length adder
            len++;

            // Max num calculator
            if (n > max) {
                max = n;
            }
        }

        // output length, max
        System.out.println(" ");
        System.out.println("Length: " + len);
        System.out.println("Maximum: " + max);
        return;
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {

        boolean validAnswer = false;
        System.out.println("Enter a positive integer: ");
        String input = in.nextLine();
        int n = -69;

        // checks to make sure input is valid
        while (!validAnswer) {
            // checks to make sure value is integer type
            if (FormatChecker.canParseInt(input)) {
                n = Integer.parseInt(input);

                // checks for positive integer
                if (n == 0) {
                    System.out.println("Zero doesn't count as positive");
                    System.out.println("Enter a positive integer: ");
                    input = in.nextLine();
                } else if (n < 0) {
                    System.out.println("I said a POSITIVE integer: ");
                    input = in.nextLine();
                } else {
                    validAnswer = true;
                }
                // gives user some sass for not following directions
            } else {
                System.out.println("That's not even a number");
                System.out.println("Enter a positive INTEGER: ");
                input = in.nextLine();
            }

        }

        return n;
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
        String ans = "y";

        // checks if user wants to keep generating serieses
        while (ans.toLowerCase().equals("y")) {

            int n = getPositiveInteger(in, out);

            generateSeries(n, out);

            System.out.println("Press Y to calculate another series: ");
            ans = in.nextLine();

        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
