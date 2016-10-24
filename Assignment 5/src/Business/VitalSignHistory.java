/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author Rishabh
 */
public class VitalSignHistory {
    private ArrayList<VitalSign> vitalSignHistory;
    private double avgLdlRiskScore;
    private double  avgCholRiskScore;
    
    public VitalSignHistory(){
        vitalSignHistory=new ArrayList<VitalSign>();
    }

    public ArrayList<VitalSign> getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSign> vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
      
    public VitalSign addVitalSign(VitalSign vitalSign) {
        
        vitalSignHistory.add(vitalSign);
        return vitalSign;
    }

    public double getAvgLdlRiskScore() {
        return avgLdlRiskScore;
    }

    public void setAvgLdlRiskScore(double avgLdlRiskScore) {
        this.avgLdlRiskScore = avgLdlRiskScore;
    }

    public double getAvgCholRiskScore() {
        return avgCholRiskScore;
    }

    public void setAvgCholRiskScore(double avgCholRiskScore) {
        this.avgCholRiskScore = avgCholRiskScore;
    }
    
    public void sortList()
    {
         Collections.sort(vitalSignHistory, new Comparator<VitalSign>(){
           public int compare (VitalSign v1, VitalSign v2){
               return v1.getCreatedOn().compareTo(v2.getCreatedOn());
           }
       });
        
    }
    
}
