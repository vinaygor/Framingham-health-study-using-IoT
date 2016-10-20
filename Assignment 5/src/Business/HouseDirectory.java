/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author vinay
 */
public class HouseDirectory {
    private ArrayList<House> housedirectory;

    public HouseDirectory(){
        this.housedirectory = new ArrayList<House>();
    }
    
    public ArrayList<House> getHousedirectory() {
        return housedirectory;
    }

    public void setHousedirectory(ArrayList<House> housedirectory) {
        this.housedirectory = housedirectory;
    }
    
    public void addHouse(House house) {
        housedirectory.add(house);
        
    }
}
