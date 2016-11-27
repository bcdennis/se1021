/**
 * SE1021
 * Winter 2016
 * Lecture 20
 * Name: Brad Dennis
 * Created: 2/4/2016
 */
package Winter2016.lecture20;

import java.io.Serializable;

/**
 * A simple person class to demonstrate Serializable and Object I/O streams.
 */
public class Person implements Serializable{

    /*
     * This is a version number of this class.  The runtime uses this number to make sure that
     * the same version is being serialized and deserialized.  If there is a mismatch, a InvalidClassException
     * gets thrown.1
     */
    private static final long serialVersionUID = 1L;
    private String lastName;
    private String firstName;
    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A person requires a name and an email.
     * @param lastName the person's surname.
     * @param firstName the person's name.
     * @param email the person's email.
     */
    public Person(String lastName, String firstName, String email) {
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
    }

    /**
     * Two people are equal when their first and last names are equal and their email address matches.
     * @param obj the operand
     * @return true if the users are the same.
     */
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if ((obj != null) && (obj instanceof Person)) {
            Person operand = (Person)obj;
            isEqual = firstName.equals(operand.firstName)
                    && lastName.equals(operand.lastName)
                    && email.equals(operand.email);
        }

        return isEqual;
    }

    /**
     * A simple string version of the person.
     * @return the person as a string.
     */
    public String toString() {
        return getFirstName() + " " + getLastName() + " - " + getEmail();
    }

    /**
     * JSONify's the person object.
     * @return the JSON for this instance.
     */
    public String toJSON() {
        return "{"
                + "\"lastname\":\"" + getLastName() + "\","
                + "\"firstname\":\"" + getFirstName() + "\","
                + "\"email\":\"" + getEmail() + "\""
                + "}";
    }
}
