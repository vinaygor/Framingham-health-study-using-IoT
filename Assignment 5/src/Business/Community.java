/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Rishabh
 */
public class Community {
    private String communityName;
    private FamilyDirectory familyDirectory;
    private float Temperature;
    private float pollutionLevel;

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public FamilyDirectory getFamilyDirectory() {
        return familyDirectory;
    }

    public void setFamilyDirectory(FamilyDirectory familyDirectory) {
        this.familyDirectory = familyDirectory;
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
