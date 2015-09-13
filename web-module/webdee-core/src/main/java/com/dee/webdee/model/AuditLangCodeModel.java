package com.dee.webdee.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author dien.nguyen
 */

@MappedSuperclass
public class AuditLangCodeModel extends AuditModel {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "lang_code")
    private String langCode;
    
    public String getLangCode() {
        return langCode;
    }
    
    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
    
}
