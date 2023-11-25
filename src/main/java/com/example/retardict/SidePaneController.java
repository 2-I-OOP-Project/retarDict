package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SidePaneController extends Controller {
    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("welcomeScene.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = Objects.requireNonNull(this.getClass().getResource("application.css")).toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = Objects.requireNonNull(this.getClass().getResource("darkTheme.css")).toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAddWordScene(ActionEvent event) throws IOException {
        FXMLLoader wordSceneLoader = new FXMLLoader(getClass().getResource("addNewWordScene.fxml"));
        root = wordSceneLoader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = Objects.requireNonNull(this.getClass().getResource("application.css")).toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = Objects.requireNonNull(this.getClass().getResource("darkTheme.css")).toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Function to switch to game scene.
     * ATTENTION: this function is also used in class MultipleChoiceEndController.
     */
    @FXML
    public void switchToGameScene(ActionEvent event) throws  IOException {
        FXMLLoader gameScene = new FXMLLoader(getClass().getResource("gameScene.fxml"));
        root = gameScene.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = Objects.requireNonNull(this.getClass().getResource("application.css")).toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = Objects.requireNonNull(this.getClass().getResource("darkTheme.css")).toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToSettingScene(ActionEvent event) throws IOException {
        FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
        root = settingSceneLoader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = Objects.requireNonNull(this.getClass().getResource("application.css")).toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = Objects.requireNonNull(this.getClass().getResource("darkTheme.css")).toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTranslationScene(ActionEvent event) throws IOException {
        FXMLLoader translationSceneLoader = new FXMLLoader(getClass().getResource("TranslationScene.fxml"));
        root = translationSceneLoader.load();

        TranslationController translationController = translationSceneLoader.getController();
        translationController.init();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = Objects.requireNonNull(this.getClass().getResource("application.css")).toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = Objects.requireNonNull(this.getClass().getResource("darkTheme.css")).toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }
}
