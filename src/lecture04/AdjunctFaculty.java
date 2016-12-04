/*
 * SE1021
 * Winter 2016
 * AdjunctFaculty.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/04/2016
 */
package lecture04;

/**
 * This class models the adjunct faculty for our demo.
 */
public class AdjunctFaculty extends Faculty{
    private static final String TITLE = "Professor";

    /**
     * Adjunct faculty have a name, an office and office hours.
     * @param name the faculty name.
     * @param office the office.
     * @param hours the instructor office hours.
     */
    public AdjunctFaculty(String name, String office, String hours) {
        super(name, TITLE, office, hours);
    }
}
