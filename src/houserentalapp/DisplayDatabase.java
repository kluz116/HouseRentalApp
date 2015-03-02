/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserentalapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ALLAN
 */
public class DisplayDatabase extends Application{
    private static ObservableList<UserMaster> row;
 private static ObservableList<String> col;
    private static void buildData(TableView tableview) {
     
      connect(); 
    String SQL = "select firstname,middlename,lastname,datein from records";
     //UserMaster cm = new UserMaster();
     try{
     String colHeading[]={"First Name","Middle Name","Lastname","Date In"};
     col = FXCollections.observableArrayList(colHeading);
     row= FXCollections.observableArrayList();
    
      rs = st.executeQuery(SQL);

     TableColumn<UserMaster,String> colName = new TableColumn<UserMaster,String>(col.get(0));
     colName.setMinWidth(200);
     colName.setCellValueFactory(new PropertyValueFactory<>("firstname"));

     TableColumn<UserMaster, String> colCourse = new TableColumn<>(col.get(1));
     colCourse.setMinWidth(200);
     colCourse.setCellValueFactory(new PropertyValueFactory<>("middlename"));

     TableColumn<UserMaster, String> colEmail = new TableColumn<>(col.get(2));
     colEmail.setMinWidth(200);
     colEmail.setCellValueFactory(new PropertyValueFactory<>("lastname"));

     TableColumn<UserMaster, String> colCity = new TableColumn<>(col.get(3));
     colCity.setMinWidth(200);
     colCity.setCellValueFactory(new PropertyValueFactory<>("datein"));

     tableview.getColumns().addAll(colName,colCourse,colEmail,colCity);
             //colMobile,colEmail,colDoj,colCity);

     while(rs.next()){

         UserMaster cm = new UserMaster();
         cm.firstname.set(rs.getString("firstname"));
         cm.middlename.set(rs.getString("middlename"));
         cm.lastname.set(rs.getString("lastname"));
         cm.datein.set(rs.getString("datein"));
         row.add(cm);


             System.out.println(row.get(0).getLName());
         }
         tableview.setItems(row);
     }catch(SQLException sqex){
          System.out.println("Error on Building Data"+ sqex); 
     }
    
    }

    @Override
  public void start(Stage stage) throws Exception {  
     stage.setFullScreen(false);  
     TableView tableview;  
     //TableView  
     tableview = new TableView();  
     DisplayDatabase.buildData(tableview);  
     //Adding GridPane  
    
     //Main Scene  
     Scene scene = new Scene(tableview);      
     stage.setScene(scene);  
     stage.show();  
   }  
   public static void main(String args[]){  
     launch(args);  
      connect(); 
   }  
   
   
  public static void connect(){
  try{
  Class.forName("com.mysql.jdbc.Driver");
  con= DriverManager.getConnection("jdbc:mysql://localhost/rentalhouse", "root", "");
  st = con.createStatement();
  
  }catch(ClassNotFoundException | SQLException e){
  
  JOptionPane.showMessageDialog(null, "Failed To Connect : " +e);
  }
    
}
    static Connection con;
    static Statement st;
    static ResultSet rs;
    static PreparedStatement pr;   
}
