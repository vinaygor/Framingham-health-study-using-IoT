/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public class House {
    
    private int houseId;
    private ArrayList<Family> family;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }
    
    public House()
    {
        this.family = new ArrayList<Family>();
    }

    public ArrayList<Family> getFamily() {
        return family;
    }

    public void setFamily(ArrayList<Family> family) {
        this.family = family;
    }
    
    public void add(Family family)
    {
        this.family.add(family);
    }
    

    
    
}
