package com.dee.webdee.dao;

import static com.dee.webdee.enumeration.EntityVersion.Online;
import static com.dee.webdee.enumeration.EntityVersion.Staging;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.dao.ArticleDao;
import com.dee.webdee.data.DataRepo;
import com.dee.webdee.enumeration.EntityVersion;
import com.dee.webdee.model.ArticleModel;
import com.dee.webdee.util.param.PageableData;

/**
 * @author dien.nguyen
 */

public class ArticleDaoTest extends AbstractTest{
    
    @Autowired
    private ArticleDao articleDao;
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private DataRepo dataRepo;
    
    @Before
    public void setUp() {
        dataRepo.prepageArticles();
    } 
    
    @After
    public void tearDown() {
        dataRepo.removeAllArticles();
    }
    
    @Test
    public void testFindByCode() {
        ArticleModel article = articleDao.findByCode("article0");
        Assert.assertNull(article);
        
        article = articleDao.findByCode("article1");
        Assert.assertNotNull(article);
        
        article = articleDao.findByCode("article1", EntityVersion.Online);
        Assert.assertNotNull(article);
        
        article = articleDao.findByCode("article1", EntityVersion.Staging);
        Assert.assertNull(article);
        
        article = articleDao.findByCode("article10", EntityVersion.Staging);
        Assert.assertNotNull(article);
    }
    
    @Test
    public void testFindByCategoryId() {
        List<ArticleModel> articleModels = articleDao.findByCategoryId(1L, new PageableData(0, 10));
        Assert.assertEquals(3, articleModels.size());
        
        articleModels = articleDao.findByCategoryId(1L, new PageableData(0, 2));
        Assert.assertEquals(2, articleModels.size());
        
        articleModels = articleDao.findByCategoryId(2L, new PageableData(0, 10));
        Assert.assertEquals(7, articleModels.size());
        
        // Query with Version
        articleModels = articleDao.findByCategoryId(1L, Online, new PageableData(0, 10));
        Assert.assertEquals(2, articleModels.size());
        
        articleModels = articleDao.findByCategoryId(1L, Staging, new PageableData(0, 10));
        Assert.assertEquals(1, articleModels.size());
        
        articleModels = articleDao.findByCategoryId(2L, Online, new PageableData(0, 10));
        Assert.assertEquals(5, articleModels.size());
        
        articleModels = articleDao.findByCategoryId(2L, Staging, new PageableData(0, 10));
        Assert.assertEquals(2, articleModels.size());
    }
    
    @Test
    public void testFindByVersion() {
        List<ArticleModel> articleModels = articleDao.findByVersion(Online, new PageableData(0, 10));
        Assert.assertEquals(7, articleModels.size());
        
        articleModels = articleDao.findByVersion(Staging, new PageableData(0, 10));
        Assert.assertEquals(3, articleModels.size());
    }
    
}
