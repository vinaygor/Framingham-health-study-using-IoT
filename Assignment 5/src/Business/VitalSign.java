/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Rishabh
 */
public class VitalSign {
    private Date createdOn;
    private boolean smoker;
    private boolean diabetes;
    private int bloodPressure;
    private int hdlCholestrol;
    private int totalCholestrol;
    private double cholRiskScore;
    private double ldlRiskScore;

    public double getCholRiskScore() {
        return cholRiskScore;
    }

    public void setCholRiskScore(double cholRiskScore) {
        this.cholRiskScore = cholRiskScore;
    }

    public double getLdlRiskScore() {
        return ldlRiskScore;
    }

    public void setLdlRiskScore(double ldlRiskScore) {
        this.ldlRiskScore = ldlRiskScore;
    }

   

   
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getHdlCholestrol() {
        return hdlCholestrol;
    }

    public void setHdlCholestrol(int hdlCholestrol) {
        this.hdlCholestrol = hdlCholestrol;
    }

    public int getTotalCholestrol() {
        return totalCholestrol;
    }

    public void setTotalCholestrol(int totalCholestrol) {
        this.totalCholestrol = totalCholestrol;
    }

   
   
   
    
}
