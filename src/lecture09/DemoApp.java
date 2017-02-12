/*
 * SE1021
 * Winter 2016
 * Brad Dennis
 * 1/13/2017
 */
package lecture09;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DemoApp extends Application {
    private static final Logger LOGGER = Logger.getLogger(DemoApp.class.getName());
    private static final String SCENE_TITLE = "";
    private static final double SCENE_WIDTH = 200;
    private static final double SCENE_HEIGHT = 100;
    private static final String SCENE_FXML = "Demo.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(SCENE_FXML));
            primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
            primaryStage.setTitle(SCENE_TITLE);
            primaryStage.show();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}
