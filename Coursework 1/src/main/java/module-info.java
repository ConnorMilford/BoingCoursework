module com.example.coursework1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coursework1 to javafx.fxml;
    exports com.example.coursework1;
}