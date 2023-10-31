package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class wordSceneController {
    @FXML
    private Label word;
    @FXML
    private Label pronunciation;
    @FXML
    private Label description;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void showWord(Word word) {
        if (word == null) {
            this.word.setText("no word selected!");
            return;
        }
        this.word.setText(word.getWord());
        this.pronunciation.setText(word.getPronunciation());
        this.description.setText(word.getDescription());
    }

    @FXML
    public void showPronunciation(String word) {
        if (word == null) {
            this.pronunciation.setText("no pronunciation!");
            return;
        }
        this.pronunciation.setText(word);
    }

    @FXML
    public void showDescription(String word) {
        if (word == null) {
            this.description.setText("no description!");
            return;
        }
        this.description.setText(word);
    }

    @FXML
    public void switchBackToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("welcomeScene.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
