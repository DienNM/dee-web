package com.dee.webdee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.dao.CategoryDao;
import com.dee.webdee.data.DataRepo;
import com.dee.webdee.enumeration.EntityVersion;
import com.dee.webdee.model.CategoryModel;
import com.dee.webdee.util.param.PageableData;

/**
 * @author dien.nguyen
 */

public class CategoryDaoTest extends AbstractTest {
    
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
    public void testFindByCode(){
        CategoryModel categoryModel = categoryDao.findByCode("java1");
        Assert.assertNull(categoryModel);
        
        categoryModel = categoryDao.findByCode("java");
        Assert.assertNotNull(categoryModel);
        Assert.assertEquals("Java", categoryModel.getName());
    }
    
    @Test
    public void testFindByParent() {
        CategoryModel categoryModel = categoryDao.findByCode("java");
        Assert.assertNotNull(categoryModel);
        
        List<CategoryModel> categories = categoryDao.findByParent(categoryModel.getParentId());
        Assert.assertEquals(2, categories.size());
        for(CategoryModel ctg : categories) {
            if(ctg.getCode().equals("java")) {
                Assert.assertEquals("Java Programming Language", ctg.getDescription());
            } else if(ctg.getCode().equals("android")) {
                Assert.assertEquals("Android", ctg.getDescription());
            } else {
                Assert.fail();
            }
        }
    }
    
    @Test
    public void testFindByParentWithPaging() {
        CategoryModel categoryModel = categoryDao.findByCode("java");
        Assert.assertNotNull(categoryModel);
        
        List<CategoryModel> categories = categoryDao.findByParent(categoryModel.getParentId(), 
                new PageableData(0, 1));
        Assert.assertEquals(1, categories.size());
        for(CategoryModel ctg : categories) {
            if(ctg.getCode().equals("android")) {
                Assert.assertEquals("Android", ctg.getDescription());
            } else {
                Assert.fail();
            }
        }
    }
    
    public void testFindByVersion() {
        List<CategoryModel> categories = categoryDao.findByVersion(EntityVersion.Online);
        Assert.assertEquals(4, categories.size());
        for(CategoryModel ctg : categories) {
            if(ctg.getCode().equals("it")) {
                Assert.assertEquals("IT", ctg.getCode());
            } else if(ctg.getCode().equals("java")) {
                Assert.assertEquals("Java", ctg.getCode());
            } else if(ctg.getCode().equals("java-core")) {
                Assert.assertEquals("java-core", ctg.getCode());
            } else if(ctg.getCode().equals("android")) {
                Assert.assertEquals("Android", ctg.getCode());
            } else {
                Assert.fail();
            }
        }
        
        categories = categoryDao.findByVersion(EntityVersion.Staging);
        Assert.assertEquals(1, categories.size());
        for(CategoryModel ctg : categories) {
            if(ctg.getCode().equals("jee")) {
                Assert.assertEquals("JEE", ctg.getCode());
            } else {
                Assert.fail();
            }
        }
    }
    
}
