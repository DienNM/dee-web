package com.dee.webdee.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.CategoryDao;
import com.dee.webdee.enumeration.EntityVersion;
import com.dee.webdee.model.CategoryModel;
import com.dee.webdee.util.param.PageableData;

/**
 * @author dien.nguyen
 */

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<CategoryModel, Long> implements CategoryDao {

    public CategoryDaoImpl() {
        super(CategoryModel.class);
    }
    
    @Override
    public CategoryModel findByCode(String code) {
        TypedQuery<CategoryModel> query = entityManager.createQuery("FROM CategoryModel c "
                + "WHERE c.code = :code", 
                CategoryModel.class);
        query.setParameter("code", code);
        List<CategoryModel> categories = query.getResultList();
        if(categories.isEmpty()){
            return null;
        }
        return categories.get(0);
    }

    @Override
    public List<CategoryModel> findByParent(Long parent) {
        return findByParent(parent, new PageableData());
    }

    @Override
    public List<CategoryModel> findByParent(Long parent, PageableData pageData) {
        TypedQuery<CategoryModel> query = entityManager.createQuery("FROM CategoryModel c "
                + "WHERE c.parentId = :parentId "
                + "ORDER BY name ASC", 
                CategoryModel.class);
        query.setParameter("parentId", parent);
        
        query.setMaxResults(pageData.getPageSize());
        query.setFirstResult(pageData.getPageIndex() * pageData.getPageSize());
        
        return query.getResultList();
    }

    @Override
    public List<CategoryModel> findByVersion(EntityVersion version) {
        return findByVersion(version, new PageableData());
    }

    @Override
    public List<CategoryModel> findByVersion(EntityVersion version, PageableData pageData) {
        TypedQuery<CategoryModel> query = entityManager.createQuery("FROM CategoryModel c "
                + "WHERE c.version = :version "
                + "ORDER BY name ASC", 
                CategoryModel.class);
        query.setParameter("version", version);
        
        query.setMaxResults(pageData.getPageSize());
        query.setFirstResult(pageData.getPageIndex() * pageData.getPageSize());
        
        return query.getResultList();
    }

}
