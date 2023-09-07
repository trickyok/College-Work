import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    // TODO - add test cases for constructor, add, remove, removeAny, contains, and size

    @Test
    public void addTest() {
        Set<String> test = this.createFromArgsTest("1", "2", "3", "4");
        Set<String> ref = this.createFromArgsRef("1", "2", "3", "4", "5");

        test.add("5");

        assertEquals(ref, test);
    }

    @Test
    public void removeTest() {
        Set<String> test = this.createFromArgsTest("1", "2", "3", "4", "5");
        Set<String> ref = this.createFromArgsRef("1", "2", "3", "4");

        test.remove("5");

        assertEquals(ref, test);
    }

    @Test
    public void removeAnyTest() {
        Set<String> test = this.createFromArgsTest("1", "2", "3", "4", "5");
        Set<String> ref = this.createFromArgsRef("1", "2", "4", "5");

        test.removeAny();

        assertEquals(ref, test);
    }

    @Test
    public void containsTest1() {
        Set<String> test = this.createFromArgsTest("1", "2", "3", "4", "5");

        assertEquals(true, test.contains("1"));
    }

    @Test
    public void containsTest2() {
        Set<String> test = this.createFromArgsTest("1", "2", "3", "4", "5");

        assertEquals(true, test.contains("2"));
    }

    @Test
    public void sizeTest() {
        Set<String> test = this.createFromArgsTest("1", "2", "3", "4");

        int size = test.size();

        assertEquals(4, size);
    }

}
