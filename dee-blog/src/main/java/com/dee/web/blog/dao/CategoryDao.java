package com.dee.web.blog.dao;

import java.util.List;

import com.dee.web.blog.enumeration.EntityVersion;
import com.dee.web.blog.model.core.CategoryModel;
import com.dee.web.blog.util.param.PageableData;

/**
 * @author dien.nguyen
 */

public interface CategoryDao extends GenericDao<CategoryModel, Long> {
    
    CategoryModel findByCode(String code);
    
    List<CategoryModel> findByParent(Long parent);
    
    List<CategoryModel> findByParent(Long parent, PageableData pageData);
    
    List<CategoryModel> findByVersion(EntityVersion version);
    
    List<CategoryModel> findByVersion(EntityVersion version, PageableData pageData);
    
}
