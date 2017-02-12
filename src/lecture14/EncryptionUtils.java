/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 02/05/2017
 */

package lecture14;


import java.util.Base64;
import java.util.Scanner;

/**
 * Utility class for encryption stuff.
 */
public class EncryptionUtils {

    private EncryptionUtils() {}


    public static String plainText(String contents) {
        return contents;
    }

    public static String rotate (String token) {
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

    public static String rot13Encoder(String token) {
        return rotate("ROT13\n"+ token);
    }

    public static String rot13Decoder(String token) {
        return rotate(token);
    }

    public static String removeHeader(String contents) {
        StringBuilder buffer = new StringBuilder();
        Scanner scanner = new Scanner(contents);
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            buffer.append(scanner.nextLine());
        }

        return buffer.toString();
    }

    public static String base64Encoder(String token) {
        return  Base64.getEncoder().encodeToString(("BASE64\n"+token).getBytes());
    }

    public static String base64Decoder(String token) {
        return new String(Base64.getDecoder().decode(token));
    }

    public static boolean isBase64(String header) {
        try {
            Base64.getDecoder().decode(header);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
