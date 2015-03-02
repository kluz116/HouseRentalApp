/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserentalapp;

import javafx.beans.property.*;


/**
 *
 * @author ALLAN
 */
class UserMaster {
    public SimpleStringProperty firstname = new SimpleStringProperty();
   public SimpleStringProperty middlename = new SimpleStringProperty();
   public SimpleStringProperty lastname = new SimpleStringProperty();
   public SimpleStringProperty datein = new SimpleStringProperty();
   


   public String getFName() {
      return firstname.get();
   }
 public String getMName() {
      return middlename.get();
   }
  public String getLName() {
      return lastname.get();
   }
   public String getDName() {
      return datein.get();
   }
   
}
