package com.dee.web.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dee.web.blog.dao.CategoryDao;
import com.dee.web.blog.enumeration.EntityVersion;
import com.dee.web.blog.model.core.CategoryModel;

/**
 * @author dien.nguyen
 */

@Service
public class DataRepo {

    @Autowired
    private CategoryDao categoryDao;
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void prepageCategories() {
        
        CategoryModel categoryRoot = new CategoryModel();
        categoryRoot.setCode("it");
        categoryRoot.setDescription("Information Technology");
        categoryRoot.setName("IT");
        categoryRoot.setVersion(EntityVersion.Online);
        saveCategory(categoryRoot);
        
        CategoryModel category1 = new CategoryModel();
        category1.setCode("java");
        category1.setDescription("Java Programming Language");
        category1.setName("Java");
        category1.setVersion(EntityVersion.Online);
        category1.setParentId(categoryRoot.getId());
        saveCategory(category1);
        
        CategoryModel category2 = new CategoryModel();
        category2.setCode("java-core");
        category2.setDescription("Java Core");
        category2.setName("Java Core");
        category2.setVersion(EntityVersion.Online);
        category2.setParentId(category1.getId());
        saveCategory(category2);
        
        CategoryModel category3 = new CategoryModel();
        category3.setCode("jee");
        category3.setDescription("Java Enterprise Edition");
        category3.setName("JEE");
        category3.setVersion(EntityVersion.Staging);
        category3.setParentId(category1.getId());
        saveCategory(category3);
        
        CategoryModel category4 = new CategoryModel();
        category4.setCode("android");
        category4.setDescription("Android");
        category4.setName("Android");
        category4.setVersion(EntityVersion.Online);
        category4.setParentId(categoryRoot.getId());
        saveCategory(category4);
    } 

    @Transactional
    public void saveCategory(CategoryModel category) {
        categoryDao.save(category);
    }

    @Transactional
    public void removeAllCategories() {
        categoryDao.removeAll();
    }
    
}
