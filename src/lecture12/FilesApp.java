/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 01/22/2017
 */

package lecture12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Two most common API's
 * http://docs.oracle.com/javase/8/docs/api/java/io/File.html
 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html
 */
public class FilesApp {
    public static void main(String[] args) {
        createAFileUsingPath();
        createFileUsingFile();
        fileAttributes();
        readingAFile();
    }


    private static void createFileUsingFile() {
        File file = new File("file.txt");
        try {
            if(!file.createNewFile()) {
                System.err.format("File named %s already exists.\n", file);
            }
        } catch (IOException e) {
            System.err.format("Unable to create the file: %s\n", e);
        }
    }

    private static void createAFileUsingPath() {

        Path file = new File("path.txt").toPath();

        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException e) {
            System.err.format("File named %s already exists.\n", file);
        } catch (IOException e) {
            // Some other sort of failure, such as permissions.
            System.err.format("Unable to create the file: %s\n", e);
        }


    }

    private static void fileAttributes() {
        File file = new File("file.txt");

        if (file.exists()) {
            System.out.printf("Is the file '%s' an executable? %b\n", file.getName(), file.canExecute());
            System.out.printf("Can we read the file? %b\n", file.canRead());
            System.out.printf("Can we write to the file? %b\n", file.canWrite());
            System.out.printf("The full path is %s\n", file.getAbsolutePath());
            System.out.printf("It was last modified on %s\n", file.lastModified());

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            System.out.printf("It was last modified on %s\n", dateFormat.format(file.lastModified()));
        }
    }


    private static void readingAFile() {
        String filename = "weather.dat";

        withAScanner(filename);
        tryScannerWithResources(filename);
        tryWithBufferedReader(filename);

    }

    private static void withAScanner(String filename) {
        Scanner scanner = null;
        try {

            scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.format("File named %s not found.\n", filename);

        } finally {

            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void tryScannerWithResources(String filename) {

        try (Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.format("File named %s not found.\n", filename);
        }
    }

    private static void tryWithBufferedReader(String filename) {

        List<WeatherRecord> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                WeatherRecord record = WeatherRecord.fromDataFile(line);
                data.add(record);
            }
        } catch (IOException e) {
            System.err.format("Error reading %s.\n", filename);
        } catch (ParseException e) {
            System.err.println("File is incorrectly formatted.  Exiting");
        }
    }

}
