import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Prompts the user for their name, inputs the name, and outputs a response
 *
 * @author Gage Farmer
 *
 */
public final class HelloJack {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HelloJack() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        String name;
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here
         */
        System.out.print("Enter your name: ");
        name = in.nextLine();
        System.out.print("Hello, " + name);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
