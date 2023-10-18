module com.example.retardict {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.retardict to javafx.fxml;
    exports com.example.retardict;
}