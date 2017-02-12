/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 02/12/2017
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * TODO Add Class Javadocs
 *
 * @author Brad
 */
public class MainController implements Initializable {
    private static final Logger LOGGER = Logger.getLogger(SharesApp.class.getName());


    @FXML
    private Label outputLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        // TODO
    }

    public void openButtonHandler(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(SecondaryController.SCENE_FXML));
            Parent root = loader.load();
            Stage secondaryStage = new Stage();
            secondaryStage.setScene(new Scene(root, SecondaryController.SCENE_WIDTH, SecondaryController.SCENE_HEIGHT));
            secondaryStage.setAlwaysOnTop(true);
            secondaryStage.initModality(Modality.APPLICATION_MODAL);
            secondaryStage.setTitle(SecondaryController.SCENE_TITLE);

            SecondaryController controller = loader.getController();
            controller.setParentController(this);

            secondaryStage.show();
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }

    }

    public void setOutputLabelText(String text) {
        outputLabel.setText(text);
    }
}
