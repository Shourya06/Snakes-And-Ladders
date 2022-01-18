module com.example.fxmlexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxmlexample to javafx.fxml;
    exports com.example.fxmlexample;
}