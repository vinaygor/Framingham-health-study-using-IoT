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
public class City {
    private ArrayList<CommunityDirectory> city;
    
    public City(){
        city=new ArrayList<CommunityDirectory>();
    }

    public ArrayList<CommunityDirectory> getCity() {
        return city;
    }

    public void setCity(ArrayList<CommunityDirectory> city) {
        this.city = city;
    }
    
}
