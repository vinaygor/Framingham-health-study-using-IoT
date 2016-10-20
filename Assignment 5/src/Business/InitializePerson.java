/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.prism.impl.BaseMesh;
import java.sql.Timestamp;
import java.util.Random;

/**
 *
 * @author vinay
 */
public class InitializePerson {
    
    private static int personID = 1;
    private static int familyID = 1;
    private static int houseID = 1;
    
    
    
    public static long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
    public static long end = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
    
    
    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    public static PersonDirectory initPersonDirectory() {
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
        
        FamilyDirectory familyDirectory = new FamilyDirectory();
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
            person.setMother(temp1);
            grandMother.getPersonDirectory().remove(index1);
            
            mother.addPerson(person);
            personDirectory.addPerson(person);
        }
        
        for (int i = 0; i < 150; i++) {
            Person person = new Person();
            House house = new House();
            
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
            
            familyDirectory.addfamily(family);
            house.setFamilyDirectory(familyDirectory);
            house.setHouseId(houseID++);
            houseDirectory.addHouse(house);
                       
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
        
        try{
            
            System.out.println("City Name :"+city.getCityName());
            
            for(CommunityDirectory community: city.getCommunityList()){
                System.out.println("City Community "+community.getCommunityDirectory().size());
                
            }                
            
            
            System.out.println("Person Directory size :"+personDirectory.getPersonDirectory().size()); 
            
         for(Family f : familyDirectory.getFamilyDirectory()){
             System.out.println("");
            System.out.println("Family Name "+f.getFamilyId());
            System.out.println("Family Members count "+f.getPersonDirectory().getPersonDirectory().size());
            System.out.println("Child's Person ID "+f.getPersonDirectory().getPersonDirectory().get(0).getPersonId());
            System.out.println("Child Name : "+ f.getPersonDirectory().getPersonDirectory().get(0).getName());
            System.out.println("Child's Father Name : "+ f.getPersonDirectory().getPersonDirectory().get(1).getName());
            System.out.println("Child's Mother Name : "+ f.getPersonDirectory().getPersonDirectory().get(2).getName());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Child's Vital Details");
            System.out.println("*************************************");
             System.out.println();
             System.out.println("Gender :"+f.getPersonDirectory().getPersonDirectory().get(0).getGender());
             System.out.println("Child's Age :"+f.getPersonDirectory().getPersonDirectory().get(0).getAge());
             System.out.println("Diabetes :"+f.getPersonDirectory().getPersonDirectory().get(0).getVitalSignHistory().getVitalSignHistory().get(0).isDiabetes());
             System.out.println("Smoker :"+f.getPersonDirectory().getPersonDirectory().get(0).getVitalSignHistory().getVitalSignHistory().get(0).isSmoker());
             System.out.println("Blood Pressure :"+f.getPersonDirectory().getPersonDirectory().get(0).getVitalSignHistory().getVitalSignHistory().get(0).getBloodPressure());
             System.out.println("HDL colestrol :"+f.getPersonDirectory().getPersonDirectory().get(0).getVitalSignHistory().getVitalSignHistory().get(0).getHdlCholestrol());
             System.out.println("Total Cholestrol :"+f.getPersonDirectory().getPersonDirectory().get(0).getVitalSignHistory().getVitalSignHistory().get(0).getTotalCholestrol());
             System.out.println("");
             System.out.println("Average Cholestrol Risk Score :"+f.getPersonDirectory().getPersonDirectory().get(0).getVitalSignHistory().getAvgCholRiskScore());
             System.out.println("Average LDL Risk Score :"+f.getPersonDirectory().getPersonDirectory().get(0).getVitalSignHistory().getAvgLdlRiskScore());
             System.out.println("______________________________________________________");
         }
         
         
//        
//        Person temp = child.getPersonDirectory().get(0);
//        System.out.println("Child Name "+temp.getName());
//        System.out.println("Father Name "+temp.getFather().getName());
//        System.out.println("Mother Name "+temp.getMother().getName());
//
//        System.out.println("Child Gender 1: "+temp.getGender());
//        System.out.println("Child Gender 2: "+child.getPersonDirectory().get(1).getGender());
//        
        }
        catch(Exception e){
            
        }
        return personDirectory;

    }
    
    public static VitalSignHistory initVitalSign(String gender,int age){
        
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
