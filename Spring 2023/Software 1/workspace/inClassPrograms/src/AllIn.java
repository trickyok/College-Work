import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.queue.Queue;
import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci / G. Farmer / S. Karanam
 */
public final class AllIn {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private AllIn() {
        // no code needed here
    }

    /**
     * Determines if every element of q is also in s.
     *
     * @param <T>
     *            = not a parameter
     * @param s
     *            = Set to be checked from
     * @param q
     *            = Queue to check values from
     *
     * @ensures allIn = [true if every element of q is also in s, false
     *          otherwise]
     * @return if q is in s
     **/
    public static <T> boolean allIn1(Set<T> s, Queue<T> q) {

        boolean result = true;
        int count = 0;

        while (count < q.length()) {
            T e = q.dequeue();
            if (!s.contains(e)) {
                result = false;
            }
            q.enqueue(e);
            count++;
        }

        return result;
    }

    /**
     * Determines if every element of q is also in s.
     *
     * @param <T>
     *            = not a parameter
     * @param s
     *            = Set to be checked from
     * @param q
     *            = Queue to check values from
     *
     * @ensures allIn = [true if every element of q is also in s, false
     *          otherwise]
     * @return if q is in s
     **/
    public static <T> boolean allIn2(Set<T> s, Queue<T> q) {
        boolean result = true;
        int count = 0;
        T num;
        Set<T> temp = new Set1L<>();

        while (count < q.length()) {
            num = q.dequeue();
            temp.add(num);
            q.enqueue(num);
            count++;
        }

        return s.isSubset(temp);

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("Hello World!");
        NaturalNumber testOne = new NaturalNumber2(3);
        NaturalNumber testTwo = new NaturalNumber2(2);
        out.println("Greater than: " + testOne.compareTo(testTwo));
        out.println("Less than: " + testTwo.compareTo(testOne));
        out.println("Equal to: " + testOne.compareTo(testOne));
        out.close();
    }

}
