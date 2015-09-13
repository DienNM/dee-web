package com.dee.webdee.dao.common.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.common.CityDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.common.CityModel;

/**
 * @author dien.nguyen
 */

@Repository
public class CityDaoImpl extends GenericDaoImpl<CityModel, Long> implements CityDao {
    
    public CityDaoImpl() {
        super(CityModel.class);
    }

    @Override
    public List<CityModel> findByCode(String code) {
        TypedQuery<CityModel> query = entityManager.createNamedQuery("findCityByCode", CityModel.class);
        query.setParameter("code", code);
        return query.getResultList();
    }

    @Override
    public CityModel findByCodeAndLangCode(String code, String langCode) {
        TypedQuery<CityModel> query = entityManager.createNamedQuery("findCityByCodeAndLangCode",
                CityModel.class);
        query.setParameter("code", code);
        query.setParameter("langCode", langCode);
        List<CityModel> cities = query.getResultList();
        if (cities.isEmpty()) {
            return null;
        }
        return cities.get(0);
    }

    @Override
    public List<CityModel> findByCountryIdAndLangCode(long countryId, String langCode) {
        TypedQuery<CityModel> query = entityManager.createNamedQuery("findCityByCountryIdAndLangCode", CityModel.class);
        query.setParameter("countryId", countryId);
        query.setParameter("langCode", langCode);
        return query.getResultList();
    }
    
}
