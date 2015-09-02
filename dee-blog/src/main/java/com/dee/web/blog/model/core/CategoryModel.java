package com.dee.web.blog.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dee.web.blog.enumeration.EntityVersion;
import com.dee.web.blog.model.AuditModel;
/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "category")
public class CategoryModel extends AuditModel{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "code", length = 50, unique = true, nullable = false)
    private String code;
    
    @Column(name = "name", length = 256, nullable = false)
    private String name;
    
    @Column(name = "description", length = 512)
    private String description;
    
    @Column(name = "version")
    @Enumerated(EnumType.STRING)
    private EntityVersion version = EntityVersion.Online;
    
    @Column(name = "parent_id", nullable = false)
    private Long parentId = 0L;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public EntityVersion getVersion() {
        return version;
    }

    public void setVersion(EntityVersion version) {
        this.version = version;
    }
    
}
