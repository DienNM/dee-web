package com.dee.web.blog.service;

import java.util.List;
import java.util.Set;

import com.dee.web.blog.dto.Category;
import com.dee.web.blog.enumeration.EntityVersion;

/**
 * @author dien.nguyen
 */

public interface CategoryService {
    
    List<Category> getAll();
    
    List<Category> getByVersion(EntityVersion version);
    
    List<Category> getByParent(Long parentId);
    
    void save(Category category);
    
    void update(Category category);
    
    void update(List<Category> categories);
    
    boolean delete(Long id);
    
    boolean deleteAll(Set<Long> id);
}
