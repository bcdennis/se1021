/*
 * SE1021
 * Winter 2016
 * Faculty.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/04/2016
 */
package lecture04;

/**
 * This is representation of the domain object Faculty.
 */
public class Faculty {
    // This constant isn't available outside of this particular class.
    private static final String DEFAULT_TITLE = "";

    private String name;
    private String title;
    private String office;
    private String hours;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getOffice() {
        return office;
    }

    public String getHours() {
        return hours;
    }

    /**
     * The required parameters for every faculty.
     * @param name the name of the faculty
     * @param title the title of the faculty
     * @param office the office where the faculty is located
     * @param hours the faculty office hours
     */
    public Faculty(String name, String title, String office, String hours) {
        this.name = name;
        this.title = title;
        this.office = office;
        this.hours = hours;
    }

    /**
     * Returns the default greeting for all faculty.
     * @return the faculty greeting.
     */
    public String getGreeting() {
        return "Hi, my name is " + getSalutation() + ".";
    }

    /**
     * Returns an announcement of the faculty's office and office hours.
     * @return the announcement
     */
    public String getOfficeInformation() {
        return "My office is " + getOffice() + " and my hours are " + getHours() + ".";
    }

    /**
     * Returns how to address the faculty member formally.
     * @return the formal salutation for the faculty member.
     */
    public String getSalutation() {
        return getTitle() + " " + getName();
    }
}
