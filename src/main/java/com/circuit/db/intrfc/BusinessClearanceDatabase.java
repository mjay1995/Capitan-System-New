<<<<<<< HEAD:src/main/java/com/circuit/db/intrfc/BusinessClearanceDatabase.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db.intrfc;

import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayReport;
import com.circuit.obj.BusinessClearance;
import com.circuit.obj.BarangayOfficials;
import com.circuit.properties.BusinessClearanceProperties;
import java.util.List;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Marvin
 */
public interface BusinessClearanceDatabase {
    
      
    public BusinessClearance getBusinessClearance(int id) throws ServiceException;
    
 
    public List<BusinessClearance> getAllBusinessClearanceInRange(int from, int to) throws ServiceException;
    
    public List<BusinessClearance> getAllBusinessClearance() throws ServiceException;
    
    public BusinessClearance saveClearance(BusinessClearance businessClearance) throws ServiceException;
    
    public boolean removeClearance(BusinessClearance businessClearance) throws ServiceException;
    
    public BusinessClearance generateBarangayReport(BusinessClearance businessClearance) throws ServiceException;
    
    public BarangayReport generateAndSaveBarangayReport(BusinessClearance  businessClearance) throws ServiceException;
    
     public BarangayReport generateAndSaveBarangayClearanceReportReciept(BusinessClearance businessClearance) throws ServiceException;
     
     public ObservableList<BusinessClearanceProperties> loadTable() throws ServiceException;
     
     public JasperReport showReport(BusinessClearance businessClearance) throws ServiceException;
     
       public BarangayOfficials addNewOfficial(BarangayOfficials barangayOfficials) throws ServiceException;

       public ObservableList<BusinessClearance> loadBusinessType(ObservableList data) throws ServiceException;
       
       public boolean validateRecord(String controlNo) throws ServiceException;
      
       
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.BarangayReport;
import com.circuit.obj.BusinessClearance;
import com.circuit.properties.BarangayClearanceProperties;
import java.util.List;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Marvin
 */
public interface BusinessClearanceDatabase {
    
      
    public BusinessClearance getBusinessClearance(int id) throws ServiceException;
    
 
    public List<BusinessClearance> getAllBusinessClearanceInRange(int from, int to) throws ServiceException;
    
    public List<BusinessClearance> getAllBusinessClearance() throws ServiceException;
    
    public BusinessClearance saveClearance(BusinessClearance businessClearance) throws ServiceException;
    
    public boolean removeClearance(BusinessClearance businessClearance) throws ServiceException;
    
    public BusinessClearance generateBarangayReport(BusinessClearance businessClearance) throws ServiceException;
    
    public BarangayReport generateAndSaveBarangayReport(BusinessClearance  businessClearance) throws ServiceException;
    
     public BarangayReport generateAndSaveBarangayClearanceReportReciept(BusinessClearance businessClearance) throws ServiceException;
     
     public ObservableList<BarangayClearanceProperties> loadTable() throws ServiceException;
     
     public JasperReport showReport(BusinessClearance businessClearance) throws ServiceException;
    
}
>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359:src/main/java/com/circuit/db/BusinessClearanceDatabase.java
