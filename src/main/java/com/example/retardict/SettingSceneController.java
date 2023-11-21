package com.example.retardict;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Stylesheet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingSceneController implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private ImageView imageView;

    @FXML
    private AnchorPane rootAnchor;

    @FXML
    private Button themeButton;

    @FXML
    private ChoiceBox<String> accentChooser;

    public static String theme = "LIGHT";

    public static String accentColor = "BLUE";

    static ObservableList<String> accentColorChoices = FXCollections.observableArrayList(
            "BLUE",
            "ORANGE",
            "RED",
            "GREEN"
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accentChooser.setItems(accentColorChoices);
        accentChooser.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                accentColor = accentChooser.getValue();
                System.out.println(accentColor);
            }
        });
        FXMLLoader sidePaneLoader = new FXMLLoader(getClass().getResource("SidePane.fxml"));
        if(theme.equals("LIGHT")) {
            themeButton.setText("LIGHT");
        } else if (theme.equals("DARK")) {
            themeButton.setText("DARK");
        }
//        SwitchButton themeSwitcher = new SwitchButton();
//        themeSwitcher.setLayoutX(800);
//        themeSwitcher.setLayoutY(250);
//        themeSwitcher.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                changeTheme(themeSwitcher.getState());
//            }
//        });
//        rootAnchor.getChildren().addAll(themeSwitcher);

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
            System.out.println("dark");
            theme = "DARK";
            themeButton.setText("LIGHT");

            FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
            root = settingSceneLoader.load();

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            String css = this.getClass().getResource("darkTheme.css").toExternalForm();
            System.out.println("using dark theme");
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("light");
            theme = "LIGHT";
            themeButton.setText("DARK");

            FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("SettingScene.fxml"));
            root = settingSceneLoader.load();

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();

            System.out.println("using light theme");
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void showImage(ActionEvent event) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src\\main\\resources\\ad.jpg"));
        imageView.setImage(image);
    }

}
