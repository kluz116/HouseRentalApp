/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserentalapp;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ALLAN
 */
public class FXMLDocumentController implements Initializable {
     @FXML
    private Pane pane3;
    @FXML
    private TextField firstname;
    @FXML
    private TextField middlename;
    @FXML
    private TextField lastname;
    @FXML
    private TextField search;
    @FXML
    private ComboBox<String> housenumber;
    @FXML
    private DatePicker date;
    @FXML
    private DatePicker date1;
    @FXML
    private Text results;
    @FXML
    private ComboBox<String> housetype;
    @FXML
    private TextField amountpaid;
    @FXML
    private ComboBox<String> amountpermonth;
    @FXML
    private ComboBox<String> month;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private TableView table;
    @FXML
    private TableColumn fname;
    @FXML
    private TableColumn mname;
    @FXML
    private TableColumn lname;
    @FXML
    private TableColumn hnumber;
    @FXML
    private TableColumn htype;
    @FXML
    private TableColumn apermonth;
    @FXML
    private TableColumn monthhh;
    @FXML
    private TableColumn apaid;
    @FXML
    private TableColumn expectedamount;
    @FXML
    private TableColumn balance;
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
        housenumber.setItems(list1);
        housetype.setItems(list2);
        amountpermonth.setItems(list3);
        month.setItems(list4);
        getRentalRecords();
        //addRentalClient();
    }   
    
    ObservableList<String> list1 = FXCollections.observableArrayList("No.1","No.2","No.3","No.4","No.5","No.6","No.7","No.8","No.9","No.10","No.11","No.12","No.13","No.14");
    ObservableList<String> list2 = FXCollections.observableArrayList("Single Room","Double Room","Full House");
    ObservableList<String> list3 = FXCollections.observableArrayList("25000","45000","85000");
    ObservableList<String> list4 = FXCollections.observableArrayList("3","6","8","12");

    @FXML
    private void onSave(ActionEvent event) throws SQLException {
        addRentalClient();
        getRentalRecords();
    }

    @FXML
    private void onUpdate(ActionEvent event) {
        Update();
        getRentalRecords();
    }

    @FXML
    private void onSignOut(ActionEvent event) throws IOException {
     ((Node)(event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
     Scene scene = new Scene(root);
     scene.getStylesheets().add("houserentalapp/login.css");
     Stage primaryStage = new Stage();
     primaryStage.setScene(scene);
     primaryStage.show();
    }

    @FXML
    private void onSearch(KeyEvent event) {
        searchClient();
    }

    @FXML
    private void onDelete(ActionEvent event) {
         Delete();
         getRentalRecords();
    }

    @FXML
    private void onReport(ActionEvent event) throws IOException {
        //((Node)(event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("Report.fxml"));
     Scene scene = new Scene(root);
     scene.getStylesheets().add("houserentalapp/login.css");
     Stage primaryStage = new Stage();
     primaryStage.setTitle("View Rental Reports");
     primaryStage.setScene(scene);
     primaryStage.show();
    }
    
     public void addRentalClient() throws SQLException{
           String NAME_PATTERN = "[a-zA-Z]";
           String AMOUT_PAID = "[0-9]";
            
            Pattern pattern = Pattern.compile(NAME_PATTERN);
            Pattern pattern1 = Pattern.compile(AMOUT_PAID);
            Matcher reg = pattern.matcher(lastname.getText());
            Matcher reg1 = pattern.matcher(middlename.getText());
            Matcher reg2 = pattern.matcher(firstname.getText());
            Matcher reg3 = pattern1.matcher(amountpaid.getText());
            
        try{
            if(firstname.getText().isEmpty()){
                results.setText("*Fill In First Name*");
            }else if(!reg2.matches()){
            results.setText("*Should be Characters*");
            }else if(middlename.getText().isEmpty()){
                results.setText("*Fill In Middle Name*");
            }else if(!reg1.matches()){
            results.setText("*Should be Characters*");
            }else if(lastname.getText().isEmpty()){
                results.setText("*Fill In Last Name*");
            }else if(!reg.matches()){
            results.setText("*Should be Characters*");
            
            }else if(amountpaid.getText().isEmpty()){
                results.setText("*Fill In Amount*");
            }else if(!reg3.matches()){
            results.setText("*Amount Should Be Numbers*");
            }else if(date.getValue().toString().isEmpty()){
                results.setText("*Fill In Date*");
            }else{
                
            
            String firstn = firstname.getText();
            String middle = middlename.getText();
            String lastn = lastname.getText();
            String hhnumber = housenumber.getValue();
            String hhtype = housetype.getValue();
            String apmonth = amountpermonth.getValue();
            String monthh = month.getValue();
            String aapaid = amountpaid.getText();
            String datee = date.getValue().toString();
            String datee1 = date1.getValue().toString();
            
            int sample = Integer.parseInt(apmonth);
            int sample1 = Integer.parseInt(monthh);
            int sample2 = Integer.parseInt(aapaid);
            
            int periodmonth = (sample*sample1);
            int balancee = (periodmonth-sample2);
          
            
               connect();
               String query = "insert into records(firstname,middlename,lastname,housenumber,housetype,amountpermonth,month,amountpaid,expectedamount,balance,datein,dateout)values('"+firstn+"','"+middle+"','"+lastn+"','"+hhnumber+"','"+hhtype+"','"+apmonth+"','"+monthh+"','"+aapaid+"','"+periodmonth+"','"+balancee+"','"+datee+"','"+datee1+"')";
               String query2 = "insert into records1(housenumber,amountpaid,expectedamount,balance,datein,dateout)values('"+hhnumber+"','"+aapaid+"','"+periodmonth+"','"+balancee+"','"+datee+"','"+datee1+"')";
               st.executeUpdate(query);
               st.executeUpdate(query2);
               results.setText("*Saved Successfuly*");
              
            
            }
        
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, e);
        }
   
    }
     
       public void Delete(){
   
   int message = JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete","Confirm Detele",JOptionPane.YES_NO_OPTION);
         if(message==0){ 
       
       try{
       String query = "delete from records where housenumber=?";
       
       pr = con.prepareStatement(query);
       pr.setString(1, housenumber.getValue());
       pr.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Deleted Succefuly");
       
       }catch(SQLException | HeadlessException e){
       
       JOptionPane.showMessageDialog(null, e);
       }
   

         }
   
   } 
       public void Update(){
            String firstn = firstname.getText();
            String middle = middlename.getText();
            String lastn = lastname.getText();
            String hhnumber = housenumber.getValue();
            String hhtype = housetype.getValue();
            String apmonth = amountpermonth.getValue();
            String monthh = month.getValue();
            String aapaid = amountpaid.getText();
            String datee = date.getValue().toString();
            String datee1 = date1.getValue().toString();

            
            int message = JOptionPane.showConfirmDialog(null,"Do You Really Want To Update","Confirm Update",JOptionPane.YES_NO_OPTION);
            
            if(message==0){
            
            try{
       String query = "update records set firstname='"+firstn+"', lastname='"+lastn+"', middlename='"+middle+"', housenumber='"+hhnumber+"', housetype='"+hhtype+"', amountpermonth='"+apmonth+"', month='"+monthh+"', amountpaid='"+aapaid+"',datein='"+datee+"',dateout='"+datee1+"' where housenumber ='"+hhnumber+"'  ";
       pr = con.prepareStatement(query);
       
      pr.execute();
      JOptionPane.showMessageDialog(null, "Updated Succefuly");
            }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
            
            }
           
            }
   
  
  }
  public void searchClient(){
            try{
            
            String query = "select * from records where housenumber = ? ";
            pr =con.prepareStatement(query);
            pr.setString(1, search.getText());
            rs = pr.executeQuery();
            
            if(rs.next()){
                String value0 = rs.getString("housenumber");
                housenumber.setValue(value0);
                String value1 = rs.getString("firstname");
                firstname.setText(value1);
                String value2 = rs.getString("lastname");
                lastname.setText(value2);
                String value3 = rs.getString("middlename");
                middlename.setText(value3);
                String value4 = rs.getString("amountpaid");
                amountpaid.setText(value4);
                String value5 = rs.getString("amountpermonth");
                amountpermonth.setValue(value5);
                String value6 = rs.getString("housetype");
                housetype.setValue(value6);
                String value7 = rs.getString("month");
                month.setValue(value7);
                //String value8 = rs.getString("date");
                
                
                
                
                
            
            }
        
        
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        
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

    private void getRentalRecords() {
       connect();
        try {             
            data = FXCollections.observableArrayList();
            //connect();
           // String query = " select housenumber,amountpaid,expectedamount,balance,datein,dateout from records ";
             String SQL = "SELECT * from records order by housenumber desc";
             rs = st.executeQuery(SQL);
            while (rs.next()) {
                UserData da = new UserData(rs.getString("firstname"),rs.getString("middlename"),rs.getString("lastname"),rs.getString("housenumber"),rs.getString("housetype"),rs.getString("amountpermonth"),rs.getString("month"),rs.getString("amountpaid"),rs.getString("expectedamount"),rs.getString("balance"),rs.getString("datein"),rs.getString("dateout"));
                 data.add(da);
            }
           
            fname.setCellValueFactory(new PropertyValueFactory("FirstName"));
            mname.setCellValueFactory(new PropertyValueFactory("MiddleName"));
            lname.setCellValueFactory(new PropertyValueFactory("LastName"));
            hnumber.setCellValueFactory(new PropertyValueFactory("HouseNumber"));
            htype.setCellValueFactory(new PropertyValueFactory("HouseType"));
            apermonth.setCellValueFactory(new PropertyValueFactory("AmountPerMonth"));
            monthhh.setCellValueFactory(new PropertyValueFactory("Month"));
            apaid.setCellValueFactory(new PropertyValueFactory("AmountPaid"));
            expectedamount.setCellValueFactory(new PropertyValueFactory("ExpectedAmount"));
            balance.setCellValueFactory(new PropertyValueFactory("Balance"));
            datein.setCellValueFactory(new PropertyValueFactory("DateIn"));
            dateout.setCellValueFactory(new PropertyValueFactory("DateOut"));
             
            //table1.setItems(null);
            table.setItems(data);
            
        } catch (Exception e) {
            System.out.println("Error on Building Data" +e);
        }
    }
    
    
  

}
