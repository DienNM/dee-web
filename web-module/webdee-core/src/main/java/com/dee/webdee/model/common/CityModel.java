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
@Table(name = "city")
@NamedQueries({
    @NamedQuery(name = "findCityByCode", query = "FROM CityModel WHERE code = :code"),
    @NamedQuery(name = "findCityByCodeAndLangCode", 
                           query = "FROM CityModel WHERE code = :code AND langCode = :langCode"),
    @NamedQuery(name = "findCityByCountryIdAndLangCode", 
                            query = "FROM CityModel WHERE countryId = :countryId AND langCode = :langCode")

})
public class CityModel extends AuditLangCodeModel{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "code", length = 100, nullable = false)
    private String code;
    
    @Column(name = "country_id")
    private long countryId;
    
    @Column(name = "name", length = 100 , nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }
    
}
