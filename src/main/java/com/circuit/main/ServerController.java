package com.circuit.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marvin
 */
public class ServerController implements Initializable {
    
    
    @FXML
    private AnchorPane serverRootPane;
   
    @FXML
    private Label curretnAdminLbl;

    @FXML
    private Label dateLbl;

    @FXML
    private Label userLoggedLbl;

    @FXML
    private BarChart<?, ?> clearanceChart;

    @FXML
    private Label treasuryOnline;

    @FXML
    private Label adminOnline;

    @FXML
    private Label businessOnline;

    @FXML
    private Label luponOnline;

    @FXML
    private ImageView currentAdminPic;

    @FXML
    private Label adminName;

    @FXML
    private Label adminDepartment;

    @FXML
    private Label adminEmployeeNo;

    @FXML
    void homeBtn(ActionEvent event) {

    }

    @FXML
    void logoutBtn(ActionEvent event) {

    }

    @FXML
    void recordsBtn(ActionEvent event) {

    }

    @FXML
    void settingsBtn(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
