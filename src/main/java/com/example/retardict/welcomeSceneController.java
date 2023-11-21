package com.example.retardict;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class welcomeSceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane rootAnchor;

    @FXML
    private ListView<Word> list;

    @FXML
    private TextField searchBox;

    @FXML
    private Label wordLabel;
    @FXML
    private Label pronunciation;
    @FXML
    private Label description;
    @FXML
    private Button closeButton;

    private Word currentSelectedWord;

    private Connection connection = null;

    private double xOffset;
    private double yOffset;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rootAnchor.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        rootAnchor.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });

        ObservableList<Word> words = FXCollections.observableArrayList();
        ObservableList<String> wordNames = null;

        list.setItems(words);

        FXMLLoader sidePaneLoader = new FXMLLoader(getClass().getResource("SidePane.fxml"));
        try {
            Parent sidePaneLoaded = sidePaneLoader.load();
            rootAnchor.getChildren().addAll(sidePaneLoaded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        rootAnchor.setOnMouseMoved(event -> {
//            double x = event.getX();
//            double y = event.getY();
//            rootAnchor.setStyle("-fx-background-color: radial-gradient(center " + 100*x/Utilities.APP_WIDTH + "% " + 100*y/Utilities.APP_HEIGHT + "%, radius 25%, #d4d4d4,  #e8e8e8);");
//            System.out.println("x = " + x + ", y = " + y);
//            System.out.println("x/Utilities.APP_WIDTH = " + x/Utilities.APP_WIDTH + ", y/Utilities.APP_HEIGHT = " + y/Utilities.APP_HEIGHT);
//        });

        try {
            connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from words");

            while (resultSet.next()) {
                Word word = new Word(resultSet.getString("word"), resultSet.getString("pronunciation"), resultSet.getString("description"));
                words.add(word);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchWord() {
        ObservableList<Word> words = FXCollections.observableArrayList();
        list.setItems(words);

        String pattern = '*' + searchBox.getText() + '*';

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from words where (word glob ?)");
            preparedStatement.setString(1, pattern);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Word word = new Word(resultSet.getString("word"), resultSet.getString("pronunciation"), resultSet.getString("description"));
                words.add(word);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void speak(ActionEvent event) {
        System.setProperty(
                "freetts.voices",
                "com.sun.speech.freetts.en.us"
                        + ".cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        Voice[] voices = VoiceManager.getInstance().getVoices();
        for (int i = 0; i < voices.length; i++) {
            System.out.println("# Voices: " + voices[i].getName());
        }
        if (voice != null)
        {
            voice.allocate();
            System.out.println("Voice rate: " + voice.getRate());
            System.out.println("Voice pitch: " + voice.getPitch());
            System.out.println("Voice volume: " + voice.getVolume());
            boolean status = voice.speak(currentSelectedWord.getWord());
            System.out.println("Status: " + status);
            voice.deallocate();
        } else {
            System.err.println("error something");
        }
    }

    @FXML
    public void displayWord(MouseEvent event) throws IOException {
        currentSelectedWord = list.getFocusModel().getFocusedItem();
        wordLabel.setText(currentSelectedWord.getWord());
        pronunciation.setText(currentSelectedWord.getPronunciation());
        description.setText(currentSelectedWord.getDescription());
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}