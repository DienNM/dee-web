package com.dee.webdee.dao.common;

import java.util.List;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.model.common.LanguageModel;

/**
 * @author dien.nguyen
 */

public interface LanguageDao extends GenericDao<LanguageModel, String> {
    
    List<LanguageModel> findByActive(boolean active);
    
    List<LanguageModel> findByDefault(boolean active);
    
}
