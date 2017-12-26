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
