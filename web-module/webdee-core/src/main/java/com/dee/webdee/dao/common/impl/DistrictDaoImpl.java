package com.dee.webdee.dao.common.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.common.DistrictDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.common.DistrictModel;

/**
 * @author dien.nguyen
 */

@Repository
public class DistrictDaoImpl extends GenericDaoImpl<DistrictModel, Long> implements DistrictDao {

    public DistrictDaoImpl() {
        super(DistrictModel.class);
    }

    @Override
    public List<DistrictModel> findByCode(String code) {
        TypedQuery<DistrictModel> query = entityManager.createNamedQuery("findDistrictByCode", DistrictModel.class);
        query.setParameter("code", code);
        return query.getResultList();
    }

    @Override
    public DistrictModel findByCodeAndLangCode(String code, String langCode) {
        TypedQuery<DistrictModel> query = entityManager.createNamedQuery("findDistrictByCodeAndLangCode",
                DistrictModel.class);
        query.setParameter("code", code);
        query.setParameter("langCode", langCode);
        List<DistrictModel> districts = query.getResultList();
        if (districts.isEmpty()) {
            return null;
        }
        return districts.get(0);
    }

    @Override
    public List<DistrictModel> findByCityIdAndLangCode(long cityId, String langCode) {
        TypedQuery<DistrictModel> query = entityManager.createNamedQuery("findDistrictByCityIdAndLangCode",
                DistrictModel.class);
        query.setParameter("cityId", cityId);
        query.setParameter("langCode", langCode);
        return query.getResultList();
    }

}
