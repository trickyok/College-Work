import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Gets input from user and square roots it using newton iteration.
 *
 * I wrote this before reading any of the instructions lol
 *
 * @author Gage Farmer
 *
 */
public final class Newton3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton3() {
    }

    static double epsilon = 0.0001;

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        boolean looping = true;

        System.out.print("Enter a value for EPSILON (Default = 0.0001): ");
        epsilon = in.nextDouble();

        while (looping) {
            printRoot(in, out);

            looping = askLoop(in, out);
        }

        in.close();
        out.close();
    }

    /**
     * Asks user if they want to continue.
     *
     * @param in
     *            input stream
     * @param out
     *            output stream
     * @return if the loop will continue or not
     */
    private static boolean askLoop(SimpleReader in, SimpleWriter out) {
        boolean res = false;

        System.out.print("Enter Y to calculate another square root: ");
        String ans = in.nextLine();

        if (ans.toLowerCase().equals("y")) {
            res = true;
        }

        return res;
    }

    /**
     * Gets number input from user.
     *
     * @param in
     *            input stream
     * @param out
     *            output stream
     * @return valid number
     */
    private static double getNumber(SimpleReader in, SimpleWriter out) {
        String input;
        double answer = -1.0;
        boolean invalid = true;

        System.out.println("Enter a number: ");
        input = in.nextLine();

        while (invalid) {
            if (FormatChecker.canParseInt(input)) {
                answer = Integer.parseInt(input);

                if (answer < 0) {
                    System.out.println("Enter a POSITIVE number: ");
                    input = in.nextLine();
                } else {
                    invalid = false;
                }
            } else if (!FormatChecker.canParseInt(input)) {
                System.out.println("Enter a NUMBER: ");
                input = in.nextLine();
            }
        }

        return answer;
    }

    /**
     * Computes estimate of square root of x to within relative error of 0.01%.
     *
     * @param x
     *            positive (or zero) number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double y = 1.0;

        if (x == 0) {
            return 0;
        }

        while (Math.abs(Math.pow(y, 2) - x) >= epsilon) {
            y = (y + (x / y)) / 2;
        }

        return y;
    }

    /**
     * Prints square root result.
     *
     * @param in
     *            input stream
     * @param out
     *            output stream
     */
    private static void printRoot(SimpleReader in, SimpleWriter out) {
        double num = getNumber(in, out);
        double answer = sqrt(num);

        System.out.println("The square root of " + num + " is " + answer);
    }

}
