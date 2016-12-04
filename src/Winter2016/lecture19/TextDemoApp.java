/**
 * SE1021
 * Winter 2016
 * Lecture 19
 * Name: Brad Dennis
 * Created: 2/4/2016
 */
package Winter2016.lecture19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class demonstrates ways to read and write textfiles.
 */
public class TextDemoApp {

    private static int EOF = -1;

    public static void main(String[] args) {
        TextDemoApp app = new TextDemoApp();
        app.go();
    }

    private void go() {
        String inputFile = "passwords.txt";
        String outputFile = "passwords.enc";
        String binaryFile = "passwords.bin";

        //https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
        //String contents = readFile(inputFile, this::readWithBufferedReader, this::noopDecoder);
        String contents = readFile(inputFile, e->readUsingBufferedReader(e), e->noopDecoder(e));

        writeFile(outputFile, contents, this::writeWithBufferedWriter, this::rotate);
        System.out.println(rotate(contents));

        System.out.println(readFile(outputFile, this::readWithBufferedReader, this::rotate));

        writeBinaryFile(binaryFile, rotate(contents));
        System.out.println(readBinaryFile(binaryFile, this::rotate));

    }

    private String readFile(String filename, IReader reader, IDecoder decoder) {
        return decoder.decode(reader.read(filename));
    }

    private void writeFile(String filename, String contents, IWriter writer, IEncoder encoder) {
        writer.write(filename, encoder.encode(contents));
    }

    private void writeBinaryFile(String filename, String contents) {
        String header = "|PWDv01|" + contents.length() + "\n";
        String trailer = "\n|EOF~";



        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filename)))){
            stream.write(header.getBytes());
            stream.write(contents.getBytes());
            stream.write(trailer.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String readBinaryFile(String filename, IDecoder decoder) {
        String contents = "";
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File(filename)))) {
            byte[] header = new byte[8];
            byte[] bytes = new byte[2];

            int headerLength = stream.read(header);

            if (headerLength != 8) {
                throw new IOException("File header corrupted.");
            }

            if (stream.read(bytes) > 0) {
                int size = Integer.parseInt(new String(bytes));
                byte[] body = new byte[size];
                if (stream.read(body) != size) {
                    throw new IOException("File body corrupted.");
                }

                contents = new String(body);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return decoder.decode(contents);
    }


    /*
     * BufferedReader reads text from a character stream.
     * https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
     */
    private String readWithBufferedReader(String filename) {
        String buffer = "";
        /*
         * FileReader is convenience class for reading characters from a file.
         * https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                buffer += line;
                buffer += "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return buffer;
    }

    /*
     * BufferedReader without try-using
     */
    private String readUsingBufferedReader(String filename) {
        String buffer = "";
        BufferedReader reader = null;

        try {
            String line;
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                buffer += line + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return buffer;
    }

    /*
     * FileInputStream Useful for reading raw bytes
     * https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html
     */
    private String readWithInputStreamReader(String filename) {
        StringBuilder buffer = new StringBuilder();

        /*
         * InputStreamReader converts bytes to characters.
         * https://docs.oracle.com/javase/8/docs/api/java/io/InputStreamReader.html
         */
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "UTF-8")) {

            int character;

            while ((character = reader.read()) != EOF) {
                buffer.append((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    /*
     * Pulling from the stream directly.
     */
    private String readWithFileInputStream(String filename) {
        StringBuilder buffer = new StringBuilder();

        try (FileInputStream stream = new FileInputStream(filename)) {

            //this only works because the file is UTF-8 encoded.
            // i.e. 1 byte = 1 char
            int character;

            while ((character = stream.read()) != EOF) {
                buffer.append((char) character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    /*
     * Low-level reading in chunks with FileInputStream and InputStreamReader
     */
    private String readWithChunkedFileInputStream(String filename) {
        StringBuilder output = new StringBuilder();
        char[] buffer = new char[500];

        /*
         * InputStreamReader can also be read in chunks (many stream readers support this)
         */
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "UTF-8")) {

            int charsRead;

            while ((charsRead = reader.read(buffer, 0, buffer.length)) != EOF) {
                output.append(buffer, 0, charsRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    /*
     * DataInputStream is high-level, it reads in java primitives at a time
     * https://docs.oracle.com/javase/8/docs/api/java/io/DataInputStream.html
     */
    private String readWithDataInputStream(String filename) {
        StringBuilder buffer = new StringBuilder();

        // DataInputStream gives you features such as readInt, readByte, readChar
        try (DataInputStream stream = new DataInputStream(new FileInputStream(filename))) {

            char character;

            while ((character = stream.readChar()) != EOF) {
                buffer.append(character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
    /*
     * Files from the nio package (it's New I/O, not Native I/O)
     * https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
     */
    private String readWithFiles(String filename) {
        Path path = Paths.get(filename);
        ArrayList<String> contents;

        String buffer = "";

        try {
            contents = (ArrayList<String>)Files.readAllLines(path);

            for(String s: contents) {
                buffer += s;
                buffer += "\n";
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return buffer;
    }

    /*
     * Files from the nio package (it's New I/O, not Native I/O)
     * https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
     */
    private void writeWithFiles(String filename, String contents) {

        ArrayList<String> lines = new ArrayList<>(Arrays.asList(contents.split("\\n")));
        try {
            Files.write(new File(filename).toPath(), lines);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * PrintWriter - Gives you all the features from PrintStream
     * https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html
     */
    private void writeWithPrintWriter(String filename, String contents) {

        // Doesn't give you a way to write bytes
       try (PrintWriter writer = new PrintWriter(new File(filename))) {
            writer.write(contents);
            //PrintWriter doesn't throw IOException
           System.out.println(writer.checkError());

       } catch (FileNotFoundException e) {
           e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    /*
     * Buffering typically improves performance and reliability.
     * https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html
     */
    private void writeWithBufferedWriter(String filename, String contents) {
        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(new File(filename)))) {
            writer.write(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * FileOutputStream - useful for writing raw bytes.
     * https://docs.oracle.com/javase/8/docs/api/java/io/FileOutputStream.html
     */
    private void writeWithFileOutputStream(String filename, String contents) {
        try (FileOutputStream stream = new FileOutputStream(new File(filename))) {
            byte[] bytes = contents.getBytes();
            stream.write(bytes);

            //stream.flush()
            //stream.close() //AutoCloseable

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * DataOutputStream - writes Java primitives in a portable way
     * https://docs.oracle.com/javase/8/docs/api/java/io/DataOutputStream.html
     */
    private void writeWithDataOutputStream(String filename, String contents) {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(filename))) {
            //you also have things like stream.writeInt, writeBoolean, etc.

            stream.writeUTF(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String noopDecoder (String token) {
        return token;
    }

    private String rotate (String token) {
        char[] word = token.toCharArray();


        for (int i = 0; i < word.length; i++) {
            char letter = word[i];

            if (letter >= 'a' && letter <= 'z') {
                if (letter > 'm') {
                    word[i] -= 13;
                } else {
                    word[i] += 13;
                }
            } else if (letter >= 'A' && letter <= 'Z') {
                if (letter > 'M') {
                    word[i] -= 13;
                } else {
                    word[i] += 13;
                }
            }


        }

        return new String(word);
    }

}
