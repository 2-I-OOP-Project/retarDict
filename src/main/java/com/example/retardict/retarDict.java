package com.example.retardict;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class chạy bằng giao diện.
 */
public class retarDict extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("retarDict");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

///**
// * Class chạy bằng CommandLine.
// */
//public class retarDict {
//    public static void main(String[] args) {
//        //while(true) chạy liên tục đến khi ngắt chương trình
//        while (true) {
//            DictionaryManagement dict1 = new DictionaryManagement();
//            dict1.insertFromCommandLine();
//            dict1.showAllWords();
//        }
//    }
//}