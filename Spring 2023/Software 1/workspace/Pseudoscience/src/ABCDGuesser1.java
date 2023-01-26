import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ABCDGuesser1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser1() {
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
        double[] exp = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0, 1 / 4,
                1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        double total = -1, error = -1, closest = 99999;
        double bestW = -1, bestX = -1, bestY = -1, bestZ = -1;
        boolean wasClosest;

        // get u
        double u = getPositiveDouble(in, out);

        // get w x y z
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        // big boy loop
        for (int i = 0; i < 16; i++) {
            wasClosest = false;
            total = Math.pow(w, exp[i]);

            for (int j = 0; j < 16; j++) {
                total = total + Math.pow(x, exp[j]);

                for (int k = 0; k < 16; k++) {
                    total = total + Math.pow(y, exp[k]);

                    for (int l = 0; l < 16; l++) {
                        total = total + Math.pow(z, exp[l]);
                        error = Math.abs(total - u);

                        if (error < closest) {
                            wasClosest = true;
                            closest = total;
                            bestZ = exp[l];
                        }
                        wasClosest = false;
                    }
                    if (error < closest) {
                        wasClosest = true;
                        closest = total;
                        bestY = exp[k];
                    }
                    wasClosest = false;
                }
                if (error < closest) {
                    wasClosest = true;
                    closest = total;
                    bestX = exp[j];
                }
                wasClosest = false;
            }
            if (error < closest) {
                wasClosest = true;
                closest = total;
                bestW = exp[i];
            }
            wasClosest = false;
        }

        // do some math
        double percentError = (closest - u) / u * 100;

        // print results
        System.out.println("u = " + u);
        System.out.println("(" + w + "^" + bestW + ")" + " + " + "(" + x + "^"
                + bestX + ")" + " + " + "(" + y + "^" + bestY + ")" + " + "
                + "(" + z + "^" + bestZ + ")" + " = " + closest);
        System.out.println("Percent Error: " + percentError);

        // close stuff
        in.close();
        out.close();
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        System.out.print("Enter a positive number: ");
        String input = in.nextLine();
        boolean looping = true;
        double num = -1;

        while (looping) {
            if (FormatChecker.canParseInt(input)) {
                num = Integer.parseInt(input);
                if (num > 0) {
                    looping = false;
                }
            } else {
                System.out.print("Enter a positive number: ");
                input = in.nextLine();
            }
        }

        return num;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        boolean looping = true;
        double num = -1;

        while (looping) {
            num = getPositiveDouble(in, out);
            if (num != 1.0) {
                looping = false;
            }
        }

        return num;
    }

}
