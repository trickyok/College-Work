import java.util.HashMap;
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
     * @param name[]
     * 			names
     */
    public EmailAccount1(String[] name) {

        this.firstName = name[0];
        this.lastName = name[1];
        this.database = new HashMap<String, Integer>();

        this.number = this.getNumber();

    }
    
    /**
     * Constructor.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     */
    public EmailAccount1(String firstName, String lastName) {
    	 this.firstName = firstName;
         this.lastName = lastName;
         this.database = new HashMap<String, Integer>();

         this.number = this.getNumber();
	}

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
    	int num = 1;

        if (this.database.containsKey(this.lastName)) {
            num = this.database.get(this.lastName);
            num++;
            this.database.replace(firstName, num - 1, num);
        } else {
        	this.database.put(this.lastName, num);
        }
        
        return num;
    }

}
