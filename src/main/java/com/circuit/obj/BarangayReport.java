/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.obj;

import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Marvin
 */
public class BarangayReport {
       
    
    private int id;
    
    private BarangayClearance barangayClearance = new BarangayClearance();
   
    private BusinessClearance businessClearance = new BusinessClearance();
    
    private JasperPrint businessClearancePrint = new JasperPrint();
    
    private JasperPrint barangayClearancePrint = new JasperPrint();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BarangayClearance getBarangayClearance() {
        return barangayClearance;
    }

    public void setBarangayClearance(BarangayClearance barangayClearance) {
        this.barangayClearance = barangayClearance;
    }

    public JasperPrint getBarangayClearancePrint() {
        return barangayClearancePrint;
    }

    public void setBarangayClearancePrint(JasperPrint barangayClearancePrint) {
        this.barangayClearancePrint = barangayClearancePrint;
    }

    public BusinessClearance getBusinessClearance() {
        return businessClearance;
    }

    public void setBusinessClearance(BusinessClearance businessClearance) {
        this.businessClearance = businessClearance;
    }

    public JasperPrint getBusinessClearancePrint() {
        return businessClearancePrint;
    }

    public void setBusinessClearancePrint(JasperPrint businessClearancePrint) {
        this.businessClearancePrint = businessClearancePrint;
    }
    
    
    
    
}
