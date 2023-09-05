import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Gage Farmer
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    // TODO - add test cases for constructor, add, remove, and length

    @Test
    public void construcTest() {
        Sequence<String> test = this.createFromArgsTest("1", "2", "3", "4");
        Sequence<String> ref = this.createFromArgsRef("1", "2", "3", "4");

        assertEquals(ref, test);
    }

    @Test
    public void addTest() {
        Sequence<String> test = this.createFromArgsTest("1", "2", "3");
        Sequence<String> ref = this.createFromArgsRef("1", "2", "3", "4");

        test.add(3, "4");

        assertEquals(ref, test);
    }

    @Test
    public void removeTest() {
        Sequence<String> test = this.createFromArgsTest("1", "2", "3", "4");
        Sequence<String> ref = this.createFromArgsRef("1", "2", "3");

        test.remove(3);

        assertEquals(ref, test);
    }

    @Test
    public void lengthTest() {
        Sequence<String> test = this.createFromArgsTest("1", "2", "3", "4");
        Sequence<String> ref = this.createFromArgsRef("1", "2", "3", "4");

        assertEquals(ref.length(), test.length());
    }

    @Test
    public void flipTest() {
        Sequence<String> test = this.createFromArgsTest("1", "2", "3", "4");
        Sequence<String> ref = this.createFromArgsRef("4", "3", "2", "1");

        test.flip();

        assertEquals(ref, test);
    }

    @Test
    public void entryTest() {
        Sequence<String> test = this.createFromArgsTest("1", "2", "3", "4");
        String ref = "2";

        String ans = test.entry(1);

        assertEquals(ref, ans);
    }

}
