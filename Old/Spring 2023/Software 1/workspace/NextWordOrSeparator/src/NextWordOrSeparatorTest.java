import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test static methods {@code generateElements} and
 * {@code nextWordOrSeparator}.
 *
 * @author Put your name here
 *
 */
public final class NextWordOrSeparatorTest {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NextWordOrSeparatorTest() {
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> charSet) {
        int i = 0;

        while (i < str.length() - 1) {
            charSet.add(str.charAt(i));
            i++;
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {

        boolean done = false;
        int i = 0;
        String word = "";

        while (!done && position + i < text.length()) {
            if (separators.contains(text.charAt(position + i))) {
                done = true;
                if (i == 0) {
                    word = word + text.charAt(position + i);
                }
            } else {
                word = word + text.charAt(position + i);
            }
            i++;
        }

        return word;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Define separator characters for test
         */
        final String separatorStr = " \t, ";
        Set<Character> separatorSet = new Set1L<>();
        generateElements(separatorStr, separatorSet);
        /*
         * Open input and output streams
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Ask for test cases
         */
        out.println();
        out.print("New test case (y/n)? ");
        String response = in.nextLine();
        while (response.equals("y")) {
            /*
             * Output heading
             */
            out.print("Test case: ");
            String testStr = in.nextLine();
            out.println();
            out.println("----Next test case----");
            out.println();
            /*
             * Process test case
             */
            int position = 0;
            while (position < testStr.length()) {
                String token = nextWordOrSeparator(testStr, position,
                        separatorSet);
                if (separatorSet.contains(token.charAt(0))) {
                    out.print("  Separator: <");
                } else {
                    out.print("  Word: <");
                }
                out.println(token + ">");
                position += token.length();
            }
            /*
             * Ask user whether to continue
             */
            out.println();
            out.print("New test case (y/n)? ");
            response = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}