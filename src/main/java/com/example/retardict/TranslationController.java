package com.example.retardict;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class TranslationController extends Controller implements Initializable {
    @FXML
    private AnchorPane rootAnchor;
    @FXML
    private TextArea inputArea;
    @FXML
    private TextArea outputArea;
    @FXML
    private Label sourceLabel;
    @FXML
    private Label targetLabel;

    public void init() {
        sourceLabel.setText("English");
        targetLabel.setText("Vietnamese");
    }

    @FXML
    public void translate() {
        String input = URLEncoder.encode(inputArea.getText(), StandardCharsets.UTF_8);

        if (input.isEmpty()) {
            inputArea.setText("No input!");
            return;
        }

        outputArea.setText("Translating...");

        String temp;
        if (sourceLabel.getText().equals("English")) {
            temp = "&target=vi&source=en";
        } else {
            temp = "&target=en&source=vi";
        }

        new Thread(() -> {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
                        .header("content-type", "application/x-www-form-urlencoded")
                        .header("Accept-Encoding", "application/gzip")
                        .header("X-RapidAPI-Key", "917d80f0d6msh6983d78e51b0189p19a167jsnee9220e7fdbd")
                        .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                        .method("POST", HttpRequest.BodyPublishers.ofString("q=" + input + temp))
                        .build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

                Platform.runLater(() -> outputArea.setText(response.body().split("\\:")[3].replace("\"}]}}", "").replace("\"", "")));
            } catch (IOException | InterruptedException e) {
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