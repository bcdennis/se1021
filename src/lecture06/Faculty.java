package lecture06;
/**
 * SE1021 – 031 & 032
 * Winter 2016
 * lecture04.Faculty.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/6/2015
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the lecture04.Faculty domain class.
 */
public class Faculty extends Person implements IScheduleable {

    // Note: In IntelliJ, if you hit alt+enter
    // you can have the IDE generate getters and setters.
    // There is a similar feature in Eclipse.
    private String rank;

    private List<IScheduleable> scheduleItems;


    // Note: Getters and setters do not need Javadoc
    // per the standard.
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * New lecture04.Faculty constructor.  Name and initial rank are required.
     *
     * @param name The name of the faculty member.
     * @param rank The initial rank of the faculty member.
     */
    public Faculty(String name, String rank) {
        //What happens if we comment out this?
        super(name);
        setRank(rank);
        scheduleItems = new ArrayList<>();
    }

    /**
     * The faculty have a unique greeting.
     *
     * @return  The faculty's greeting.
     */
    @Override
    public String greet() {
        return "Hello, my name is " + getName();
    }


    /**
     * Schedules this faculty.
     * @param time  the event time.
     * @param duration  the event duration.
     * @param location  the event location.
     * @param daysOfWeek the event days of the week.
     */
    @Override
    public void schedule(String time, String duration, String location, String daysOfWeek) {
       // do something here.
    }

    /**
     * Creates a String representation of the faculty member's schedule
     *
     * @return A String of the schedule.
     */
    @Override
    public String generateSchedule() {
        String schedule = "";

        return schedule;
    }

    /**
     * Returns a String representation of the lecture04.Faculty Member.
     *
     * @return the String representation of the faculty.
     */
    @Override
    public String toString() {
        return super.toString() + "Rank: " + getRank() + "\n";
    }



}
