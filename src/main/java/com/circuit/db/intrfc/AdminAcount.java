<<<<<<< HEAD:src/main/java/com/circuit/db/intrfc/AdminAcount.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db.intrfc;

import com.circuit.properties.AdminProperties;
import com.circuit.properties.BarangayClearanceProperties;
import com.circuit.exception.ServiceException;
import com.circuit.obj.Admin;
import javafx.collections.ObservableList;

/**
 *
 * @author Marvin
 */
public interface AdminAcount {
    
    public boolean validateLogin(String username, String password) throws ServiceException;
    
    public Admin addNewAccount(Admin admin) throws ServiceException;
    
    public Admin removeAccount(Admin admin) throws ServiceException;
    
   public ObservableList<AdminProperties> loadTable() throws ServiceException;
   
  
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import com.circuit.properties.AdminProperties;
import com.circuit.properties.BarangayClearanceProperties;
import com.circuit.exception.ServiceException;
import com.circuit.obj.Admin;
import javafx.collections.ObservableList;

/**
 *
 * @author Marvin
 */
public interface AdminAcount {
    
    public boolean validateLogin(String username, String password) throws ServiceException;
    
    public Admin addNewAccount(Admin admin) throws ServiceException;
    
    public Admin removeAccount(Admin admin) throws ServiceException;
    
   public ObservableList<AdminProperties> loadTable() throws ServiceException;
   
   //public String setName() throws ServiceException;
    
}
>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359:src/main/java/com/circuit/db/AdminAcount.java
