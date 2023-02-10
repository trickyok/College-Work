import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class Oddity {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Oddity() {
        // no code needed here
    }

    /**
     * Determines whether values from array are even or odd
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {

        // Wasn't considering negative remainders

        SimpleWriter out = new SimpleWriter1L();
        final int[] values = { 8, -4, 3, 0, -5 };
        int i = 0;
        while (i < values.length) {
            int remainder = values[i] % 2;
            if (remainder == 1 || remainder == -1) {
                out.println("odd");
            } else {
                out.println("even");
            }
            i = i + 1;
        }

        System.out.println("-------------------");

        // Unable to use == operator on doubles

        final double x = 456.0;
        final double y = 100.0 * 4.56;
        final double err = .00000001;
        if (Math.abs(x - y) <= err) {
            out.println("equal");
        } else {
            out.println("not equal");
        }

        System.out.println("-------------------");

        // Overflow error

        final long something = 24 * 60 * 60;
        final long microsPerDay = 1000 * 1000 * something;
        final long millisPerDay = 1000 * something;
        out.println(microsPerDay / millisPerDay);

        System.out.println("-------------------");

        // Wasn't adding numbers as ints

        int num = 12345 + 54321;
        out.println(num);
        out.close();
    }

}
