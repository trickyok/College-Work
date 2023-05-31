import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 *
 * @author Gage Farmer
 *
 */

public class NNtoStringWithCommasTest {

    @Test
    public void test0() {
        NaturalNumber n = new NaturalNumber2();
        NaturalNumber nOrig = new NaturalNumber2();
        String nTest = "0";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nOrig = new NaturalNumber2(1);
        String nTest = "1";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test12() {
        NaturalNumber n = new NaturalNumber2(12);
        NaturalNumber nOrig = new NaturalNumber2(12);
        String nTest = "12";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test123() {
        NaturalNumber n = new NaturalNumber2(123);
        NaturalNumber nOrig = new NaturalNumber2(123);
        String nTest = "123";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test1234() {
        NaturalNumber n = new NaturalNumber2(1234);
        NaturalNumber nOrig = new NaturalNumber2(1234);
        String nTest = "1,234";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test12345() {
        NaturalNumber n = new NaturalNumber2(12345);
        NaturalNumber nOrig = new NaturalNumber2(12345);
        String nTest = "12,345";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test123456() {
        NaturalNumber n = new NaturalNumber2(123456);
        NaturalNumber nOrig = new NaturalNumber2(123456);
        String nTest = "123,456";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test1234567() {
        NaturalNumber n = new NaturalNumber2(1234567);
        NaturalNumber nOrig = new NaturalNumber2(1234567);
        String nTest = "1,234,567";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(nOrig, n);
    }

    @Test
    public void test12345678() {
        NaturalNumber n = new NaturalNumber2(12345678);
        NaturalNumber nOrig = new NaturalNumber2(12345678);
        String nTest = "12,345,678";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(n, nOrig);
    }

    @Test
    public void test123456789() {
        NaturalNumber n = new NaturalNumber2(123456789);
        NaturalNumber nOrig = new NaturalNumber2(123456789);
        String nTest = "123,456,789";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(nTest, n2);
        assertEquals(n, nOrig);
    }

    @Test
    public void test1234567890() {
        NaturalNumber n = new NaturalNumber2(1234567890);
        NaturalNumber nOrig = new NaturalNumber2(1234567890);
        String nTest = "1,234,567,890";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(n2, nTest);
        assertEquals(n, nOrig);
    }

    @Test
    public void test1000() {
        NaturalNumber n = new NaturalNumber2(1000);
        NaturalNumber nOrig = new NaturalNumber2(1000);
        String nTest = "1,000";
        String n2 = redirectToMethodUnderTest(n);
        assertEquals(n2, nTest);
        assertEquals(n, nOrig);
    }

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas6.toStringWithCommas(n);
    }

    /**
     * NNtoStringWithCommas2 test0 test1 test12 test1234 test12345 test1234567
     * test12345678 test1234567890 test1000
     *
     * NNtoStringWithCommas3 test0 (FAIL)
     *
     * NNtoStringWithCommas4 test1000 (FAIL)
     *
     * NNtoStringWithCommas5 test12345 (FAIL) test123456 (FAIL) test1234567
     * (FAIL) test12345678 (FAIL) test123456789 (FAIL)
     *
     * NNtoStringWithCommas6
     *
     */
}
