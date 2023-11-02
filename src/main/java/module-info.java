module com.example.retardict {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires freetts;

    opens com.example.retardict to javafx.fxml;
    exports com.example.retardict;
}