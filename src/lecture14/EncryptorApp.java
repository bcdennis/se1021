/*
 * SE1021
 * Winter 2017
 * Name: Brad Dennis, Ph.D.
 * Created: 02/05/2017
 */

package lecture14;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EncryptorApp extends Application {
    private static final Logger LOGGER = Logger.getLogger(EncryptorApp.class.getName());
    private static final String SCENE_TITLE = "";
    private static final double SCENE_WIDTH = 600;
    private static final double SCENE_HEIGHT = 400;
    private static final String SCENE_FXML = "Encryptor.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(SCENE_FXML));
            Parent root = loader.load();

            EncryptorController controller = loader.getController();
            controller.setStaqe(primaryStage);

            primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
            primaryStage.setTitle(SCENE_TITLE);
            primaryStage.show();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}
