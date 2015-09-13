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
@Table(name = "district")
@NamedQueries({
    @NamedQuery(name = "findDistrictByCode", query = "FROM DistrictModel WHERE code = :code"),
    @NamedQuery(name = "findDistrictByCodeAndLangCode", 
                           query = "FROM DistrictModel WHERE code = :code AND langCode = :langCode"),
    @NamedQuery(name = "findDistrictByCityIdAndLangCode", 
                            query = "FROM DistrictModel WHERE cityId = :cityId AND langCode = :langCode")

})
public class DistrictModel extends AuditLangCodeModel{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "code", length = 100, nullable= false)
    private String code;
    
    @Column(name = "name", length = 100)
    private String name;
    
    @Column(name = "city_id")
    private long cityId;

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

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
