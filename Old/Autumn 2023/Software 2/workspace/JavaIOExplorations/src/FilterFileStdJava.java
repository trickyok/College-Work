import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Program to copy a text file into another file.
 *
 * @author Gage Farmer
 *
 */
public final class FilterFileStdJava {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private FilterFileStdJava() {
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
    	String filterfile = args[2];
    	
    	BufferedReader in = new BufferedReader(new FileReader(infile));
    	PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter(outfile)));
    	BufferedReader inFilter = new BufferedReader(new FileReader(filterfile));
    	
    	java.util.Set<String> filter = new HashSet<String>();
    	String temp = inFilter.readLine();
    	
    	while (temp != null) {
    		temp.toLowerCase();
    		filter.add(temp);
    		temp = inFilter.readLine();
    	}
    	
    	String line = in.readLine();
    	String[] list;
    	
    	while (line != null) {
	        list = line.split(" ");
	        
	        for (int idx = 0; idx < list.length; idx++) {
	        	String item = list[idx];
	        	String itemDouble = null;
	        	
	        	if (idx != 0) {
	        		itemDouble = list[idx - 1] + " " + list[idx];
	        	}
	        	
	        	if (filter.contains(item)) {
	        		out.print(item + "\n");
	        	} else if (filter.contains(itemDouble)) {
	        		out.print(itemDouble + "\n");
	        	}
	        }
	        
	        line = in.readLine();
    	}
    	
        in.close();
        out.close();
    }
}
