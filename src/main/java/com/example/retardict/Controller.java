package com.example.retardict;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField searchBox;

    @FXML
    private ListView<Integer> listView = new ListView<>();

    @FXML
    protected void getTextInSearchBox() {
        welcomeText.setText(this.searchBox.getText());
    }

    @FXML
    protected void testFunction() {
        return;
    }
}