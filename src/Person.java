/**
 * SE1021 – 031 & 032
 * Winter 2016
 * Person parent class.
 * Name: Brad Dennis, Ph.D.
 * Created: 12/6/2015
 */
public class Person {

    private String name;

    // Note: the coding standard places Getters & Setters
    // above the constructor.
    // see https://goo.gl/MTsXoD
    // The final keyword says no children can override this method.
    // This is the 'final' implementation of this method.
    public final String getName() {
        return name;
    }

    /**
     * Note: There is no default constructor.
     * If you do not have any constructors implemented,
     * Java will inject a no-arg default constructor.
     * If you do, it won't.
     *
     * Try the following code in Lecture04.java
     * Person aPerson = new Person();
     */

    /**
     * A constructor that sets the name.
     * A person is required to have a name.
     *
     * @param name The name of the person.
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Convert the person to a String representation.
     * Note: calling getName here instead of directly
     * accessing the name variable encapsulates any work
     * necessary on the name.
     *
     * @return The String representation of this person.
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\n";
    }
}
