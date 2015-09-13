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
@Table(name = "currencies")
@NamedQueries({
    @NamedQuery(name = "findCurrencyByActive", query = "FROM CurrencyModel WHERE active = :active"),
    @NamedQuery(name = "findCurrencyByDefault", query = "FROM CurrencyModel WHERE byDefault = :byDefault"),
    @NamedQuery(name = "findCurrencyByLangCode", query = "FROM CurrencyModel WHERE langCode = :langCode"),
    @NamedQuery(name = "findCurrencyByIsoCode", query = "FROM CurrencyModel WHERE isoCode = :isoCode"),
    @NamedQuery(name = "findCurrencyByIsoCodeAndLangCode", 
                        query = "FROM CurrencyModel WHERE isoCode = :isoCode AND langCode = :langCode")
})
public class CurrencyModel extends AuditLangCodeModel{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "code", length = 5, nullable = false)
    private String isoCode;
    
    @Column(name = "symbol", length = 3)
    private String symbol;
    
    @Column(name = "digits")
    private int digits = 2;
    
    @Column(name = "name", length = 100)
    private String name;
    
    @Column(name = "active")
    private boolean active = Boolean.TRUE;

    @Column(name = "by_default")
    private boolean byDefault = Boolean.TRUE;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public int getDigits() {
        return digits;
    }
    
    public void setDigits(int digits) {
        this.digits = digits;
    }

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

    public boolean isByDefault() {
        return byDefault;
    }

    public void setByDefault(boolean byDefault) {
        this.byDefault = byDefault;
    }
    
}
