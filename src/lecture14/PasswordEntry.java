/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 02/05/2017
 */

package lecture14;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

/**
 * This class represents a row in the password file.
 * It is used for binding to the TableView.
 */
public class PasswordEntry implements Serializable {
    private static final int WEBSITE_COL = 0;
    private static final int USERNAME_COL = 1;
    private static final int PASSWORD_COL = 2;
    private String website;
    private String username;
    private String password;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public PasswordEntry(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public String toString(){
        return getWebsite() + " " + getUsername() + " " + getPassword();
    }

    /**
     * Factory method for creating a password entry object from a file row.
     * @param s the row from the file
     * @return the PasswordEntry object
     */
    public static PasswordEntry fromFileEntry(String s) {
        String[] parts = s.split("\\s");
        return new PasswordEntry(parts[WEBSITE_COL], parts[USERNAME_COL], parts[PASSWORD_COL]);
    }
}
