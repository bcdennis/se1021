package lecture07;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * Car.java
 * Name: Brad Dennis, Ph.D.
 * Created: 12/12/2015
 */

/**
 * A simple car class for demo.
 */
public abstract class Car {
    private final String make;
    private final String model;
    private final String color;

    public String getMake() {
        return make;
    }

    protected String getModel() {
        return model;
    }

    private String getColor() {
        return color;
    }

    /**
     * Make and model are required for cars.
     * @param make  The make of the car.
     * @param model The model of the car.
     */
    public Car(String make, String model, String color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    /**
     * All cars go 'honk honk'.
     */
    public final void honk() {
        System.out.println("Honk honk!");
    }

    /**
     * The String representation the car.
     *
     * @return The car as a string.
     */
    public String toString() {
        return getColor() + " " + getMake() + " " + getModel();
    }

    /**
     * Checks to see if one car is the same as another.
     *
     * @param obj the operand
     * @return whether or not the cars are the same.
     */
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof Car) {
            Car operand = (Car)obj;
            isEqual =  getMake().equals(operand.getMake())
                    && getModel().equals(operand.getModel());
        }

        return isEqual;
    }
}
