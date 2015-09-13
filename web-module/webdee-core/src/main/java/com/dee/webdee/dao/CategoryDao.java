package com.dee.webdee.dao;

import java.util.List;

import com.dee.webdee.enumeration.EntityVersion;
import com.dee.webdee.model.CategoryModel;
import com.dee.webdee.util.param.PageableData;

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
