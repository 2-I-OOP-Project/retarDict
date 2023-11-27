package com.example.retardict;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.retardict.apiservices.TranslateAPI;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TranslationController extends Controller implements Initializable {
    @FXML
    private TextArea inputArea;
    @FXML
    private TextArea outputArea;
    @FXML
    private Label sourceLabel;
    @FXML
    private Label targetLabel;
    private TranslateAPI translateAPI;

    public void init() {
        sourceLabel.setText("English");
        targetLabel.setText("Vietnamese");
    }

    @FXML
    public void translate() throws InterruptedException {
        outputArea.setText("Translating...");
        translateAPI = new TranslateAPI(inputArea.getText(), sourceLabel.getText(), targetLabel.getText());
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                outputArea.setText(translateAPI.getData());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }

    @FXML
    public void swapLanguage() {
        String temp = sourceLabel.getText();
        sourceLabel.setText(targetLabel.getText());
        targetLabel.setText(temp);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader sidePaneLoader = new FXMLLoader(getClass().getResource("SidePane.fxml"));
        try {
            Parent sidePaneLoaded = sidePaneLoader.load();
            rootAnchor.getChildren().addAll(sidePaneLoaded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}