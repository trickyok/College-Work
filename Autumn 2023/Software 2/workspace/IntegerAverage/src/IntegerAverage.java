/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class IntegerAverage {

	/**
	 * No argument constructor--private to prevent instantiation.
	 */
	private IntegerAverage() {
		// no code needed here
	}

	/**
	 * Main method.
	 *
	 * @param args the command line arguments; unused here
	 */
	public static void main(String[] args) {

	}

	/**
	 * gets average of j and k.
	 *
	 * @param j
	 * @param k
	 * @return returns (j+k)/2
	 */
	public static int average(int j, int k) {

		// dont work
		// int avg0 = (j + k) / 2;

		// int avg1 = (j / 2) + (k / 2);

		// int avg2 = (((j / 2) * 2) + ((k / 2) * 2)) / 2;

		// does work
		int avg3 = (int) ((j / 2.0) + (k / 2.0));

		return avg3;

	}

}
