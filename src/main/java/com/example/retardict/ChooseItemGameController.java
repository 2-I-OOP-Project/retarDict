package com.example.retardict;

import com.example.retardict.game.ChooseItem;
import com.example.retardict.game.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Label;

public class ChooseItemGameController implements Initializable {
    private Parent root;
    private Scene scene;
    private Stage stage;
    private final ChooseItem chooseItem = ChooseItem.getChooseItem();
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private Label questionBox;
    @FXML
    private AnchorPane rootAnchor;

    public ChooseItemGameController() throws FileNotFoundException {
    }

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

    private boolean checkIfArrayIsFull(Item[] items, int size) {
        for (int i = 0; i < size; i++) {
            if (items[i] == null) {
                return false;
            }
        }
        return true;
    }

    @FXML
    public void setQuestion(ActionEvent event) throws FileNotFoundException {
        ChooseItem chooseItem = ChooseItem.getChooseItem();

        Item correctItem = chooseItem.returnRandomItem();
        correctItem.setChosen(true);

        Item[] items = new Item[4];

        int randomIndex = (int) (Math.random() * 4);
        items[randomIndex] = correctItem;

        while (!checkIfArrayIsFull(items, 4)) {
            randomIndex = (int) (Math.random() * 4);
            Item temp = chooseItem.returnRandomItem();
            if (items[randomIndex] == null && (temp != correctItem) && (!temp.isChosen())) {
                items[randomIndex] = temp;
                temp.setChosen(true);
            }
        }

        imageView1.setImage(items[0].getImage());
        imageView2.setImage(items[1].getImage());
        imageView3.setImage(items[2].getImage());
        imageView4.setImage(items[3].getImage());

        questionBox.setText(correctItem.getQuestion());
    }
}
