import java.io.FileWriter;

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
     */
    private static void generateTerm(SimpleReader in, FileWriter outFile) {

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
        FileWriter outFile = new FileWriter(null);

        generateTerm(in, outFile);

        in.close();
        out.close();
    }

}
