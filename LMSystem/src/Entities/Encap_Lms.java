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
public class Encap_Lms {
    private String id;
    private String name;
    private String authour;
    private String faculty;
    private String description;
    private int total;

    public Encap_Lms(String id, int total) {
        this.id = id;
        this.total = total;
    }
   

    public Encap_Lms(String id, String name, String authour, String faculty,String description, int total) {
        this.id = id;
        this.name = name;
        this.authour = authour;
        this.faculty = faculty;
        this.description = description;
        this.total=total;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the authour
     */
    public String getAuthour() {
        return authour;
    }

    /**
     * @param authour the authour to set
     */
    public void setAuthour(String authour) {
        this.authour = authour;
    }
    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    
}
