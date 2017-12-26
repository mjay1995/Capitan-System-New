/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayReport;
import com.circuit.obj.BusinessClearance;
import com.circuit.properties.BarangayClearanceProperties;
import com.circuit.utils.ReportUtility;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Marvin
 */
public class BusinessClearanceImpl extends DatabaseSource implements BusinessClearanceDatabase{

    @Override
    public BusinessClearance getBusinessClearance(int id) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BusinessClearance> getAllBusinessClearanceInRange(int from, int to) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BusinessClearance> getAllBusinessClearance() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusinessClearance saveClearance(BusinessClearance businessClearance) throws ServiceException {
      PreparedStatement ps;
      
        
        try
        {
            if(businessClearance.getId() == 0)
            {
                String insertSql = ""
                        + "INSERT INTO "
                        + "bus_clearance "
                        + " ("
                        + "surname, "
                        + "firstname, "
                        + "middlename,"
                        + "fullname, "
                        + "occupation, "
                        + "residence, "
                        + "businessName, "
                        + "businessAdd, "
                        + "businessType, "
                        + "isNew, "
                        + "buildingType, "
                        + "ownershipType, "
                        + "remarks, "
                        + "recommendations, "
                        + "clearanceFee, "
                        + "inspectorName "
                        + ")"
                        + "VALUES "
                        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                ps = this.getConnection().prepareStatement(insertSql);
                ps.setString(1, businessClearance.getSurname());
                ps.setString(2, businessClearance.getFirstName());
                ps.setString(3, businessClearance.getMiddleName());
                ps.setString(4, businessClearance.getFullName());
                ps.setString(5, businessClearance.getOccupation());
                ps.setString(6, String.valueOf(businessClearance.getResidence()));
                ps.setString(7, String.valueOf(businessClearance.getBusinessName()));
                ps.setString(8, businessClearance.getBusinessAddres());
                ps.setString(9, businessClearance.getBusinessType());
                ps.setBoolean(10, businessClearance.isNew());
                ps.setString(11, businessClearance.getBuildingType());
                ps.setString(12, businessClearance.getOwnershipType());
                ps.setString(13, businessClearance.getRemarks());
                ps.setString(14, businessClearance.getRecommendations());
                ps.setString(15, String.valueOf(businessClearance.getClearanceFee()));
                ps.setString(16, businessClearance.getInspectorName()); 
                           }
            else
            {
                 String updateSQL = ""
                        + "UPDATE "
                        + "bus_clearance "
                        + "SET "
                       + "surname = ?, "
                        + "firstname = ?, "
                        + "middlename = ?,"
                        + "fullname = ?, "
                        + "occupation = ?, "
                        + "residence = ?, "
                        + "businessName = ?, "
                        + "businessAdd = ?, "
                        + "businessType = ?, "
                        + "isNew = ?, "
                        + "buildingType = ?, "
                        + "ownershipType = ?, "
                        + "remarks = ?, "
                        + "recommendations = ?, "
                        + "clearanceFee = ?, "
                        + "inspectorName = ? "
                         + "WHERE "
                         + "id = ?";
 
                
                ps = this.getConnection().prepareStatement(updateSQL);
                  ps.setString(1, businessClearance.getSurname());
                ps.setString(2, businessClearance.getFirstName());
                ps.setString(3, businessClearance.getMiddleName());
                ps.setString(4, businessClearance.getFullName());
                ps.setString(5, businessClearance.getOccupation());
                ps.setString(6, String.valueOf(businessClearance.getResidence()));
                ps.setString(7, String.valueOf(businessClearance.getBusinessName()));
                ps.setString(8, businessClearance.getBusinessAddres());
                ps.setString(9, businessClearance.getBusinessType());
                ps.setBoolean(10, businessClearance.isNew());
                ps.setString(11, businessClearance.getBuildingType());
                ps.setString(12, businessClearance.getOwnershipType());
                ps.setString(13, businessClearance.getRemarks());
                ps.setString(14, businessClearance.getRecommendations());
                ps.setString(15, String.valueOf(businessClearance.getClearanceFee()));
                ps.setString(16, businessClearance.getInspectorName()); 
            }
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(BarangayClearanceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  businessClearance;
    }

    @Override
    public boolean removeClearance(BusinessClearance businessClearance) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusinessClearance generateBarangayReport(BusinessClearance businessClearance) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BarangayReport generateAndSaveBarangayReport(BusinessClearance businessClearance) throws ServiceException {
         BarangayReport barangayClearanceReport = new BarangayReport();
        
       
        barangayClearanceReport.setBusinessClearance(businessClearance);
        barangayClearanceReport.setBusinessClearancePrint(ReportUtility.generateBusClearanceReport(businessClearance));
      
        return barangayClearanceReport;
    }

    @Override
    public BarangayReport generateAndSaveBarangayClearanceReportReciept(BusinessClearance businessClearance) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<BarangayClearanceProperties> loadTable() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JasperReport showReport(BusinessClearance businessClearance) throws ServiceException {
        JasperViewer jv;
        jv = new JasperViewer(generateAndSaveBarangayReport(businessClearance).getBarangayClearancePrint(),true);
                  jv.setExtendedState(JasperViewer.NORMAL);
                  jv.setDefaultCloseOperation(HIDE_ON_CLOSE);
                  jv.setVisible(true);
        return null;
    }
    
}
