import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Calculates fewest number of coins for change using greedy method.
 *
 * @author Gage Farmer
 *
 */
public final class CoinChange1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange1() {
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

        System.out.print("Enter an amount of cents: ");
        int amount = in.nextInteger();

        int dollar = amount / 100;
        amount = amount % 100;

        int halfDollar = amount / 50;
        amount = amount % 50;

        int quarter = amount / 25;
        amount = amount % 25;

        int dime = amount / 10;
        amount = amount % 10;

        int nickel = amount / 5;
        amount = amount % 5;

        int penny = amount;

        System.out.println(dollar + " dollars");
        System.out.println(halfDollar + " half-dollars");
        System.out.println(quarter + " quarters");
        System.out.println(dime + " dimes");
        System.out.println(nickel + " nickels");
        System.out.println(penny + " pennies");

        in.close();
        out.close();
    }

}
