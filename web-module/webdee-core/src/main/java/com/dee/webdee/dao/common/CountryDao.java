package com.dee.webdee.dao.common;

import java.util.List;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.model.common.CountryModel;

/**
 * @author dien.nguyen
 */

public interface CountryDao extends GenericDao<CountryModel, Long> {
    
    List<CountryModel> findByActive(boolean active);
    
    List<CountryModel> findByLangCode(String langCode);
    
    List<CountryModel> findByIsoCode(String isoCode);
    
    CountryModel findByIsoCodeAndLangCode(String isoCode, String langCode);
    
}
