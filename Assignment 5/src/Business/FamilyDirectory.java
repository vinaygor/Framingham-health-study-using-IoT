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
public class FamilyDirectory {
    private ArrayList<Family> familyDirectory;
    
    public FamilyDirectory(){
        familyDirectory=new ArrayList<Family>();
    }

    public ArrayList<Family> getFamilyDirectory() {
        return familyDirectory;
    }

    public void setFamilyDirectory(ArrayList<Family> familyDirectory) {
        this.familyDirectory = familyDirectory;
    }
    
      public void addfamily(Family family) {
        familyDirectory.add(family);
    }
    
}
