package lecture07;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * <p>
 * Name: Brad Dennis, Ph.D.
 * Created: 12/12/2015
 */
public abstract class Audi extends  Car {
    private final static String MAKE = "Audi";

    /**
     * All Audi's require a model.
     *
     * @param model The model of the Audi.
     */
    public Audi(String model, String color) {
        super(MAKE, model, color);
    }
}
