package com.dee.webdee.model.media;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.dee.webdee.enumeration.media.MediaSizeType;

/**
 * @author dien.nguyen
 */

@MappedSuperclass
public class ImageProductModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "size_type")
    @Enumerated(EnumType.STRING)
    private MediaSizeType sizeType; 
    
    private long internalImageId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MediaSizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(MediaSizeType sizeType) {
        this.sizeType = sizeType;
    }

    public long getInternalImageId() {
        return internalImageId;
    }

    public void setInternalImageId(long internalImageId) {
        this.internalImageId = internalImageId;
    }
    
}
