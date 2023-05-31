import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeExploration {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private XMLTreeExploration() {
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

        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");
        XMLTree results = xml.child(0);
        XMLTree channel = results.child(0);
        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);
        XMLTree astronomy = channel.child(10);

        // System.out.println(xml);
        xml.display();
        if (xml.isTag()) {
            System.out.println(xml.label() + " is a tag");
        } else {
            System.out.println(xml.label() + " is text");
        }

        System.out.println(
                "Channel has " + channel.numberOfChildren() + " children");
        System.out.println(titleText);
        System.out.println(xml.child(0).child(0).child(1).child(0));

        if (astronomy.hasAttribute("sunset")) {
            System.out.println("Astronomy has attribute sunset");
        }
        if (astronomy.hasAttribute("midday")) {
            System.out.println("Astronomy has attribute midday");
        }

        System.out.println(astronomy.attributeValue("sunrise"));
        System.out.println(astronomy.attributeValue("sunset"));

        printMiddleNode(channel, out);

        in.close();
        out.close();
    }

    /**
     *  * Output information about the middle child of the given
     * {@code XMLTree}.  *  * @param xt  *            the {@code XMLTree} whose
     * middle child is to be printed  * @param out  *            the output
     * stream  * @updates out.content  * @requires <pre>
      * [the label of the root of xt is a tag]  and
      * [xt has at least one child]  and  out.is_open
      * </pre>  * @ensures <pre>
      * out.content = #out.content * [the label of the middle child
      *  of xt, whether the root of the middle child is a tag or text,
      *  and if it is a tag, the number of children of the middle child]
      * </pre>  
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        int middle = xt.numberOfChildren() / 2;

        System.out.println(xt.child(middle));
    }

}
