package com.dee.web.blog.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.dee.web.blog.enumeration.EntityVersion;
import com.dee.web.blog.model.AuditModel;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "article")
public class ArticleModel extends AuditModel{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "code", length = 128, nullable = false)
    private String code;
    
    @Column(name = "title", length = 128, nullable = false)
    private String title;
    
    @Column(name = "sub_title", length = 512)
    private String subTitle;
    
    @Lob
    @Column(name = "content", nullable = false)
    private String content;
    
    @Column(name = "version")
    @Enumerated(EnumType.STRING)
    private EntityVersion version = EntityVersion.Online;
    
    @Column(name = "category_id")
    private Long categoryId;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EntityVersion getVersion() {
        return version;
    }

    public void setVersion(EntityVersion version) {
        this.version = version;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
}
