package com.dee.webdee.dao.common;

import java.util.List;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.model.common.CityModel;

/**
 * @author dien.nguyen
 */

public interface CityDao extends GenericDao<CityModel, Long> {
    
    /**
     * Find city in all languages with given city code
     * @param code Code of City
     * @return List<CityModel>
     */
    List<CityModel> findByCode(String code);
    
    /**
     * Find city with given city code and given language
     * @param code Code of City
     * @param langCode Language Code
     * @return CityModel
     */
    CityModel findByCodeAndLangCode(String code, String langCode);
    
    /**
     * Find cities belong to given country id and given code
     * @param countryId Country Id
     * @param langCode Language Code
     * @return List<CityModel>
     */
    List<CityModel> findByCountryIdAndLangCode(long countryId, String langCode);
    
}
