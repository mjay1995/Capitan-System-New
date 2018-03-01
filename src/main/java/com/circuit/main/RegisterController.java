<<<<<<< HEAD
package com.circuit.main;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.circuit.db.DatabaseSource;
import com.circuit.db.SqlConnect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.db.impl.BarangayClearanceImpl;
import com.circuit.db.impl.BusinessClearanceImpl;
import com.circuit.db.impl.PedicabClearanceImpl;
import com.circuit.db.impl.WorkingClearanceImpl;
import com.circuit.exception.ServiceException;
import com.circuit.obj.BarangayClearance;
import com.circuit.obj.BusinessClearance;
import com.circuit.obj.PedicabClearance;
import com.circuit.obj.UserContext;
import com.circuit.obj.WorkingClearance;
import com.circuit.service.ClearanceService;
import com.circuit.service.impl.ClearanceServiceImpl;
import com.circuit.utils.WebcamInitialize;
import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class RegisterController extends DatabaseSource implements Initializable {
    private final BarangayClearance barangayClearance = new BarangayClearance();
        private final BusinessClearance businessClearance = new BusinessClearance();
    private final WorkingClearance workingClearance = new WorkingClearance();
       private final PedicabClearance pedicabClearance = new PedicabClearance();
    private final BarangayClearanceImpl barangayClearanceImpl = new BarangayClearanceImpl();
    private final BusinessClearanceImpl businessClearanceImpl = new BusinessClearanceImpl();
    private final WorkingClearanceImpl workingClearanceImpl = new WorkingClearanceImpl();
    private final PedicabClearanceImpl pedicabClearanceImpl = new PedicabClearanceImpl();
    private final ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    public  WebcamInitialize webcamInitialize = new WebcamInitialize();
          private static Task<Void> webCamTask;

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
    private Label date_label;

    @FXML
    private Pane clearancePane;

    @FXML
    public Pane brgyPane;

    @FXML
    public JFXTextField lastNameField;

    @FXML
    public JFXTextField firstNameField;

    @FXML
    public JFXTextField middleNameField;

    @FXML
    public JFXComboBox<String> genderType;
    
       @FXML
    private JFXButton newClearanceBtn;
    
    @FXML
    public DatePicker birthDate;

    @FXML
    public JFXTextField cityField;

    @FXML
    public JFXTextField ageField;

    @FXML
    public JFXTextField citizenshipField;

    @FXML
    public JFXTextField addressField;

    @FXML
    public JFXComboBox<String> civilStat;


    @FXML
    public JFXTextField barangayField;

    @FXML
    public JFXTextField purposeField;

    @FXML
    private Label control_no;

    @FXML
    private JFXButton submitButton;

    @FXML
    private JFXButton saveButton;

    @FXML
    private Pane webcamPane;

    @FXML
    public ImageView profilePicId;

    @FXML
    private JFXButton capture_btn;

    @FXML
    public JFXComboBox<String> registerType;

    @FXML
    private Label time_label;
    
       @FXML
    private Pane busClearance;

    @FXML
    private Pane busPane;

    @FXML
    private JFXTextField BCFirstName;

    @FXML
    private JFXTextField BCLastName;

    @FXML
    private JFXTextField BCMiddleName;

    @FXML
    private JFXTextField BCBusName;

    @FXML
    private JFXTextField BCBusAdd;

    @FXML
    private JFXTextField BCBusType;

     @FXML
    private JFXComboBox<String> BCbldgType;
    @FXML
    private JFXTextField BCPlateNo;
    
        @FXML
    private JFXButton resetBtn;

    @FXML
    private JFXTextField BCBal;

    @FXML
    private JFXTextField BCStatus;

    @FXML
    private JFXTextField BCAmountPaid;

    @FXML
    private JFXTextField BCChange;

    @FXML
    private JFXButton printBC;

    @FXML
    private JFXButton saBC;

    @FXML
    private JFXTextField BCBrgyField;

    @FXML
    private Label BCCtrlNo;

    @FXML
    private JFXTextField BCORNo;

    @FXML
    private JFXTextField BCORDate;

    @FXML
    private JFXButton dashboardButton;

    @FXML
    private JFXButton createNewButton;

    @FXML
    private JFXButton managementButton;

    @FXML
    private JFXButton recordsButton;

    @FXML
    private JFXButton viewOfficials;
    
      @FXML
    public JFXTextField balanceField;

    @FXML
    public JFXTextField statusField;

    @FXML
    public JFXTextField amountPaidField;

    @FXML
    public JFXTextField changeField;
    
    
    @FXML
    private JFXButton newBusClearance;
    
    
    @FXML
    private JFXTextField orNoField;

    
    @FXML
    private JFXComboBox<String> BCRegisterType;
    
        @FXML
    private Pane workPane;
    
   @FXML
    private JFXTextField WCFirstName;

    @FXML
    private JFXTextField WCLastName;

    @FXML
    private JFXTextField WCMiddleName;

    @FXML
    private JFXDatePicker WCBirthdate;

    @FXML
    private JFXComboBox<String> WCGender;

    @FXML
    private JFXTextField WCAdd;

    @FXML
    private JFXTextField WCAge;

    @FXML
    private JFXComboBox<String> WCCivilStat;

    @FXML
    private JFXTextField WCCitizenship;

    @FXML
    private JFXTextField WCAppliedPos;

    @FXML
    private JFXTextField WCcompanyName;

    @FXML
    private JFXTextField WCcompanyAdd;

    @FXML
    private JFXTextField WCRemarks;

    @FXML
    private JFXTextField WCBrgyField;

    @FXML
    private Label WCCtrlNo;

    @FXML
    private JFXTextField WCOrNo;

    @FXML
    private JFXTextField WCAmountPaid;

    @FXML
    private JFXTextField WCORDate;

    @FXML
    private JFXButton saveWC;

    @FXML
    private JFXButton printWC;

    @FXML
    private JFXButton newWorkClearance;

    @FXML
    private JFXButton WCCapture_btn;

    @FXML
    private JFXButton WCResetBtn;

    @FXML
    public ImageView WCProfilePic;
    
    @FXML
    private Pane pedPane;

    @FXML
    private JFXTextField PCFirstName;

    @FXML
    private JFXTextField PCLastName;

    @FXML
    private JFXTextField PCMiddleName;

    @FXML
    private JFXDatePicker PCBirthdate;

    @FXML
    private JFXComboBox<String> PCGender;

    @FXML
    private JFXTextField PCAdd;

    @FXML
    private JFXTextField PCRemarks;
    
     @FXML
    private JFXComboBox<String> PCCivilStat;
    
       @FXML
    private JFXTextField PCPlateNo;
       
     @FXML
    private JFXTextField PCExpire;


    @FXML
    private JFXTextField PCSideColor;

    @FXML
    private JFXTextField PCBikeColor;

    @FXML
    private JFXTextField PCTrapColor;

    @FXML
    private JFXTextField PCRSide;

    @FXML
    private JFXTextField PCCLside;

    @FXML
    private JFXTextField PCFrontM;

    @FXML
    private JFXTextField PCBackM;

    @FXML
    private JFXTextField PCBrgtField;

    @FXML
    private Label PCCtrlNo;

    @FXML
    private JFXTextField PCOrNo;

    @FXML
    private JFXTextField PCAmountPaid;

    @FXML
    private JFXTextField PCORDate;

    @FXML
    private JFXButton savePC;

    @FXML
    private JFXButton printPC;

    @FXML
    private JFXButton newPedClearance;



    
    final ObservableList purposeOptions = FXCollections.observableArrayList();
     final ObservableList remarksOptions = FXCollections.observableArrayList();
         final ObservableList ownershipOptions = FXCollections.observableArrayList();
      @FXML
    private JFXComboBox purposeBox = new JFXComboBox(purposeOptions);
      
          @FXML
    private JFXComboBox remarksBox = new JFXComboBox(remarksOptions);
          
            @FXML
    private JFXComboBox BCOwnership = new JFXComboBox(ownershipOptions);
      private int webCamIndex;
  
    
    
    
    private boolean image;
    private boolean stopCamera;
    private Thread webCamThread;
    private File file;
    
    private  ByteArrayOutputStream bos = new ByteArrayOutputStream();
     private ClearanceService clearanceService = new ClearanceServiceImpl();
     private Webcam BCwebcam = null;
     private Webcam WCWebcam = null;
     
        @FXML
    void BCOwnershipBox(ActionEvent event) {
        
          if(BCOwnership.getSelectionModel().getSelectedItem().equals("SINGLE PROPRIETOR")|| BCOwnership.getSelectionModel().getSelectedItem().equals("PARTNERSHIP"))
              {
                  BCLastName.setDisable(false);
                  BCFirstName.setDisable(false);
                  BCMiddleName.setDisable(false);
              }
              else
              {
                   BCLastName.setDisable(true);
                  BCFirstName.setDisable(true);
                  BCMiddleName.setDisable(true);
              }


    }

    @FXML
    void WCcapture_image(ActionEvent event) {
         if(webcamInitialize.stopCamera != true)
        {
             webcamInitialize.stopCamera = true;
            webcamInitialize.WCWebcam.close();
        }
        else
        {
            webcamInitialize. WCWebcam = Webcam.getDefault();
            webcamInitialize. WCWebcam.setViewSize(new Dimension(640,480));
          webcamInitialize.WCWebcam.open();
          BufferedImage bufferedImage = WCWebcam.getImage();
          
          javafx.scene.image.Image imageFx = SwingFXUtils.toFXImage(bufferedImage, null);
          WCProfilePic.setImage(imageFx);
          webcamInitialize.WCWebcam.close();
        

    }
    }

    @FXML
    void capture_image(ActionEvent event) {
         if(webcamInitialize.stopCamera != true)
        {
             webcamInitialize.stopCamera = true;
         webcamInitialize.BCwebcam.close();
        }
        else
        {
             webcamInitialize.BCwebcam = Webcam.getDefault();
         webcamInitialize.BCwebcam.setViewSize(new Dimension(640,480));
          webcamInitialize.BCwebcam.open();
          BufferedImage bufferedImage = BCwebcam.getImage();
          
          javafx.scene.image.Image imageFx = SwingFXUtils.toFXImage(bufferedImage, null);
          profilePicId.setImage(imageFx);
          webcamInitialize.BCwebcam.close();

        }
    }

    @FXML
    void configureSystem(ActionEvent event) throws IOException {
            BCwebcam.close();
             WCWebcam.close();
  AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Configuration.fxml"));
          createNew.getChildren().setAll(pane);


    }

    @FXML
    void createNewApp(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/CreateNew.fxml"));
          createNew.getChildren().setAll(pane);


    }

    @FXML
    void createNewBrgyClear(ActionEvent event) throws IOException {
          Date date = new Date();
    String Buscontrol_no_format = new SimpleDateFormat("yyyy-ddhms").format(date);
       lastNameField.clear();
      firstNameField.clear();
     middleNameField.clear();
      cityField.clear();
       addressField.clear();
      ageField.clear();
      
      citizenshipField.clear();
   
      control_no.setText(Buscontrol_no_format);
      if(webcamInitialize.stopCamera == true)
        {
         webcamInitialize.stopCamera = false    ;
           webcamInitialize.initializeWebCam(profilePicId,WCProfilePic);
        }
      balanceField.clear();
       orNoField.clear();
       amountPaidField.clear();
      changeField.clear();
      
        System.out.println("Number of Active Threads " + Thread.activeCount());

    }

    @FXML
    void createNewBusClearance(ActionEvent event) {
        Date date = new Date();
           String Buscontrol_no_format = new SimpleDateFormat("yyyy-ddhms").format(date);
        BCAmountPaid.clear();
        BCBusAdd.clear();
        BCBusName.clear();
        BCBusType.clear();
        BCBusType.clear();
        BCFirstName.clear();
        BCLastName.clear();
        BCMiddleName.clear();
        BCPlateNo.clear();
        BCORNo.clear();
        BCOwnership.getSelectionModel().select(0);
        BCCtrlNo.setText(Buscontrol_no_format);


    }

    @FXML
    void createNewPedClearance(ActionEvent event) {
        
        
        Date date = new Date();
           String Buscontrol_no_format = new SimpleDateFormat("yyyy-ddhms").format(date);
        PCAdd.clear();
        PCAmountPaid.clear();
        PCBackM.clear();
        PCBikeColor.clear();
        PCBirthdate.getEditor().clear();
        PCCLside.clear();
        PCCivilStat.getSelectionModel().select(0);
        PCCtrlNo.setText(Buscontrol_no_format);
        PCFirstName.clear();
        PCLastName.clear();
        PCMiddleName.clear();
        PCPlateNo.clear();
        PCRSide.clear();
        PCTrapColor.clear();
        PCORDate.clear();
        PCOrNo.clear();
    }

    @FXML
    void createNewWorkClearance(ActionEvent event) {
        Date date = new Date();
        String Buscontrol_no_format = new SimpleDateFormat("yyyy-ddhms").format(date);
        WCAdd.clear();
        WCAge.clear();
        WCAmountPaid.clear();
        WCAppliedPos.clear();
        WCBirthdate.getEditor().clear();
        WCCitizenship.clear();
        WCCivilStat.getSelectionModel().select(0);
        WCCtrlNo.setText(Buscontrol_no_format);
        WCFirstName.clear();
        WCLastName.clear();
        WCMiddleName.clear();
        WCOrNo.clear();
        WCORDate.clear();
        WCRemarks.clear();
        if(webcamInitialize.stopCamera == true)
        {
         webcamInitialize.stopCamera = false;
        webcamInitialize.initializeWebCam(profilePicId,WCProfilePic);
        }
           WCcompanyAdd.clear();
           WCcompanyName.clear();
           
             System.out.println("Number of Active Threads " + Thread.activeCount());

    }

    @FXML
    void openHome(ActionEvent event) throws IOException {
            stopCamera = true;
            
            
            if(webcamInitialize.WCWebcam.close() == true)
           {
                 webcamInitialize.webCamTask.isDone();
                  webcamInitialize.BCwebcam.close();     
                   AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
                    createNew.getChildren().setAll(pane);
           }
           else
           {
           
               webcamInitialize.webCamTask.isDone();
               webcamInitialize.WCWebcam.close();
               AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
               createNew.getChildren().setAll(pane);
           }
        

            
         


    }

    @FXML
    void printBrgyClearance(ActionEvent event)throws ServiceException{
         barangayClearanceImpl.showReport(barangayClearance);


    }

    @FXML
    void printBusClearance(ActionEvent event) throws ServiceException {
         businessClearanceImpl.showReport(businessClearance);   

    }

    @FXML
    void printPedClearance(ActionEvent event) throws ServiceException {
         pedicabClearanceImpl.showReport(pedicabClearance);   

    }

    @FXML
    void printWorkClearance(ActionEvent event) throws ServiceException {
        workingClearanceImpl.showReport(workingClearance);   
    }

    @FXML
    void purposeItemPick(ActionEvent event) {
         try {
         SqlConnect connect = new SqlConnect();
       
        
                    String query = "SELECT * FROM brgy_clearance_purpose WHERE purpose = ? " ;
                  PreparedStatement pst= connect.getDataSource().getConnection().prepareStatement(query);
                    pst.setString(1, (String) purposeBox.getSelectionModel().getSelectedItem());
                ResultSet rs =  pst.executeQuery();
              
            while(rs.next())
            {
                balanceField.setText((rs.getString("cost")));
            }
          
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @FXML
    void regTypePick(ActionEvent event) {
        
         if("Barangay Clearance".equals(registerType.getSelectionModel().getSelectedItem()))
        {
             webcamInitialize.stopCamera = true;
            webcamInitialize.webCamTask.isDone();
           webcamInitialize.BCwebcam.close();
           webcamInitialize.WCWebcam.close();
             AnchorPane pane = new AnchorPane(brgyPane);
             clearancePane.getChildren().setAll(pane);
             brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             
             if(webcamInitialize.stopCamera == true)
              {
                  webcamInitialize.stopCamera = false;
                  webcamInitialize.initializeWebCam(profilePicId,WCProfilePic);
              }
             busPane.setVisible(false);
             busPane.setDisable(true);
             workPane.setVisible(false);
             workPane.setDisable(true);
             pedPane.setVisible(false);
             pedPane.setDisable(true);
             barangayField.setText(UserContext.getCurrentBarangay());
             
        }
         else if("Business Clearance".equals(registerType.getSelectionModel().getSelectedItem()))
       {
              AnchorPane pane =  new AnchorPane(busPane);
             clearancePane.getChildren().setAll(pane);
               brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             busPane.setVisible(true);
             busPane.setDisable(false);
           webcamInitialize.BCwebcam.close();
           webcamInitialize.WCWebcam.close();
             workPane.setVisible(false);
             workPane.setDisable(true);
             pedPane.setVisible(false);
             pedPane.setDisable(true);
               BCBrgyField.setText(UserContext.getCurrentBarangay());
           
      }else if ("Working Clearance".equals(registerType.getSelectionModel().getSelectedItem()))
      {
            webcamInitialize.stopCamera = true;
            webcamInitialize.webCamTask.isDone();
           webcamInitialize.BCwebcam.close();
           webcamInitialize.WCWebcam.close();
           AnchorPane pane =  new AnchorPane(workPane);
              clearancePane.getChildren().setAll(pane);
              if(webcamInitialize.stopCamera == true)
              {
                  webcamInitialize.stopCamera = false;
                  webcamInitialize.initializeWebCam(profilePicId,WCProfilePic);
              }
         
               brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             busPane.setVisible(false);
             busPane.setDisable(true);
             workPane.setVisible(true);
             workPane.setDisable(false);
             pedPane.setVisible(false);
             pedPane.setDisable(true);
              WCBrgyField.setText(UserContext.getCurrentBarangay());

      }
      else if ("Pedicab Clearance".equals(registerType.getSelectionModel().getSelectedItem()))
      {
           AnchorPane pane =  new AnchorPane(pedPane);
              clearancePane.getChildren().setAll(pane);
               webcamInitialize.BCwebcam.close();
               webcamInitialize.WCWebcam.close();
               brgyPane.setVisible(true);
             brgyPane.setDisable(false);
             busPane.setVisible(false);
             busPane.setDisable(true);
             workPane.setVisible(false);
             workPane.setDisable(true);
             pedPane.setVisible(true);
             pedPane.setDisable(false);
              PCBrgtField.setText(UserContext.getCurrentBarangay());
      }


    }

    @FXML
    void resetWebcam(ActionEvent event) {
        
    
         stopCamera = false;
         webcamInitialize.initializeWebCam(profilePicId,WCProfilePic);
        


    }

    @FXML
    void saveBrgyClearanceRecord(ActionEvent event) throws ServiceException, ParseException {
        
       
          int change;
          
       
            DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
            Date date = new Date();
            String birthDateString = dateFormat.format(date);
             LocalDate localDate = birthDate.getValue();
             DateTimeFormatter localDateFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            Timestamp timestamp = new Timestamp(date.getTime());
            
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date);        
          
       
               
        
       barangayClearance.setId(getId());
       barangayClearance.setSurname(lastNameField.getText().toUpperCase());
       barangayClearance.setFirstName(firstNameField.getText().toUpperCase());
       barangayClearance.setMiddleName(middleNameField.getText().toUpperCase());
       barangayClearance.setFullname(firstNameField.getText().toUpperCase() + " " +  middleNameField.getText().charAt(0)+"." + " " +lastNameField.getText().toUpperCase());
       barangayClearance.setGender(genderType.getSelectionModel().getSelectedItem().toUpperCase());
       barangayClearance.setBirthDate(localDate.format(localDateFormat));
      
       
       barangayClearance.setCity(cityField.getText().toUpperCase());
       barangayClearance.setAddress(addressField.getText().toUpperCase()  + " " + UserContext.getCurrentBarangay() + "," + UserContext.getCurrentCity());
       barangayClearance.setAge(ageField.getText());
       barangayClearance.setRemarks(remarksBox.getSelectionModel().getSelectedItem().toString().toUpperCase());
       barangayClearance.setCitizenship(citizenshipField.getText().toUpperCase());
       barangayClearance.setBarangay(UserContext.getCurrentBarangay()); 
       barangayClearance.setCurrent_date(dateFormat.format(date));
       barangayClearance.setControl_no(control_no.getText().toUpperCase());
       barangayClearance.setCivilStatus(civilStat.getSelectionModel().getSelectedItem().toUpperCase());
       barangayClearance.setClearancePurpose(purposeBox.getSelectionModel().getSelectedItem().toString().toUpperCase());
       barangayClearance.setCurrentAdmin(UserContext.getAdminName());
       barangayClearance.setRegCost(Integer.parseInt(balanceField.getText().toUpperCase()));
       barangayClearance.setORNo(orNoField.getText().toUpperCase());
       barangayClearance.setAmountPaid(amountPaidField.getText().toUpperCase());
       barangayClearance.setClearanceType(registerType.getSelectionModel().getSelectedItem().toString().toUpperCase());
       change = Integer.parseInt(balanceField.getText()) - Integer.parseInt(amountPaidField.getText());
       changeField.setText(String.valueOf(change));
       barangayClearance.setAmountChange(Integer.parseInt(changeField.getText()));
        BufferedImage bImage = SwingFXUtils.fromFXImage(profilePicId.getImage(), null);
        try {
            barangayClearance.setProfileImage(bImage);
            File file = new File(System.getProperty("FOLDER_LOCATION") + barangayClearance.getFullname() + ".png");
            ImageIO.write(bImage, "png", file);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (barangayClearanceImpl.validateRecord(control_no.getText()) == true)
            {
                 JOptionPane.showMessageDialog(null, "Data Exist");
            }
        
        else if(birthDate.getEditor().getText().isEmpty() || lastNameField.getText().trim().equals("") || firstNameField.getText().trim().equals("") || middleNameField.getText().trim().equals("") || ageField.getText().trim().equals("")
                || citizenshipField.getText().trim().equals("") || cityField.getText().trim().equals("") || addressField.getText().trim().equals("") ||
                profilePicId.getImage() == null || orNoField.getText().trim().equals(""))
        {
             JOptionPane.showMessageDialog(null, "Incomplete Data Input");
        }
        else
        {
            changeField.setText(String.valueOf(change));
            barangayClearanceImpl.saveClearance(barangayClearance);
            JOptionPane.showMessageDialog(null, "Saved!");
        }


    }

    @FXML
    void saveBusClearanceRecord(ActionEvent event) throws ServiceException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String control_no_format = new SimpleDateFormat("yyyy-HmmSS").format(date); 
             int change;
            
             
             if(BCOwnership.getSelectionModel().getSelectedItem().equals("SINGLE PROPRIETOR") || BCOwnership.getSelectionModel().getSelectedItem().equals("PARTNERSHIP"))
             {
                businessClearance.setId(getId());
                businessClearance.setBusinessName(BCBusName.getText().toUpperCase());
                businessClearance.setFirstName(BCFirstName.getText().toUpperCase());
                businessClearance.setSurname(BCLastName.getText().toUpperCase());
                businessClearance.setMiddleName(BCMiddleName.getText().toUpperCase());
                businessClearance.setBusinessAddres(BCBusAdd.getText().toUpperCase() + " " + UserContext.getCurrentBarangay() + "," + UserContext.getCurrentCity());
                businessClearance.setBusinessType(BCBusType.getText().toUpperCase());
                businessClearance.setBuildingType(BCbldgType.getSelectionModel().getSelectedItem().toUpperCase());
                businessClearance.setOwnershipType(BCOwnership.getSelectionModel().getSelectedItem().toString().toUpperCase());
                businessClearance.setFullName(BCFirstName.getText().toUpperCase() + " "+middleNameField.getText().charAt(0)+"." + " "+ BCLastName.getText().toUpperCase());
                businessClearance.setPlateNo(BCPlateNo.getText().toUpperCase());
                businessClearance.setORNo(BCORNo.getText().toUpperCase());
                businessClearance.setCtrlNo(BCCtrlNo.getText().toUpperCase());
                businessClearance.setORDate(BCORDate.getText().toUpperCase());
                businessClearance.setClearanceFee(BCAmountPaid.getText().toUpperCase());
                businessClearance.setApplicationType(BCRegisterType.getSelectionModel().getSelectedItem().toUpperCase());
                businessClearance.setCurrentDate(dateFormat.format(date));
                businessClearance.setClearanceType(registerType.getSelectionModel().getSelectedItem().toString().toUpperCase());
                
                 if (businessClearanceImpl.validateRecord(BCCtrlNo.getText()) == true)
            {
                 JOptionPane.showMessageDialog(null, "Data Exist");
            }
        
                 else if(BCBusName.getText().trim().equals("") || BCFirstName.getText().trim().equals("") || BCLastName.getText().trim().equals("") || BCMiddleName.getText().trim().equals("") 
                        || BCBusAdd.getText().trim().equals("") || BCBusType.getText().trim().equals("") || BCOwnership.getEditor().equals("") || BCPlateNo.getText().trim().equals("") 
                        || BCORDate.getText().trim().equals("") || BCORNo.getText().trim().equals("") )
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }
                else
                {

                    businessClearanceImpl.saveClearance(businessClearance);
                    JOptionPane.showMessageDialog(null, "Saved!");
                }
             }
             else
             {
                businessClearance.setId(getId());
                businessClearance.setBusinessName(BCBusName.getText().toUpperCase());
                businessClearance.setBusinessAddres(BCBusAdd.getText().toUpperCase() + " " + UserContext.getCurrentBarangay() + "," + UserContext.getCurrentCity());
                businessClearance.setBusinessType(BCBusType.getText().toUpperCase());
                businessClearance.setBuildingType(BCbldgType.getSelectionModel().getSelectedItem());
                businessClearance.setFullName(BCBusName.getText().toUpperCase());
                businessClearance.setOwnershipType(BCOwnership.getSelectionModel().getSelectedItem().toString().toUpperCase());
                businessClearance.setPlateNo(BCPlateNo.getText().toUpperCase());
                businessClearance.setORNo(BCORNo.getText().toUpperCase());
                businessClearance.setCtrlNo(BCCtrlNo.getText().toUpperCase());
                businessClearance.setORDate(BCORDate.getText().toUpperCase());
                 businessClearance.setClearanceFee(BCAmountPaid.getText().toUpperCase());
                businessClearance.setApplicationType(BCRegisterType.getSelectionModel().getSelectedItem().toUpperCase());
                businessClearance.setCurrentDate(dateFormat.format(date));
                businessClearance.setClearanceType(registerType.getSelectionModel().getSelectedItem().toUpperCase());

                if (businessClearanceImpl.validateRecord(BCCtrlNo.getText()) == true)
                         {
                              JOptionPane.showMessageDialog(null, "Data Exist");
                         }
                else if(BCBusName.getText().trim().equals("") || BCBusAdd.getText().trim().equals("") || BCBusType.getText().trim().equals("") || BCOwnership.getEditor().equals("") || BCPlateNo.getText().trim().equals("") 
                                     || BCORDate.getText().trim().equals("") || BCORNo.getText().trim().equals("") )
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }
                else
                {
                    //BCChange.setText(String.valueOf(change));
                    businessClearanceImpl.saveClearance(businessClearance);
                    JOptionPane.showMessageDialog(null, "Saved!");
                }
             }


    }

    @FXML
    void savePedClearanceRecord(ActionEvent event) throws ServiceException {
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            
            pedicabClearance.setId(getId());
            pedicabClearance.setOwnerName(PCFirstName.getText().toUpperCase() + " " + PCMiddleName.getText().charAt(0)+"." + " " + PCLastName.getText().toUpperCase());
            pedicabClearance.setAddress(PCAdd.getText().toUpperCase() + " " + UserContext.getCurrentBarangay() + "," + UserContext.getCurrentCity());
            pedicabClearance.setBirthDate(PCBirthdate.getEditor().getText().toUpperCase());
            pedicabClearance.setGender(PCGender.getSelectionModel().getSelectedItem().toUpperCase());
            pedicabClearance.setRemarks(PCRemarks.getText().toUpperCase());
            pedicabClearance.setPlateNo(PCPlateNo.getText().toUpperCase());
            pedicabClearance.setPedBodNo(PCPlateNo.getText().toUpperCase());
            pedicabClearance.setExpiryDate(PCExpire.getText().toUpperCase());
            pedicabClearance.setSideColor(PCSideColor.getText().toUpperCase());
            pedicabClearance.setBikeColor(PCBikeColor.getText().toUpperCase());
            pedicabClearance.setTrapColor(PCTrapColor.getText().toUpperCase());
            pedicabClearance.setrSide(PCRSide.getText().toUpperCase());
            pedicabClearance.setlSide(PCCLside.getText().toUpperCase());
            pedicabClearance.setFrontMark(PCFrontM.getText().toUpperCase());
            pedicabClearance.setBackMark(PCBackM.getText().toUpperCase());
            pedicabClearance.setBarangay(PCBrgtField.getText().toUpperCase());
            pedicabClearance.setBarangayKap(UserContext.getBARANGAY_CAPTAIN().toUpperCase());
            pedicabClearance.setORNo(PCOrNo.getText().toUpperCase());
            pedicabClearance.setORDate(PCORDate.getText().toUpperCase());
            pedicabClearance.setControlNo(PCCtrlNo.getText().toUpperCase());
            pedicabClearance.setCtrNo(PCPlateNo.getText().toUpperCase());
            pedicabClearance.setCivilStat(PCCivilStat.getSelectionModel().getSelectedItem().toUpperCase());
            pedicabClearance.setDateIssued(dateFormat.format(date));
            pedicabClearance.setCurrentAdmin(UserContext.getAdminName().toUpperCase());
            pedicabClearance.setClearanceType(registerType.getSelectionModel().getSelectedItem().toUpperCase());
            
            if(pedicabClearanceImpl.validateRecord(PCCtrlNo.getText()) == true)
            {
                    JOptionPane.showMessageDialog(null, "Data Exists");
                    
            } 
            else if(PCFirstName.getText().equals("") || PCMiddleName.getText().equals("") || PCLastName.getText().equals("") || PCAdd.getText().equals("") || PCBirthdate.getEditor().getText().equals("")
                    || PCGender.getSelectionModel().getSelectedItem().equals("") || PCPlateNo.getText().equals(""))
            {
                  JOptionPane.showMessageDialog(null, "Invalid Input");
            }
            else
            {
                pedicabClearanceImpl.saveClearance(pedicabClearance);
                JOptionPane.showMessageDialog(null, "Saved!");
            }
            
            
    }

    @FXML
    void saveWorkClearanceRecord(ActionEvent event) throws ServiceException {
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
          
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
           
           
            
            workingClearance.setId(getId());
            workingClearance.setFirstName(WCFirstName.getText().toUpperCase());
            workingClearance.setMiddleName(WCMiddleName.getText().toUpperCase());
            workingClearance.setLastName(WCLastName.getText().toUpperCase());
            workingClearance.setFullName(WCFirstName.getText().toUpperCase() + " " + WCMiddleName.getText().charAt(0)+"." + " " + WCLastName.getText().toUpperCase());
            workingClearance.setControlNo(WCCtrlNo.getText().toUpperCase());
            workingClearance.setAddress(WCAdd.getText().toUpperCase());
            workingClearance.setBirthDate(WCBirthdate.getEditor().getText().toUpperCase());
            workingClearance.setAge(WCAge.getText().toUpperCase());
            workingClearance.setGender(WCGender.getSelectionModel().getSelectedItem().toUpperCase());
            workingClearance.setCivilStat(WCCivilStat.getSelectionModel().getSelectedItem().toUpperCase());
            workingClearance.setCitizenship(WCCitizenship.getText().toUpperCase());
            workingClearance.setAppPos(WCAppliedPos.getText().toUpperCase());
            workingClearance.setComName(WCcompanyName.getText().toUpperCase()   + " " + UserContext.getCurrentBarangay() + "," + UserContext.getCurrentCity());
            workingClearance.setComAdd(WCcompanyAdd.getText().toUpperCase());
            workingClearance.setBarangayKap(UserContext.getBARANGAY_CAPTAIN().toUpperCase());
            workingClearance.setBarangaySec(UserContext.getBARANGAY_SEC().toUpperCase());
            workingClearance.setBarangay(WCBrgyField.getText().toUpperCase());
            workingClearance.setCurrentDate(dateFormat.format(date));
            workingClearance.setRemarks(WCRemarks.getText().toUpperCase());
            workingClearance.setCurrentAdmin(UserContext.getAdminName().toUpperCase());
            workingClearance.setClearanceType(registerType.getSelectionModel().getSelectedItem().toUpperCase());
            BufferedImage bImage = SwingFXUtils.fromFXImage(WCProfilePic.getImage(), null);
             try {
                workingClearance.setProfileImage(bImage);
                File file = new File(System.getProperty("FOLDER_LOCATION") + workingClearance.getFullName() + registerType.getSelectionModel().getSelectedItem() + ".png");
                ImageIO.write(bImage, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
             if (workingClearanceImpl.validateRecord(WCCtrlNo.getText()) == true)
            {
                 JOptionPane.showMessageDialog(null, "Data Exist");
            }
            else if(WCFirstName.getText().equals("") || WCMiddleName.getText().equals("") || WCLastName.getText().equals("")
                    || WCAdd.getText().equals("") || WCAge.getText().equals("")  || WCcompanyAdd.getText().equals("")
                    || WCcompanyName.getText().equals(""))
            {
                 JOptionPane.showMessageDialog(null, "Invalid Input");
            }
            else 
            {
                    workingClearanceImpl.saveClearance(workingClearance);
                     JOptionPane.showMessageDialog(null, "Saved!");
               
            }
    }

    @FXML
    void signOutCapitan(ActionEvent event) throws IOException {
        
     
           
           if(webcamInitialize.WCWebcam.close() == true)
           {
                    webcamInitialize.webCamTask.isDone();
                  webcamInitialize.BCwebcam.close();     
                   AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
                    createNew.getChildren().setAll(pane);
           }
           else
           {
               webcamInitialize.webCamTask.isDone();
               webcamInitialize.WCWebcam.close();
               AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
               createNew.getChildren().setAll(pane);
           }
           
        


    }

    @FXML
    void viewRecords(ActionEvent event) {

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        webcamInitialize.initializeWebCam(profilePicId,WCProfilePic);
        
        
        barangayClearance.setBarangayCapt(UserContext.getBARANGAY_CAPTAIN());
        barangayClearance.setBarangayKag1(UserContext.getKAGAWAD_1());
        barangayClearance.setBarangayKag2(UserContext.getKAGAWAD_2());
        barangayClearance.setBarangayKag3(UserContext.getKAGAWAD_3());
        barangayClearance.setBarangayKag4(UserContext.getKAGAWAD_4());
        barangayClearance.setBarangayKag5(UserContext.getKAGAWAD_5());
        barangayClearance.setBarangayKag6(UserContext.getKAGAWAD_6());
        barangayClearance.setBarangayKag7(UserContext.getKAGAWAD_7());
        barangayClearance.setBarangaySec(UserContext.getBARANGAY_SEC());
        barangayClearance.setBarangayTres(UserContext.getBARANGAY_TRES());
        
        BCBrgyField.setText(UserContext.getCurrentBarangay());
        businessClearance.setBrgyCapt(UserContext.getBARANGAY_CAPTAIN());
        businessClearance.setBarangay(UserContext.getCurrentBarangay());
      
        try {
            purposeBox.getItems().addAll(barangayClearanceImpl.loadComboBox(purposeOptions));
           purposeBox.getSelectionModel().select(1);
        } catch (ServiceException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            remarksBox.getItems().addAll(barangayClearanceImpl.loadRemarksBox(remarksOptions));
            remarksBox.getSelectionModel().select(1);
        }catch (ServiceException ex)
        {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            BCOwnership.getItems().addAll(businessClearanceImpl.loadBusinessType(ownershipOptions));
            BCOwnership.getSelectionModel().select(0);
        } catch (ServiceException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
            BCbldgType.getItems().addAll("RENTED" , "OWNED");
            BCbldgType.getSelectionModel().select("OWNED");
//     
       
       
            registerType.getItems().addAll("Barangay Clearance","Business Clearance","Working Clearance","Pedicab Clearance");
            registerType.getSelectionModel().select("Barangay Clearance");
            
            barangayField.setText(UserContext.getCurrentBarangay());
          
    
            genderType.getItems().addAll("Male","Female");
            genderType.getSelectionModel().select("Male");
            WCGender.getItems().addAll("Male" , "Female");
            WCGender.getSelectionModel().select("Male");
            PCGender.getItems().addAll("Male" , "Female");
            PCGender.getSelectionModel().select("Male");
            citizenshipField.setText("Filipino");
            citizenshipField.setDisable(true);
            
            civilStat.getItems().addAll("Single","Married","Divorced","Widowed");
            civilStat.getSelectionModel().select("Single");
            WCCivilStat.getItems().addAll("Single","Married","Divorced","Widowed");
            WCCivilStat.getSelectionModel().select("Single");
            PCCivilStat.getItems().addAll("Single","Married","Divorced","Widowed");
            PCCivilStat.getSelectionModel().select("Single");
           

            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String control_no_format = new SimpleDateFormat("yyyy-ddhms").format(date);
            String time_format = new SimpleDateFormat("hh:mm a").format(date);
            long year = TimeUnit.MILLISECONDS.convert(365, TimeUnit.DAYS);
            Date expiry = new Date(System.currentTimeMillis() + year);
            String expire = new SimpleDateFormat("MM/dd/yyyy").format(expiry);
            time_label.setText(time_format);
            date_label.setText(dateFormat.format(date));
            
             control_no.setText(control_no_format);
             BCCtrlNo.setText(control_no_format);
             WCCtrlNo.setText(control_no_format);
             PCCtrlNo.setText(control_no_format);
          
           
            BCORDate.setText(dateFormat.format(date));
            BCRegisterType.getItems().addAll("NEW","RENEWAL");
            BCRegisterType.getSelectionModel().select("NEW");
            PCExpire.setText(expire);
            PCORDate.setText(dateFormat.format(date));
            cityField.setText(UserContext.getCurrentCity());

     
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
            
            
            //initializeWebCam();
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
    

>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359
