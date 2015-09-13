package com.dee.webdee.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dee.webdee.dao.ArticleDao;
import com.dee.webdee.dao.CategoryDao;
import com.dee.webdee.enumeration.EntityVersion;
import com.dee.webdee.model.ArticleModel;
import com.dee.webdee.model.CategoryModel;

/**
 * @author dien.nguyen
 */

@Service
public class DataRepo {

    @Autowired
    private CategoryDao categoryDao;
    
    @Autowired
    private ArticleDao articleDao;
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void prepageCategories() {
        
        CategoryModel categoryRoot = new CategoryModel();
        categoryRoot.setCode("it");
        categoryRoot.setDescription("Information Technology");
        categoryRoot.setName("IT");
        categoryRoot.setVersion(EntityVersion.Online);
        categoryDao.save(categoryRoot);
        
        CategoryModel category1 = new CategoryModel();
        category1.setCode("java");
        category1.setDescription("Java Programming Language");
        category1.setName("Java");
        category1.setVersion(EntityVersion.Online);
        category1.setParentId(categoryRoot.getId());
        categoryDao.save(category1);
        
        CategoryModel category2 = new CategoryModel();
        category2.setCode("java-core");
        category2.setDescription("Java Core");
        category2.setName("Java Core");
        category2.setVersion(EntityVersion.Online);
        category2.setParentId(category1.getId());
        categoryDao.save(category2);
        
        CategoryModel category3 = new CategoryModel();
        category3.setCode("jee");
        category3.setDescription("Java Enterprise Edition");
        category3.setName("JEE");
        category3.setVersion(EntityVersion.Staging);
        category3.setParentId(category1.getId());
        categoryDao.save(category3);
        
        CategoryModel category4 = new CategoryModel();
        category4.setCode("android");
        category4.setDescription("Android");
        category4.setName("Android");
        category4.setVersion(EntityVersion.Online);
        category4.setParentId(categoryRoot.getId());
        categoryDao.save(category4);
    } 

    @Transactional
    public void removeAllCategories() {
        categoryDao.removeAll();
    }
    
    @Transactional
    public void prepageArticles() {
        for(int i = 1; i <= 10; i++) {
            ArticleModel article = new ArticleModel();
            article.setCode("article" + i);
            article.setTitle("Title " + i);
            article.setContent("Content " + i);
            article.setSubTitle("Sub Title " + i);
            if(i >= 8) {
                article.setVersion(EntityVersion.Staging);
            } else {
                article.setVersion(EntityVersion.Online);
            }
            if(i % 3 == 0) {
                article.setCategoryId(1L);
            } else {
                article.setCategoryId(2L);
            }
            articleDao.save(article);
        }
    } 

    @Transactional
    public void removeAllArticles() {
        articleDao.removeAll();
    }
    
}
