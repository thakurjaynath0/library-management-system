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
public class EncapIssue {
    private int stid;
    private String name;
    private String address;
    private String faculty;
    private String gender;
    private String phone;
    private String bookid;
    private String bookname;
    private String issuedate;
    private String returndate;
    private String status;

    public EncapIssue(int stid, String name, String address, String faculty, String gender, String phone, String bookid, String bookname, String issuedate, String returndate, String status) {
        this.stid = stid;
        this.name = name;
        this.address = address;
        this.faculty = faculty;
        this.gender = gender;
        this.phone = phone;
        this.bookid = bookid;
        this.bookname = bookname;
        this.issuedate = issuedate;
        this.returndate = returndate;
        this.status = status;
    }

    /**
     * @return the stid
     */
    public int getStid() {
        return stid;
    }

    /**
     * @param stid the stid to set
     */
    public void setStid(int stid) {
        this.stid = stid;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the bookid
     */
    public String getBookid() {
        return bookid;
    }

    /**
     * @param bookid the bookid to set
     */
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    /**
     * @return the bookname
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * @param bookname the bookname to set
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * @return the issuedate
     */
    public String getIssuedate() {
        return issuedate;
    }

    /**
     * @param issuedate the issuedate to set
     */
    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    /**
     * @return the returndate
     */
    public String getReturndate() {
        return returndate;
    }

    /**
     * @param returndate the returndate to set
     */
    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
