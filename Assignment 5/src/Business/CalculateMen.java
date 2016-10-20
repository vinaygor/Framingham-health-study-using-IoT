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
public class CalculateMen {
    
    public VitalSign calculateRiskScore(VitalSign vitalSign, int age){
        
        double ldlRiskScore = 0;
        double cholRiskScore = 0;
        
        NavigableMap<Integer,Integer> ageLDLMap =new TreeMap<Integer, Integer>();
            ageLDLMap.put(1,-1);
            ageLDLMap.put(35,0);
            ageLDLMap.put(40,1);
            ageLDLMap.put(45,2);
            ageLDLMap.put(50,3);
            ageLDLMap.put(55,4);
            ageLDLMap.put(60,5);
            ageLDLMap.put(65,6);
            ageLDLMap.put(70,7);
        ldlRiskScore= ldlRiskScore + ageLDLMap.get(ageLDLMap.floorKey(age));
        
        NavigableMap<Integer,Integer> ageCholMap =new TreeMap<Integer, Integer>();
            ageCholMap.put(1,-1);
            ageCholMap.put(35,0);
            ageCholMap.put(40,1);
            ageCholMap.put(45,2);
            ageCholMap.put(50,3);
            ageCholMap.put(55,4);
            ageCholMap.put(60,5);
            ageCholMap.put(65,6);
            ageCholMap.put(70,7);
        cholRiskScore = cholRiskScore + ageCholMap.get(ageCholMap.floorKey(age));
        
        NavigableMap<Integer,Integer> ldlMap = new TreeMap<Integer,Integer>();
            ldlMap.put(0,-3);
            ldlMap.put(100,0);
            ldlMap.put(130,0);
            ldlMap.put(160,1);
            ldlMap.put(190,2);
        ldlRiskScore= ldlRiskScore + ldlMap.get(ldlMap.floorKey(vitalSign.getTotalCholestrol()));
    
        NavigableMap<Integer,Integer> cholMap = new TreeMap<Integer,Integer>();
            cholMap.put(0,-3);
            cholMap.put(160,0);
            cholMap.put(200,1);
            cholMap.put(240,2);
            cholMap.put(280,3);
        cholRiskScore = cholRiskScore + cholMap.get(cholMap.floorKey(vitalSign.getTotalCholestrol()));
        
        NavigableMap<Integer,Integer> hdlLdlMap = new TreeMap<Integer,Integer>();
            hdlLdlMap.put(0,2);
            hdlLdlMap.put(35,1);
            hdlLdlMap.put(45,0);
            hdlLdlMap.put(50,0);
            hdlLdlMap.put(60,-1);
        ldlRiskScore= ldlRiskScore + hdlLdlMap.get(hdlLdlMap.floorKey(vitalSign.getHdlCholestrol()));
            
        NavigableMap<Integer,Integer> hdlCholMap = new TreeMap<Integer,Integer>();
            hdlCholMap.put(0,2);
            hdlCholMap.put(35,1);
            hdlCholMap.put(45,0);
            hdlCholMap.put(50,0);
            hdlCholMap.put(60,-2);
        cholRiskScore = cholRiskScore + hdlCholMap.get(hdlCholMap.floorKey(vitalSign.getHdlCholestrol()));
            
        NavigableMap<Integer,Integer> systolicMap = new TreeMap<Integer,Integer>();
            systolicMap.put(0,0);
            systolicMap.put(120,0);
            systolicMap.put(130,1);
            systolicMap.put(140,2);
            systolicMap.put(160,3);
        ldlRiskScore= ldlRiskScore + systolicMap.get(systolicMap.floorKey(vitalSign.getBloodPressure()));
        cholRiskScore = cholRiskScore + systolicMap.get(systolicMap.floorKey(vitalSign.getBloodPressure()));    
            
        NavigableMap<Boolean,Integer> diabetesMap = new TreeMap<Boolean,Integer>();
            diabetesMap.put(false,0);
            diabetesMap.put(true,2);
        ldlRiskScore= ldlRiskScore + diabetesMap.get(diabetesMap.floorKey(vitalSign.isDiabetes()));
        cholRiskScore = cholRiskScore + diabetesMap.get(diabetesMap.floorKey(vitalSign.isDiabetes()));    
            
        NavigableMap<Boolean,Integer> smokersMap = new TreeMap<Boolean,Integer>();
            smokersMap.put(false,0);
            smokersMap.put(true,2);
        ldlRiskScore= ldlRiskScore + smokersMap.get(smokersMap.floorKey(vitalSign.isSmoker()));
        cholRiskScore = cholRiskScore + smokersMap.get(smokersMap.floorKey(vitalSign.isSmoker()));    
            
        NavigableMap<Double,Integer> ldlRiskPercentageMap = new TreeMap<Double,Integer>();
            ldlRiskPercentageMap.put(-10.0,1);
            ldlRiskPercentageMap.put(-2.0,2);
            ldlRiskPercentageMap.put(-1.0,2);
            ldlRiskPercentageMap.put(0.0,3);
            ldlRiskPercentageMap.put(1.0,4);
            ldlRiskPercentageMap.put(2.0,4);
            ldlRiskPercentageMap.put(3.0,6);
            ldlRiskPercentageMap.put(4.0,7);
            ldlRiskPercentageMap.put(5.0,9);
            ldlRiskPercentageMap.put(6.0,11);
            ldlRiskPercentageMap.put(7.0,14);
            ldlRiskPercentageMap.put(8.0,18);
            ldlRiskPercentageMap.put(9.0,22);
            ldlRiskPercentageMap.put(10.0,27);
            ldlRiskPercentageMap.put(11.0,33);
            ldlRiskPercentageMap.put(12.0,40);
            ldlRiskPercentageMap.put(13.0,47);
            ldlRiskPercentageMap.put(14.0,56);
        int ldlRiskPercentage= ldlRiskPercentageMap.get(ldlRiskPercentageMap.floorKey(ldlRiskScore));   
            
        NavigableMap<Double,Integer> chdCholRiskPercentageMap = new TreeMap<Double,Integer>();
            chdCholRiskPercentageMap.put(-10.0,2);
            chdCholRiskPercentageMap.put(0.0,3);
            chdCholRiskPercentageMap.put(1.0,3);
            chdCholRiskPercentageMap.put(2.0,4);
            chdCholRiskPercentageMap.put(3.0,5);
            chdCholRiskPercentageMap.put(4.0,7);
            chdCholRiskPercentageMap.put(5.0,8);
            chdCholRiskPercentageMap.put(6.0,10);
            chdCholRiskPercentageMap.put(7.0,13);
            chdCholRiskPercentageMap.put(8.0,16);
            chdCholRiskPercentageMap.put(9.0,20);
            chdCholRiskPercentageMap.put(10.0,25);
            chdCholRiskPercentageMap.put(11.0,31);
            chdCholRiskPercentageMap.put(12.0,37);
            chdCholRiskPercentageMap.put(13.0,45);
            chdCholRiskPercentageMap.put(14.0,53);    
        int cholRiskPercentage =chdCholRiskPercentageMap.get(chdCholRiskPercentageMap.floorKey(cholRiskScore));
        
        vitalSign.setLdlRiskScore(ldlRiskScore);
        vitalSign.setCholRiskScore(cholRiskScore);
        
        return vitalSign;
    }
}
