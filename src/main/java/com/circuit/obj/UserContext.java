package com.circuit.obj;


import com.circuit.obj.Admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marvin
 */
public class UserContext {
    
 
    public static String adminName;
    public static String currentBarangay;
    public static int id;
    

  

    public static String getAdminName() {
        return adminName;
    }

    public static void setAdminName(String adminName) {
        UserContext.adminName = adminName;
    }

    public static String getCurrentBarangay() {
        return currentBarangay;
    }

    public static void setCurrentBarangay(String currentBarangay) {
        UserContext.currentBarangay = currentBarangay;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UserContext.id = id;
    }
    
    
    
    
    
    
    
}
