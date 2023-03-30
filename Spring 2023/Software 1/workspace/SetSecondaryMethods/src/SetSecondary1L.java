import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {

    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        Set<T> removed = s.newInstance();
        Set<T> restore = s.newInstance();
        T temp;

        while (s.size() > 0) {
            temp = s.removeAny();
            if (this.contains(temp)) {
                this.remove(temp);
                removed.add(temp);
            }
            restore.add(temp);
        }

        s.transferFrom(restore);
        ;

        return removed;
    }

    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        int i = s.size();
        T temp;
        Set<T> backup = s.newInstance();

        while (i > 0) {
            temp = s.removeAny();
            if (!this.contains(temp)) {
                this.add(temp);

            } else {
                backup.add(temp);
            }

            i--;
        }

        s.transferFrom(backup);

    }

    /**
     * Reports whether {@code this} is a subset of {@code s}. (A is a subset of
     * B exactly when every element of A is also an element of B.)
     *
     * @param s
     *            the second set
     * @return whether {@code this} is a subset of {@code s}
     * @ensures isSubset = (this is subset of s)
     */
    @Override
    public boolean isSubset(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        boolean result = true;
        int count = 0;
        T num;
        Set<T> temp = new Set1L<>();

        while (count < s.size()) {
            num = s.removeAny();
            temp.add(num);
            s.add(num);
            count++;
        }

        return temp.isSubset(this);
    }

}
