module com.example.skipboserver {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.google.gson;


    opens com.example.skipboserver to javafx.fxml;
    exports com.example.skipboserver;
    exports com.example.skipboserver.controller;
    opens com.example.skipboserver.controller to javafx.fxml;
}