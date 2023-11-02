module com.example.retardict {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.retardict to javafx.fxml;
    exports com.example.retardict;
    exports com.example.retardict.game;
    opens com.example.retardict.game to javafx.fxml;
    exports com.example.retardict.game.multipleChoice;
    opens com.example.retardict.game.multipleChoice to javafx.fxml;
}