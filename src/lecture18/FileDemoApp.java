/**
 * SE1021
 * Winter 2016
 * Lecture 16
 * Name: Brad Dennis
 * Created: 1/21/2016
 */
package lecture18;

import java.io.File;

/**
 * Demonstrates file I/O in java.
 */
public class FileDemoApp {


    public static void main(String[] args) {
        readAFileWithTheFileClass();
        readAFileWithThePathClass();
    }

    private static void readAFileWithTheFileClass() {

    }

    private static void readAFileWithThePathClass() {

        String filename = "src/lecture04/Course2.java";

        File sourceFile = new File(filename);

        if (sourceFile.isDirectory()) {
            System.out.println(file);
        } else if (sourceFile.isFile()) {
            System.out.println(filename +  "is a file.");
        } else {
            System.out.println("not a file");
        }
    }

}
