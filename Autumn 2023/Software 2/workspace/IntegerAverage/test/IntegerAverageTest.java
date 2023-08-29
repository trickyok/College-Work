import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Sample JUnit test fixture for SequenceSmooth.
 *
 * @author Put your name here
 *
 */
public final class IntegerAverageTest {

	/**
	 * Constructs and returns a sequence of the integers provided as arguments.
	 *
	 * @param args 0 or more integer arguments
	 * @return the sequence of the given arguments
	 * @ensures createFromArgs= [the sequence of integers in args]
	 */
	private Sequence<Integer> createFromArgs(Integer... args) {
		Sequence<Integer> s = new Sequence1L<Integer>();
		for (Integer x : args) {
			s.add(s.length(), x);
		}
		return s;
	}

	/**
	 * Test 1 IntegerAverage
	 */
	@Test
	public void test1() {
		/*
		 * Set up variables and call method under test
		 */
		int j = Integer.MAX_VALUE;
		int k = Integer.MAX_VALUE - 1;
		int expectedAns = Integer.MAX_VALUE - 1;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 2 IntegerAverage
	 */
	@Test
	public void test2() {
		/*
		 * Set up variables and call method under test
		 */
		int j = Integer.MIN_VALUE;
		int k = Integer.MIN_VALUE + 1;
		int expectedAns = Integer.MIN_VALUE + 1;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 3 IntegerAverage
	 */
	@Test
	public void test3() {
		/*
		 * Set up variables and call method under test
		 */
		int j = Integer.MIN_VALUE;
		int k = Integer.MIN_VALUE;
		int expectedAns = Integer.MIN_VALUE;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 4 IntegerAverage
	 */
	@Test
	public void test4() {
		/*
		 * Set up variables and call method under test
		 */
		int j = Integer.MAX_VALUE;
		int k = Integer.MAX_VALUE;
		int expectedAns = Integer.MAX_VALUE;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 5 IntegerAverage
	 */
	@Test
	public void test5() {
		/*
		 * Set up variables and call method under test
		 */
		int j = 5;
		int k = 8;
		int expectedAns = 6;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 6 IntegerAverage
	 */
	@Test
	public void test6() {
		/*
		 * Set up variables and call method under test
		 */
		int j = -5;
		int k = -8;
		int expectedAns = -6;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 7 IntegerAverage
	 */
	@Test
	public void test7() {
		/*
		 * Set up variables and call method under test
		 */
		int j = 11;
		int k = -4;
		int expectedAns = 3;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 8 IntegerAverage
	 */
	@Test
	public void test8() {
		/*
		 * Set up variables and call method under test
		 */
		int j = -3;
		int k = 2;
		int expectedAns = 0;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 9 IntegerAverage
	 */
	@Test
	public void test9() {
		/*
		 * Set up variables and call method under test
		 */
		int j = 3;
		int k = 5;
		int expectedAns = 4;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}

	/**
	 * Test 10 IntegerAverage
	 */
	@Test
	public void test10() {
		/*
		 * Set up variables and call method under test
		 */
		int j = -3;
		int k = -5;
		int expectedAns = -4;
		int ans = IntegerAverage.average(j, k);
		/*
		 * Assert that values of variables match expectations
		 */
		assertEquals(expectedAns, ans);
	}
}