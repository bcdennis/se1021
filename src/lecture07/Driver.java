package lecture07;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * Lecture 07 Driver
 * Name: Brad Dennis, Ph.D.
 * Created: 12/12/2015
 */

public class Driver {
    public static void main(String[] args) {

        AudiAllroad car1 = new AudiAllroad("Black", "S-type");
        AudiA6 car2 = new AudiA6("White");

        System.out.println(car1);
        System.out.println(car2);

        Audi car3 = new AudiAllroad("Yellow", "");
        System.out.println(car3);

        Car car4 = new AudiAllroad("Red", "");
        System.out.println(car4);



    }
}
