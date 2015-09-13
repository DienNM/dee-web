package com.dee.webdee.model.media;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.dee.webdee.enumeration.media.MediaGroupType;

/**
 * @author dien.nguyen
 */

@MappedSuperclass
public class ImageInternalModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "full_name", length = 256)
    private String fullName;
    
    @Column(name = "file_name", length = 100)
    private String fileName;
    
    @Column(name = "group_type")
    @Enumerated(EnumType.STRING)
    private MediaGroupType groupType;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public MediaGroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(MediaGroupType groupType) {
        this.groupType = groupType;
    }
    
}
