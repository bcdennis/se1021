/**
 * SE1021
 * Winter 2016
 * Lecture 20
 * Name: Brad Dennis
 * Created: 2/4/2016
 */
package lecture20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Demonstration app for Object I/O.
 */
public class ObjectIODemoApp {

    public void go() {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("person.bin"))) {

            Person p = new Person("Dennis", "Brad", "bcdennis@gmail.com");
            stream.writeObject(p);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("person.bin"))) {
            Person p = (Person) stream.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ObjectIODemoApp app = new ObjectIODemoApp();
        app.go();
    }
}
