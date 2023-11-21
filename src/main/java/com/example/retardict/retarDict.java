package com.example.retardict;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/**
 * Class chạy bằng giao diện.
 */
public class retarDict extends Application {
    public Stage stage;
    public Scene scene;
    private Parent root;

    /**
     * The start function to run application with FXML files
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     */
    @Override
    public void start(Stage stage) throws IOException {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScene.fxml")));

            Scene scene = new Scene(root);
            stage.setTitle(Utilities.APP_TITLE);
            stage.setWidth(Utilities.APP_WIDTH);
            stage.setHeight(Utilities.APP_HEIGHT);
            stage.setResizable(false);

//            Image icon = new Image(Utilities.PATH_TO_ICON);
//            stage.getIcons().add(icon);

            String css = Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}