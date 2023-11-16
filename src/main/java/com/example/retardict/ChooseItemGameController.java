package com.example.retardict;

import com.example.retardict.game.ChooseItem;
import com.example.retardict.game.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import javafx.scene.control.Label;

public class ChooseItemGameController {
    private Parent root;
    private Scene scene;
    private Stage stage;
    private ChooseItem chooseItem;
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
    private Item correctItem;
    private Item[] items;
    private int numberOfItems;

    public ChooseItemGameController() throws FileNotFoundException {
        items = new Item[4];
        chooseItem = ChooseItem.getChooseItem();
        numberOfItems = chooseItem.getNumberOfItems();
    }

    private boolean checkIfArrayIsNotFull(Item[] items) {
        for (int i = 0; i < 4; i++) {
            if (items[i] == null) {
                return true;
            }
        }
        return false;
    }

    @FXML
    public void initializeQuestion(ActionEvent event) {
        correctItem = chooseItem.returnRandomItem();
        correctItem.setChosen(true);

        int randomIndex = (int) (Math.random() * 4);
        items[randomIndex] = correctItem;

        while (checkIfArrayIsNotFull(items)) {
            randomIndex = (int) (Math.random() * 4);
            Item temp = chooseItem.returnRandomItem();
            if (items[randomIndex] == null && (!temp.isChosen())) {
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
    @FXML
    public void setQuestionByAction(ActionEvent event) {
        for (int i = 0; i < 4; ++i) {
            items[i].setChosen(false);
            items[i] = null;
        }

        correctItem = chooseItem.returnRandomItem();
        correctItem.setChosen(true);

        int randomIndex = (int) (Math.random() * 4);
        items[randomIndex] = correctItem;

        while (checkIfArrayIsNotFull(items)) {
            randomIndex = (int) (Math.random() * 4);
            Item temp = chooseItem.returnRandomItem();

            if (items[randomIndex] == null && (!temp.isChosen())) {
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


    public void clickImageView1(MouseEvent event) {
        if (items[0] == correctItem) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }

    public void clickImageView2(MouseEvent event) {
        if (items[1] == correctItem) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }

    public void clickImageView3(MouseEvent event) {
        if (items[2] == correctItem) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }

    public void clickImageView4(MouseEvent event) {
        if (items[3] == correctItem) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }
}

//
//
//
//    @FXML
//    public void setQuestionByMouse(MouseEvent event) throws FileNotFoundException {
//        ChooseItem chooseItem = ChooseItem.getChooseItem();
//
//        Item correctItem = chooseItem.returnRandomItem();
//        correctItem.setChosen(true);
//
//        Item[] items = new Item[4];
//
//        int randomIndex = (int) (Math.random() * 4);
//        items[randomIndex] = correctItem;
//
//        while (checkIfArrayIsNotFull(items)) {
//            randomIndex = (int) (Math.random() * 4);
//            Item temp = chooseItem.returnRandomItem();
//            if (items[randomIndex] == null && (temp != correctItem) && (!temp.isChosen())) {
//                items[randomIndex] = temp;
//                temp.setChosen(true);
//            }
//        }
//
//        imageView1.setImage(items[0].getImage());
//        imageView2.setImage(items[1].getImage());
//        imageView3.setImage(items[2].getImage());
//        imageView4.setImage(items[3].getImage());
//
//        questionBox.setText(correctItem.getQuestion());
//    }
//}