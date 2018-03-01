<<<<<<< HEAD:src/main/java/com/circuit/db/intrfc/BarangayClearanceDatabase.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db.intrfc;

import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.BarangayReport;
import com.circuit.properties.BarangayClearanceProperties;
import com.circuit.properties.BusinessClearanceProperties;
import java.util.List;
import java.util.Observable;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Marvin
 */
public interface BarangayClearanceDatabase {
    
    public BarangayClearance getBarangayClearance(int id) throws ServiceException;
    
    public List<BarangayClearance> getAllBarangayClearanceInRange(int from, int to) throws ServiceException;
    
    public List<BarangayClearance> getAllBarangayClearance() throws ServiceException;
    
    public BarangayClearance saveClearance(BarangayClearance barangayClearance) throws ServiceException;
    
    public boolean removeClearance(BarangayClearance barangayClearance) throws ServiceException;
    
    public BarangayClearance generateBarangayReport(BarangayClearance barangayClearance) throws ServiceException;
    
    public ObservableList loadComboBox(ObservableList data) throws ServiceException;
    
    public ObservableList loadRemarksBox(ObservableList data) throws ServiceException;
    
    public void loadCost(String purpose) throws ServiceException;
    
    public BarangayReport generateAndSaveBarangayReport(BarangayClearance  barangayClearance) throws ServiceException;
    
     public BarangayReport generateAndSaveBarangayClearanceReportReciept(BarangayClearance barangayClearance) throws ServiceException;
     
     public JasperReport showReport(BarangayClearance barangayClearance) throws ServiceException;
     
    public void VideoFeedTaker() throws ServiceException;
    
    public void startStream() throws ServiceException;
    
    public boolean validateRecord(String controlNo) throws ServiceException;
    
    public ObservableList<BarangayClearanceProperties> loadTable(ObservableList data) throws ServiceException;
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import com.circuit.properties.BarangayClearanceProperties;
import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.BarangayReport;
import java.sql.ResultSet;
import java.util.List;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Marvin
 */
public interface BarangayClearanceDatabase {
    
    public BarangayClearance getBarangayClearance(int id) throws ServiceException;
    
 
    public List<BarangayClearance> getAllBarangayClearanceInRange(int from, int to) throws ServiceException;
    
    public List<BarangayClearance> getAllBarangayClearance() throws ServiceException;
    
    public BarangayClearance saveClearance(BarangayClearance barangayClearance) throws ServiceException;
    
    public boolean removeClearance(BarangayClearance barangayClearance) throws ServiceException;
    
    public BarangayClearance generateBarangayReport(BarangayClearance barangayClearance) throws ServiceException;
    
    public BarangayReport generateAndSaveBarangayReport(BarangayClearance  barangayClearance) throws ServiceException;
    
     public BarangayReport generateAndSaveBarangayClearanceReportReciept(BarangayClearance barangayClearance) throws ServiceException;
     
     public ObservableList<BarangayClearanceProperties> loadTable() throws ServiceException;
     
     public JasperReport showReport(BarangayClearance barangayClearance) throws ServiceException;
   
    
}
>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359:src/main/java/com/circuit/db/BarangayClearanceDatabase.java
