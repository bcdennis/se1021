/*
 * SE1021
 * Winter 2016
 * Driver.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/04/2016
 */
package lecture04;

public class Driver {
    public static void main(String[] args) {
        doInstructorDemo();
        //doInteractiveDemo();
        //doStudentDemo();
    }

    private static void doInstructorDemo() {
        AdjunctFaculty dawson = new AdjunctFaculty("Jack Dawson", "L302", "M:1PM T:11AM");
        System.out.println(dawson.getGreeting());
        System.out.println(dawson.getOfficeInformation());

        FulltimeFaculty dennis = new FulltimeFaculty("Brad Dennis", "L333", "M:1PM T1PM",
                                                      FulltimeFaculty.ASSISTANT_PROFESSOR);

        System.out.println(dennis.getGreeting());
        System.out.println(dennis.getOfficeInformation());
    }


    private static void doStudentDemo() {

    }

    private static void doInteractiveDemo() {

    }

}
