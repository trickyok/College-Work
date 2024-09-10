
import components.queue.QueueSecondary;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code Queue} represented as a {@code Sequence} of entries, with
 * implementations of primary methods.
 *
 * @param <T> type of {@code Queue} entries
 * @correspondence this = $this.entries
 */
public abstract class Queue3<T> extends QueueSecondary<T> {

	/*
	 * Private members --------------------------------------------------------
	 */

	/**
	 * Entries included in {@code this}.
	 */
	private Sequence<T> entries;

	/**
	 * Creator of initial representation.
	 */
	private void createNewRep() {
		this.entries = new Sequence1L<T>();
	}

	/*
	 * Constructors -----------------------------------------------------------
	 */

	/**
	 * No-argument constructor.
	 */
	public Queue3() {
		this.createNewRep();
	}

	/*
	 * Standard methods removed to reduce clutter...
	 */

	/*
	 * Kernel methods ---------------------------------------------------------
	 */

	@Override
	public final void enqueue(T x) {
		assert x != null : "Violation of: x is not null";

		this.enqueue(x);

	}

	@Override
	public final T dequeue() {
		assert this.length() > 0 : "Violation of: this /= <>";

		T removed = this.dequeue();

		return removed;
	}

	@Override
	public final int length() {

		// This line added just to make the component compilable.
		return this.length();
	}

	/**
	 * Reports the front of {@code this}.
	 *
	 * @return the front entry of {@code this}
	 * @aliases reference returned by {@code front}
	 * @requires this /= <>
	 * @ensures <front> is prefix of this
	 */
	@Override
	public T front() {
		assert this.length() > 0 : "Violation of: this /= <>";

		T front = this.dequeue();
		T temp = front;

		for (int idx = 0; idx <= this.length(); idx++) {
			this.enqueue(temp);
			temp = this.dequeue();
		}

		return front;
	}

	/*
	 * Iterator removed to reduce clutter...
	 */

}