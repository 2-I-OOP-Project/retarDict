package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserDefinedWordListViewCell extends ListCell<UserDefinedWord> {
    @FXML
    private Label wordLabel;
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

            editButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
//                    TextField newWordField = new TextField();
                    if (editWordField.isDisabled()) {
                        System.out.println("disabled");
                        editWordField.setDisable(false);
                        editWordField.setOpacity(1);
                        comfirmEditButton.setDisable(false);
                        comfirmEditButton.setOpacity(1);
                    } else {
                        System.out.println("not");
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
                }
            });

            deleteButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Model.deleteUserDefinedWord(word.getWord());
                }
            });
            setText(null);

            setGraphic(anchorPane);

        }
    }
}
