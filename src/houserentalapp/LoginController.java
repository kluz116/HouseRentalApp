/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserentalapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ALLAN
 */
public class LoginController implements Initializable {
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorMessage;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onLogin(ActionEvent event) throws IOException {
        
        
        if(username.getText().equals("admin") && password.getText().equals("admin")){
        
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
               
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("houserentalapp/login.css");
        stage.setTitle("My House Rental Managment System.");
        stage.setScene(scene);
        stage.show();
            
    
  
    }else if(username.getText().isEmpty()){
         errorMessage.setText("Fill In Username");
    }else if(password.getText().isEmpty()){
         errorMessage.setText("Fill In Password");
    }else{
         errorMessage.setText("Wrong Password Or Username");
    }
    }
    
    
    
    
    
    }
    
    
    
    
    

