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
public class Report extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception { //To change body of generated methods, choose Tools | Templates.
    
       Parent root = FXMLLoader.load(getClass().getResource("Report.fxml"));
     Scene scene = new Scene(root);
  
     scene.getStylesheets().add("houserentalapp/login.css");
     primaryStage.setScene(scene);
     primaryStage.setTitle("View Rental Reports");
     primaryStage.show();
    }
    
}
