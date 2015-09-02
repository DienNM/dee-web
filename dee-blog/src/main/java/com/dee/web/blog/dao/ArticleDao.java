package com.dee.web.blog.dao;

import java.util.List;

import com.dee.web.blog.enumeration.EntityVersion;
import com.dee.web.blog.model.core.ArticleModel;
import com.dee.web.blog.util.param.PageableData;

/**
 * @author dien.nguyen
 */

public interface ArticleDao extends GenericDao<ArticleModel, Long> {
    
    ArticleModel findByCode(String code);
    
    ArticleModel findByCode(String code, EntityVersion version);
    
    List<ArticleModel> findByCategoryId(Long categoryId, PageableData pageableData);
    
    List<ArticleModel> findByCategoryId(Long categoryId, EntityVersion articleVersion, PageableData pageableData);
    
    List<ArticleModel> findByVersion(EntityVersion version, PageableData pageableData);
}
