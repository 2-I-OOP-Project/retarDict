package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class UserDefinedWordListViewCell extends ListCell<UserDefinedWord> {
    @FXML
    private Label wordLabel;
    @FXML
    private Label meaningLabel;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;
    @FXML
    private TextField editWordField;
    @FXML
    private Button comfirmEditButton;
    @FXML
    private AnchorPane anchorPane;

    private FXMLLoader fxmlloader;

    @Override
    protected void updateItem(UserDefinedWord word, boolean empty) {
        super.updateItem(word, empty);

        if (empty || word.getWord().isEmpty()) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlloader == null) {
                fxmlloader = new FXMLLoader(getClass().getResource("UserDefinedWordListViewCell.fxml"));
                fxmlloader.setController(this);
                try {
                    fxmlloader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            wordLabel.setText(word.getWord());
            meaningLabel.setText(word.getMeaning());

            editButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (editWordField.isDisabled()) {
                        editWordField.setDisable(false);
                        editWordField.setOpacity(1);
                        comfirmEditButton.setDisable(false);
                        comfirmEditButton.setOpacity(1);
                    } else {
                        editWordField.setDisable(true);
                        editWordField.setOpacity(0);
                        comfirmEditButton.setDisable(true);
                        comfirmEditButton.setOpacity(0);
                    }


                    System.out.println(event.getSource());
                }
            });

            comfirmEditButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("edit");
                    String newWord = editWordField.getText();
                    Model.editUserDefinedWord(word.getWord(), newWord);
                    editWordField.setDisable(true);
                    editWordField.setOpacity(0);
                    comfirmEditButton.setDisable(true);
                    comfirmEditButton.setOpacity(0);

                    FXMLLoader wordSceneLoader = new FXMLLoader(getClass().getResource("addNewWordScene.fxml"));
                    Parent root = null;
                    try {
                        root = wordSceneLoader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    ApplicationColorController.setColor(scene);
                    stage.setScene(scene);
                    stage.show();
                }
            });

            deleteButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Model.deleteUserDefinedWord(word.getWord());
                    FXMLLoader wordSceneLoader = new FXMLLoader(getClass().getResource("addNewWordScene.fxml"));
                    Parent root = null;
                    try {
                        root = wordSceneLoader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    ApplicationColorController.setColor(scene);
                    stage.setScene(scene);
                    stage.show();
                }
            });
            setText(null);

            setGraphic(anchorPane);

        }
    }
}
