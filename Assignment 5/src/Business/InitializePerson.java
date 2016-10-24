/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.prism.impl.BaseMesh;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author vinay
 */
public class InitializePerson {
    
    private static int personID = 1;
    private static int familyID = 1;
    private static int houseID = 1;
    
    
    
    public static long offset = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
    public static long end = Timestamp.valueOf("2015-12-31 00:00:00").getTime();
    
    
    public  String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    
    public int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    public  PersonDirectory initPersonDirectory() {
        PersonDirectory personDirectory = new PersonDirectory();
        PersonDirectory grandFather = new PersonDirectory();
        PersonDirectory grandMother = new PersonDirectory();
        PersonDirectory father = new PersonDirectory();
        PersonDirectory mother = new PersonDirectory();
        PersonDirectory child = new PersonDirectory();
        HouseDirectory houseDirectory = new HouseDirectory();
        City city = new City();
        CommunityDirectory communityDirectory= new CommunityDirectory();
        Community community1 = new Community();
        Community community2 = new Community();
        
        community1.setCommunityName("Roxbury");
        community1.setPollutionLevel(19);
        community1.setTemperature(66);
        
        community2.setCommunityName("BackBay");
        community2.setPollutionLevel(29);
        community2.setTemperature(69);
        
        
        Random rand = new Random();

        //There are two ways presented in here for random string generation you can use whatever you feel is right.
        String myCharacters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        //Insert your user freindly names here
        String[] gender = {"Male","Female"};

        for (int i = 0; i < 300; i++) {
            Person person = new Person();
            person.setPersonId(Integer.toString(personID++));
            String name = generateString(rand, myCharacters, 4);
            person.setName(name);
            int n = randInt(80,100);
            person.setAge(n);
            person.setPatient(rand.nextBoolean());
            
            person.setGender("Male");
            VitalSignHistory vsh = initVitalSign(person.getGender(),person.getAge());
                       
            if(person.isPatient()){
                vsh.setAvgCholRiskScore(vsh.getAvgCholRiskScore()+1.0);
                vsh.setAvgLdlRiskScore(vsh.getAvgLdlRiskScore()+1.0);
            }
            vsh.sortList();
            person.setVitalSignHistory(vsh);
            grandFather.addPerson(person);
            personDirectory.addPerson(person);
        }
        
        for (int i = 0; i < 300; i++) {
            Person person = new Person();
            person.setPersonId(Integer.toString(personID++));
            //String name = generateString(rand, myCharacters, 4);
            //You can use this as well for user freindly names
            String name = generateString(rand, myCharacters, 3);
            person.setName(name);
            int n = randInt(80,100);
            person.setAge(n);
            person.setPatient(rand.nextBoolean());
            person.setGender("Female");
            VitalSignHistory vsh = initVitalSign(person.getGender(),person.getAge());
            if(person.isPatient()){
                vsh.setAvgCholRiskScore(vsh.getAvgCholRiskScore()+1.0);
                vsh.setAvgLdlRiskScore(vsh.getAvgLdlRiskScore()+1.0);
            }
            vsh.sortList();
            person.setVitalSignHistory(vsh);
            grandMother.addPerson(person);
            personDirectory.addPerson(person);
        }
        
        for (int i = 0; i < 150; i++) {
            Person person = new Person();
            person.setPersonId(Integer.toString(personID++));
            String name = generateString(rand, myCharacters, 4);
            person.setName(name);
            int n = randInt(40,70);
            double hereditoryRiskScore=0.5;
            double ldlRiskScore=0.0;
            double cholRiskScore=0.0;
            
            person.setAge(n);
            
            person.setGender("Male");
            VitalSignHistory vsh = initVitalSign(person.getGender(),person.getAge());
            person.setVitalSignHistory(vsh);
            ldlRiskScore = vsh.getAvgLdlRiskScore();
            cholRiskScore = vsh.getAvgCholRiskScore();
            
            int index = rand.nextInt(grandFather.getPersonDirectory().size());
            Person temp= grandFather.getPersonDirectory().get(index);
            boolean isPatient = temp.isPatient();
            if(isPatient)
            {
                ldlRiskScore = ldlRiskScore+ hereditoryRiskScore;
                cholRiskScore = cholRiskScore+ hereditoryRiskScore;
            }
            
            person.setFather(temp);
            grandFather.getPersonDirectory().remove(index);
            
            int index1 = rand.nextInt(grandMother.getPersonDirectory().size());
            Person temp1= grandMother.getPersonDirectory().get(index);
            boolean isPatient2=temp1.isPatient();
            if(isPatient2)
            {
                ldlRiskScore = ldlRiskScore+ hereditoryRiskScore;
                cholRiskScore = cholRiskScore+ hereditoryRiskScore;
            }
            ldlRiskScore = Math.round(ldlRiskScore*100D)/100D;
            cholRiskScore = Math.round(cholRiskScore*100D)/100D;
            vsh.setAvgLdlRiskScore(ldlRiskScore);
            vsh.setAvgCholRiskScore(cholRiskScore);
            vsh.sortList();
            person.setMother(temp1);
            grandMother.getPersonDirectory().remove(index1);
            
            father.addPerson(person);
            personDirectory.addPerson(person);
        }
        
        for (int i = 0; i < 150; i++) {
            Person person = new Person();
            person.setPersonId(Integer.toString(personID++));
            String name = generateString(rand, myCharacters, 4);
            person.setName(name);
            int n = randInt(40,70);
            person.setAge(n);
            double hereditoryRiskScore=0.5;
            double ldlRiskScore=0.0;
            double cholRiskScore=0.0;
            
            person.setGender("Female");
            VitalSignHistory vsh = initVitalSign(person.getGender(),person.getAge());
            person.setVitalSignHistory(vsh);
            ldlRiskScore = vsh.getAvgLdlRiskScore();
            cholRiskScore = vsh.getAvgCholRiskScore();
            
            int index = rand.nextInt(grandFather.getPersonDirectory().size());
            Person temp= grandFather.getPersonDirectory().get(index);
            boolean isPatient = temp.isPatient();
            if(isPatient)
            {
                ldlRiskScore = ldlRiskScore+ hereditoryRiskScore;
                cholRiskScore = cholRiskScore+ hereditoryRiskScore;
            }
            person.setFather(temp);
            grandFather.getPersonDirectory().remove(index);
            
            int index1 = rand.nextInt(grandMother.getPersonDirectory().size());
            Person temp1= grandMother.getPersonDirectory().get(index);
            boolean isPatient2=temp1.isPatient();
            if(isPatient2)
            {
                ldlRiskScore = ldlRiskScore+ hereditoryRiskScore;
                cholRiskScore = cholRiskScore+ hereditoryRiskScore;
            }
            ldlRiskScore = Math.round(ldlRiskScore*100D)/100D;
            cholRiskScore = Math.round(cholRiskScore*100D)/100D;
            vsh.setAvgLdlRiskScore(ldlRiskScore);
            vsh.setAvgCholRiskScore(cholRiskScore);
            vsh.sortList();
            person.setMother(temp1);
            grandMother.getPersonDirectory().remove(index1);
            
            mother.addPerson(person);
            personDirectory.addPerson(person);
        }
        House house=null;
        for (int i = 1; i < 151; i++) {
            Person person = new Person();
            
            if(i%10==1)
            {
                house = new House();
                house.setHouseId(houseID++);
                houseDirectory.addHouse(house);
            }
            person.setPersonId(Integer.toString(personID++));
            
            String name = generateString(rand, myCharacters, 3);
            person.setName(name);
            
            int n = randInt(20,40);
            person.setAge(n);
            
            double hereditory1=0.5;
            double hereditory2=0.2;
            double ldlRiskScore=0.0;
            double cholRiskScore=0.0; 
            
            
            int genderSelect = rand.nextInt(gender.length);
            person.setGender(gender[genderSelect]);
            
            VitalSignHistory vsh = initVitalSign(person.getGender(),person.getAge());
            person.setVitalSignHistory(vsh);
            ldlRiskScore = vsh.getAvgLdlRiskScore();
            cholRiskScore = vsh.getAvgCholRiskScore();
            
            int index = rand.nextInt(father.getPersonDirectory().size());
            Person temp= father.getPersonDirectory().get(index);
            boolean isPatient = temp.isPatient();
            if(isPatient)
            {
                ldlRiskScore = ldlRiskScore+ hereditory1;
                cholRiskScore = cholRiskScore+ hereditory1;
            }
            person.setFather(temp);
            father.getPersonDirectory().remove(index);
            
            
            int index1 = rand.nextInt(mother.getPersonDirectory().size());
            Person temp1= mother.getPersonDirectory().get(index);
            boolean isPatient2=temp1.isPatient();
            if(isPatient2)
            {
                ldlRiskScore = ldlRiskScore+ hereditory1;
                cholRiskScore = cholRiskScore+ hereditory1;
            }
            person.setMother(temp1);
            mother.getPersonDirectory().remove(index1);
            child.addPerson(person);
            personDirectory.addPerson(person);
            
            //Adding family members starting from children
            Family family = new Family();
            family.setFamilyId(Integer.toString(familyID++));
            
            //Adding child into the family
            family.getPersonDirectory().addPerson(person);
            
            //Adding child's Parents
            if(!person.getFather().equals(null) &&  !person.getMother().equals(null)){
                family.getPersonDirectory().addPerson(person.getFather());
                family.getPersonDirectory().addPerson(person.getMother());
                
                //Adding Father's Parents
                if(!person.getFather().getFather().equals(null) && !person.getFather().getMother().equals(null)){
                    family.getPersonDirectory().addPerson(person.getFather().getFather());
                    boolean isPatient3 = person.getFather().getFather().isPatient();
                    if(isPatient3)
                    {
                       ldlRiskScore = ldlRiskScore+ hereditory2;
                       cholRiskScore = cholRiskScore+ hereditory2; 
                    }
                    family.getPersonDirectory().addPerson(person.getFather().getMother());
                    boolean isPatient4 = person.getFather().getMother().isPatient();
                    if(isPatient4)
                    {
                       ldlRiskScore = ldlRiskScore+ hereditory2;
                       cholRiskScore = cholRiskScore+ hereditory2; 
                    }
                }
                
                //Adding Mother's Parents
                if(!person.getMother().getFather().equals(null) && !person.getMother().getMother().equals(null)){
                    family.getPersonDirectory().addPerson(person.getMother().getFather());
                    boolean isPatient5 = person.getMother().getFather().isPatient();
                    if(isPatient5)
                    {
                       ldlRiskScore = ldlRiskScore+ hereditory2;
                       cholRiskScore = cholRiskScore+ hereditory2; 
                    }
                    
                    family.getPersonDirectory().addPerson(person.getMother().getMother());
                    boolean isPatient6 = person.getMother().getMother().isPatient();
                    if(isPatient6)
                    {
                       ldlRiskScore = ldlRiskScore+ hereditory2;
                       cholRiskScore = cholRiskScore+ hereditory2; 
                    }
                    
                }
            }
            ldlRiskScore = Math.round(ldlRiskScore*100D)/100D;
            cholRiskScore = Math.round(cholRiskScore*100D)/100D;
            vsh.setAvgLdlRiskScore(ldlRiskScore);
            vsh.setAvgCholRiskScore(cholRiskScore);
            vsh.sortList();
            
           house.add(family);
            
                       
        }
        int count =0;
        HouseDirectory tempDir = new HouseDirectory();
        for(int i =0;i<(houseDirectory.getHousedirectory().size()/2);i++){
            tempDir.addHouse(houseDirectory.getHousedirectory().get(i));
            count++;
        }
        
        HouseDirectory tempDir1 = new HouseDirectory();
        for(int i =count;i<(houseDirectory.getHousedirectory().size());i++){
            tempDir1.addHouse(houseDirectory.getHousedirectory().get(i));
        }
        
        community1.setHouseDirectory(tempDir);
        community2.setHouseDirectory(tempDir1);
        
        communityDirectory.addCommunity(community1);
        communityDirectory.addCommunity(community2);
        
        city.addCommunityDir(communityDirectory);
        city.setCityName("Boston");
        
        
        
        Scanner s = new Scanner(System.in);
        boolean flag=true;
        while(flag)
        {
            System.out.println("Welcome Framingham Heart Study ");
            System.out.println("**********************************************");
            System.out.println("1. City Level Report");
            System.out.println("2. Community Level Report");
            System.out.println("3. House Level Report");
            System.out.println("4. Family Level Report");
            System.out.println("5. Person Report");
            System.out.println("6. Back to User Input Screen");
            System.out.println("Enter the choice:");
            int n = s.nextInt();
            
            switch(n)
            {
                case 1:
                            int pCount=0,maleCount=0,femaleCount=0;
                            
                            System.out.println("City Name :"+city.getCityName());
                          
                            for ( Person p : personDirectory.getPersonDirectory())
                            {
                                if(p.getVitalSignHistory().getAvgLdlRiskScore()>10&&p.getVitalSignHistory().getAvgCholRiskScore()>10)
                                {    pCount++;
                                if(p.getGender().equals("Male"))
                                    maleCount++;
                                else
                                    femaleCount++;
                                }
                            }
                            System.out.println("Number of people having risk of getting heart disease : "+pCount);
                            System.out.println("----------------------------------------------");
                            System.out.println("Displaying details based on Gender");
                            System.out.println("Total number of Males at Risk : "+maleCount);
                            System.out.println("Total number of Females at Risk : "+femaleCount);
                            System.out.println("----------------------------------------------");
                            double percentage = Math.round(((pCount*100d)/(personDirectory.getPersonDirectory().size()*100d))*100D)/100D;
                            System.out.println("Overall risk  percentage of people at city Level :"+percentage*100 +"%");
                            System.out.println("----------------------------------------------");
                break;
                case 2:            
                    for(Community community: communityDirectory.getCommunityDirectory()){
                        System.out.println("Community Name : "+community.getCommunityName());
                        double avgldlRiskCommunity=0,avgcholRiskCommunity=0;
                        int personCommunityCount=0;
                       HouseDirectory hd =community.getHouseDirectory();
                       for(House communityHouse :hd.getHousedirectory() ){
                           for(Family family :communityHouse.getFamily()){
                               for(Person communityPerson : family.getPersonDirectory().getPersonDirectory())
                               {
                                   personCommunityCount++;
                                   avgldlRiskCommunity = avgldlRiskCommunity +communityPerson.getVitalSignHistory().getAvgLdlRiskScore();
                                   avgcholRiskCommunity = avgcholRiskCommunity +communityPerson.getVitalSignHistory().getAvgCholRiskScore();
                                   
                               }
                           }
                       }
                       avgldlRiskCommunity =Math.round((avgldlRiskCommunity/personCommunityCount)*100D)/100D;
                       avgcholRiskCommunity = Math.round((avgcholRiskCommunity/personCommunityCount)*100D)/100D;
                       System.out.println("Average Ldl risk before change in pollution level :" +avgldlRiskCommunity);
                       System.out.println("Average Cholestrol risk before change in pollution level :" +avgcholRiskCommunity);
                       System.out.println("_________________________________________");
                       System.out.println("Enter the new pollution level (1-3...increasing order)");
                        int input =s.nextInt();
                        if(input<4 && input>0){
                            avgldlRiskCommunity = avgldlRiskCommunity + (input*1.5);
                            avgcholRiskCommunity = avgcholRiskCommunity+(input*1.5);
                            community.setPollutionLevel(input);
                            System.out.println("Average Ldl risk After change in pollution level :" +avgldlRiskCommunity);
                       System.out.println("Average Cholestrol risk After change in pollution level :" +avgcholRiskCommunity);
                        System.out.println("_________________________________________");
                        }
                        else
                            System.out.println("Value is incorrect !");
                    }
                        for(Community comm: communityDirectory.getCommunityDirectory()){
                        System.out.println("Community Name : "+comm.getCommunityName());
                        double averageNumber=0;
                        int personAgeGroupCount=0,personAgeGroupRisk=0;
                       HouseDirectory houseDir =comm.getHouseDirectory();
                       for(House communityHouse :houseDir.getHousedirectory() ){
                           for(Family family :communityHouse.getFamily()){
                               for(Person communityPerson : family.getPersonDirectory().getPersonDirectory())
                               {
                                   if(communityPerson.getAge()>40 && communityPerson.getAge()<80){
                                       personAgeGroupCount++;
                                   if(communityPerson.getVitalSignHistory().getAvgLdlRiskScore()>10 && communityPerson.getVitalSignHistory().getAvgCholRiskScore()>10)
                                       personAgeGroupRisk++;
                                   
                               }
                           }
                       }
                        }
                            System.out.println("___________________________________________");
                            System.out.println("Number of people at age group (41-79) : "+personAgeGroupCount);
                            System.out.println("Number of people at Risk for age group (41-79) : "+personAgeGroupRisk);
                            System.out.println("___________________________________________");
                           }
                       
                    break;
                    
                case 3:
                    
                    for(Community comm: communityDirectory.getCommunityDirectory()){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Community Name : "+comm.getCommunityName());
                        double avgldlRiskHouse=0,avgcholRiskHouse=0;
                        int personAgeGroupCount=0,personAgeGroupRisk=0;
                        
                       HouseDirectory houseDir =comm.getHouseDirectory();
                       for(House communityHouse :houseDir.getHousedirectory() ){
                           System.out.println("House ID : "+communityHouse.getHouseId());
                           int smokerCount=0,diabetesCount=0; 
                           for(Family family :communityHouse.getFamily()){
                               
                               avgldlRiskHouse = avgldlRiskHouse + family.getAvgLdlRiskScore();
                               avgcholRiskHouse = avgcholRiskHouse + family.getAvgCholRiskScore();
                               for(Person p :family.getPersonDirectory().getPersonDirectory()) 
                                {
                                if(p.getVitalSignHistory().getVitalSignHistory().get(4).isSmoker())
                                    smokerCount++;
                                
                                 if(p.getVitalSignHistory().getVitalSignHistory().get(4).isDiabetes())
                                    diabetesCount++;
                                }
                               
                              }
                           avgldlRiskHouse =avgldlRiskHouse/communityHouse.getFamily().size();
                           avgcholRiskHouse = avgcholRiskHouse/communityHouse.getFamily().size();
                           System.out.println("Number of Families in house "+communityHouse.getHouseId()+ " : "+communityHouse.getFamily().size());
                           System.out.println("");
                           System.out.println("Average LDL Risk score of all the members in the house :"+Math.round(avgldlRiskHouse)*100D/100D);
                           System.out.println("Average Cholestrol Risk score of all the members in the house :"+Math.round(avgcholRiskHouse)*100D/100D);
                           System.out.println("Number of Smokers in House :" +communityHouse.getHouseId()+" : "+smokerCount); 
                           System.out.println("Number of people having Diabetes in House :" +communityHouse.getHouseId()+" : "+diabetesCount); 
                           System.out.println("");
                           
         
                       }
                        }
                 
                 
            break;
            
                case 4:
                    
                     System.out.println("Enter Family ID to display their details: ");
                               String familyNumber = s.next();
                     for(Community comm: communityDirectory.getCommunityDirectory()){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Community Name : "+comm.getCommunityName());
                        double avgldlRiskHouse=0,avgcholRiskHouse=0;
                        int personAgeGroupCount=0,personAgeGroupRisk=0;
                        
                       HouseDirectory houseDir =comm.getHouseDirectory();
                      
                       for(House communityHouse :houseDir.getHousedirectory() ){
                           int smokerCount=0,diabetesCount=0;
                           
                               Person personTemp=new Person();
                           for(Family family :communityHouse.getFamily()){
                               if(family.getFamilyId().equals(familyNumber)){
                                   System.out.println("_________________________________________________");
                                   System.out.println("Family ID :"+family.getFamilyId());
                                   System.out.println("");
                                   System.out.println("Average Cholestrol Score :"+family.getAvgCholRiskScore());
                                   System.out.println("Average LDL Score :"+family.getAvgLdlRiskScore());
                                   for(Person person : family.getPersonDirectory().getPersonDirectory())
                                   {
                                       int num=0;
                                       if(num==0){
                                       personTemp = person;
                                       num++;
                                       }
                                       else{
                                           if(person.getVitalSignHistory().getAvgCholRiskScore()<personTemp.getVitalSignHistory().getAvgCholRiskScore())
                                               personTemp=person;
                                       }
                                      
                                       System.out.println("Person Name :'"+person.getName()+"'     "+"Age :"+person.getAge());
                                       System.out.println("LDL Risk Score :"+person.getVitalSignHistory().getAvgLdlRiskScore()+"    "+"Cholestrol Risk Score :"+person.getVitalSignHistory().getAvgCholRiskScore());
                                       
                                   }
                                   System.out.println("_________________________________________________");
                                   System.out.println("Person having lowest Cholestrol level in this family is '"+personTemp.getName()+"' having Cholestrol Risk Score as "+personTemp.getVitalSignHistory().getAvgCholRiskScore());
                               }
                               else{
                                   System.out.println("Sorry... we don't have that many families!!");
                               }
                               
                              }
                     
                       }
                        }
                 
                     
                    
                    break;
                    
                case 5:
                    System.out.println("_________________________________________________");
                    System.out.println("Enter Person ID to view the details :");
                    String personID=s.next();
                    for(Person personDetail : personDirectory.getPersonDirectory()){
                        
                        if(personDetail.getPersonId().equals(personID)){
                         
                            System.out.println("Person Details :");
                            System.out.println("Person ID :"+personDetail.getPersonId());
                            System.out.println("Name :"+personDetail.getName());
                            System.out.println("Gender :"+personDetail.getGender());
                            System.out.println("Age :"+personDetail.getAge());
                             System.out.println("Average LDL Risk Score :"+personDetail.getVitalSignHistory().getAvgLdlRiskScore());
                            System.out.println("Average Cholestrol Risk Score :"+personDetail.getVitalSignHistory().getAvgCholRiskScore());
                            System.out.println(personDetail.getName()+"'s Vital History Details:");
                            System.out.println("Date                        BloodPressure       Total Chol        HDL Chol      Smoker      Diabetes        Chol Risk        LDL Risk");
                            for(VitalSign vitalSign : personDetail.getVitalSignHistory().getVitalSignHistory()){
                                System.out.println(vitalSign.getCreatedOn()+"       "+vitalSign.getBloodPressure()+"                    "+vitalSign.getTotalCholestrol()+"              "+vitalSign.getHdlCholestrol()+"        "+vitalSign.isSmoker()+"          "+vitalSign.isDiabetes()+"             "+vitalSign.getCholRiskScore()+"           "+vitalSign.getLdlRiskScore());
                            }
                            System.out.println("");
                           
                            System.out.println("______________________________________________________________");
             
                            
                            
             if(personDetail.getGender().equals("Male")){
             NavigableMap<Integer,Integer> compareMale =new TreeMap<Integer, Integer>();
            compareMale.put(1,3);
            compareMale.put(30,3);
            compareMale.put(35,5);
            compareMale.put(40,7);
            compareMale.put(45,11);
            compareMale.put(50,14);
            compareMale.put(55,16);
            compareMale.put(60,21);
            compareMale.put(65,25);
            compareMale.put(70,30);
            
            int avgAge=compareMale.get(compareMale.floorKey(personDetail.getAge()));
            
            CalculateMen calculateMen=new CalculateMen();
            int ldlPercent=calculateMen.ldlRiskPercentage(personDetail.getVitalSignHistory().getVitalSignHistory().get(4));
            int cholPercent=calculateMen.cholRiskPercentage(personDetail.getVitalSignHistory().getVitalSignHistory().get(4));
            System.out.println("Average percent this age group is :"+avgAge);
            System.out.println("LDL percent for person is :"+ldlPercent);
            
            
         }else if(gender.equals("Female")){
             NavigableMap<Integer,Integer> compareFemale =new TreeMap<Integer, Integer>();
            compareFemale.put(1,1);
            compareFemale.put(30,1);
            compareFemale.put(35,1);
            compareFemale.put(40,2);
            compareFemale.put(45,5);
            compareFemale.put(50,8);
            compareFemale.put(55,12);
            compareFemale.put(60,12);
            compareFemale.put(65,13);
            compareFemale.put(70,14);
            
            int avgAge=compareFemale.get(compareFemale.floorKey(personDetail.getAge()));
            
            CalculateWomen calculateWomen=new CalculateWomen();
            int ldlPercent=calculateWomen.ldlRiskPercentage(personDetail.getVitalSignHistory().getVitalSignHistory().get(4));
            int cholPercent=calculateWomen.cholRiskPercentage(personDetail.getVitalSignHistory().getVitalSignHistory().get(4));
             System.out.println("Average percent this age group is :"+avgAge);
            System.out.println("LDL percent for person is :"+ldlPercent);
            
         }
                            
       }
                        System.out.println("");
                       
     }
                    
                    break;
                    
                case 6:
                    flag = false;
                    
                default:
                    System.out.println("Enter valid choice!");
            }
            
            
                    
  
        }
    
        return personDirectory;
  //  }

    
    
    }
    
