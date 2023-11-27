package com.example.retardict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
    enum TABLES {
        userDefinedWords,
        words
    }

    public static void addUserDefinedWord(UserDefinedWord word) {
        try {
            Connection connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userDefinedWords VALUES (?, ?);");
            preparedStatement.setString(1, word.getWord());
            preparedStatement.setString(2, word.getMeaning());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteUserDefinedWord(String word) {
        try {
            Connection connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userDefinedWords WHERE word = ?;");
            preparedStatement.setString(1, word);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editUserDefinedWord(String oldWord, String newWord) {
        try {
            Connection connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE userDefinedWords SET word = ? WHERE word = ?;");
            preparedStatement.setString(1, newWord);
            preparedStatement.setString(2, oldWord);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addTranslationHistory(String sourceLanguage, String targetLanguage, String sourceText, String targetText) {
        try {
            Connection connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO translationHistory VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, sourceLanguage);
            preparedStatement.setString(2, targetLanguage);
            preparedStatement.setString(3, sourceText);
            preparedStatement.setString(4, targetText);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
