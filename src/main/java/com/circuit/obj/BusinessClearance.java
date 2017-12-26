/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.obj;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Marvin
 */
public class BusinessClearance {
    
    int id;
    String surname;
    String firstName;
    String middleName;
    String occupation;
    String residence;
    String businessName;
    String businessAddres;
    String businessType;
    boolean isNew;
    String buildingType;
    String ownershipType;
    String remarks;
    String recommendations;
    float clearanceFee;
    String inspectorName;
    
    String fullName;
    
    
    
    private Map<String,Object> data = new HashMap<String,Object>();
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        
        return surname;
    }

    public void setSurname(String surname) {
        this.data.put("SURNAME", surname);
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.data.put("FIRSTNAME", firstName);
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.data.put("MIDDLENAME", middleName);
        this.middleName = middleName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.data.put("OCCUPATION", occupation);
        this.occupation = occupation;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.data.put("RESIDENCE",  residence);
        this.residence = residence;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.data.put("BUSINESS_NAME", businessName);
        this.businessName = businessName;
    }

    public String getBusinessAddres() {
        return businessAddres;
    }

    public void setBusinessAddres(String businessAddres) {
        this.data.put("BUSINESS_ADDRES", businessAddres);
        this.businessAddres = businessAddres;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.data.put("BUSINESS_TYPE", businessType);
        this.businessType = businessType;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
         this.data.put("isNew", isNew);
        this.isNew = isNew;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.data.put("BUILDING_TYPE", buildingType);
        this.buildingType = buildingType;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.data.put("OWNERSHIP_TYPE", ownershipType);
        this.ownershipType = ownershipType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.data.put("REMARKS", remarks);
        this.remarks = remarks;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.data.put("RECOMMENDATIONS", recommendations);
        this.recommendations = recommendations;
    }

    public float getClearanceFee() {
        return clearanceFee;
    }

    public void setClearanceFee(float clearanceFee) {
        this.data.put("CLEARANCE_FEE", clearanceFee);
        this.clearanceFee = clearanceFee;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.data.put("INSPECTOR_NAME", inspectorName);
        this.inspectorName = inspectorName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
    
        
     public Map<String,Object> getData()
    {
        
        return data;
    }
    
}
