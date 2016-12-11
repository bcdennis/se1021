/*
 * SE1021
 * Winter 2016
 * FulltimeFaculty.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/04/2016
 */
package lecture04;

/**
 * This class models a fulltime faculty at MSOE.
 */
public class FulltimeFaculty extends Faculty{
    public static final String ASSISTANT_PROFESSOR = "Assistant Professor";
    public static final String ASSOCIATE_PROFESSOR = "Associate Professor";
    public static final String FULL_PROFESSOR = "Professor";
    private static final String TITLE = "Dr.";
    private final String rank;


    public String getRank() {
        return rank;
    }
    /**
     * The required parameters for every faculty.
     *
     * @param name   the name of the faculty
     * @param office the office where the faculty is located
     * @param hours  the faculty office hours
     * @param rank the faculty rank
     */
    public FulltimeFaculty(String name, String office, String hours, String rank) {
        //super(name,TITLE , office, hours);
        this.rank = rank;
    }

    /**
     * Returns the greeting for fulltime faculty.
     * @return the faculty greeting.
     */
    @Override
    public String getGreeting() {
        return super.getGreeting() + " I am a(n) " + getRank() + ".";
    }

}
