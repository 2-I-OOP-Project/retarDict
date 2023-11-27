package com.example.retardict;

import com.example.retardict.Word;
import com.example.retardict.retarDict;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class wordSceneController extends Controller implements Initializable {
    @FXML
    private Label wordLabel;
    @FXML
    private Label pronunciation;
    @FXML
    private Label description;

    private Word word;

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
    public void showWord(Word inputWord) {
        this.word = inputWord;
        if (inputWord == null) {
            this.wordLabel.setText("no word selected!");
            return;
        }
        this.wordLabel.setText(word.getWord());
        this.pronunciation.setText(word.getPronunciation());
        this.description.setText(word.getDescription());
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
            boolean status = voice.speak(word.getWord());
            System.out.println("Status: " + status);
            voice.deallocate();
        } else {
            System.err.println("error something");
        }
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
