package com.dee.webdee.enumeration.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dien.nguyen
 */

public enum MariageStatus {
    
    Married,
    Single,
    Divorced,
    None {
        @Override
        public boolean isValid() {
            return false;
        }
    };
    
    public boolean isValid() {
        return true;
    }
    
    public List<MariageStatus> getValidMariageStatus() {
        List<MariageStatus> marriedStatus = new ArrayList<MariageStatus>();
        for(MariageStatus ms : MariageStatus.values()) {
            if(ms.isValid()) {
                marriedStatus.add(ms);
            }
        }
        return marriedStatus;
    }
    
    public List<MariageStatus> getMariageStatus() {
        List<MariageStatus> marriedStatus = new ArrayList<MariageStatus>();
        for(MariageStatus ms : MariageStatus.values()) {
            marriedStatus.add(ms);
        }
        return marriedStatus;
    }
    
}
