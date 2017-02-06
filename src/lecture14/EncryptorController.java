/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 02/05/2017
 */
package lecture14;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static javafx.scene.input.DataFormat.PLAIN_TEXT;

/**
 * TODO Add Class Javadocs
 *
 * @author Brad
 */
public class EncryptorController implements Initializable {

    private static final String TEXT_FILE = "txt";
    private static final String DATA_FILE = "dat";
    private static final String BINARY_FILE = "bin";
    private static final String OBJECT_FILE = "obj";

    private static final String TEXT = "text";
    private static final String ROT13 = "rot13";
    private static final String BASE64 = "base64";


    private Stage staqe = null;

    @FXML
    private TextField passwordFileText;
    @FXML
    private TableColumn websiteColumn;
    @FXML
    private TableColumn usernameColumn;
    @FXML
    private TableColumn passwordColumn;
    @FXML
    private TableView passwordsTable;
    @FXML
    private ToggleGroup encryptionSchemes;



    public void setStaqe(Stage staqe) {
        this.staqe = staqe;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {

    }

    public void fileOpenClickHandler(ActionEvent actionEvent) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Load Password File");
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Binary", "*.bin"),
                new FileChooser.ExtensionFilter("Data", "*.dat"),
                new FileChooser.ExtensionFilter("Object", "*.obj")
        );

        File passwordsFile = chooser.showOpenDialog(this.staqe);
        if (passwordsFile != null) {
            passwordFileText.setText(passwordsFile.getAbsolutePath());
        }
    }

    public void encryptClickHandler(ActionEvent actionEvent) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Password File");
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Binary", "*.bin"),
                new FileChooser.ExtensionFilter("Data", "*.dat"),
                new FileChooser.ExtensionFilter("Object", "*.obj")
        );

        File outputFile = chooser.showSaveDialog(this.staqe);
        if (outputFile != null) {
            IEncoder encoder = getEncoder();
            IWriter writer = getWriter(outputFile.getName());
            String contents = getContents(passwordsTable);
            writeFile(outputFile, contents, writer, encoder);
        }
    }

    private String getContents(TableView table) {
        StringBuffer buffer = new StringBuffer();

        ObservableList<PasswordEntry> data =  table.getItems();
        for(PasswordEntry row : data) {
            buffer.append(row + "\n");
        }

        return buffer.toString();
    }

    @SuppressWarnings("unchecked")
    public void loadClickHandler(ActionEvent actionEvent) {
        File sourceFile = new File( passwordFileText.getText());
        ObservableList<PasswordEntry> data = FXCollections.observableList(getListFromFile(sourceFile));

        websiteColumn.setCellValueFactory(new PropertyValueFactory<PasswordEntry, String>("website"));
        websiteColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        websiteColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PasswordEntry, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<PasswordEntry, String> t) {
                ((PasswordEntry) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setWebsite(t.getNewValue());
            }
        });

        usernameColumn.setCellValueFactory(new PropertyValueFactory<PasswordEntry, String>("username"));
        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        usernameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PasswordEntry, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<PasswordEntry, String> t) {
                ((PasswordEntry) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setUsername(t.getNewValue());
            }
        });

        passwordColumn.setCellValueFactory(new PropertyValueFactory<PasswordEntry, String>("password"));
        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PasswordEntry, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<PasswordEntry, String> t) {
                ((PasswordEntry) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setPassword(t.getNewValue());
            }
        });

        passwordsTable.setItems(data);
    }

    private List<PasswordEntry> getListFromFile(File passwordFile) {
        List<PasswordEntry> entries = new ArrayList<>();

        IDecoder decoder = getDecoder(passwordFile);
        IReader reader = getReader(passwordFile.getName());

        String contents = readFile(passwordFile.getAbsolutePath(), reader, decoder);

        for (String s : contents.split("\\r\\n|\\n|\\r")) {
            entries.add(PasswordEntry.fromFileEntry(s));
        }

        return entries;
    }

    public void fileExitClickHandler(ActionEvent actionEvent) {
        System.exit(0);

    }

    private void writeFile(File file, String contents, IWriter writer, IEncoder encoder) {
        writer.write(file.getAbsolutePath(), encoder.encode(contents));
    }

    private String readFile(String filename, IReader reader, IDecoder decoder) {
        return decoder.decode(reader.read(filename));
    }

    private IDecoder getDecoder(File file) {
        IDecoder decoder = (e) -> EncryptionUtils.plainText(e);
        String header = identifyEncoding(FileUtils.peek(file));


        switch(header)  {
            case TEXT:
                break;
            case ROT13:
                decoder = EncryptionUtils::rot13Encoder;
                break;
            case BASE64:
                decoder = EncryptionUtils::base64Encoder;
        }

        return decoder;
    }

    private String identifyEncoding(String header) {
        String encoding = TEXT;

        if (EncryptionUtils.rot13Decoder(header).equals(ROT13)) {
            encoding = ROT13;
        } else if (EncryptionUtils.isBase64(header)) {
            encoding = BASE64;
        }

        return encoding;
    }

    private IEncoder getEncoder() {
        IEncoder encoder = EncryptionUtils::plainText;
        switch (encryptionSchemes.getSelectedToggle().getUserData().toString()) {
            case "TEXT":
                break;
            case ROT13:
                encoder = EncryptionUtils::rot13Encoder;
                break;
            case BASE64:
                encoder = EncryptionUtils::base64Decoder;
                break;
        }

        return encoder;
    }

    private IReader getReader(String filename) {
        IReader reader  = FileUtils::readWithFilesApi;
        String extension = FileUtils.getExtension(filename);

        switch(extension) {
            case TEXT_FILE:
                break;
            case DATA_FILE:
                reader = FileUtils::readWithDataStream;
                break;
            case BINARY_FILE:
                reader = FileUtils::readWithFileStream;
                break;
            case OBJECT_FILE:
                reader = FileUtils::readWithObjectStream;
                break;

        }

        return reader;
    }


    private IWriter getWriter(String filename) {
        IWriter writer  = FileUtils::writeWithFilesApi;
        String extension = FileUtils.getExtension(filename);

        switch(extension) {
            case TEXT_FILE:
                break;
            case DATA_FILE:
                writer = FileUtils::writeWithDataStream;
                break;
            case BINARY_FILE:
                writer = FileUtils::writeWithFileStream;
                break;
            case OBJECT_FILE:
                writer = FileUtils::writeWithObjectStream;
                break;

        }

        return writer;
    }
}
