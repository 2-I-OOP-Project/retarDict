package com.example.retardict;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class addNewWordSceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField userDefinedWord;

    @FXML
    private TextField userDefinedMeaning;

    @FXML
    private ListView<UserDefinedWord> list;

    private Connection connection = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<UserDefinedWord> words = FXCollections.observableArrayList();
        list.setItems(words);
        list.setCellFactory(userDefinedWordListView -> new UserDefinedWordListViewCell());

        try {
            connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM userDefinedWords");

            while (resultSet.next()) {
                UserDefinedWord word = new UserDefinedWord(resultSet.getString("word"), resultSet.getString("meaning"));
                words.add(word);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void switchBackToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("welcomeScene.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addUserDefinedWord(ActionEvent event) {
        UserDefinedWord word = new UserDefinedWord(userDefinedWord.getText(), userDefinedMeaning.getText());
        System.out.println(word.getWord());
        System.out.println(word.getMeaning());
        if (word.getWord() != null) {
            Model.addUserDefinedWord(word);
        }
    }

    @FXML
    public void deleteUserDefinedWord(ActionEvent event) {
//        String word = userDefinedWord.getText();
//        String meaning = userDefinedMeaning.getText();
//        System.out.println(word);
//        System.out.println(meaning);
        System.out.println(list.getFocusModel().focusedItemProperty());

//        try {
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/testdb.db");
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userDefinedWords WHERE word = ?;");
//            preparedStatement.setString(1, word);
//            preparedStatement.executeUpdate();
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
