module com.example.skipboserver {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.skipboserver to javafx.fxml;
    exports com.example.skipboserver;
}