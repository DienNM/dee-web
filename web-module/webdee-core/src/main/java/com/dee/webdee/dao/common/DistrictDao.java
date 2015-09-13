package com.dee.webdee.dao.common;

import java.util.List;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.model.common.DistrictModel;

/**
 * @author dien.nguyen
 */

public interface DistrictDao extends GenericDao<DistrictModel, Long> {
    
    /**
     * Find districts by given code
     * @param code Code of District
     * @return List<DistrictModel> 
     */
    List<DistrictModel> findByCode(String code);
    
    /**
     * Find District by giving District Code and given language code
     * @param code Code of District Code
     * @param langCode Language Code
     * @return DistrictModel
     */
    DistrictModel findByCodeAndLangCode(String code, String langCode);
    
    /**
     * Find Districts belong to given city in a giving language code
     * @param cityId City Id
     * @param langCode Language Code
     * @return List<DistrictModel>
     */
    List<DistrictModel> findByCityIdAndLangCode(long cityId, String langCode);
    
}
