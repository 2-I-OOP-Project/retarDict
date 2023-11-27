package com.example.retardict;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingSceneController extends Controller implements Initializable {
    @FXML
    private ImageView imageView;
    @FXML
    private Button themeButton;
    @FXML
    private ChoiceBox<String> accentChooser;

    public static String theme = "LIGHT";
    public static String accentColor = "ORANGE";

    static ObservableList<String> accentColorChoices = FXCollections.observableArrayList(
            "BLUE",
            "ORANGE",
            "GREEN"
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accentChooser.setItems(accentColorChoices);
        accentChooser.setValue(accentColor);
        accentChooser.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                accentColor = accentChooser.getValue();
                System.out.println(accentColor);
                FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
                try {
                    root = settingSceneLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                ApplicationColorController.setColor(scene);
                stage.setScene(scene);
                stage.show();
            }
        });
        if (theme.equals("LIGHT")) {
            themeButton.setText("LIGHT");
        } else if (theme.equals("DARK")) {
            themeButton.setText("DARK");
        }

        FXMLLoader sidePaneLoader = new FXMLLoader(getClass().getResource("SidePane.fxml"));
        try {
            Parent sidePaneLoaded = sidePaneLoader.load();
            rootAnchor.getChildren().addAll(sidePaneLoaded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void changeTheme(ActionEvent event) throws IOException {
        // switch to dark theme
        if (theme.equals("LIGHT")) {
            theme = "DARK";
            themeButton.setText("LIGHT");

            FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
            root = settingSceneLoader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            ApplicationColorController.setColor(scene);
            stage.setScene(scene);
            stage.show();
        } else {
            theme = "LIGHT";
            themeButton.setText("DARK");

            FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
            root = settingSceneLoader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            ApplicationColorController.setColor(scene);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void showImage(ActionEvent event) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src\\main\\resources\\ad.jpg"));
        imageView.setImage(image);
    }

}
