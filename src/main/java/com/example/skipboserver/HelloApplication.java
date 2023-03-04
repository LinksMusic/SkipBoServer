package com.example.skipboserver;

import com.example.skipboserver.connection.Server;
import com.example.skipboserver.management.Gameboard;
import com.example.skipboserver.datatypes.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        Server server = new Server(4200);
        try{
            server.start();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}