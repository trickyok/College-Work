/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIO {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ProgramWithIO() {
    }

    public static boolean allTheSame(int x, int y, int z) {
        return (x == y && y == z);
    }

    public static boolean allDifferent(int x, int y, int z) {
        return (x != y && y != z && x != z);
    }

    public static boolean sorted(int x, int y, int z) {
        return (x <= y && y <= z);
    }

    // I hope this works lol I wrote this all in word
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        if (allTheSame(x, y, z)) {
            System.out.println("All the same");
        }
        if (allDifferent(x, y, z)) {
            System.out.println("All different");
        }
        if (sorted(x, y, z)) {
            System.out.println("Sorted");
        }
    }

}
