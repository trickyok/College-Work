import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Extension of {@code NaturalNumber2} with secondary operations implemented as
 * instance methods: add, subtract, and power.
 *
 * @author Gage Farmer
 *
 */
public final class NaturalNumberInstanceOps extends NaturalNumber2 {

    /**
     * No-argument constructor.
     */
    public NaturalNumberInstanceOps() {
    }

    /**
     * Constructor from {@code int}.
     *
     * @param i
     *            {@code int} to initialize from
     */
    public NaturalNumberInstanceOps(int i) {
        super(i);
    }

    /**
     * Constructor from {@code String}.
     *
     * @param s
     *            {@code String} to initialize from
     */
    public NaturalNumberInstanceOps(String s) {
        super(s);
    }

    /**
     * Constructor from {@code NaturalNumber}.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     */
    public NaturalNumberInstanceOps(NaturalNumber n) {
        super(n);
    }

    @Override
    public void add(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        /**
         * @decreases n
         */
        int thisLowDigit = this.divideBy10();
        int nLowDigit = n.divideBy10();
        if (!n.isZero()) {
            this.add(n);
        }
        thisLowDigit += nLowDigit;
        if (thisLowDigit >= RADIX) {
            thisLowDigit -= RADIX;
            this.increment();
        }
        this.multiplyBy10(thisLowDigit);
        n.multiplyBy10(nLowDigit);
    }

    @Override
    public void subtract(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        assert this.compareTo(n) >= 0 : "Violation of: this >= n";

        int thisLowDigit = this.divideBy10();
        int nLowDigit = n.divideBy10();
        if (!n.isZero()) {
            this.subtract(n);
        }
        thisLowDigit -= nLowDigit;
        if (thisLowDigit < 0) {
            thisLowDigit += 10;
            this.decrement();
        }
        this.multiplyBy10(thisLowDigit);
        n.multiplyBy10(nLowDigit);

    }

    /**
     * Recursive function that calculates this to 'p'th power.
     *
     * @param p
     *            power, number of recursive cycles to do
     *
     * @param firstNum
     *            original number to do calculations with
     *
     * @ensures firstNum to 'p'th power
     */
    public void power(int p, NaturalNumber firstNum) {
        assert p >= 0 : "Violation of: p >= 0";

        if (firstNum.equals(0)) {
            firstNum.copyFrom(this);
        }

        if (p > 2) {
            this.multiply(firstNum);
            // "Assignment of parameter p is not allowed" <- don't care, didn't ask.
            p -= 1;
            this.power(p);
        }

    }

}