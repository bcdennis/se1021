package lecture06;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * IScheduleable.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/6/2015
 */

/**
 * The scheduleable interface.  Domain classes that can be scheduled
 * should implement this interface.
 */
public interface IScheduleable {

    void schedule(String time, String duration, String location, String daysOfWeek);
    String getSchedule();
}
