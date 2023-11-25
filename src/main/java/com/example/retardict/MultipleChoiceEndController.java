package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MultipleChoiceEndController extends Controller {
    @FXML
    private Label scoreBox;

    @FXML
    public void switchToGameScene(ActionEvent event) throws IOException {
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

    public void displayScore(ActionEvent event, int score, int numberOfQuestions) {
        scoreBox.setText("Your score is: " + score + "/" + numberOfQuestions);
    }
}
