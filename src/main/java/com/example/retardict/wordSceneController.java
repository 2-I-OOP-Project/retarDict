package com.example.retardict;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class wordSceneController {
    @FXML
    private Label word;

    @FXML
    public void showWord(String word) {
        if (word == null) {
            this.word.setText("no word selected!");
            return;
        }
        this.word.setText(word);
    }
}
