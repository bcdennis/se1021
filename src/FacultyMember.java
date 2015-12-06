/**
 * SE1021 – 031 & 032
 * Winter 2016
 * <p>
 * Name: Brad Dennis, Ph.D.
 * Created: 12/6/2015
 */
public class FacultyMember extends Person {

    // Note: In IntelliJ, if you hit alt+enter
    // you can have the IDE generate getters and setters.
    // There is a similar feature in Eclipse.
    private String rank;


    // Note: Getters and setters do not need Javadoc
    // per the standard.
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * New Faculty constructor.  Name and initial rank are required.
     *
     * @param name The name of the faculty member.
     * @param rank The initial rank of the faculty member.
     */
    public FacultyMember(String name, String rank) {
        //What happens if we comment out this?
        super(name);
        setRank(rank);
    }

    /**
     * Returns a String representation of the Faculty Member.
     *
     * @return the String representation of the faculty.
     */
    @Override
    public String toString() {
        return super.toString() + "Rank: " + getRank() + "\n";
    }
}
