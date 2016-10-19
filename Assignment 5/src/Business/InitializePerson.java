/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Timestamp;
import java.util.Random;

/**
 *
 * @author vinay
 */
public class InitializePerson {
    
    private static int personID = 1;
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
        PersonDirectory Father = new PersonDirectory();
        PersonDirectory Mother = new PersonDirectory();
        PersonDirectory child = new PersonDirectory();
        Random rand = new Random();

        //There are two ways presented in here for random string generation you can use whatever you feel is right.
        String myCharacters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        //Insert your user freindly names here
        String[] gender = {"Male","Female"};

        for (int i = 0; i < 300; i++) {
            Person person = grandFather.addPerson();
            person.setPersonId(Integer.toString(personID++));
            String name = generateString(rand, myCharacters, 4);
            person.setName(name);
            int n = randInt(80,100);
            person.setAge(n);
            n = randInt(40,100);
            person.setGender("Male");
            VitalSignHistory vsh = initVitalSign(person.getGender(),person.getAge());
            person.setVitalSignHistory(vsh);

        }
        
        for (int i = 0; i < 300; i++) {
            Person person = grandMother.addPerson();
            person.setPersonId(Integer.toString(personID++));
            //String name = generateString(rand, myCharacters, 4);
            //You can use this as well for user freindly names
            String name = generateString(rand, myCharacters, 3);
            person.setName(name);
            int n = randInt(80,100);
            person.setAge(n);
            n = randInt(40,100);
            person.setGender("Female");

        }
        
        for (int i = 0; i < 150; i++) {
            Person person = Father.addPerson();
            person.setPersonId(Integer.toString(personID++));
            String name = generateString(rand, myCharacters, 4);
            person.setName(name);
            int n = randInt(40,70);
            person.setAge(n);
            n = randInt(40,100);
            person.setGender("Male");
        
            int index = rand.nextInt(grandFather.getPersonDirectory().size());
            Person temp= grandFather.getPersonDirectory().get(index);
            person.setFather(temp);
            grandFather.getPersonDirectory().remove(index);
            
            int index1 = rand.nextInt(grandMother.getPersonDirectory().size());
            Person temp1= grandMother.getPersonDirectory().get(index);
            person.setMother(temp1);
            grandMother.getPersonDirectory().remove(index1);
        }
        
        for (int i = 0; i < 150; i++) {
            Person person = Mother.addPerson();
            person.setPersonId(Integer.toString(personID++));
            String name = generateString(rand, myCharacters, 4);
            person.setName(name);
            int n = randInt(40,70);
            person.setAge(n);
            n = randInt(40,100);
            person.setGender("Female");
            
            int index = rand.nextInt(grandFather.getPersonDirectory().size());
            Person temp= grandFather.getPersonDirectory().get(index);
            person.setFather(temp);
            grandFather.getPersonDirectory().remove(index);
            
            int index1 = rand.nextInt(grandMother.getPersonDirectory().size());
            Person temp1= grandMother.getPersonDirectory().get(index);
            person.setMother(temp1);
            grandMother.getPersonDirectory().remove(index1);
        }
        
        for (int i = 0; i < 150; i++) {
            Person person = child.addPerson();
            
            person.setPersonId(Integer.toString(personID++));
            
            String name = generateString(rand, myCharacters, 3);
            person.setName(name);
            
            int n = randInt(20,40);
            person.setAge(n);
            
            n = randInt(40,100);
            
            
            int genderSelect = rand.nextInt(gender.length);
            person.setGender(gender[genderSelect]);
            
            int index = rand.nextInt(Father.getPersonDirectory().size());
            Person temp= Father.getPersonDirectory().get(index);
            person.setFather(temp);
            Father.getPersonDirectory().remove(index);
            
            
            int index1 = rand.nextInt(Mother.getPersonDirectory().size());
            Person temp1= Mother.getPersonDirectory().get(index);
            person.setMother(temp1);
            Mother.getPersonDirectory().remove(index1);
        }
        try{
        Person temp = child.getPersonDirectory().get(0);
        System.out.println("Child Name "+temp.getName());
        System.out.println("Father Name "+temp.getFather().getName());
        System.out.println("Mother Name "+temp.getMother().getName());

        System.out.println("Child Gender 1: "+temp.getGender());
        System.out.println("Child Gender 2: "+child.getPersonDirectory().get(1).getGender());
        
        }
        catch(Exception e){
            
        }
        return personDirectory;

    }
    
    public static VitalSignHistory initVitalSign(String gender,int age){
        
        Random random = new Random();
        VitalSignHistory vsh = new VitalSignHistory();
        
        
        for(int i=0;i<5;i++){
        VitalSign vitalSign = vsh.addVitalSign();
        //A systolic blood pressure of 120 to 139 means you have prehypertension, or borderline high blood pressure. 
        //Even people with prehypertension are at a higher risk of developing heart disease. 
        //A systolic blood pressure number of 140 or higher is considered to be hypertension, or high blood pressure.
        //
        vitalSign.setBloodPressure(randInt(110, 150));
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
        vitalSign.setCreatedOn(rand);
        
        int selectDiabetes = random.nextInt(2);
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
            int riskScore = calculateMen.calculateRiskScore(vitalSign,age);
            vitalSign.setRiskScore(riskScore);
        }
        else
        {
            CalculateWomen calculateWomen = new CalculateWomen();
            int riskScore = calculateWomen.calculateRiskScore(vitalSign,age);
            vitalSign.setRiskScore(riskScore);
        }
        
        }
        return vsh;
    }
}
