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
    private int hdlCholestrol;
    private int totalCholestrol;
    private int riskScore;

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

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }
    
    
}
