package com.dee.webdee.dao.common.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.common.CurrencyDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.common.CurrencyModel;

/**
 * @author dien.nguyen
 */

@Repository
public class CurrencyDaoImpl extends GenericDaoImpl<CurrencyModel, Long> implements CurrencyDao {

    public CurrencyDaoImpl() {
        super(CurrencyModel.class);
    }

    @Override
    public List<CurrencyModel> findByActive(boolean active) {
        TypedQuery<CurrencyModel> query = entityManager.createNamedQuery("findCurrencyByActive", CurrencyModel.class);
        query.setParameter("active", active);
        return query.getResultList();
    }

    @Override
    public List<CurrencyModel> findByDefault(boolean byDefault) {
        TypedQuery<CurrencyModel> query = entityManager.createNamedQuery("findCurrencyByDefault", CurrencyModel.class);
        query.setParameter("byDefault", byDefault);
        return query.getResultList();
    }

    @Override
    public List<CurrencyModel> findByLangCode(String langCode) {
        TypedQuery<CurrencyModel> query = entityManager.createNamedQuery("findCurrencyByLangCode", CurrencyModel.class);
        query.setParameter("langCode", langCode);
        return query.getResultList();
    }

    @Override
    public List<CurrencyModel> findByIsoCode(String isoCode) {
        TypedQuery<CurrencyModel> query = entityManager.createNamedQuery("findCurrencyByIsoCode", CurrencyModel.class);
        query.setParameter("isoCode", isoCode);
        return query.getResultList();
    }

    @Override
    public CurrencyModel findByIsoCodeAndLangCode(String isoCode, String langCode) {
        TypedQuery<CurrencyModel> query = entityManager.createNamedQuery("findCurrencyByIsoCodeAndLangCode", CurrencyModel.class);
        query.setParameter("isoCode", isoCode);
        query.setParameter("langCode", langCode);
        List<CurrencyModel> currencies = query.getResultList();
        if (currencies.isEmpty()) {
            return null;
        }
        return currencies.get(0);
    }

}
