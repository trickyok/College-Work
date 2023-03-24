import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Gage Farmer
 *
 *         idk why this was scheduled due right after spring break....
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";
        NaturalNumber total = new NaturalNumber2();
        NaturalNumber temp = new NaturalNumber2();
        NaturalNumber ZERO = new NaturalNumber2();

        if (exp.numberOfChildren() > 0) {
            for (int i = 0; i < exp.numberOfChildren(); i++) {
                if (exp.label().equals("plus")) {
                    temp = new NaturalNumber2(evaluate(exp.child(i)));
                    total.add(temp);
                } else if (exp.label().equals("minus")) {
                    if (total.compareTo(ZERO) == 0) {
                        temp = new NaturalNumber2(evaluate(exp.child(i)));
                        total.add(temp);
                    } else {
                        temp = new NaturalNumber2(evaluate(exp.child(i)));
                        total.subtract(temp);
                    }
                } else if (exp.label().equals("times")) {
                    if (total.compareTo(ZERO) == 0) {
                        temp = new NaturalNumber2(evaluate(exp.child(i)));
                        total.add(temp);
                    } else {
                        temp = new NaturalNumber2(evaluate(exp.child(i)));
                        total.multiply(temp);
                    }
                } else if (exp.label().equals("divide")) {
                    if (total.compareTo(ZERO) == 0) {
                        temp = new NaturalNumber2(evaluate(exp.child(i)));
                        total.add(temp);
                    } else {
                        assert evaluate(exp.child(i)).compareTo(
                                ZERO) != 0 : "Violation of: Divide by 0";
                        temp = new NaturalNumber2(evaluate(exp.child(i)));
                        total.divide(temp);
                    }
                }

            }
        } else {
            total = new NaturalNumber2(
                    Integer.parseInt(exp.attributeValue("value")));
        }

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return total;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}