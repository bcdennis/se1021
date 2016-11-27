package Winter2016.lecture07;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * <p>
 * Name: Brad Dennis, Ph.D.
 * Created: 12/12/2015
 */
public class AudiAllroad extends Audi {
    private final static String MODEL = "Allroad";
    private final String kit;

    public String getKit() {
        return kit;
    }

    /**
     * Default constructor for Allroad
     */
    public AudiAllroad(String color, String kit) {
        super(MODEL, color);
        this.kit = kit;
    }

    /**
     * A string representation of Audi Allroad
     *
     * @return A string representation of Audi Allroad
     */
    public String toString() {
        return super.toString() + " " + kit + " and I am a sports wagon";
    }

    /**
     * Checks to see if the operand is the same kind of allroad.
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof AudiAllroad) {
            AudiAllroad operand = (AudiAllroad)obj;
            isEqual =  super.equals(operand)
                    && kit.equals(operand.getKit());
        }

        return isEqual;
    }
}
