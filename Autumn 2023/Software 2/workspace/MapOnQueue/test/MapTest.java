import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    @Test
    public void addTest() {

        Map<String, String> test = this.createFromArgsTest("1", "1", "2", "2");
        Map<String, String> ref = this.createFromArgsRef("1", "1", "2", "2",
                "3", "3");

        test.add("3", "3");

        assertEquals(ref, test);
    }

    @Test
    public void removeTest() {

        Map<String, String> test = this.createFromArgsTest("1", "1", "2", "2",
                "3", "3");
        Map<String, String> ref = this.createFromArgsRef("1", "1", "2", "2");

        test.remove("3");

        assertEquals(ref, test);
    }

    @Test
    public void removeAnyTest() {

        Map<String, String> test = this.createFromArgsTest("1", "1", "2", "2",
                "3", "3");
        Map<String, String> ref = this.createFromArgsRef("2", "2", "3", "3");

        test.removeAny();

        assertEquals(ref, test);
    }

    @Test
    public void valueTest() {

        Map<String, String> test = this.createFromArgsTest("1", "1", "2", "2",
                "3", "3");

        assertEquals("2", test.value("2"));
    }

    @Test
    public void hasKeyTest() {

        Map<String, String> test = this.createFromArgsTest("1", "1", "2", "2",
                "3", "3");

        assertEquals(true, test.hasKey("1"));
        assertEquals(true, test.hasKey("2"));
        assertEquals(true, test.hasKey("3"));
        assertEquals(false, test.hasKey("4"));
        assertEquals(false, test.hasKey("0"));
    }

    @Test
    public void sizeTest() {

        Map<String, String> test = this.createFromArgsTest("1", "1", "2", "2",
                "3", "3");

        assertEquals(3, test.size());
    }

}
