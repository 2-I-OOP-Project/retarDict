package com.example.retardict;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class ApplicationColorController extends Controller {
    public static void setColor(Scene scene) {
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = null;
            if (SettingSceneController.accentColor.equals("BLUE")) {
                css = ApplicationColorController.class.getResource("lightBlue.css").toExternalForm();
                scene.setFill(Color.TRANSPARENT);
            } else if (SettingSceneController.accentColor.equals("ORANGE")) {
                css = ApplicationColorController.class.getResource("lightOrange.css").toExternalForm();
                scene.setFill(Color.TRANSPARENT);
            } else {
                css = ApplicationColorController.class.getResource("lightGreen.css").toExternalForm();
                scene.setFill(Color.TRANSPARENT);
            }
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else if (SettingSceneController.theme.equals("DARK")) {
            String css = null;
            if (SettingSceneController.accentColor.equals("BLUE")) {
                css = ApplicationColorController.class.getResource("darkBlue.css").toExternalForm();
                scene.setFill(Color.TRANSPARENT);
            } else if (SettingSceneController.accentColor.equals("ORANGE")) {
                css = ApplicationColorController.class.getResource("darkOrange.css").toExternalForm();
                scene.setFill(Color.TRANSPARENT);
            } else {
                css = ApplicationColorController.class.getResource("darkGreen.css").toExternalForm();
                scene.setFill(Color.TRANSPARENT);
            }
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
        scene.setFill(Color.TRANSPARENT);
    }
}
