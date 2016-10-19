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
   

    public Family()
    {
        this.personDirectory = new PersonDirectory();
        
    }
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

    public Person addPerson(Person person) {
        personDirectory.addPerson(person);
        return person;
    }
}
