<<<<<<< HEAD
package com.circuit.main;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.db.impl.BarangayClearanceImpl;
import com.circuit.db.impl.BusinessClearanceImpl;
import com.circuit.db.impl.ClearanceChartImpl;
import com.circuit.db.impl.ConfigurationImpl;
import com.circuit.exception.ServiceException;
import com.circuit.obj.Admin;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.UserContext;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class MainController implements Initializable {
    
    BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    Admin admin = new Admin();
     BarangayClearance barangayClearance = new BarangayClearance();
     RegisterController registerController = new RegisterController();
     ConfigurationImpl configurationImpl = new ConfigurationImpl();
     BusinessClearanceImpl businessClearanceImpl = new BusinessClearanceImpl();
     ClearanceChartImpl clearanceChartImpl = new ClearanceChartImpl();
    
   @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXButton dashboardButton;

    @FXML
    private JFXButton createNewButton;

    @FXML
    private JFXButton recordsButton;

    @FXML
    private JFXButton configureBtn;

    @FXML
    private JFXButton signOutBtn;

    @FXML
    private Label currentAdmin;

    @FXML
    private Label currentDate;

    @FXML
    private BarChart<String, Integer> clearanceChart;
    

    
       @FXML
    void bailTab(ActionEvent event) {

    }

    

    @FXML
    void configureSystem(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Configuration.fxml"));
          rootPane.getChildren().setAll(pane);

    }

    @FXML
    void createNewApp(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateNew.fxml"));
          rootPane.getChildren().setAll(pane);

    }
    
        @FXML
    void editBrgyClearanceData(MouseEvent event) throws IOException {
        
        
//        try
//        {
//            
//            brgyDataTable.getSelectionModel().select(1, idCol);
//            
//   
//          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateNew.fxml"));
//          rootPane.getChildren().setAll(pane);
//          
//          String
//          
//          
//        }
//        
     

        

    }

    @FXML
    void openHome(ActionEvent event) throws IOException{
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          rootPane.getChildren().setAll(pane);

    }

    @FXML
    void pedTab(ActionEvent event) {

    }

    @FXML
    void signOutCapitan(ActionEvent event) throws IOException{
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
          rootPane.getChildren().setAll(pane);

    }

    @FXML
    void viewRecords(ActionEvent event) throws IOException {
   
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Records.fxml"));
          rootPane.getChildren().setAll(pane);

    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
           
           barangayClearance.setCurrentAdmin(UserContext.getAdminName());
        try {
            configurationImpl.loadOfficials(UserContext.getCurrentBarangay());
        } catch (ServiceException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

       
        currentAdmin.setText(UserContext.getAdminName());
         DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            currentDate.setText(dateFormat.format(date));
      
       
            try
            {
                 clearanceChart.getData().add(clearanceChartImpl.loadBrgyClearance());
                 clearanceChart.getData().add(clearanceChartImpl.loadBusClearance());
                 clearanceChart.getData().add(clearanceChartImpl.loadWorkingClearance());
                 clearanceChart.getData().add(clearanceChartImpl.loadPedicabClearance());
            }
            catch(Exception e)
            {
                
            }
                   
            
    System.out.println("Number of Active Threads " + Thread.activeCount());
    }    
    
}
=======
package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.db.BarangayClearanceImpl;
import com.circuit.exception.ServiceException;
import com.circuit.obj.Admin;
import com.circuit.obj.UserContext;
import com.circuit.properties.BarangayClearanceProperties;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class MainController implements Initializable {
    
    BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    Admin admin = new Admin();
   
    
   @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXButton dashboardButton;

    @FXML
    private JFXButton createNewButton;

    @FXML
    private JFXButton managementButton;

    @FXML
    private JFXButton recordsButton;

    @FXML
    private TableView<BarangayClearanceProperties> brgyDataTable;

    @FXML
    private TableColumn<BarangayClearanceProperties, Integer> idCol;

    @FXML
    private TableColumn<BarangayClearanceProperties, String> fullNameCol;

    @FXML
    private TableColumn<BarangayClearanceProperties, String> dateRegCol;

    @FXML
    private TextField searchBrgy;

    @FXML
    private ComboBox<?> dropBrgy;

    @FXML
    private TableView<?> busDataTableView;

    @FXML
    private TableColumn<?, ?> busId;

    @FXML
    private TableColumn<?, ?> busFullName;

    @FXML
    private TableColumn<?, ?> busName;

    @FXML
    private TextField searchBus;

    @FXML
    private ComboBox<?> dropBus;

    @FXML
    private TableView<?> bailDataTableView;

    @FXML
    private TableColumn<?, ?> bailId;

    @FXML
    private TableColumn<?, ?> bailName;

    @FXML
    private TableColumn<?, ?> bailVio;

    @FXML
    private TextField searchBail;

    @FXML
    private ComboBox<?> dropBail;

    @FXML
    private TableView<?> pedDataTableView;

    @FXML
    private TableColumn<?, ?> pedId;

    @FXML
    private TableColumn<?, ?> pedFullName;

    @FXML
    private TableColumn<?, ?> pedReg;

    @FXML
    private TableColumn<?, ?> pedExp;

    @FXML
    private TextField searchPed;

    @FXML
    private ComboBox<?> dropPed;

    @FXML
    private Label currentAdmin;
    @FXML
    void bailTab(ActionEvent event) {

    }

    @FXML
    void brgyTab(ActionEvent event) {

    }

    @FXML
    void busTab(ActionEvent event) {

    }

    @FXML
    void createNewApp(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateNew.fxml"));
          rootPane.getChildren().setAll(pane);

    }

   

    @FXML
    void manageDataButton(ActionEvent event) {

    }

    @FXML
    void openHome(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          rootPane.getChildren().setAll(pane);
           
    }
    
        @FXML
    void pedTab(ActionEvent event) {

    }

    @FXML
    void viewRecords(ActionEvent event)throws IOException {

          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Records.fxml"));
          rootPane.getChildren().setAll(pane);

    }

    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

       
        currentAdmin.setText(UserContext.getAdminName());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        dateRegCol.setCellValueFactory(new PropertyValueFactory<>("current_date"));
             
        try {
            brgyDataTable.setItems(barangayClearanceImpl.loadTable());
        } catch (ServiceException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
            
            
    
    }    
    
}
>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359
