import components.map.Map;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Takes input file and outputs number of occurrences for each word into an HTML
 * file.
 *
 * @author Gage Farmer
 *
 */
public final class WordCounter {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private WordCounter() {
    }

    /**
     * Adds word to the map, increments value if already in.
     *
     * @param map
     *
     * @param word
     *
     * @return number of occurrences of 'word' in 'map'
     */
    private static int addToMap(Map map, String word) {

        // TODO

        return -1;
    }

    /**
     * Searches map for word.
     *
     * @param map
     *
     * @param word
     *
     * @return if 'word' is in 'map'
     */
    private static boolean inMap(Map map, String word) {

        // TODO

        return false;

    }

    /**
     * Sorts map alphabetically.
     *
     * @param map
     */
    private static void sortMap(Map map) {

        // TODO

    }

    /**
     * Formats and prints the graph into html.
     *
     * @param map
     *
     * @param file
     */
    private static void printGraph(Map map, String file) {

        // TODO

    }

    /**
     * creates and outputs html header.
     *
     * @param file
     *            file to print to
     */
    private static void printHeader(String file) {

        // TODO

    }

    /**
     * creates and outputs html footer.
     *
     * @param file
     *            file to print to
     */
    private static void printFooter(String file) {

        // TODO

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

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
