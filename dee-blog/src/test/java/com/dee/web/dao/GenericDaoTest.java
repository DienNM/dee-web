package com.dee.web.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dee.web.AbstractTest;
import com.dee.web.blog.dao.CategoryDao;
import com.dee.web.blog.model.core.CategoryModel;
import com.dee.web.blog.util.param.PageableData;
import com.dee.web.data.DataRepo;

/**
 * @author dien.nguyen
 */

public class GenericDaoTest extends AbstractTest {
    
    @Autowired
    private CategoryDao categoryDao;
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private DataRepo dataRepo;
    
    @Before
    public void setUp() {
        dataRepo.prepageCategories();
    } 
    
    @After
    public void tearDown() {
        dataRepo.removeAllCategories();
    }
    
    @Test
    public void testFind(){
        List<CategoryModel> categories = categoryDao.findAll();
        Assert.assertEquals(5, categories.size());
        
        categories = categoryDao.findAll(new PageableData(0, 10));
        Assert.assertEquals(5, categories.size());

        categories = categoryDao.findAll(new PageableData(0, 2));
        Assert.assertEquals(2, categories.size());
        
        categories = categoryDao.findAll(new PageableData(1, 2));
        Assert.assertEquals(2, categories.size());
        
        CategoryModel category = categoryDao.findById(categories.get(0).getId());
        Assert.assertNotNull(category);
    }
    
    @Test
    @Transactional
    public void testDelete() {
        List<CategoryModel> categories = categoryDao.findAll();
        Assert.assertEquals(5, categories.size());
        
        categoryDao.remove(categories.get(0).getId());
        categories = categoryDao.findAll();
        Assert.assertEquals(4, categories.size());
        
        Set<Long> ids = new HashSet<Long>();
        ids.add(categories.get(0).getId());
        ids.add(categories.get(1).getId());
        
        categoryDao.remove(ids);
        categories = categoryDao.findAll();
        Assert.assertEquals(2, categories.size());
        
        categoryDao.removeAll();
        categories = categoryDao.findAll();
        Assert.assertEquals(0, categories.size());
    }
    
    public void testUpdate() {
        List<CategoryModel> categories = categoryDao.findAll();
        Assert.assertEquals(5, categories.size());
        
        CategoryModel categoryFirst = categories.get(0);
        CategoryModel categorySecond = categories.get(1);
        CategoryModel categoryThird = categories.get(2);
        
        Assert.assertNull(categoryFirst.getUpdatedAt());
        Assert.assertNull(categoryFirst.getUpdatedBy());
        Assert.assertNull(categorySecond.getUpdatedAt());
        Assert.assertNull(categorySecond.getUpdatedBy());
        Assert.assertNull(categoryThird.getUpdatedAt());
        Assert.assertNull(categoryThird.getUpdatedBy());
        
        categoryFirst.setCode(categoryFirst.getCode() + "_");
        categoryDao.update(categoryFirst);
        
        categoryFirst = categoryDao.findById(categoryFirst.getId());
        Assert.assertNotNull(categoryFirst.getUpdatedAt());
        Assert.assertNotNull(categoryFirst.getUpdatedBy());
        
        // Update multiple
        categorySecond.setCode(categorySecond.getCode() + "_");
        categoryThird.setCode(categoryThird.getCode() + "_");
        categoryDao.update(Arrays.asList(categorySecond, categoryThird));
        
        categorySecond = categoryDao.findById(categorySecond.getId());
        Assert.assertNotNull(categorySecond.getUpdatedAt());
        Assert.assertNotNull(categorySecond.getUpdatedBy());
        
        categoryFirst = categoryDao.findById(categoryThird.getId());
        Assert.assertNotNull(categoryThird.getUpdatedAt());
        Assert.assertNotNull(categoryThird.getUpdatedBy());
    }
    
}
