import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program with implementation of some {@code NaturalNumber} secondary
 * operations implemented as static methods: increment, decrement, and
 * printWithCommas, toStringWithCommas.
 *
 * @author Put your name here
 *
 */
public final class NaturalNumberStaticOps {

    /**
     * Constant needed to print/convert {@code NaturalNumber} with commas.
     */
    private static final NaturalNumber ONE_THOUSAND = new NaturalNumber2(1000);
    private static final int THREE = 3;

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NaturalNumberStaticOps() {
    }

    /**
     * Get command from user.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return the command entered by the user
     * @updates in.content
     * @updates out.content
     * @requires in.is_open and out.is_open
     * @ensures <pre>
     * [displays a menu of available commands, prompts the user to
     *   enter a command, inputs and returns the command]
     * </pre>
     */
    private static String getCommand(SimpleReader in, SimpleWriter out) {
        out.println();
        out.println("Command: i [increment]");
        out.println("         d [decrement]");
        out.println("         p [printWithCommas]");
        out.println("         s [toStringWithCommas]");
        out.print("         q [quit]: ");
        return in.nextLine();
    }

    /**
     * Increments the given {@code NaturalNumber}.
     *
     * @param n
     *            the number to increment
     * @updates n
     * @ensures n = #n + 1
     */
    private static void increment(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        int digit = n.divideBy10();
        digit = digit + 1;
        if (digit == NaturalNumber.RADIX) {
            digit = 0;
            increment(n);
        }
        n.multiplyBy10(digit);
    }

    /**
     * Decrements the given {@code NaturalNumber}.
     *
     * @param n
     *            the number to decrement
     * @updates n
     * @requires n > 0
     * @ensures n = #n - 1
     */
    private static void decrement(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        assert !n.isZero() : "Violation of: n > 0";
        int digit = n.divideBy10();
        digit = digit - 1;

        if (digit == NaturalNumber.RADIX) {
            digit = 0;
            decrement(n);
        }

        n.multiplyBy10(digit);

    }

    /**
     * Outputs the given {@code NaturalNumber} with commas to the given output
     * stream.
     *
     * @param n
     *            the number to output with commas
     * @param out
     *            the output stream
     * @updates out.content
     * @requires out.is_open
     * @ensures out.content = #out.content * [display of n with commas]
     */
    private static void printWithCommas(NaturalNumber n, SimpleWriter out) {
        assert n != null : "Violation of: n1 is not null";
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        String numbah = n.toString();
        String newNumbah = "";
        int j = 0;

        for (int i = numbah.length() - 1; i >= 0; i--) {

            if (j % THREE == 0 && i != numbah.length() - 1) {
                newNumbah = numbah.charAt(i) + "," + newNumbah;
            } else {
                newNumbah = numbah.charAt(i) + newNumbah;
            }
            j++;
        }

        System.out.print(newNumbah);

    }

    /**
     * Converts the given {@code NaturalNumber} to a {@code String} with commas.
     *
     * @param n
     *            the number to convert
     * @return the {@code String} with commas
     * @ensures toStringWithCommas = [String representation of n with commas]
     */
    private static String toStringWithCommas(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";

        String numbah = n.toString();
        String newNumbah = "";
        int j = 0;

        for (int i = numbah.length() - 1; i >= 0; i--) {

            if (j % THREE == 0 && i != numbah.length() - 1) {
                newNumbah = numbah.charAt(i) + "," + newNumbah;
            } else {
                newNumbah = numbah.charAt(i) + newNumbah;
            }
            j++;
        }

        return newNumbah;
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

        String command = getCommand(in, out);
        while (!command.equals("q")) {
            out.println();
            if (command.equals("i")) {
                out.print("Enter a natural number: ");
                NaturalNumber n = new NaturalNumber2(in.nextLine());
                out.println("Before increment: n = " + n);
                increment(n);
                out.println("After increment:  n = " + n);
            } else if (command.equals("d")) {
                out.print("Enter a natural number: ");
                NaturalNumber n = new NaturalNumber2(in.nextLine());
                out.println("Before decrement: n = " + n);
                decrement(n);
                out.println("After decrement:  n = " + n);
            } else if (command.equals("p")) {
                out.print("Enter a natural number: ");
                NaturalNumber n = new NaturalNumber2(in.nextLine());
                out.println("Before printWithCommas: n = " + n);
                out.print("Number with commas: ");
                printWithCommas(n, out);
                out.println();
                out.println("After printWithCommas:  n = " + n);
            } else if (command.equals("s")) {
                out.print("Enter a natural number: ");
                NaturalNumber n = new NaturalNumber2(in.nextLine());
                out.println("Before toStringWithCommas: n = " + n);
                out.println("Number with commas: " + toStringWithCommas(n));
                out.println("After toStringWithCommas:  n = " + n);
            } else {
                out.println(command);
            }
            command = getCommand(in, out);
        }

        in.close();
        out.close();
    }

}
