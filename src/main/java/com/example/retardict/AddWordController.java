package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AddWordController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField userDefinedWord;
    @FXML
    private TextField userDefinedMeaning;

    @FXML
    public void switchBackToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("hello-view.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addUserDefinedWord(ActionEvent event) {
        String word = userDefinedWord.getText();
        String meaning = userDefinedMeaning.getText();
        System.out.println(word);
        System.out.println(meaning);
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/testdb.db");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userDefinedWords VALUES (?, ?);");
            preparedStatement.setString(1, word);
            preparedStatement.setString(2, meaning);
            preparedStatement.executeUpdate();
//            Statement statement = connection.createStatement();
//
//            ResultSet rs = statement.executeQuery("SELECT * FROM words;");
//            while (rs.next()) {
//                System.out.println(rs.getString("word"));
//            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public void deleteUserDefinedWord(ActionEvent event) {
//        String word = userDefinedWord.getText();
//        String meaning = userDefinedMeaning.getText();
//        System.out.println(word);
//        System.out.println(meaning);
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/testdb.db");
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userDefinedWords WHERE word = ?;");
//            preparedStatement.setString(1, word);
//            preparedStatement.executeUpdate();
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
