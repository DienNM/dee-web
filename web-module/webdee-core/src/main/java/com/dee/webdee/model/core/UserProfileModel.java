package com.dee.webdee.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "user_profile")
public class UserProfileModel {
    
    @Id
    @Column(name = "user_id")
    private long id;
    
    // Reference to LanguageModel
    @Column(name = "language_code")
    private String languageCode;
    
    @Column(name = "currency_code")
    private String currencyCode;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
