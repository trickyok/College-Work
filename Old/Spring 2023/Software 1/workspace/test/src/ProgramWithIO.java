import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

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

        SimpleReader in = new SimpleReader1L();

        String str = "Poop Fart";

        // a
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                System.out.println(str.charAt(i));
            }
        }

        // b
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 1) {
                System.out.println(str.charAt(i));
            }
        }

        // c and d
        char[] vowel = new char[] { 'a', 'e', 'i', 'o', 'u', 'y' };
        boolean check = false;
        int numVowel = 0;

        for (int i = 0; i < str.length(); i++) {
            for (char c : vowel) {
                if (c == str.charAt(i)) {
                    System.out.print("_");
                    check = true;
                    numVowel++;
                }
            }
            if (!check) {
                System.out.print(str.charAt(i));
            }
            check = false;
        }
        System.out.println(numVowel);

        // e
        for (int i = 0; i < str.length(); i++) {
            for (char c : vowel) {
                if (c == str.charAt(i)) {
                    System.out.println(i);
                }
            }
        }

        int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };

        int i = 1;
        while (i < 10) {
            a[i] = a[i - 1];
            i++;
        }

        System.out.println("a");
        for (int element : a) {
            System.out.print(element);
        }

        i = 9;
        while (i > 0) {
            a[i] = a[i - 1];
            i--;
        }

        System.out.println("b");
        for (int element : a) {
            System.out.print(element);
        }

        i = 0;
        while (i < 9) {
            a[i] = a[i + 1];
            i++;
        }

        System.out.println("c");
        for (int element : a) {
            System.out.print(element);
        }

        i = 8;
        while (i >= 0) {
            a[i] = a[i + 1];
            i--;
        }

        System.out.println("d");
        for (int element : a) {
            System.out.print(element);
        }

        i = 1;
        while (i < 10) {
            a[i] = a[i] + a[i - 1];
            i++;
        }

        System.out.println("e");
        for (int element : a) {
            System.out.print(element);
        }

        i = 1;
        while (i < 10) {
            a[i] = 0;
            i = i + 2;
        }

        System.out.println("f");
        for (int element : a) {
            System.out.print(element);
        }

        i = 0;
        while (i < 5) {
            a[i + 5] = a[i];
            i++;
        }

        System.out.println("g");
        for (int element : a) {
            System.out.print(element);
        }

        i = 1;
        while (i < 5) {
            a[i] = a[9 - i];
            i++;
        }

        System.out.println("h");
        for (int element : a) {
            System.out.print(element);
        }

        in.close();

    }

}
