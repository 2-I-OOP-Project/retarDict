package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class addNewWordSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void switchBackToMainScene(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("welcomeScene.fxml"));
//        root = fxmlLoader.load();

        Parent root = FXMLLoader.load(getClass().getResource("welcomeScene.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("switchBackToMainScene");
    }
}
