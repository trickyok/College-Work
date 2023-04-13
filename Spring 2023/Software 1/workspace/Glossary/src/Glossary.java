import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.TreeMap;

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
    private static void generateTerm(TreeMap<String, String> in,
            SimpleWriter out) {

        for (Entry<String, String> entry : in.entrySet()) {
            String term = entry.getKey();

            out.println("<a href=\"#term_" + term + "\">" + term + "</a>");

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
    private static void generateDefinition(TreeMap<String, String> in,
            SimpleWriter out) {

        for (Entry<String, String> entry : in.entrySet()) {
            String term = entry.getKey();
            String definition = entry.getValue();

            out.println("<a id=\"term_" + term + "\">");
            out.println(term + " - " + definition);

        }

    }

    /**
     * turn file into a map.
     *
     * @param in
     *            infile
     * @param length
     *            length of file
     * @return map!!!!
     */
    private static TreeMap<String, String> generateMap(SimpleReader in,
            int length) {
        int line = 0, i = 0;
        String next = in.nextLine(), term = "", definition = "";
        TreeMap<String, String> map = new TreeMap<>();

        while (line < length) {
            while (!next.equals("")) {

                if (i == 0) {
                    term = in.nextLine();
                } else {
                    definition = definition + " " + in.nextLine();
                }

                line++;
                i++;
                next = in.nextLine();
            }

            map.put(term, definition);
            term = "";
            definition = "";
            i = 0;
        }

        return null;

    }

    /**
     * skips 10 lines.
     *
     * @param out
     *            outfile
     */
    private static void nextPage(SimpleWriter out) {
        for (int i = 0; i < 10; i++) {
            out.println();
        }
    }

    /**
     * Generates the header for the html file.
     *
     * @param out
     *            outfile!!!!
     */
    public static void generateHeader(SimpleWriter out) {
        out.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");
        out.println(
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"h"
                        + "ttp://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        out.println();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File fileLOL = new File("data/terms.txt");
        int fileLength = (int) fileLOL.length();
        SimpleReader in = new SimpleReader1L("data/terms.txt");
        SimpleWriter out = new SimpleWriter1L("data/glossary.html");
        TreeMap<String, String> map;

        map = generateMap(in, fileLength);
        generateHeader(out);
        generateTerm(map, out);
        nextPage(out);
        generateDefinition(map, out);

        in.close();
        out.close();
    }

}
