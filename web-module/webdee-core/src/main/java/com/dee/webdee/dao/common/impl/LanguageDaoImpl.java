package com.dee.webdee.dao.common.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.common.LanguageDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.common.LanguageModel;

/**
 * @author dien.nguyen
 */

@Repository
public class LanguageDaoImpl extends GenericDaoImpl<LanguageModel, String> implements LanguageDao {

    public LanguageDaoImpl() {
        super(LanguageModel.class);
    }

    @Override
    public List<LanguageModel> findByActive(boolean active) {
        TypedQuery<LanguageModel> query = entityManager.createNamedQuery("findLanguageByActive", LanguageModel.class);
        query.setParameter("active", active);
        return query.getResultList();
    }

    @Override
    public List<LanguageModel> findByDefault(boolean active) {
        TypedQuery<LanguageModel> query = entityManager.createNamedQuery("findLanguageByDefault", LanguageModel.class);
        query.setParameter("byDefault", active);
        return query.getResultList();
    }

}
