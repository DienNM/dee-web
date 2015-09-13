package com.dee.webdee.enumeration.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dien.nguyen
 */

public enum UserTitle {
    
    Mr,
    Mss,
    Ms,
    None {
        @Override
        public boolean isValid() {
            return false;
        }
    };
    
    public boolean isValid() {
        return true;
    }
    
    public List<UserTitle> getValidTitles() {
        List<UserTitle> titles = new ArrayList<UserTitle>();
        for(UserTitle title : UserTitle.values()) {
            if(title.isValid()) {
                titles.add(title);
            }
        }
        return titles;
    }
    
    public List<UserTitle> getTitles() {
        List<UserTitle> titles = new ArrayList<UserTitle>();
        for(UserTitle title : UserTitle.values()) {
            titles.add(title);
        }
        return titles;
    }
    
}
