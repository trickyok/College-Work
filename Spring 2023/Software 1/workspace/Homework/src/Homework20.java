import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Homework20
 *
 * @author Gage Farmer
 *
 */

public final class Homework20 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework20() {
        // no code needed here
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @param <T>
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public static void flipStack() {
        Stack<T> temp = new Stack1L<>();

        temp.push(this.pop());
        this.flipStack();
        this.push(temp.pop);
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flipSequence() {
        Sequence<T> temp = new Sequence1L<>();

        temp.append(this.extract(0, 0));
        this.flipSequence();
        this.append(temp.extract(0, 0));
    }

}
