package components.waitingLine;

/**
 * @author Gage Farmer
 * @author Nolan Xu
 * @author Minh Cho
 * @author Ben Holm-Bertelsen
 * @author Henry Fritz
 */

/**
 * {@code QueueKernel} enhanced with secondary methods.
 *
 * @param <T>
 *            type of {@code Queue} entries
 * @mathdefinitions <pre>
 * IS_TOTAL_PREORDER (
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y, z: T
 *   ((r(x, y) or r(y, x))  and
 *    (if (r(x, y) and r(y, z)) then r(x, z)))
 *
 * IS_SORTED (
 *   s: string of T,
 *   r: binary relation on T
 *  ) : boolean is
 *  for all x, y: T where (<x, y> is substring of s) (r(x, y))
 * </pre>
 */
public interface WaitingLine<T> extends WaitingLineKernel<T> {

    /**
     * Reports the front of {@code this}.
     *
     * @return the front entry of {@code this}
     * @aliases reference returned by {@code front}
     * @requires this /= <>
     * @ensures <front> is prefix of this
     */
    T front();

    /**
     * Replaces the front of {@code this} with {@code x}, and returns the old
     * front.
     *
     * @param x
     *            the new front entry
     * @return the old front entry
     * @aliases reference {@code x}
     * @updates this
     * @requires this /= <>
     * @ensures <pre>
     * <replaceFront> is prefix of #this  and
     * this = <x> * #this[1, |#this|)
     * </pre>
     */
    T replaceFront(T x);

    /**
     * Merges two waiting lines in a fair matter.
     *
     * @param w
     *            the {@code WaitingLine} to be merged into {@code this}
     * @updates this
     * @clears w
     * @requires {@code entries(this) intersect entries(w) = empty set}
     * @ensures for all a, b in this, if a, b in #this and #this.indexOf(a) <
     *          #this.indexOf(b) or if a, b in #w and #w.indexOf(a) <
     *          #w.indexOf(b) then this.indexOf(a) < this.indexOf(b)
     */
    void merge(WaitingLine<T> w);

    /**
     * Splits one line into two, returns the second line.
     *
     * @param x
     *            the position where the split will occur, value at x will be
     *            front of returned WaitingLine
     * @return new WaitingLine
     * @updates this
     * @ensures |this| = |this| / 2
     */
    WaitingLine<T> split(int x);

}
