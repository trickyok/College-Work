import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Counts the characters in the input and returns a map of each.
 *
 * @author G. Farmer
 */
public final class Meeting49 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Meeting49() {
        // no code needed here
    }

    /**
     * Returns a map where each key is a character and each value is the count
     * of the occurrences of that character in the string str.
     *
     * @param str
     *            string to count characters from
     * @ensures characterCount = [map where each key is a character in the
     *          string str and each associated value is the count of the
     *          occurrences of that character in str]
     * @return map of characters and their values
     **/
    public static Map<Character, Integer> countCharacters1(String str) {
        Map<Character, Integer> map = new Map1L<>();
        int i = 0;
        int temp;

        while (i < str.length()) {
            if (!map.hasKey(str.charAt(i))) {
                map.add(str.charAt(i), 1);
            } else {
                temp = map.value(str.charAt(i)) + 1;
                map.replaceValue(str.charAt(i), temp);
            }

            i++;
        }

        return map;
    }

    /**
     * Returns a map where each key is a character and each value is the count
     * of the occurrences of that character in the string str.
     *
     * @param str
     *            string to count characters from
     * @ensures characterCount = [map where each key is a character in the
     *          string str and each associated value is the count of the
     *          occurrences of that character in str]
     * @return map of characters and their values
     **/
    public static Map<Character, Integer> countCharacters2(String str) {
        Map<Character, Integer> result;

        if (str.length() == 0) {
            result = new Map1L<>();
        } else {

            String sub = str.substring(1);

            result = countCharacters2(sub);

            char key = str.charAt(0);
            if (result.hasKey(key)) {
                int count = result.value(key);
                result.replaceValue(key, count);

            } else {
                result.add(key, 0);
            }
        }
        return result;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        String str = in.nextLine();

        out.println(countCharacters1(str));
        out.println(countCharacters2(str, 0));

        out.close();
        in.close();
    }

}
