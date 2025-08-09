package components.waitingLine;

import java.util.Iterator;

/**
 * Layered implementations of secondary methods for {@code Queue}.
 *
 * <p>
 * Assuming execution-time performance of O(1) for method {@code iterator} and
 * its return value's method {@code next}, execution-time performance of
 * {@code front} as implemented in this class is O(1). Execution-time
 * performance of {@code replaceFront} and {@code flip} as implemented in this
 * class is O(|{@code this}|). Execution-time performance of {@code append} as
 * implemented in this class is O(|{@code q}|). Execution-time performance of
 * {@code sort} as implemented in this class is O(|{@code this}| log
 * |{@code this}|) expected, O(|{@code this}|^2) worst case. Execution-time
 * performance of {@code rotate} as implemented in this class is
 * O({@code distance} mod |{@code this}|).
 *
 * @param <T>
 *            type of {@code Queue} entries
 */
public abstract class WaitingLineSecondary<T> implements WaitingLine<T> {

    /*
     * Private members --------------------------------------------------------
     */

    /*
     * 2221/2231 assignment code deleted.
     */

    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Common methods (from Object) -------------------------------------------
     */

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof WaitingLine<?>)) {
            return false;
        }
        WaitingLine<?> q = (WaitingLine<?>) obj;
        if (this.length() != q.length()) {
            return false;
        }
        Iterator<T> it1 = this.iterator();
        Iterator<?> it2 = q.iterator();
        while (it1.hasNext()) {
            T x1 = it1.next();
            Object x2 = it2.next();
            if (!x1.equals(x2)) {
                return false;
            }
        }
        return true;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        final int samples = 2;
        final int a = 37;
        final int b = 17;
        int result = 0;
        /*
         * This code makes hashCode run in O(1) time. It works because of the
         * iterator order string specification, which guarantees that the (at
         * most) samples entries returned by the it.next() calls are the same
         * when the two Queues are equal.
         */
        int n = 0;
        Iterator<T> it = this.iterator();
        while (n < samples && it.hasNext()) {
            n++;
            T x = it.next();
            result = a * result + b * x.hashCode();
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<");
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            if (it.hasNext()) {
                result.append(",");
            }
        }
        result.append(">");
        return result.toString();
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public T front() {
        assert this.length() > 0 : "Violation of: this /= <>";

        T front = this.dequeue();
        T next = this.dequeue();
        this.enqueue(front);

        while (!front.equals(next)) {
            this.enqueue(next);
            next = this.dequeue();
        }

        this.enqueue(next);

        return front;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public T replaceFront(T x) {
        assert this.length() > 0 : "Violation of: this /= <>";

        T front = this.dequeue();
        T next = this.dequeue();
        this.enqueue(x);

        while (!x.equals(next)) {
            this.enqueue(next);
            next = this.dequeue();
        }

        this.enqueue(next);

        return front;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void merge(WaitingLine<T> w) {
        assert w != null : "Violation of: q is not null";
        assert w != this : "Violation of: q is not this";

        WaitingLine<T> thisNew = this.newInstance();
        thisNew.clear();

        T next1 = this.dequeue();
        T next2 = w.dequeue();

        while (!next1.equals(null) && !next2.equals(null)) {
            thisNew.enqueue(next1);
            thisNew.enqueue(next2);

            next1 = this.dequeue();
            next2 = w.dequeue();
        }
        while (!next1.equals(null)) {
            thisNew.enqueue(next1);

            next1 = this.dequeue();
        }
        while (!next2.equals(null)) {
            thisNew.enqueue(next2);

            next2 = w.dequeue();
        }

        this.transferFrom(thisNew);

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public WaitingLine<T> split(int x) {
        assert x < this.length() : "Violation of: x is less than this.length";
        assert x < 0 : "Violation of: x is positive";

        WaitingLine<T> frontLine = this.newInstance();
        WaitingLine<T> rearLine = this.newInstance();

        for (int i = 0; i < x; i++) {
            frontLine.enqueue(this.dequeue());
        }
        while (this.length() >= 1) {
            rearLine.enqueue(this.dequeue());
        }

        this.transferFrom(frontLine);

        return rearLine;
    }

}
