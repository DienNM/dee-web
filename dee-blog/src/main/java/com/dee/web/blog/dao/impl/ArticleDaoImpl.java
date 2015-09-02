package com.dee.web.blog.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.web.blog.dao.ArticleDao;
import com.dee.web.blog.enumeration.EntityVersion;
import com.dee.web.blog.model.core.ArticleModel;
import com.dee.web.blog.util.param.PageableData;

/**
 * @author dien.nguyen
 */

@Repository
public class ArticleDaoImpl extends GenericDaoImpl<ArticleModel, Long> implements ArticleDao{

    public ArticleDaoImpl() {
        super(ArticleModel.class);
    }

    @Override
    public ArticleModel findByCode(String code) {
        TypedQuery<ArticleModel> query = entityManager.createQuery("FROM ArticleModel a "
                + "WHERE a.code = :code", 
                ArticleModel.class);
        query.setParameter("code", code);
        List<ArticleModel> articles = query.getResultList();
        if(articles.isEmpty()) {
            return null;
        }
        return articles.get(0);
    }

    @Override
    public ArticleModel findByCode(String code, EntityVersion version) {
        TypedQuery<ArticleModel> query = entityManager.createQuery("FROM ArticleModel a "
                + "WHERE a.code = :code AND a.version = :version", 
                ArticleModel.class);
        query.setParameter("code", code);
        query.setParameter("version", version);
        
        List<ArticleModel> articles = query.getResultList();
        if(articles.isEmpty()) {
            return null;
        }
        return articles.get(0);
    }

    @Override
    public List<ArticleModel> findByCategoryId(Long categoryId, PageableData pageableData) {
        TypedQuery<ArticleModel> query = entityManager.createQuery("FROM ArticleModel a "
                + "WHERE a.categoryId = :categoryId ", 
                ArticleModel.class);
        query.setParameter("categoryId", categoryId);
        query.setMaxResults(pageableData.getPageSize());
        query.setFirstResult(pageableData.getPageIndex() * pageableData.getPageSize());
        
        return query.getResultList();
    }

    @Override
    public List<ArticleModel> findByCategoryId(Long categoryId, EntityVersion articleVersion, PageableData pageableData) {
        TypedQuery<ArticleModel> query = entityManager.createQuery("FROM ArticleModel a "
                + "WHERE a.categoryId = :categoryId  AND a.version = :version ", 
                ArticleModel.class);
        
        query.setParameter("categoryId", categoryId);
        query.setParameter("version", articleVersion);
        
        query.setMaxResults(pageableData.getPageSize());
        query.setFirstResult(pageableData.getPageIndex() * pageableData.getPageSize());
        
        return query.getResultList();
    }

    @Override
    public List<ArticleModel> findByVersion(EntityVersion version, PageableData pageableData) {
        TypedQuery<ArticleModel> query = entityManager.createQuery("FROM ArticleModel a "
                + "WHERE a.version = :version ", 
                ArticleModel.class);
        
        query.setParameter("version", version);
        
        query.setMaxResults(pageableData.getPageSize());
        query.setFirstResult(pageableData.getPageIndex() * pageableData.getPageSize());
        
        return query.getResultList();
    }

}
