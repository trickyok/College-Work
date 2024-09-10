import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Program to copy a text file into another file.
 *
 * @author Gage Farmer
 *
 */
public final class CopyFileStdJava {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CopyFileStdJava() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments: input-file-name output-file-name
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	
    	String infile = args[0];
    	String outfile = args[1];
    	
    	BufferedReader in = new BufferedReader(new FileReader(infile));
    	PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter(outfile)));
    	
    	String item = in.readLine();

        while (item != null) {
        	out.print(item + "\n");
        	item = in.readLine();
        }
        
        in.close();
        out.close();
    }

}
