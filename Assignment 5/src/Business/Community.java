/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class Community {
    private String communityName;
    private HouseDirectory houseDirectory;
    private float Temperature;
    private float pollutionLevel;

    public Community()
    {
      //  this.housedirectory = new ArrayList<House>();
    }
    
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public HouseDirectory getHouseDirectory() {
        return houseDirectory;
    }

    public void setHouseDirectory(HouseDirectory houseDirectory) {
        this.houseDirectory = houseDirectory;
    }

    

    

    public float getTemperature() {
        return Temperature;
    }

    public void setTemperature(float Temperature) {
        this.Temperature = Temperature;
    }

    public float getPollutionLevel() {
        return pollutionLevel;
    }

    public void setPollutionLevel(float pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }
    
    
}
