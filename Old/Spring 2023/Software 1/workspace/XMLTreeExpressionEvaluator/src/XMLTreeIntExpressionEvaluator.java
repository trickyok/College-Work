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
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";
        int total = 0;

        if (exp.numberOfChildren() > 0) {
            for (int i = 0; i < exp.numberOfChildren(); i++) {
                if (exp.label().equals("plus")) {
                    total += evaluate(exp.child(i));
                } else if (exp.label().equals("minus")) {
                    if (total == 0) {
                        total += evaluate(exp.child(i));
                    } else {
                        total -= evaluate(exp.child(i));
                    }
                } else if (exp.label().equals("times")) {
                    if (total == 0) {
                        total += evaluate(exp.child(i));
                    } else {
                        total *= evaluate(exp.child(i));
                    }
                } else if (exp.label().equals("divide")) {
                    if (total == 0) {
                        total += evaluate(exp.child(i));
                    } else {
                        assert evaluate(exp
                                .child(i)) != 0 : "Violation of: Divide by 0";
                        total /= evaluate(exp.child(i));
                    }
                }

            }
        } else {
            total = Integer.parseInt(exp.attributeValue("value"));
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