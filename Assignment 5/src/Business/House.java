/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author ayush
 */
public class House {
    
    private int houseId;
    private FamilyDirectory familyDirectory;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }
    
    public House()
    {
        this.familyDirectory = new FamilyDirectory();
    }

    public FamilyDirectory getFamilyDirectory() {
        return familyDirectory;
    }

    public void setFamilyDirectory(FamilyDirectory familyDirectory) {
        this.familyDirectory = familyDirectory;
    }
    
}
