/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserentalapp;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ALLAN
 */
public class ReportController implements Initializable {
    @FXML
    private TableView table1;
    @FXML
    private TableColumn housenumber;
    @FXML
    private TableColumn amountpaid;
    @FXML
    private TableColumn expectedamount;
    @FXML
    private TableColumn  balance;
    @FXML
    private TableColumn datein;
    @FXML
    private TableColumn dateout;
    private ObservableList data;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect();
        try {             
            data = FXCollections.observableArrayList();
            //connect();
           // String query = " select housenumber,amountpaid,expectedamount,balance,datein,dateout from records ";
             String SQL = "SELECT * from records order by housenumber desc";
             rs = st.executeQuery(SQL);
            while (rs.next()) {
                data.add(new UserData(rs.getString("housenumber"),rs.getString("amountpaid"),rs.getString("expectedamount"),rs.getString("balance"),rs.getString("datein"),rs.getString("dateout")));
            }
           
            housenumber.setCellValueFactory(new PropertyValueFactory("HouseNumber"));
            amountpaid.setCellValueFactory(new PropertyValueFactory("AmountPaid"));
            expectedamount.setCellValueFactory(new PropertyValueFactory("ExpectedAmount"));
            balance.setCellValueFactory(new PropertyValueFactory("Balance"));
            datein.setCellValueFactory(new PropertyValueFactory("DateIn"));
            dateout.setCellValueFactory(new PropertyValueFactory("DateOut"));
            //table1.setItems(null);
            table1.setItems(data);
            
        } catch (Exception e) {
            System.out.println("Error on Building Data" +e);
        }
    }    
    public class UserData {

        public  StringProperty HouseNumber;
        public StringProperty AmountPaid;
        public StringProperty ExpectedAmount;
        public StringProperty Balance;
        public StringProperty DateIn;
        public  StringProperty DateOut;

        public UserData(String HouseNumber, String AmountPaid, String ExpectedAmount,String Balance, String DateIn, String DateOut) {
            this.HouseNumber = new SimpleStringProperty(HouseNumber);
            this.AmountPaid = new SimpleStringProperty(AmountPaid);
            this.ExpectedAmount = new SimpleStringProperty(ExpectedAmount);
            this.Balance = new SimpleStringProperty(Balance);
            this.DateIn = new SimpleStringProperty(DateIn);
            this.DateOut = new SimpleStringProperty(DateOut);
        }

        public StringProperty HouseNumberProperty() {
            return HouseNumber;
        }

        public StringProperty AmountPaidProperty() {
            return AmountPaid;
        }
         public StringProperty ExpectedAmountProperty() {
            return ExpectedAmount;
        }

        public StringProperty BalanceProperty() {
            return Balance;
        }
         public StringProperty DateInProperty() {
            return DateIn;
        }

        public StringProperty DateOutProperty() {
            return DateOut;
        }
    } 
    
    public void connect(){
  try{
  Class.forName("com.mysql.jdbc.Driver");
  con= DriverManager.getConnection("jdbc:mysql://localhost/rentalhouse", "root", "");
  st = con.createStatement();
  
  }catch(ClassNotFoundException | SQLException e){
  
  JOptionPane.showMessageDialog(null, "Failed To Connect : " +e);
  }
    
}
  
  
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pr;
}
