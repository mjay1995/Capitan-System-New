<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Marvin
 */
public class BarangayClearanceProperties {
    
    public SimpleIntegerProperty id;
    public SimpleStringProperty control_no;
   public SimpleStringProperty fullname;
    public SimpleStringProperty currentDate;



    public BarangayClearanceProperties(int id, String control_no, String fullname, String currentDate){
       this.id = new SimpleIntegerProperty(id);
        this.control_no = new SimpleStringProperty(control_no);
        this.fullname = new SimpleStringProperty(fullname);
        this.currentDate = new SimpleStringProperty(currentDate);  
 
        
    }

    
    
    public int getId() {
        return id.get();
    }

//    public String getMiddleName() {
//        return middleName.get();
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName.set(middleName);
//    }
    public void setId(int id) {
        this.id.set(id);
    }

    public String getControlNo() {
        return control_no.get();
    }

    public void setId(String control_no) {
        this.control_no.set(control_no);
    }

    public String getFullname() {
        return fullname.get();
    }

    public void setFullname(String fullname) {
        this.fullname.set(fullname);
    }

    public String getCurrent_date() {
        return currentDate.get();
    }

    public void setCurrent_date(String currentDate) {
        this.currentDate.set(currentDate);
    }


    }
    
    
    
    
    
   
    
    

    /**
     * @param args the command line arguments
     */
   
    

=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Marvin
 */
public class BarangayClearanceProperties {
    
    
    IntegerProperty id;
    StringProperty fullname;
    StringProperty current_date;


    public BarangayClearanceProperties(int id, String fullname, String current_date){
        this.id = new SimpleIntegerProperty(id);
        this.fullname = new SimpleStringProperty(fullname);
        this.current_date = new SimpleStringProperty(current_date);  
     
        
    }



//    public String getMiddleName() {
//        return middleName.get();
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName.set(middleName);
//    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFullname() {
        return fullname.get();
    }

    public void setFullname(String fullname) {
        this.fullname.set(fullname);
    }

    public String getCurrent_date() {
        return current_date.get();
    }

    public void setCurrent_date(String current_date) {
        this.current_date.set(current_date);
    }
    
    
    
   
    
    

    /**
     * @param args the command line arguments
     */
   
    
}
>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359
