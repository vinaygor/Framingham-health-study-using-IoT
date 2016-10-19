/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Rishabh
 */
public class Person {
    private String personId;
    private String name;
    private int age;
    private String Gender;
    private String Level;
    private boolean patient;
    private boolean legalIssues;
    private boolean financialIssues;
    private VitalSignHistory vitalSignHistory;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public boolean isPatient() {
        return patient;
    }

    public void setPatient(boolean patient) {
        this.patient = patient;
    }

    public boolean isLegalIssues() {
        return legalIssues;
    }

    public void setLegalIssues(boolean legalIssues) {
        this.legalIssues = legalIssues;
    }

    public boolean isFinancialIssues() {
        return financialIssues;
    }

    public void setFinancialIssues(boolean financialIssues) {
        this.financialIssues = financialIssues;
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    
}
