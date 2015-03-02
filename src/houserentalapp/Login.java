/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserentalapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ALLAN
 */
public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
     Scene scene = new Scene(root);
  
     scene.getStylesheets().add("houserentalapp/login.css");
     primaryStage.setScene(scene);
     primaryStage.setTitle("Login Panel");
     primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    } 
}
