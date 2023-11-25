package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SidePaneController extends Controller {
    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("welcomeScene.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ApplicationColorController.setColor(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAddWordScene(ActionEvent event) throws IOException {
        FXMLLoader wordSceneLoader = new FXMLLoader(getClass().getResource("addNewWordScene.fxml"));
        root = wordSceneLoader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ApplicationColorController.setColor(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Function to switch to game scene.
     * ATTENTION: this function is also used in class MultipleChoiceEndController.
     */
    @FXML
    public void switchToGameScene(ActionEvent event) throws IOException {
        FXMLLoader gameScene = new FXMLLoader(getClass().getResource("gameScene.fxml"));
        root = gameScene.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ApplicationColorController.setColor(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCatScene(ActionEvent event) {
        System.out.println("nya");
    }

    @FXML
    public void switchToSettingScene(ActionEvent event) throws IOException {
        FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
        root = settingSceneLoader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ApplicationColorController.setColor(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}