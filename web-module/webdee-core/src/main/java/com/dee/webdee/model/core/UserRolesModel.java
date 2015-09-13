package com.dee.webdee.model.core;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.dee.webdee.enumeration.core.RoleAppliedType;
import com.dee.webdee.model.id.LLCompositeKey;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "user_roles")
public class UserRolesModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides(value = {
            @AttributeOverride(name = "user_id", column = @Column(name = "id1")),
            @AttributeOverride(name = "role_id", column = @Column(name = "id2"))
    })
    private LLCompositeKey id;
    
    @Column(name = "applied_type")
    @Enumerated(EnumType.STRING)
    private RoleAppliedType appliedType = RoleAppliedType.Included;
    
    public LLCompositeKey getId() {
        return id;
    }
    
    public void setId(LLCompositeKey id) {
        this.id = id;
    }

    public RoleAppliedType getAppliedType() {
        return appliedType;
    }

    public void setAppliedType(RoleAppliedType appliedType) {
        this.appliedType = appliedType;
    }
    
}
