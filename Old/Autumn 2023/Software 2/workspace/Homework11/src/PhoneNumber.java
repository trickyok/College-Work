/**
 * Simple class representing a 7-digit phone number in the form "XXX-XXXX" for a
 * phone in the immediate OSU area.
 */
public class PhoneNumber {

    /**
     * The phone number representation.
     */
    private String rep;

    /**
     * Constructor. {@code pNum} must be in the form "XXX-XXXX" where each "X"
     * is a digit '0'-'9'.
     */
    public PhoneNumber(String pNum) {
        this.rep = pNum;
    }

    @Override
    public int hashCode() {

        int hash = 0;

        for (int i = 0; i < 8; i++) {
            // Simply ignore the letters and hope they don't store a number like a silly fella
            if (Character.isDigit(this.rep.charAt(i))) {
                hash += this.rep.charAt(i);
            }
        }

        return hash;
    }

}
