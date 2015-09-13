package com.dee.webdee.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.dee.webdee.model.AuditLangCodeModel;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "findCountryByActive", query = "FROM CountryModel WHERE active = :active"),
    @NamedQuery(name = "findCountryByLangCode", query = "FROM CountryModel WHERE langCode = :langCode"),
    @NamedQuery(name = "findCountryByIsoCode", query = "FROM CountryModel WHERE isoCode = :isoCode"),
    @NamedQuery(name = "findCountryByIsoCodeAndLangCode", 
                          query = "FROM CountryModel WHERE isoCode = :isoCode AND langCode = :langCode")
})
public class CountryModel extends AuditLangCodeModel {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "iso_code", length = 2, nullable = false)
    private String isoCode;
    
    @Column(name = "name", length = 100)
    private String name;
    
    private boolean active = Boolean.TRUE;

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
