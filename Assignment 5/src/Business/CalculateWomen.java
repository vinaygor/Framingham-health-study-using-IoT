/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author vinay
 */
public class CalculateWomen {
 
    public VitalSign calculateRiskScore(VitalSign vitalSign,int age){
         
        double ldlRiskScore = 0.0;
        double cholRiskScore = 0.0;
       
        NavigableMap<Integer,Integer> ageLDLMap =new TreeMap<Integer, Integer>();
            ageLDLMap.put(1,-9);
            ageLDLMap.put(30,-9);
            ageLDLMap.put(35,-4);
            ageLDLMap.put(40,0);
            ageLDLMap.put(45,3);
            ageLDLMap.put(50,6);
            ageLDLMap.put(55,7);
            ageLDLMap.put(60,8);
            ageLDLMap.put(65,8);
            ageLDLMap.put(70,8);
        ldlRiskScore=ldlRiskScore + ageLDLMap.get(ageLDLMap.floorKey(age));
        cholRiskScore=cholRiskScore +ageLDLMap.get(ageLDLMap.floorKey(age));
    //---------------    
    NavigableMap<Integer,Integer> ldlMap =new TreeMap<Integer, Integer>();
            ldlMap.put(0,-2);
            ldlMap.put(100,0);
            ldlMap.put(130,0);
            ldlMap.put(160,2);
            ldlMap.put(190,2);
     
    ldlRiskScore=ldlRiskScore+ldlMap.get(ldlMap.floorKey(vitalSign.getTotalCholestrol()));
        
    NavigableMap<Integer,Integer> cholMap =new TreeMap<Integer, Integer>();
   cholMap.put(0,-2);
   cholMap.put(160,0);
   cholMap.put(200,1);
   cholMap.put(240,1);
   cholMap.put(280,3);
     
    cholRiskScore=cholRiskScore+cholMap.get(cholMap.floorKey(vitalSign.getTotalCholestrol()));
    
    //--------------------
    NavigableMap<Integer,Integer> hdlLdlMap =new TreeMap<Integer, Integer>();
   hdlLdlMap.put(0,5);
   hdlLdlMap.put(35,2);
   hdlLdlMap.put(45,1);
   hdlLdlMap.put(50,0);
   hdlLdlMap.put(60,-2);
     
   ldlRiskScore=ldlRiskScore+hdlLdlMap.get(hdlLdlMap.floorKey(vitalSign.getHdlCholestrol()));
        
    NavigableMap<Integer,Integer> hdlCholMap =new TreeMap<Integer, Integer>();
   hdlCholMap.put(0,5);
   hdlCholMap.put(35,2);
   hdlCholMap.put(45,1);
   hdlCholMap.put(50,0);
   hdlCholMap.put(60,-3);
     
   cholRiskScore=cholRiskScore+hdlCholMap.get(hdlCholMap.floorKey(vitalSign.getHdlCholestrol()));
    
    
    //-----------------
    
   NavigableMap<Integer,Integer> systolicMap =new TreeMap<Integer, Integer>();
   systolicMap.put(1,-3);
   systolicMap.put(120,0);
   systolicMap.put(130,0);
   systolicMap.put(140,2);
   systolicMap.put(160,3);
   
    ldlRiskScore= ldlRiskScore + systolicMap.get(systolicMap.floorKey(vitalSign.getBloodPressure()));
    cholRiskScore = cholRiskScore + systolicMap.get(systolicMap.floorKey(vitalSign.getBloodPressure()));
        
    //-----------
    NavigableMap<Boolean,Integer> diabetesMap =new TreeMap<Boolean, Integer>();
   diabetesMap.put(true,4);
   diabetesMap.put(false,0);
   
    ldlRiskScore= ldlRiskScore + diabetesMap.get(diabetesMap.floorKey(vitalSign.isDiabetes()));
    cholRiskScore = cholRiskScore + diabetesMap.get(diabetesMap.floorKey(vitalSign.isDiabetes()));
    
    //--------
    
    NavigableMap<Boolean,Integer> smokersMap =new TreeMap<Boolean, Integer>();
   smokersMap.put(true,2);
   smokersMap.put(false,0);
   
    ldlRiskScore= ldlRiskScore + smokersMap.get(smokersMap.floorKey(vitalSign.isSmoker()));
    cholRiskScore = cholRiskScore + smokersMap.get(smokersMap.floorKey(vitalSign.isSmoker()));
     
//----------   
    
   
    
    
    //--------------------------------
    
    vitalSign.setLdlRiskScore(ldlRiskScore);
    vitalSign.setCholRiskScore(cholRiskScore);
   
        return vitalSign;
    }
    
