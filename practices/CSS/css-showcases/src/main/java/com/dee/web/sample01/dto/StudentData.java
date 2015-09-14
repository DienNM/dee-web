package com.dee.web.sample01.dto;

import java.io.Serializable;
import java.util.Date;

import com.dee.web.sample01.enumeration.Gender;

/**
 * @author dien.nguyen
 **/

public class StudentData implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String id;
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    private String fullName;
    
    private Date dateOfBirth;
    
    private Gender gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
    
}
