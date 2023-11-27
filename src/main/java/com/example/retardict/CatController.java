package com.example.retardict;

import com.example.retardict.apiservices.CatAPI;
import com.example.retardict.apiservices.TranslateAPI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CatController extends Controller implements Initializable {
    @FXML
    private AnchorPane rootAnchor;

    @FXML
    private ImageView catView;

    @FXML
    private Button closeButton;

    private CatAPI catAPI;

    private CatImage catImage;
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
        String source = "https://cdn2.thecatapi.com/images/cdb.jpg";
        Image catImage = new Image(source);
        catView.setImage(catImage);

        FXMLLoader sidePaneLoader = new FXMLLoader(getClass().getResource("SidePane.fxml"));
        try {
            Parent sidePaneLoaded = sidePaneLoader.load();
            rootAnchor.getChildren().addAll(sidePaneLoaded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void getCat() throws InterruptedException {
        catAPI = new CatAPI();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                catImage = catAPI.getData();
//                System.out.println(catImage.getUrl());
                Image cat = new Image(catImage.getUrl());
                catView.setImage(cat);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
