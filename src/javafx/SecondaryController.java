/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 02/12/2017
 */
package javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * A controller for a second Scene to demo swapping info between scenes.
 *
 * @author Brad
 */
public class SecondaryController implements Initializable {
    public static final String SCENE_TITLE = "Second Scene";
    public static final double SCENE_WIDTH = 600;
    public static final double SCENE_HEIGHT = 400;
    public static final String SCENE_FXML = "Secondary.fxml";

    @FXML
    private TextArea inputTextArea;
    private MainController parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        // TODO
    }

    public void setParentController(MainController controller) {
        parent = controller;
    }

    public void saveButtonHandler(ActionEvent actionEvent) {
        parent.setOutputLabelText(inputTextArea.getText());

        Stage stage = (Stage) inputTextArea.getScene().getWindow();
        stage.close();

    }
}
