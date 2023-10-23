package com.example.retardict;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utilities {
    public static List<String> loadFromTextFile(String filePath) {
        List<String> words = null;
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
            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:/intelliJ/DictionaryMaybe/src/main/resources/testdb.db");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO words VALUES (?, ?, ?);");

            for (String word : words) {
                String[] wholeWord = word.split("\n",2);
                String[] firstLine = wholeWord[0].split("/",2);

                String word_target = firstLine[0];
                String pronunciation = "/" + firstLine[1];
                String description = wholeWord[1];
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
        List<String> words = Utilities.loadFromTextFile("src/main/resources/test.txt");
        Utilities.loadToDatabase(words);


//        try {
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:/intelliJ/DictionaryMaybe/src/main/resources/testdb.db");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from test");
//            while(rs.next()) {
//                // read the result set
//                System.out.println("name = " + rs.getString("name"));
//                System.out.println("surname = " + rs.getString("surname"));
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
    }
}
