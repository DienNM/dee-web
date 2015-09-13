package com.dee.webdee.dao.common.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.common.CountryDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.common.CountryModel;

/**
 * @author dien.nguyen
 */

@Repository
public class CountryDaoImpl extends GenericDaoImpl<CountryModel, Long> implements CountryDao {

    public CountryDaoImpl() {
        super(CountryModel.class);
    }

    @Override
    public List<CountryModel> findByActive(boolean active) {
        TypedQuery<CountryModel> query = entityManager.createNamedQuery("findCountryByActive", CountryModel.class);
        query.setParameter("active", active);
        return query.getResultList();
    }

    @Override
    public List<CountryModel> findByLangCode(String langCode) {
        TypedQuery<CountryModel> query = entityManager.createNamedQuery("findCountryByLangCode", CountryModel.class);
        query.setParameter("langCode", langCode);
        return query.getResultList();
    }

    @Override
    public List<CountryModel> findByIsoCode(String isoCode) {
        TypedQuery<CountryModel> query = entityManager.createNamedQuery("findCountryByIsoCode", CountryModel.class);
        query.setParameter("isoCode", isoCode);
        return query.getResultList();
    }

    @Override
    public CountryModel findByIsoCodeAndLangCode(String isoCode, String langCode) {
        TypedQuery<CountryModel> query = entityManager.createNamedQuery("findCountryByIsoCodeAndLangCode",
                CountryModel.class);
        query.setParameter("isoCode", isoCode);
        query.setParameter("langCode", langCode);
        List<CountryModel> countries = query.getResultList();
        if (countries.isEmpty()) {
            return null;
        }
        return countries.get(0);
    }

}
