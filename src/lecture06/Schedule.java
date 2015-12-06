package lecture06;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * Schedule.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/6/2015
 */

/**
 * The Schedule data type.
 */
public class Schedule {
    private String time;
    private String duration;
    private String location;
    private String daysOfWeek;

    /**
     * A schedule must have a time, duration, location, and a days of the week.
     *
     * @param time the time of the scheduled event.
     * @param duration the duration.
     * @param location the location the event occurs.
     * @param daysOfWeek the days of the week the event happens on.
     */
    public Schedule(String time, String duration, String location, String daysOfWeek) {
        this.time = time;
        this.duration = duration;
        this.location = location;
        this.daysOfWeek = daysOfWeek;
    }

    /**
     * Returns a string representation of the scheduled event.
     *
     * @return The string representation of the event.
     */
    public String getSchedule() {
        return "Every " + daysOfWeek + " at " + time + " for " + duration + " in " + location;
    }
}
