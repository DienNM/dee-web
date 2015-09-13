package com.dee.webdee.dao.common;

import java.util.List;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.model.common.CurrencyModel;

/**
 * @author dien.nguyen
 */

public interface CurrencyDao extends GenericDao<CurrencyModel, Long> {

    List<CurrencyModel> findByActive(boolean active);
    
    List<CurrencyModel> findByDefault(boolean byDefault);

    List<CurrencyModel> findByLangCode(String langCode);

    List<CurrencyModel> findByIsoCode(String isoCode);

    CurrencyModel findByIsoCodeAndLangCode(String isoCode, String langCode);

}
