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
public class Family {
    private PersonDirectory personDirectory;
    private String familyId;
    private boolean legalIssues;
    private boolean financialIssues;
    private boolean geneticIssue;

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
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

    public boolean isGeneticIssue() {
        return geneticIssue;
    }

    public void setGeneticIssue(boolean geneticIssue) {
        this.geneticIssue = geneticIssue;
    }

    
}
