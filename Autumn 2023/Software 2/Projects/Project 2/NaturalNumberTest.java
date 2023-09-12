import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    // TODO - add test cases for four constructors, multiplyBy10, divideBy10, isZero

    @Test
    public void constrNoArgTest() {
        NaturalNumber test = this.constructorTest();
        NaturalNumber ref = this.constructorRef();

        assertEquals(ref, test);
    }

    @Test
    public void constrIntArgTest() {
        NaturalNumber test = this.constructorTest(0);
        NaturalNumber ref = this.constructorRef(0);

        assertEquals(ref, test);
    }

    @Test
    public void constrIntArgTest2() {
        NaturalNumber test = this.constructorTest(1);
        NaturalNumber ref = this.constructorRef(1);

        assertEquals(ref, test);
    }

    @Test
    public void constrStrArgTest() {
        NaturalNumber test = this.constructorTest("0");
        NaturalNumber ref = this.constructorRef("0");

        assertEquals(ref, test);
    }

    @Test
    public void constrStrArgTest2() {
        NaturalNumber test = this.constructorTest("1");
        NaturalNumber ref = this.constructorRef("1");

        assertEquals(ref, test);
    }

    @Test
    public void constrNNArgTest() {
        NaturalNumber num = new NaturalNumber1L("0");

        NaturalNumber test = this.constructorTest(num);
        NaturalNumber ref = this.constructorRef(num);

        assertEquals(ref, test);
    }

    @Test
    public void constrNNArgTest2() {
        NaturalNumber num = new NaturalNumber1L("233");

        NaturalNumber test = this.constructorTest(num);
        NaturalNumber ref = this.constructorRef(num);

        assertEquals(ref, test);
    }

}
