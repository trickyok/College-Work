import java.util.Map;

/**
 * Implementation of {@code EmailAccount}.
 *
 * @author Gage Farmer
 *
 */
public final class EmailAccount1 implements EmailAccount {

    /*
     * Private members --------------------------------------------------------
     */

    private Map<String, Integer> database;
    private String firstName;
    private String lastName;
    private int number;

    /*
     * Constructor ------------------------------------------------------------
     */

    /**
     * Constructor.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     */
    public EmailAccount1(String firstName, String lastName,
            Map<String, Integer> database) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.database = database;

        this.number = this.getNumber();

    }

    /*
     * Methods ----------------------------------------------------------------
     */

    @Override
    public String name() {

        // returns "Gage Farmer"
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String emailAddress() {

        // returns "farmer.308@osu.edu"
        return this.lastName.toLowerCase() + "." + this.number + "@osu.edu";
    }

    @Override
    public String toString() {

        // returns "Name: Gage Farmer, Email: farmer.308@osu.edu"
        return "Name: " + this.name() + ", Email: " + this.emailAddress();
    }

    private Integer getNumber() {

        if (this.database.containsKey(this.lastName)) {
            this.database.get(this.lastName);
        }

        return num;
    }

}