    public int ldlRiskPercentage(VitalSign vitalSign){
        double ldlRiskScore=vitalSign.getLdlRiskScore();
        NavigableMap<Double,Integer> ldlRiskPercentageMap =new TreeMap<Double, Integer>();
   ldlRiskPercentageMap.put(-17.0,1);
   ldlRiskPercentageMap.put(-1.0,2);
   ldlRiskPercentageMap.put(0.0,2);
   ldlRiskPercentageMap.put(1.0,2);
   ldlRiskPercentageMap.put(2.0,3);
   ldlRiskPercentageMap.put(3.0,3);
   ldlRiskPercentageMap.put(4.0,4);
   ldlRiskPercentageMap.put(5.0,5);
   ldlRiskPercentageMap.put(6.0,6);
   ldlRiskPercentageMap.put(7.0,7);
   ldlRiskPercentageMap.put(8.0,8);
   ldlRiskPercentageMap.put(9.0,9);
   ldlRiskPercentageMap.put(10.0,11);
   ldlRiskPercentageMap.put(11.0,13);
   ldlRiskPercentageMap.put(12.0,15);
   ldlRiskPercentageMap.put(13.0,17);
   ldlRiskPercentageMap.put(13.0,17);
   ldlRiskPercentageMap.put(14.0,20);
   ldlRiskPercentageMap.put(15.0,24);
   ldlRiskPercentageMap.put(16.0,27);
   ldlRiskPercentageMap.put(17.0,32);
   
   int ldlPercentage=ldlRiskPercentageMap.get(ldlRiskPercentageMap.floorKey(ldlRiskScore));
   return ldlPercentage;
    }
    
    public int cholRiskPercentage(VitalSign vitalSign){
   double cholRiskScore=vitalSign.getCholRiskScore();
   NavigableMap<Double,Integer> chdCholRiskPercentageMap =new TreeMap<Double, Integer>();
   chdCholRiskPercentageMap.put(-17.0,1);
   chdCholRiskPercentageMap.put(-1.0,2);
   chdCholRiskPercentageMap.put(0.0,2);
   chdCholRiskPercentageMap.put(1.0,2);
   chdCholRiskPercentageMap.put(2.0,3);
   chdCholRiskPercentageMap.put(3.0,3);
   chdCholRiskPercentageMap.put(4.0,4);
   chdCholRiskPercentageMap.put(5.0,4);
   chdCholRiskPercentageMap.put(6.0,5);
   chdCholRiskPercentageMap.put(7.0,6);
   chdCholRiskPercentageMap.put(8.0,7);
   chdCholRiskPercentageMap.put(9.0,8);
   chdCholRiskPercentageMap.put(10.0,10);
   chdCholRiskPercentageMap.put(11.0,11);
   chdCholRiskPercentageMap.put(12.0,13);
   chdCholRiskPercentageMap.put(13.0,15);
   chdCholRiskPercentageMap.put(13.0,15);
   chdCholRiskPercentageMap.put(14.0,18);
   chdCholRiskPercentageMap.put(15.0,20);
   chdCholRiskPercentageMap.put(16.0,24);
   chdCholRiskPercentageMap.put(17.0,27);
   
   int cholPercentage=chdCholRiskPercentageMap.get(chdCholRiskPercentageMap.floorKey(cholRiskScore));
   return cholPercentage;
    }
}