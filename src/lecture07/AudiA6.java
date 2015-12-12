package lecture07;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * <p>
 * Name: Brad Dennis, Ph.D.
 * Created: 12/12/2015
 */
public class AudiA6 extends Audi {
    private final static String MODEL = "A6";

    /**
     * Default constructor for A6
     */
    public AudiA6(String color) {
        super(MODEL, color);
    }

    /**
     * A string representation of Audi A6
     *
     * @return A string representation of Audi A6
     */
    public String toString() {
        return super.toString() + " and I am a luxury sedan.";
    }
}
