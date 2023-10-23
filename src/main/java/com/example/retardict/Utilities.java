package com.example.retardict;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utilities {
    public static void loadFromTextFile(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            List<String> words = myReader.useDelimiter("@").tokens().collect(Collectors.toList());

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
    }

    public static void main(String[] args) {
//        Utilities.loadFromTextFile("src/main/resources/anhviet109K.txt");

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:/intelliJ/DictionaryMaybe/src/main/resources/testdb.db");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from test");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("surname = " + rs.getString("surname"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
