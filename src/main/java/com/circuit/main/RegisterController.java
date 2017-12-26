package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.db.BarangayClearanceImpl;
import com.circuit.db.DatabaseSource;
import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.UserContext;
import com.circuit.service.ClearanceService;
import com.circuit.service.impl.ClearanceServiceImpl;
import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.util.JRLoader;
import sun.misc.BASE64Encoder;


/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class RegisterController extends DatabaseSource implements Initializable {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private BarangayClearance barangayClearance = new BarangayClearance();
    private BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    
      private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
     @FXML
    private AnchorPane createNew;

    @FXML
    private JFXButton dashboardButton;

    @FXML
    private JFXButton createNewButton;

    @FXML
    private JFXButton managementButton;

    @FXML
    private JFXButton recordsButton;

    @FXML
    private Label control_no;

    @FXML
    private Label date_label;

    @FXML
    private Pane clearancePane;

    @FXML
    private Pane brgyPane;

    @FXML
    private JFXTextField lastNameField;

    @FXML
    private JFXTextField firstNameField;

    @FXML
    private JFXTextField middleNameField;

    @FXML
    private JFXComboBox<String> genderType;

    @FXML
    private JFXDatePicker birthdate;

    @FXML
    private JFXTextField cityField;

    @FXML
    private JFXTextField remarksField;

    @FXML
    private JFXTextField ageField;

    @FXML
    private JFXTextField citizenshipField;

    @FXML
    private JFXComboBox<String> civilStat;
    
    @FXML
    private JFXTextField addressField;

    @FXML
    private JFXTextField barangayField;

    @FXML
    private JFXButton submitButton;

    @FXML
    private JFXButton saveButton;

    @FXML
    private Pane webcamPane;

    @FXML
    private ImageView profilePicId;

    @FXML
    private Pane busPane;

    @FXML
    private JFXTextField BusLastNameField;

    @FXML
    private JFXTextField busFirstNameField;

    @FXML
    private JFXTextField BusMiddleNameField;

    @FXML
    private JFXComboBox<?> BusType;

    @FXML
    private JFXTextField BusAddress;

    @FXML
    private JFXTextField BldgType;

    @FXML
    private JFXTextField BusOwn;

    @FXML
    private JFXTextField BusRemarks;

    @FXML
    private JFXTextField BusBarangayField;

    @FXML
    private JFXButton submitButton1;

    @FXML
    private JFXButton saveButton1;

    @FXML
    private Pane webcamPane2;

    @FXML
    private ImageView profilePicId2;

    @FXML
    private JFXTextField BusName;

    @FXML
    private JFXComboBox<?> BusType1;

    @FXML
    private JFXTextField BusFee;

    @FXML
    private JFXTextField BusReco;

    @FXML
    private Pane bailPane;

    @FXML
    private JFXTextField BusLastNameField1;

    @FXML
    private JFXTextField busFirstNameField1;

    @FXML
    private JFXTextField BusMiddleNameField1;

    @FXML
    private JFXComboBox<?> bailType;

    @FXML
    private JFXTextField BusAddress1;

    @FXML
    private JFXTextField BldgType1;

    @FXML
    private JFXTextField BusOwn1;

    @FXML
    private JFXTextField BusRemarks1;

    @FXML
    private JFXTextField bailBrgyField;

    @FXML
    private JFXButton submitButton11;

    @FXML
    private JFXButton saveButton11;

    @FXML
    private Pane webcamPane11;

    @FXML
    private ImageView profilePicId11;

    @FXML
    private JFXTextField BusName1;

    @FXML
    private JFXComboBox<?> BusType11;

    @FXML
    private JFXTextField BusFee1;

    @FXML
    private JFXTextField BusReco1;

    @FXML
    private Pane pedPane;

    @FXML
    private JFXTextField BusLastNameField2;

    @FXML
    private JFXTextField busFirstNameField2;

    @FXML
    private JFXTextField BusMiddleNameField2;

    @FXML
    private JFXComboBox<?> pedType;

    @FXML
    private JFXTextField BusAddress2;

    @FXML
    private JFXTextField BldgType2;

    @FXML
    private JFXTextField BusOwn2;

    @FXML
    private JFXTextField BusRemarks2;

    @FXML
    private JFXTextField PedBrgyField;

    @FXML
    private JFXButton submitButton12;

    @FXML
    private JFXButton saveButton12;

    @FXML
    private Pane webcamPane12;

    @FXML
    private ImageView profilePicId12;

    @FXML
    private JFXTextField BusName2;

    @FXML
    private JFXComboBox<?> BusType12;

    @FXML
    private JFXTextField BusFee2;

    @FXML
    private JFXTextField BusReco2;

    @FXML
    private JFXComboBox<String> registerType;
    
    
    private boolean image;
    
    private File file;
    
    private  ByteArrayOutputStream bos = new ByteArrayOutputStream();
     private ClearanceService clearanceService = new ClearanceServiceImpl();
    

    
    
   @FXML
    void createNewApp(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateNew.fxml"));
          createNew.getChildren().setAll(pane);


    }

    @FXML
    void manageDataButton(ActionEvent event) {

    }

    @FXML
    void openHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
          createNew.getChildren().setAll(pane);



    }

    @FXML
    void printBailRecord(ActionEvent event) {

    }

    @FXML
    void printBrgyClearance(ActionEvent event) throws IOException, ServiceException {
         barangayClearanceImpl.showReport(barangayClearance);
             


    }

    @FXML
    void printBusRec(ActionEvent event) {

    }

    @FXML
    void printPedRecord(ActionEvent event) {

    }

    @FXML
    void regTypePick(ActionEvent event) {
         
        if(registerType.getSelectionModel().getSelectedItem() == "Barangay Clearance")
        {
             AnchorPane pane = new AnchorPane(brgyPane);
             clearancePane.getChildren().setAll(pane);
             brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             busPane.setVisible(false);
             busPane.setDisable(true);
             bailPane.setVisible(false);
             bailPane.setDisable(true);
             pedPane.setVisible(false);
             pedPane.setDisable(true);
             barangayField.setText(UserContext.getCurrentBarangay());
             
        }
         else if(registerType.getSelectionModel().getSelectedItem() == "Business Clearance")
       {
              AnchorPane pane =  new AnchorPane(busPane);
              clearancePane.getChildren().setAll(pane);
               brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             busPane.setVisible(true);
             busPane.setDisable(false);
             bailPane.setVisible(false);
             bailPane.setDisable(true);
             pedPane.setVisible(false);
             pedPane.setDisable(true);
               BusBarangayField.setText(UserContext.getCurrentBarangay());
           
      }else if (registerType.getSelectionModel().getSelectedItem() == "Bail Clearance")
      {
           AnchorPane pane =  new AnchorPane(bailPane);
              clearancePane.getChildren().setAll(pane);
               brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             busPane.setVisible(false);
             busPane.setDisable(true);
             bailPane.setVisible(true);
             bailPane.setDisable(false);
             pedPane.setVisible(false);
             pedPane.setDisable(true);
              bailBrgyField.setText(UserContext.getCurrentBarangay());
      }
      else if (registerType.getSelectionModel().getSelectedItem() == "Pedicab Clearance")
      {
           AnchorPane pane =  new AnchorPane(pedPane);
              clearancePane.getChildren().setAll(pane);
               brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             busPane.setVisible(false);
             busPane.setDisable(true);
             bailPane.setVisible(false);
             bailPane.setDisable(true);
             pedPane.setVisible(true);
             pedPane.setDisable(false);
              PedBrgyField.setText(UserContext.getCurrentBarangay());
      }


    }

    @FXML
    void saveBailRecord(ActionEvent event) {

    }

    @FXML
    void saveBrgyClearanceRecord(ActionEvent event) throws ServiceException {
        Webcam webcam = Webcam.getDefault();
          String imageString = null;
          
       
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date);        
          
       
               
        
       barangayClearance.setId(getId());
       barangayClearance.setSurname(lastNameField.getText());
       barangayClearance.setFirstName(firstNameField.getText());
       barangayClearance.setMiddleName(middleNameField.getText());
       barangayClearance.setFullname(firstNameField.getText() + " " +  middleNameField.getText() + " " +lastNameField.getText());
       barangayClearance.setGender(genderType.getSelectionModel().getSelectedItem().toString());
       barangayClearance.setBirthDate(birthdate.getValue().toString());
       barangayClearance.setCity(cityField.getText());
       barangayClearance.setAddress(addressField.getText());
       barangayClearance.setAge(ageField.getText());
       barangayClearance.setRemarks(remarksField.getText());
       barangayClearance.setCitizenship(citizenshipField.getText());
       barangayClearance.setBarangay(UserContext.getCurrentBarangay()); 
       barangayClearance.setCurrent_date(dateFormat.format(date));
       barangayClearance.setControl_no(control_no_format);
       barangayClearance.setCivilStatus(civilStat.getSelectionModel().getSelectedItem().toString());
       webcam.open();
          BufferedImage bufferedImage = webcam.getImage();
         javafx.scene.image.Image imageFx = SwingFXUtils.toFXImage(bufferedImage, null);
        try {
            ImageIO.write(bufferedImage, "JPG", bos);
            byte[] imageBytes = bos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        profilePicId.setImage(imageFx);
        webcam.close();
     
       
      barangayClearance.setProfileImage(imageString.getBytes());
      
         
       
       barangayClearanceImpl.saveClearance(barangayClearance);
        //barangayClearanceImpl.showReport(barangayClearance);
            
        System.out.println("Saved!");


    }

    @FXML
    void saveBusRecord(ActionEvent event) {

    }

    @FXML
    void savePedRecord(ActionEvent event) {

    }

    @FXML
    void viewRecords(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Records.fxml"));
          createNew.getChildren().setAll(pane);



    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
  
           
    
       
            registerType.getItems().addAll("Barangay Clearance","Business Clearance","Bail Clearance","Pedicab Clearance");
            registerType.getSelectionModel().select("Barangay Clearance");
            
            
               barangayField.setText(UserContext.getCurrentBarangay());
         
    
            genderType.getItems().addAll("Male","Female");
            genderType.getSelectionModel().select("Male");
            
            civilStat.getItems().addAll("Single","Married","Divorced","Widowed");
            civilStat.getSelectionModel().select("Single");

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date);
            date_label.setText(dateFormat.format(date));
            control_no.setText(control_no_format);
           
           
            
     
            if(barangayClearance.getId() != 0)
            {
             
            try {
                 String query = "SELECT * FROM bgy_clearance";
                Statement st = this.getConnection().createStatement();
                ResultSet  rs= st.executeQuery(query);
                while(rs.next())
                {
                    int ctrlNo = rs.getInt("control_no");
                    System.out.println(ctrlNo);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
 }
             
    }    
    

