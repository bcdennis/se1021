package lecture04;
/**
 * SE1021 – 031 & 032
 * Winter 2016
 * Lecture 04 - Inheritance, Aggregation, & Composition
 * Name: Brad Dennis, Ph.D.
 * Created: 12/7/2015
 */

import java.util.ArrayList;

/**
 * This is representation of the domain object Course.
 */
public class Course {

    private Faculty instructor;
    private ArrayList<Student> students;
    private String courseId;
    private String courseTitle;

    public Faculty getInstructor() {
        return instructor;
    }

    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }


    /**
     *  Required constructor.
     *
     * @param courseId  The ID of the course.
     * @param courseTitle   The title of the course.
     */
    public Course(String courseId, String courseTitle) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
    }
}
