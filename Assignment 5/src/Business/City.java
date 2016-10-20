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
    private ArrayList<CommunityDirectory> communityList;
    private String cityName;

    public City() {
        this.communityList = new ArrayList<>();
    }

    public ArrayList<CommunityDirectory> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(ArrayList<CommunityDirectory> communityList) {
        this.communityList = communityList;
    }
    
   
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

     public void addCommunityDir(CommunityDirectory c){
      communityList.add(c);
    }
}
