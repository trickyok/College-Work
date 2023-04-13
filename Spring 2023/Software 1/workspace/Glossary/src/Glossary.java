import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Creates a glossary of terms for a given input
 *
 * @author Gage Farmer
 *
 */
public final class Glossary {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Glossary() {
    }

    /**
     * Takes term and its definition from the in-file, and formats it properly
     * into the out-file.
     *
     * @param in
     *            input file
     * @param out
     *            output file
     */
    private static void generateTerm(SimpleReader in, SimpleWriter out) {
        int line = 0;
        String next = in.nextLine();

        while (!next.equals("")) {
            if (line == 0) {
                // is a term
                out.println("<a href=\"#term_" + next + "\">" + next + "</a>");
            }

            line++;
            next = in.nextLine();
        }

    }

    /**
     * Takes term and its definition from the in-file, and formats it properly
     * into the out-file.
     *
     * @param in
     *            input file
     * @param out
     *            output file
     */
    private static void generateDefinition(SimpleReader in, SimpleWriter out) {
        int line = 0;
        String next = in.nextLine();
        String term = "";

        while (!next.equals("")) {
            if (line != 0) {
                out.println("<a id=\"term_" + term + "\">");
                out.println(term + " - " + next);
            } else {
                term = next;
            }

            line++;
            next = in.nextLine();

        }

    }

    /**
     * skips 10 lines
     */
    private static void nextPage(SimpleWriter out) {
        for (int i = 0; i < 10; i++) {
            out.println();
        }
    }

    /**
     * Generates the header for the html file
     */
    public static void generateHeader(SimpleWriter out) {
        out.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");
        out.println(
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        out.println();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in1 = new SimpleReader1L("data/terms.txt");
        SimpleReader in2 = new SimpleReader1L("data/terms.txt");
        SimpleWriter out = new SimpleWriter1L("data/glossary.html");

        generateHeader(out);
        generateTerm(in1, out);
        nextPage(out);
        generateDefinition(in2, out);

        in1.close();
        in2.close();
        out.close();
    }

}
