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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class welcomeSceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static final String PATH_TO_DATABASE_CONNECTION = "jdbc:sqlite:D:\\CODING\\code\\retarDict\\src\\main\\resources\\testdb.db";

    @FXML
    private ListView<String> list;

    @FXML
    private TextField searchBox;

    private Connection connection = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> words = FXCollections.observableArrayList();
        list.setItems(words);

        try {
            connection = DriverManager.getConnection(PATH_TO_DATABASE_CONNECTION);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select word from words");

            while (resultSet.next()) {
                words.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchWord() {
        ObservableList<String> words = FXCollections.observableArrayList();
        list.setItems(words);

        String pattern = '*' + searchBox.getText() + '*';

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select word from words where (word glob ?)");
            preparedStatement.setString(1, pattern);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                words.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void switchToAddWordScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addNewWordScene.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("switchToAddWordScene");
    }

    /**
     * Switch to word description scene.
     * ERROR: click to blank area of the list will still switch to blank word scene.
     */
    @FXML
    public void switchToWordScene(MouseEvent event) throws IOException {
        FXMLLoader wordSceneLoader = new FXMLLoader(getClass().getResource("wordScene.fxml"));
        root = wordSceneLoader.load();

        String word = list.getFocusModel().getFocusedItem();
        wordSceneController wordSceneController = wordSceneLoader.getController();
        wordSceneController.showWord(word);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("switchToAddWordScene");
    }
}