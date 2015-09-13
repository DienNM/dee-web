package com.dee.webdee.dao.core.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.core.RoleLangDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.core.RoleLangModel;
import com.dee.webdee.model.id.SSCompositeKey;

/**
 * @author dien.nguyen
 */

@Repository
public class RoleLangDaoImpl extends GenericDaoImpl<RoleLangModel, SSCompositeKey> implements RoleLangDao {

    public RoleLangDaoImpl() {
        super(RoleLangModel.class);
    }

    @Override
    public List<RoleLangModel> findByRoleCode(String roleCode) {
        TypedQuery<RoleLangModel> query = entityManager.createNamedQuery("findRoleByRoleCode", RoleLangModel.class);
        query.setParameter("roleCode", roleCode);
        return query.getResultList();
    }

    @Override
    public List<RoleLangModel> findByLangCode(String langCode) {
        TypedQuery<RoleLangModel> query = entityManager.createNamedQuery("findRoleByLangCode", RoleLangModel.class);
        query.setParameter("langCode", langCode);
        return query.getResultList();
    }
}
