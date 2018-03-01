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
public class ClearanceRemarksProperties {
    
    IntegerProperty id;
    StringProperty remarks;

    public ClearanceRemarksProperties(int id, String remarks) {
        this.id = new SimpleIntegerProperty(id);
        this.remarks = new SimpleStringProperty(remarks);
    }
    
    

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getRemarks() {
        return remarks.get();
    }

    public void setRemarks(String remarks) {
        this.remarks.set(remarks);
    }
    
    
    
    
}
