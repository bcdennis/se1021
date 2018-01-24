/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 02/05/2017
 */

package lecture14;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Utility Class for file I/O
 */
public class FileUtils {
    private static final Logger LOGGER = Logger.getLogger(EncryptorApp.class.getName());
    private static int EOF = -1;

    private FileUtils() {
    }

    public static String getExtension(String filename) {
        if (filename == null) {
            return null;
        }

        int index = Math.max(filename.lastIndexOf("."), filename.lastIndexOf("."));
        return filename.toLowerCase().substring(index + 1);
    }

    /*
     * Files from the nio package (it's New I/O, not Native I/O)
     * https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
     */
    public static String readWithFilesApi(String filename) {
        Path path = Paths.get(filename);
        ArrayList<String> contents;

        StringBuilder buffer = new StringBuilder();

        try {
            contents = (ArrayList<String>) Files.readAllLines(path);

            for (String s : contents) {
                buffer.append(s);
                buffer.append("\n");
            }
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }

        return buffer.toString();
    }

    /*
     * DataInputStream is high-level, it reads in java primitives at a time
     * https://docs.oracle.com/javase/8/docs/api/java/io/DataInputStream.html
     */
    public static String readWithDataStream(String filename) {
        String contents = "";

        // DataInputStream gives you features such as readInt, readByte, readChar
        try (DataInputStream stream = new DataInputStream(new FileInputStream(filename))) {
            contents = stream.readUTF();
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }

        return contents;
    }

    /*
     * Pulling from the stream directly.
     */
    public static String readWithFileStream(String filename) {
        StringBuilder buffer = new StringBuilder();

        try (FileInputStream stream = new FileInputStream(filename)) {

            //this only works because the file is UTF-8 encoded.
            // i.e. 1 byte = 1 char
            int character;

            while ((character = stream.read()) != EOF) {
                buffer.append((char) character);
            }

        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }

        return buffer.toString();
    }

    /*
     * Low-level reading in chunks with FileInputStream and InputStreamReader
     */
    public static String readWithChunkedFileInputStream(String filename) {
        StringBuilder output = new StringBuilder();
        char[] buffer = new char[512];

        /*
         * InputStreamReader can also be read in chunks (many stream readers support this)
         */
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "UTF-8")) {

            int charsRead;

            while ((charsRead = reader.read(buffer, 0, buffer.length)) != EOF) {
                output.append(buffer, 0, charsRead);
            }

        } catch (IOException e) {
            LOGGER.severe(e.getMessage());

        }

        return output.toString();
    }


    public static String readWithObjectStream(String filename) {
        StringBuilder buffer = new StringBuilder();

        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename))) {
            PasswordEntry entry;
            while ((entry = (PasswordEntry) stream.readObject()) != null) {
                buffer.append(entry);
                buffer.append("\n");
            }

        } catch (ClassNotFoundException | IOException e) {
            LOGGER.severe(e.getMessage());
        }


        return buffer.toString();
    }

    /**
     * Peeks into the first line of the file.
     *
     * @param file the file to check
     * @return the first line of the file
     */
    public static String peek(File file) {
        String head = "";
        Path path = file.toPath();
        ArrayList<String> contents;

        try {
            contents = (ArrayList<String>) Files.readAllLines(path);
            head = contents.get(0);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());

        }

        return head;
    }

    /*
     * Files from the nio package (it's New I/O, not Native I/O)
     * https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
     */
    public static void writeWithFilesApi(String filename, String contents) {

        ArrayList<String> lines = new ArrayList<>(Arrays.asList(contents.split("\\n")));
        try {
            Files.write(new File(filename).toPath(), lines);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());

        }
    }

    /*
     * FileOutputStream - useful for writing raw bytes.
     * https://docs.oracle.com/javase/8/docs/api/java/io/FileOutputStream.html
     */
    public static void writeWithFileStream(String filename, String contents) {
        try (FileOutputStream stream = new FileOutputStream(new File(filename))) {
            byte[] bytes = contents.getBytes(StandardCharsets.UTF_8);
            stream.write(bytes);

            stream.flush();
            stream.close(); //AutoCloseable

        } catch (IOException e) {
            LOGGER.severe(e.getMessage());

        }
    }

    /*
     * DataOutputStream allows you to write java primitives in a "java" portable way.
     * https://docs.oracle.com/javase/8/docs/api/java/io/DataOutputStream.html
     */
    public static void writeWithDataStream(String filename, String contents) {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(filename))) {
            //you also have things like stream.writeInt, writeBoolean, etc.

            stream.writeUTF(contents);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());

        }
    }

    /*
     * ObjectOutputStream allows you to write java objects in a "java" portable way.
     * https://docs.oracle.com/javase/8/docs/api/java/io/ObjectOutputStream.html
     */
    public static void writeWithObjectStream(String filename, String contents) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream((filename)))) {

            for (String s : contents.split("\\r\\n|\\n|\\r")) {
                stream.writeObject(PasswordEntry.fromFileEntry(s));
            }

        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    /*
     * PrintWriter - Gives you all the features from PrintStream
     * https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html
     */
    public static void writeWithPrintWriter(String filename, String contents) {

        // Doesn't give you a way to write bytes
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            writer.write(contents);
            //PrintWriter doesn't throw IOException
            System.out.println(writer.checkError());

        } catch (FileNotFoundException e) {
            LOGGER.severe(e.getMessage());

        }
    }

    /*
     * Buffering typically improves performance and reliability.
     * https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html
     */
    public static void writeWithBufferedWriter(String filename, String contents) {
        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(new File(filename)))) {
            writer.write(contents);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());

        }
    }

    /*
     * FileWriter a class for writing text files.
     * https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html
     */
    private void writeWithFileWriter(String filename, String contents) {
        try (FileWriter writer = new FileWriter(new File(filename))) {
            writer.write(contents);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());

        }
    }
}
