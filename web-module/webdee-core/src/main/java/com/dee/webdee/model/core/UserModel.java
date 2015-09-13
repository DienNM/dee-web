package com.dee.webdee.model.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "user")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    
    @Column(name = "password", length = 64, nullable = false)
    private String password;
    
    @Column(name = "encrypted_password")
    private boolean encryptedPassword = Boolean.TRUE;
    
    @Column(name = "last_time_changed_password")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTimeChangedPassword;
    
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    
    @Column(name = "last_name", length = 50)
    private String lastName;
    
    @Column(name = "number_times_loggin_failed")
    private int timesLogginFailed = 0;
    
    @Column(name = "last_time_loggin_failed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTimeLogginFailed;
    
    @Column(name = "created_by")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    private String createdBy;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(boolean encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Date getLastTimeChangedPassword() {
        return lastTimeChangedPassword;
    }

    public void setLastTimeChangedPassword(Date lastTimeChangedPassword) {
        this.lastTimeChangedPassword = lastTimeChangedPassword;
    }

    public Date getLastTimeLogginFailed() {
        return lastTimeLogginFailed;
    }

    public void setLastTimeLogginFailed(Date lastTimeLogginFailed) {
        this.lastTimeLogginFailed = lastTimeLogginFailed;
    }

    public int getTimesLogginFailed() {
        return timesLogginFailed;
    }

    public void setTimesLogginFailed(int timesLogginFailed) {
        this.timesLogginFailed = timesLogginFailed;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
}
