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
    private int diabetes;
    private int bloodPressure;
    private double hdlCholestrol;
    private double totalCholestrol;
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

   

    public double getLDLriskScore() {
        return LDLriskScore;
    }

    public void setLDLriskScore(double LDLriskScore) {
        this.LDLriskScore = LDLriskScore;
    }
    private double LDLriskScore;

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

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getHdlCholestrol() {
        return hdlCholestrol;
    }

    public void setHdlCholestrol(double hdlCholestrol) {
        this.hdlCholestrol = hdlCholestrol;
    }

    public double getTotalCholestrol() {
        return totalCholestrol;
    }

    public void setTotalCholestrol(double totalCholestrol) {
        this.totalCholestrol = totalCholestrol;
    }

   
    
}
