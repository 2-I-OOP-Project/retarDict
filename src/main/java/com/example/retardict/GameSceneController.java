package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameSceneController extends Controller implements Initializable {
    @FXML
    private Button numberOfQuestionsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader sidePaneLoader = new FXMLLoader(getClass().getResource("SidePane.fxml"));
        try {
            Parent sidePaneLoaded = sidePaneLoader.load();
            rootAnchor.getChildren().addAll(sidePaneLoaded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void switchToMultipleChoiceScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("multipleChoiceScene.fxml"));
        root = loader.load();

        MultipleChoiceSceneController multipleChoiceSceneController = loader.getController();
        multipleChoiceSceneController.setQuestion(event);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ApplicationColorController.setColor(scene);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToChooseItemGameScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseItemScene.fxml"));
        root = loader.load();

        ChooseItemGameController chooseItemGameController = loader.getController();
        chooseItemGameController.initializeQuestion(event);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ApplicationColorController.setColor(scene);
        stage.setScene(scene);
        stage.show();
    }
}
