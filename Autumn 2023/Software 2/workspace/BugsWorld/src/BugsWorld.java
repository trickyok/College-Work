/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class BugsWorld {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private BugsWorld() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void TryToGuess(String[] args) {
        /*
         * Put your main program code here
         */

        while (true) {
            FindObstacle();
        }
    }

    public static void FindObstacle() {

        boolean nextEmpty = true;

        while (nextEmpty) {
            move();
        }

    }

    public static void move() {

    }

}
