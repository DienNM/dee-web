package com.dee.webdee.model.media;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dee.webdee.enumeration.media.MediaGroupType;
import com.dee.webdee.enumeration.media.MediaSizeType;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "media_size_type")
public class MediaSizeTypeModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "width")
    private int width;
    
    @Column(name = "height")
    private int height;
    
    @Column(name = "group_type")
    @Enumerated(EnumType.STRING)
    private MediaGroupType groupType;
    
    @Column(name = "size_type")
    @Enumerated(EnumType.STRING)
    private MediaSizeType sizeType;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MediaGroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(MediaGroupType groupType) {
        this.groupType = groupType;
    }

    public MediaSizeType getSizeType() {
        return sizeType;
    }

    public void setSizeType(MediaSizeType sizeType) {
        this.sizeType = sizeType;
    }
    
}
