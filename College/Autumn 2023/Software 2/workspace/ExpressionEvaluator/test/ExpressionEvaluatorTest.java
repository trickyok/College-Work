import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code ExpressionEvaluator}'s {@code valueOfExpr}
 * static method.
 *
 * @author Put your name here
 *
 */
public final class ExpressionEvaluatorTest {

    @Test
    public void testExample() {
        StringBuilder exp = new StringBuilder(
                "281/7/2-1-5*(15-(14-1))+((1))+20=30!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(30, value);
        assertEquals("=30!", exp.toString());
    }

    // TODO - add other (simpler) test cases to help with debugging

    
    @Test
    public void test1() {
        StringBuilder exp = new StringBuilder(
                "9+10=19!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(19, value);
        assertEquals("=19!", exp.toString());
    }
    
    @Test
    public void test2() {
        StringBuilder exp = new StringBuilder(
                "10-9=1!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(1, value);
        assertEquals("=1!", exp.toString());
    }
}
