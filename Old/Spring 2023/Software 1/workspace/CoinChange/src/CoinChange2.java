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
public final class CoinChange2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange2() {
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
        int i = 0;
        int temp = 0;

        System.out.print("Enter an amount of cents: ");
        int amount = in.nextInteger();

        // arrays for coins and such
        String[] names = { " dollars", " half-dollars", " quarters", " dimes",
                " nickels", " pennies" };
        int[] nums = { 100, 50, 25, 10, 5, 1 };

        // greedy loop
        while (i < 5) {
            temp = amount / nums[i];
            amount = amount % nums[i];

            System.out.println(temp + names[i]);

            i++;
        }

        in.close();
        out.close();
    }

}
