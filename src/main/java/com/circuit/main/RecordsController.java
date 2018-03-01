<<<<<<< HEAD
package com.circuit.main;

import com.circuit.db.impl.BarangayClearanceImpl;
import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.circuit.obj.UserContext;
import com.circuit.properties.BarangayClearanceProperties;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class RecordsController implements Initializable {
    BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    BarangayClearance barangayClearance = new BarangayClearance();
    
    
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
  
    @FXML
    public AnchorPane recordsPane;

    @FXML
    public TableView<BarangayClearanceProperties> recordTable;

     @FXML
    private TableColumn<BarangayClearanceProperties, String> controlNoCol;

    @FXML
    private TableColumn<BarangayClearanceProperties, String> fullNameCol;

    @FXML
    private TableColumn<BarangayClearanceProperties, String> dateRegCol;

    @FXML
    public Pane brgyPane;

     @FXML
    public JFXTextField editFirstNameField;

    @FXML
    public JFXTextField editLastNameField;

    @FXML
    public JFXTextField editMiddleNameField;

    @FXML
    public JFXComboBox<String> genderType;

    @FXML
    public DatePicker birthDate;

    @FXML
    public JFXComboBox<String> civilStat;

    @FXML
    public JFXTextField cityField;

    @FXML
    public JFXTextField ageField;

    @FXML
    public JFXTextField citizenshipField;

    @FXML
    public JFXTextField addressField;

    @FXML
    public JFXComboBox<String> purposeBox;

    @FXML
    public JFXTextField barangayField;

    @FXML
    public Label control_no;

    @FXML
    public JFXComboBox<String> remarksBox;

    @FXML
    public JFXTextField balanceField;

    @FXML
    public JFXTextField amountPaidField;

    @FXML
    public JFXTextField changeField;

    @FXML
    public JFXButton submitButton;

    @FXML
    public JFXButton saveButton;

    @FXML
    public JFXButton newClearanceBtn;

    @FXML
    public JFXTextField orNoField;

    @FXML
    public JFXButton capture_btn;

    @FXML
    public JFXButton resetBtn;

    @FXML
    public ImageView profilePicId;

    @FXML
    public Label current_barangay;

    @FXML
    public Label current_date;

    @FXML
    public JFXTextField searchBar;

    @FXML
    public JFXButton dashboardButton;

    @FXML
    public JFXButton createNewButton;

    @FXML
    public JFXButton recordsButton;

    @FXML
    public JFXButton configureBtn;

    @FXML
    public JFXButton signOutBtn;

    public final ObservableList<BarangayClearanceProperties> clearanceList = FXCollections.observableArrayList();
  
    
    @FXML
    void capture_image(ActionEvent event) {

    }

    @FXML
    void configureSystem(ActionEvent event) {

    }


    @FXML
    void createNewBrgyClear(ActionEvent event) {

    }


    @FXML
    void printBrgyClearance(ActionEvent event) {

    }

    @FXML
    void purposeItemPick(ActionEvent event) {

    }

    @FXML
    void resetWebcam(ActionEvent event) {

    }

    @FXML
    void saveBrgyClearanceRecord(ActionEvent event) {

    }

    @FXML
    void searchRecord(ActionEvent event) {

    }

    @FXML
    void signOutCapitan(ActionEvent event) {

    }
    
      @FXML
    void editRow(MouseEvent event) throws ServiceException {
      

    }



    @FXML
    void createNewApp(ActionEvent event) throws IOException {
        
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          recordsPane.getChildren().setAll(pane);

    }

    @FXML
    void manageDataButton(ActionEvent event) {
        

    }

    @FXML
    void openHome(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
             recordsPane.getChildren().setAll(pane);

    }
    
  
    @FXML
    void viewRecords(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Records.fxml"));
          recordsPane.getChildren().setAll(pane);

    }
    
     @FXML
    void viewOfficials(ActionEvent event) throws IOException {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Officials.fxml"));
          recordsPane.getChildren().setAll(pane);
    }
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date);
            
            current_date.setText(dateFormat.format(date));
            current_barangay.setText(UserContext.getCurrentBarangay());
            
           controlNoCol.setCellValueFactory(new PropertyValueFactory<>("controlNo"));
            fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullname"));
            dateRegCol.setCellValueFactory(new PropertyValueFactory<>("current_date"));
            
            
        try {
          
            recordTable.setItems(barangayClearanceImpl.loadTable(clearanceList));
           
        } catch (ServiceException ex) {
            Logger.getLogger(RecordsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            
              recordTable.setOnMousePressed((MouseEvent event) -> {
                  try {
                      
                      barangayClearanceImpl.getBarangayClearance(recordTable.getSelectionModel().getSelectedItem().getId());
                  } catch (ServiceException ex) {
                      Logger.getLogger(RecordsController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  
                  editFirstNameField.setText(barangayClearance.getFirstName());
                  editLastNameField.setText(barangayClearance.getSurname());
                  editMiddleNameField.setText(barangayClearance.getMiddleName());
             
                 
                  brgyPane.setVisible(true);
                  recordTable.setVisible(false);
            });
            
            
            
    }    
    
}
=======
package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.obj.UserContext;
import com.circuit.properties.AdminProperties;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class RecordsController implements Initializable {
    
     @FXML
    private AnchorPane recordsPane;

    @FXML
    private JFXButton dashboardButton;

    @FXML
    private JFXButton createNewButton;

    @FXML
    private JFXButton managementButton;

    @FXML
    private JFXButton recordsButton;

    @FXML
    private TableView<AdminProperties> adminTable;

    @FXML
    private TableColumn<AdminProperties, Integer> idNoColumn;

    @FXML
    private TableColumn<AdminProperties, String> adminNameCol;

    @FXML
    private TableColumn<AdminProperties, String> positionCol;

    @FXML
    public Label current_barangay;

    @FXML
    public Label current_date;

    @FXML
    void createNewApp(ActionEvent event) throws IOException {
        
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          recordsPane.getChildren().setAll(pane);

    }

    @FXML
    void manageDataButton(ActionEvent event) {
        

    }

    @FXML
    void openHome(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
             recordsPane.getChildren().setAll(pane);

    }

    @FXML
    void viewRecords(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Records.fxml"));
          recordsPane.getChildren().setAll(pane);

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date);
            
            current_date.setText(dateFormat.format(date));
            current_barangay.setText(UserContext.getCurrentBarangay());
    }    
    
}
>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359
