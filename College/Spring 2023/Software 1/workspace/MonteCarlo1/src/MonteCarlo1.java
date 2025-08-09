import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo1() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();
        /*
         * Declare counters and initialize them
         */
        int ptsInInterval = 0, ptsInSubinterval = 0;
        /*
         * Create pseudo-random number generator
         */
        Random rndX = new Random1L();
        Random rndY = new Random1L();
        /*
         * Generate points and count how many fall in circle's interval
         */
        while (ptsInInterval < n) {
            /*
             * Generate pseudo-random number in [0.0,2.0) interval
             */
            double x = 2 * rndX.nextDouble();
            double y = 2 * rndY.nextDouble();
            /*
             * Increment total number of generated points
             */
            ptsInInterval++;
            /*
             * calculate distance from origin
             */
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            /*
             * check if distance from center is less than 1.0
             */
            if (distance <= 2.0) {
                if (x >= 0 && y >= 0) {
                    ptsInSubinterval++;
                }
            }
        }
        /*
         * Estimate area of circle by multiplying area of square by number of
         * points in the circle then dividing by total number of points
         */
        double area = Math.pow(2, 2) * ptsInSubinterval / ptsInInterval;
        output.println("Area of the circle is " + area);
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}