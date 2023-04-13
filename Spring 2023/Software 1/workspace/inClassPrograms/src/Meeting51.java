import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Counts the characters in the input and returns a map of each.
 *
 * @author G. Farmer
 */
public final class Meeting51 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Meeting51() {
        // no code needed here
    }

    /**
     * Increments each element of set by 1.
     *
     * @param set
     *            set to update
     * @updates set
     * @ensures set = [#set with each element incremented by 1]
     **/
    public static void increment(Set<NaturalNumber> set) {
        Set<NaturalNumber> temp = new Set1L<>();
        int i = 0;
        int length = set.size();
        NaturalNumber num = new NaturalNumber2();

        while (i < length) {
            num = set.removeAny();
            num.increment();
            temp.add(num);
            i++;
        }

        set.transferFrom(temp);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("yo mama");
        out.close();
    }

}
