package com.example.retardict;

import javafx.fxml.FXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Utilities {
    public static final String APP_TITLE = "retarDict";
    public static final String PREMIUM_CODE = "tudiennay10diem";

    public static final int APP_WIDTH = 1280;
    public static final int APP_HEIGHT = 720;
    public static final String PATH_TO_DATABASE = "jdbc:sqlite:src\\main\\resources\\testdb.db";
    public static final String PATH_TO_ICON = "src\\main\\resources\\icon.jpg";
    private static List<String> words = null;

    public static List<String> loadFromTextFile(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            words = myReader.useDelimiter("@").tokens().collect(Collectors.toList());

//            words.forEach(System.out::println);

            for (String word : words) {
                System.out.println("new word:");
                System.out.println(word);
            }

//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
        }
        return words;
    }

    public static void loadToDatabase(List<String> words) {
        try {
            Connection connection = DriverManager.getConnection(Utilities.PATH_TO_DATABASE);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO words VALUES (?, ?, ?);");

            for (String word : words) {
                String[] wholeWord = word.split("\n", 2);
                String[] firstLine = wholeWord[0].split("/", 2);

                String word_target = firstLine[0];
                String pronunciation = null;
                if (firstLine.length != 1) {
                    pronunciation = "/" + firstLine[1];
                }
                String description = null;
                if (wholeWord.length == 2) {
                    description = wholeWord[1];
                }
                statement.setString(1, word_target);
                statement.setString(2, pronunciation);
                statement.setString(3, description);
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<String> words = Utilities.loadFromTextFile("src/main/resources/anhviet109K.txt");
        Utilities.loadToDatabase(words);
    }
}