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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class welcomeSceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane rootAnchor;

    @FXML
    private ListView<Word> list;

    @FXML
    private TextField searchBox;

    private Connection connection = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Word> words = FXCollections.observableArrayList();
        ObservableList<String> wordNames = null;

        list.setItems(words);

        FXMLLoader sidePaneLoader = new FXMLLoader(getClass().getResource("SidePane.fxml"));
        try {
            Parent sidePaneLoaded = sidePaneLoader.load();
            rootAnchor.getChildren().addAll(sidePaneLoaded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        rootAnchor.setOnMouseMoved(event -> {
//            double x = event.getX();
//            double y = event.getY();
//            rootAnchor.setStyle("-fx-background-color: radial-gradient(center " + 100*x/Utilities.APP_WIDTH + "% " + 100*y/Utilities.APP_HEIGHT + "%, radius 25%, black,  #e8e8e8);");
//            System.out.println("x = " + x + ", y = " + y);
//            System.out.println("x/Utilities.APP_WIDTH = " + x/Utilities.APP_WIDTH + ", y/Utilities.APP_HEIGHT = " + y/Utilities.APP_HEIGHT);
//        });

        try {
            connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from words");

            while (resultSet.next()) {
                Word word = new Word(resultSet.getString("word"), resultSet.getString("pronunciation"), resultSet.getString("description"));
                words.add(word);
//                wordNames.add(word.getWord());

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchWord() {
        ObservableList<Word> words = FXCollections.observableArrayList();
//        ObservableList<String> wordNames = null;
//        for (Word word : words) {
//            wordNames.add(word.getWord());
//        }
        list.setItems(words);

        String pattern = '*' + searchBox.getText() + '*';

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from words where (word glob ?)");
            preparedStatement.setString(1, pattern);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Word word = new Word(resultSet.getString("word"), resultSet.getString("pronunciation"), resultSet.getString("description"));
                words.add(word);
//                wordNames.add(word.getWord());

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void switchToAddWordScene(ActionEvent event) throws IOException {
        FXMLLoader wordSceneLoader = new FXMLLoader(getClass().getResource("addNewWordScene.fxml"));
        root = wordSceneLoader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to word description scene.
     * ERROR: click to blank area of the list will still switch to blank word scene.
     */
    @FXML
    public void switchToWordScene(MouseEvent event) throws IOException {
        FXMLLoader wordSceneLoader = new FXMLLoader(getClass().getResource("wordScene.fxml"));
        root = wordSceneLoader.load();

        Word word = list.getFocusModel().getFocusedItem();
        wordSceneController wordSceneController = wordSceneLoader.getController();
        wordSceneController.showWord(word);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToGameScene(ActionEvent event) throws  IOException {
        FXMLLoader gameScene = new FXMLLoader(getClass().getResource("gameScene.fxml"));
        root = gameScene.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}