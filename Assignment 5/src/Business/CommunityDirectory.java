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
public class CommunityDirectory {
    private ArrayList<Community> communityDirectory;

    public CommunityDirectory() {
        communityDirectory = new ArrayList<Community>();
    }

    public ArrayList<Community> getCommunityDirectory() {
        return communityDirectory;
    }

    public void setCommunityDirectory(ArrayList<Community> communityDirectory) {
        this.communityDirectory = communityDirectory;
    }
    
    public void addCommunity(Community c){
      communityDirectory.add(c);
    }
    
}
