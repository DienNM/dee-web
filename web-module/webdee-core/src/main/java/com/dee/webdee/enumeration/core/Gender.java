package com.dee.webdee.enumeration.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dien.nguyen
 */

public enum Gender {
    
    Male,
    Female,
    None {
        @Override
        public boolean isValid() {
            return false;
        }
    };
    
    public boolean isValid() {
        return true;
    }
    
    public List<Gender> getValidGenders() {
        List<Gender> genders = new ArrayList<Gender>();
        for(Gender gender : Gender.values()) {
            if(gender.isValid()) {
                genders.add(gender);
            }
        }
        return genders;
    }
    
    public List<Gender> getGenders() {
        List<Gender> genders = new ArrayList<Gender>();
        for(Gender gender : Gender.values()) {
            genders.add(gender);
        }
        return genders;
    }
    
}
