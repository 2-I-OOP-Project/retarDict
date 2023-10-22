package com.example.retardict;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onNotGayButtonClick() {
        welcomeText.setText("You must be gay!");
    }

    @FXML
    protected void onGayButtonClick() {
        welcomeText.setText("Of course you are!");
    }
}