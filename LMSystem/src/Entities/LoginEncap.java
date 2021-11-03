/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Jay
 */
public class LoginEncap {
    private int Id;
    private String Name;
    private String Address;
    private String Phone;
    private String Email;
    private String Username;
    private String Password;
    private String Gender;
    private String Faculty;

    public LoginEncap(int Id, String Username, String Password) {
        this.Id = Id;
        this.Username = Username;
        this.Password = Password;
    }

    public LoginEncap(int Id, String Name, String Address, String Phone, String Email, String Username, String Password, String Gender, String Faculty) {
        this.Id = Id;
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Gender = Gender;
        this.Faculty = Faculty;
    }
    
    

    public LoginEncap(int Id, String Name, String Address, String Phone, String Email, String Gender, String Faculty) {
        this.Id = Id;
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
        this.Gender = Gender;
        this.Faculty = Faculty;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Faculty
     */
    public String getFaculty() {
        return Faculty;
    }

    /**
     * @param Faculty the Faculty to set
     */
    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }
    
    

   
    
}
