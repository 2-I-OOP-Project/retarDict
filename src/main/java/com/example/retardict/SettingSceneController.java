package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SettingSceneController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private ImageView imageView;

    public static String theme = "LIGHT";

    public static String accentColor = "BLUE";

    @FXML
    public void changeTheme(ActionEvent event) {
        if (theme.equals("LIGHT")) {
            theme = "DARK";
        } else {
            theme = "LIGHT";
        }
    }

    public void showImage(ActionEvent event) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src\\main\\resources\\ad.jpg"));
        imageView.setImage(image);
    }
}
