import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        String fileName, definition;
        out.println("<ul>");

        for (Entry<String, String> entry : in.entrySet()) {
            String term = entry.getKey();
            if (!term.equals("")) {
                out.println("<li><a href=\"pages/" + term + ".html\">" + term
                        + "</a></li>");
                fileName = "data/pages/" + term + ".html";
                definition = entry.getValue();
                generateDefinition(term, definition, fileName);
            }

        }

        out.println("</ul>");
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
    private static void generateDefinition(String term, String definition,
            String fileName) {

        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        SimpleWriter out = new SimpleWriter1L(fileName);

        out.println("<i><h1><b style='color:red;'>" + term
                + "</b></i></h1><br><head>" + definition + "</head>");
        out.println(
                "<br><br>Return to <a href=\"javascript:history.back()\">index</a>");

        out.close();
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
        int line = 1, i = 0;
        String next = in.nextLine(), term = "", definition = "";
        TreeMap<String, String> map = new TreeMap<>();

        while (line < length) {
            if (!next.equals("")) {

                if (i == 0) {
                    term = next;
                } else {
                    definition = definition + " " + next;
                }
                next = in.nextLine();
                line++;
                i++;

            } else {
                map.put(term, definition);
                term = "";
                definition = "";
                i = 0;
                next = in.nextLine();
                line++;
            }

        }
        map.put(term, definition); // brute force get fcked java

        return map;

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
        out.println("<h1>Glossary<h1>");
        out.println("<h3>Index</h3>");
    }

    /**
     * counts the lines in the file. I'll be honest, i ripped this code off the
     * Internet but honestly it felt like a huge waste of time to try and figure
     * it out on my own. i don't feel sorry at all. this code wasn't the main
     * focus of the project. why would i spend my time counting lines when i can
     * spend time on more important things like Counter-Strike: Global
     * Offensive?? Did you know I'm top 2 in the world?? I'm a GAMER!!! I
     * GAMEE!!!!! YOU CANT HOLD ME DOWN WITH YOUR SILLY LINE COUNTING
     * SHENANIGANS!!!!
     * IIIIIIIIIIIIIIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!!!!!!!!!!
     *
     * @param fileName
     *            name of file LOL!!!!
     * @return the number of lines LOL!!!!!
     * @throws IOException
     */
    public static long countLines(String fileName) throws IOException {

        Path path = Paths.get(fileName);

        long lines = 0;
        try {

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SimpleReader getName = new SimpleReader1L();
        SimpleWriter nameGet = new SimpleWriter1L();

        nameGet.print("Enter a file name: ");
        String fileName = getName.nextLine();

        // getting file name and stuff
        if (!fileName.substring(0, 5).equals("data/")) {
            fileName = "data/" + fileName;
        }
        if (!fileName.substring(fileName.length() - 4, fileName.length() - 3)
                .equals(".")) {
            fileName = fileName + ".txt";
        }

        getName.close();
        nameGet.close();

        // i hate comments
        int fileLength = (int) countLines(fileName);
        SimpleReader in = new SimpleReader1L(fileName);
        SimpleWriter out = new SimpleWriter1L("data/glossary.html");
        TreeMap<String, String> map;

        map = generateMap(in, fileLength);
        generateHeader(out);
        generateTerm(map, out);

        in.close();
        out.close();
    }

}
