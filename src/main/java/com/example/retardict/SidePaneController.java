package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SidePaneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("welcomeScene.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = this.getClass().getResource("application.css").toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = this.getClass().getResource("darkTheme.css").toExternalForm();
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
            String css = this.getClass().getResource("application.css").toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = this.getClass().getResource("darkTheme.css").toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToGameScene(ActionEvent event) throws  IOException {
        FXMLLoader gameScene = new FXMLLoader(getClass().getResource("gameScene.fxml"));
        root = gameScene.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = this.getClass().getResource("application.css").toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = this.getClass().getResource("darkTheme.css").toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCatScene(ActionEvent event) {
        System.out.println("nya");
    }

    @FXML
    public void switchToSettingScene(ActionEvent event) throws IOException {
        FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
        root = settingSceneLoader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = this.getClass().getResource("application.css").toExternalForm();
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else {
            String css = this.getClass().getResource("darkTheme.css").toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        stage.setScene(scene);
        stage.show();
    }
}
