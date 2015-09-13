package com.dee.webdee.model.listenner;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.dee.webdee.model.AuditModel;

/**
 * @author dien.nguyen
 */

public class AuditDataListenner {
    
    @PrePersist
    public void beforeSave(AuditModel auditModel) {
        auditModel.setCreatedAt(Calendar.getInstance().getTime());
        auditModel.setCreatedBy("System");// TODO
    }
    
    @PreUpdate
    public void beforeUpdate(AuditModel auditModel) {
        auditModel.setUpdatedAt(Calendar.getInstance().getTime());
        auditModel.setUpdatedBy("System");// TODO
    }
    
}