    public  VitalSignHistory initVitalSign(String gender,int age){
        
        Random random = new Random();
        VitalSignHistory vsh = new VitalSignHistory();
        double avgLdlRiskScore=0.0;
        double avgCholRiskScore=0.0;
        
        for(int i=0;i<5;i++){
        VitalSign vitalSign = new VitalSign();
        //A systolic blood pressure of 120 to 139 means you have prehypertension, or borderline high blood pressure. 
        //Even people with prehypertension are at a higher risk of developing heart disease. 
        //A systolic blood pressure number of 140 or higher is considered to be hypertension, or high blood pressure.
        //
        vitalSign.setBloodPressure(randInt(110, 165));
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
        vitalSign.setCreatedOn(rand);
        
        boolean selectDiabetes = random.nextBoolean();
        vitalSign.setDiabetes(selectDiabetes);
        //HDL cholesterol levels greater than 60 milligrams per deciliter (mg/dL) are high. ... 
        //HDL cholesterol levels less than 40 mg/dL are low. 
        //That's not so good. In general, people with high HDL are at lower risk for heart disease.
        //  
        int hdlCholestrol = randInt(35, 65);
        vitalSign.setHdlCholestrol(hdlCholestrol);
        
        boolean selectSmoker = random.nextBoolean();
        vitalSign.setSmoker(selectSmoker);
        
        //Less than 200mg/dL	Desirable
        //200-239 mg/dL	Borderline high
        //240mg/dL and above	High
        
        int totalCholestrol = randInt(195,245);
        vitalSign.setTotalCholestrol(totalCholestrol);
        
        if(gender.equalsIgnoreCase("Male")){
            CalculateMen calculateMen = new CalculateMen();
            vitalSign = calculateMen.calculateRiskScore(vitalSign,age);
           // vitalSign.setRiskScore(riskScore);
        }
        if(gender.equalsIgnoreCase("Female"))
        {
            CalculateWomen calculateWomen = new CalculateWomen();
            vitalSign = calculateWomen.calculateRiskScore(vitalSign,age);
        //    vitalSign.setRiskScore(riskScore);
        }
        vsh.addVitalSign(vitalSign);
        avgLdlRiskScore = avgLdlRiskScore + vitalSign.getLdlRiskScore();
        avgCholRiskScore = avgCholRiskScore + vitalSign.getCholRiskScore();
        }
        avgLdlRiskScore=avgLdlRiskScore/5;
        avgCholRiskScore=avgCholRiskScore/5;
        vsh.setAvgLdlRiskScore(avgLdlRiskScore);
        vsh.setAvgCholRiskScore(avgCholRiskScore);
        return vsh;
    }
}
