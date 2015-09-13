package com.dee.webdee.model.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.dee.webdee.model.AuditLangCodeModel;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "user_group")
public class UserGroupModel extends AuditLangCodeModel{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "group_name", length = 100)
    private String groupName;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_groups_users", joinColumns = {@JoinColumn(name = "group")}, 
                inverseJoinColumns = {@JoinColumn(name = "user")})
    private List<UserModel> user = new ArrayList<UserModel>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_groups_roles", joinColumns = {@JoinColumn(name = "group")}, 
                inverseJoinColumns = {@JoinColumn(name = "role")})
    private Set<RoleModel> roles = new HashSet<RoleModel>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<UserModel> getUser() {
        return user;
    }

    public void setUser(List<UserModel> user) {
        this.user = user;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }

}
