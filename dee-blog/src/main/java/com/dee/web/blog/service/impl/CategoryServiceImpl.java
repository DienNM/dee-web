package com.dee.web.blog.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dee.web.blog.dto.Category;
import com.dee.web.blog.enumeration.EntityVersion;
import com.dee.web.blog.service.CategoryService;

/**
 * @author dien.nguyen
 */

@Service
public class CategoryServiceImpl implements CategoryService{

    @Override
    public List<Category> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Category> getByVersion(EntityVersion version) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Category> getByParent(Long parentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Category category) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Category category) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(List<Category> categories) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteAll(Set<Long> id) {
        // TODO Auto-generated method stub
        return false;
    }

}
