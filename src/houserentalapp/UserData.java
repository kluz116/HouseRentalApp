/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserentalapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ALLAN
 */
public class UserData {
    
        public  StringProperty FirstName;
        public  StringProperty MiddleName;
        public  StringProperty LastName;
        public  StringProperty HouseNumber;
        public  StringProperty HouseType;
        public  StringProperty AmountPerMonth;
        public  StringProperty Month;
        public StringProperty AmountPaid;
        public StringProperty ExpectedAmount;
        public StringProperty Balance;
        public StringProperty DateIn;
        public  StringProperty DateOut;

        public UserData(String FirstName,String MiddleName,String LastName,String HouseNumber,String HouseType, String AmountPerMonth, String Month, String AmountPaid, String ExpectedAmount,String Balance, String DateIn, String DateOut) {
            this.FirstName = new SimpleStringProperty(FirstName);
            this.MiddleName = new SimpleStringProperty(MiddleName);
            this.LastName = new SimpleStringProperty(LastName);
            this.HouseNumber = new SimpleStringProperty(HouseNumber);
            this.HouseType = new SimpleStringProperty(HouseType);
            this.AmountPerMonth = new SimpleStringProperty(AmountPerMonth);
            this.Month = new SimpleStringProperty(Month);
            this.AmountPaid = new SimpleStringProperty(AmountPaid);
            this.ExpectedAmount = new SimpleStringProperty(ExpectedAmount);
            this.Balance = new SimpleStringProperty(Balance);
            this.DateIn = new SimpleStringProperty(DateIn);
            this.DateOut = new SimpleStringProperty(DateOut);
        }
        public StringProperty FirstNameProperty() {
            return FirstName;
        }
        public StringProperty MiddleNameProperty() {
            return MiddleName;
        }
        public StringProperty LastNameProperty() {
            return LastName;
        }
        public StringProperty HouseNumberProperty() {
            return HouseNumber;
        }
           public StringProperty HouseTypeProperty() {
            return HouseType;
        }
              public StringProperty AmountPerMonthProperty() {
            return AmountPerMonth;
        }
                 public StringProperty MonthProperty() {
            return Month;
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
    

