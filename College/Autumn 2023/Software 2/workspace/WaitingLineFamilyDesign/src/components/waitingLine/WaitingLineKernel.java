package components.waitingLine;
import components.standard.Standard;



/**
 * First-in-first-out (FIFO) queue kernel component with primary methods. (Note:
 * by package-wide convention, all references are non-null.)
 *
 * @param <T>
 *            type of {@code QueueKernel} entries
 * @mathmodel type QueueKernel is modeled by string of T
 * @initially <pre>
 * default:
 *  ensures
 *   this = <>
 * </pre>
 * @iterator ~this.seen * ~this.unseen = this
 */
public interface WaitingLineKernel<T> extends Standard<WaitingLine<T>>, Iterable<T> {

    /**
     * Adds {@code x} to the end of {@code this}.
     *
     * @param x
     *            the entry to be added
     * @aliases reference {@code x}
     * @updates this
     * @ensures this = #this * <x>
     */
    void enqueue(T x);

    /**
     * Removes and returns the entry at the front of {@code this}.
     *
     * @return the entry removed
     * @updates this
     * @requires this /= <>
     * @ensures #this = <dequeue> * this
     */
    T dequeue();

    /**
     * Reports length of {@code this}.
     *
     * @return the length of {@code this}
     * @ensures length = |this|
     */
    int length();
    
    /**
     * Removes and returns the given entry {@code x}.
     *
     * @updates this
     * @requires this /= <>
     * @ensures #this = <dequeue> * this
     */
    void remove(T x);

    /**
     * Reports position of {@code x}.
     *
     * @return the position of {@code x}
     * @ensures position = |x|
     */
    int position(T x);

}
