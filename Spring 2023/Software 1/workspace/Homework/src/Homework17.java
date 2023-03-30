import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author G. Farmer
 */
public final class Homework17 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework17() {
        // no code needed here
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public <T> void flip(Queue<T> thiss) {
        Queue<T> temp = new Queue1L<>();

        for (int i = 0; i < thiss.length(); i++) {
            temp.enqueue(thiss.dequeue());
            thiss.enqueue(temp.dequeue());
        }
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public static <T> void flip2(Queue<T> thiss) {
        Queue<T> temp = new Queue1L<>();

        for (int i = 0; i < thiss.length(); i++) {
            temp.enqueue(thiss.dequeue());
            thiss.enqueue(temp.dequeue());
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
    }

}
