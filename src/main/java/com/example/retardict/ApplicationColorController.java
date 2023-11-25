package com.example.retardict;

import javafx.scene.Scene;

public class ApplicationColorController {
    public static void setColor(Scene scene) {
        if (SettingSceneController.theme.equals("LIGHT")) {
            String css = null;
            if (SettingSceneController.accentColor.equals("BLUE")) {
                css = ApplicationColorController.class.getResource("lightBlue.css").toExternalForm();
                System.out.println("light blue");
            } else if (SettingSceneController.accentColor.equals("ORANGE")) {
                css = ApplicationColorController.class.getResource("lightOrange.css").toExternalForm();
                System.out.println("light orange");
            } else {
                css = ApplicationColorController.class.getResource("lightGreen.css").toExternalForm();
                System.out.println("light green");
            }
            System.out.println("using light theme");
            scene.getStylesheets().add(css);
        } else if (SettingSceneController.theme.equals("DARK")) {
            String css = null;
            if (SettingSceneController.accentColor.equals("BLUE")) {
                css = ApplicationColorController.class.getResource("darkBlue.css").toExternalForm();
                System.out.println("dark blue");
            } else if (SettingSceneController.accentColor.equals("ORANGE")) {
                css = ApplicationColorController.class.getResource("darkOrange.css").toExternalForm();
                System.out.println("dark orange");
            } else {
                css = ApplicationColorController.class.getResource("darkGreen.css").toExternalForm();
                System.out.println("dark green");
            }
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
        }
    }
}
