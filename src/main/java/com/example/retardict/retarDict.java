package com.example.retardict;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class chạy bằng giao diện.
 */
public class retarDict extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        // đoạn code để chạy giao diện nhưng không dùng file fxml
//        Group root = new Group();
//        Scene scene = new Scene(root, Color.BLACK);
//
//        // thêm icon cho app nhưng chưa chạy được
//        Image icon = new Image("D:\\CODING\\code\\retarDict\\src\\main\\resources\\images\\download.jpg");
//        stage.getIcons().add(icon);
//
//        stage.setTitle("retarDict");
//
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(retarDict.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("retarDict");
        Image icon = new Image("C:\\Users\\ADMIN\\things\\intelliJProjects\\dictionaryMaybe\\src\\main\\resources\\images\\download.jpg");
        stage.getIcons().add(icon);
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