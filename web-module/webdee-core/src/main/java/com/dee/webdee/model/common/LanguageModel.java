package com.dee.webdee.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "language")
@NamedQueries(value = {
        @NamedQuery(name = "findLanguageByActive", query = "FROM LanguageModel where active = :active"),
        @NamedQuery(name = "findLanguageByDefault", query = "FROM LanguageModel where byDefault = :byDefault")
})
public class LanguageModel {
    
    @Id
    @Column(name = "code", length = 10)
    private String code;
    
    @Column(name = "country_code", length = 3, nullable = false)
    private String countryCode;
    
    @Column(name = "lang_code", length = 3, nullable = false)
    private String langCode;
    
    @Column(name = "is_active")
    private boolean active = Boolean.TRUE;
    
    @Column(name = "is_default")
    private boolean byDefault;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isByDefault() {
        return byDefault;
    }

    public void setByDefault(boolean byDefault) {
        this.byDefault = byDefault;
    }
    
}
