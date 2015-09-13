package com.dee.webdee.model.core;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.dee.webdee.model.AuditLangCodeModel;
import com.dee.webdee.model.id.SSCompositeKey;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "role_lang")
@NamedQueries({
    @NamedQuery(name = "findRoleByRoleCode", query = "FROM RoleLangModel WHERE id.id1 = :roleCode"),
    @NamedQuery(name = "findRoleByLangCode", query = "FROM RoleLangModel WHERE id.id2 = :langCode")
})
public class RoleLangModel extends AuditLangCodeModel{
    
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides(value = {
            @AttributeOverride(name = "role_code", column = @Column(name = "id1")),
            @AttributeOverride(name = "lang_code", column = @Column(name = "id2"))
    })
    private SSCompositeKey id;
    
    @Column(name = "name", length = 100)
    private String name;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public SSCompositeKey getId() {
        return id;
    }

    public void setId(SSCompositeKey id) {
        this.id = id;
    }
    
}
