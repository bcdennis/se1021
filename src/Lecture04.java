import java.util.ArrayList;
import java.util.List;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * Lecture 04 - Inheritance, Aggregation, & Composition
 * Name: Brad Dennis, Ph.D.
 * Created: 12/6/2015
 */
public class Lecture04 {

    public static void main(String[] args) {
        Person aPerson = new Person("Jane Doe");
        System.out.println(aPerson.toString());

        FacultyMember drDennis = new FacultyMember("Brad Dennis", "Assistant Professor");
        System.out.println(drDennis.toString());

        //Ex. 1 Implement student. Submit it here:
        //http://goo.gl/forms/F0X3RZWopl

        List<FacultyMember> department = new ArrayList<>();
        department.add(drDennis);

        List<Person> msoePeople = new ArrayList<>();
        msoePeople.add(drDennis);

        //Ex. 2 These are great examples of aggregates.  But what about
        //composites?  How would we implement course?


    }
}
