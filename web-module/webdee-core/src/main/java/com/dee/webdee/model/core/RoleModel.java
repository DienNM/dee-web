package com.dee.webdee.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "role")
public class RoleModel{

    @Id
    @Column(name = "role_code", length = 30, nullable = false, unique = true)
    private String roleCode;
    
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
