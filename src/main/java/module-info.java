module com.example.retardict {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires freetts;
    requires java.net.http;
    requires org.controlsfx.controls;
    requires com.google.gson;

    opens com.example.retardict to javafx.fxml, com.google.gson;
    exports com.example.retardict;
    exports com.example.retardict.game;
    opens com.example.retardict.game to javafx.fxml;
}