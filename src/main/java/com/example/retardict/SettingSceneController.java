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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

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
    @FXML
    private Button closeButton;
    @FXML
    private Rating rating;

    public static boolean premium = false;

    public static String theme = "LIGHT";
    public static String accentColor = "ORANGE";

    static ObservableList<String> accentColorChoices = FXCollections.observableArrayList(
            "BLUE",
            "ORANGE",
            "GREEN"
    );


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
                scene.setFill(Color.TRANSPARENT);
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
            scene.setFill(Color.TRANSPARENT);
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
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void openPremiumRegister(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        FXMLLoader settingSceneLoader = new FXMLLoader(getClass().getResource("premiumRegister.fxml"));
        Parent root = settingSceneLoader.load();

        alert.setGraphic(root);
        alert.show();
    }

    @FXML
    public void handleRating(ActionEvent event) {
        System.out.println(rating.getRating());
    }

    public void showImage(ActionEvent event) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src\\main\\resources\\ad.jpg"));
        imageView.setImage(image);
    }

    @FXML
    public void handleCloseButtonAction(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
