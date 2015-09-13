package com.dee.webdee.model.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dee.webdee.enumeration.core.Gender;
import com.dee.webdee.enumeration.core.MariageStatus;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "user_detail")
public class UserDetailModel {
    
    @Id
    @Column(name = "user_id")
    private long id;
    
    @Column(name = "avatar_main")
    private long avatarMain;
    
    @Column(name = "avatar_icon")
    private long avatarIcon;
    
    @Column(name = "brithday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.None;
    
    @Column(name = "mariage_status")
    @Enumerated(EnumType.STRING)
    private MariageStatus mariageStatus = MariageStatus.None;

    public long getAvatarMain() {
        return avatarMain;
    }

    public void setAvatarMain(long avatarMain) {
        this.avatarMain = avatarMain;
    }

    public long getAvatarIcon() {
        return avatarIcon;
    }

    public void setAvatarIcon(long avatarIcon) {
        this.avatarIcon = avatarIcon;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MariageStatus getMariageStatus() {
        return mariageStatus;
    }

    public void setMariageStatus(MariageStatus mariageStatus) {
        this.mariageStatus = mariageStatus;
    }
    
}
