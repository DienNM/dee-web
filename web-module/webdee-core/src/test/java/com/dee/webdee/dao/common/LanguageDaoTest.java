package com.dee.webdee.dao.common;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.model.common.LanguageModel;

/**
 * @author dien.nguyen
 */

public class LanguageDaoTest extends AbstractTest {
    
    @Autowired
    private LanguageDao languageDao;
    
    private LanguageModel language1;
    private LanguageModel language2;
    private LanguageModel language3;
    
    @Before
    public void setUp() {
        language1 = new LanguageModel();
        language1.setActive(true);
        language1.setByDefault(true);
        language1.setCode("vn_VN");
        language1.setLangCode("vn");
        language1.setCountryCode("VN");
        languageDao.save(language1);
        
        language2 = new LanguageModel();
        language2.setActive(true);
        language2.setByDefault(false);
        language2.setCode("en_EN");
        language2.setLangCode("en");
        language2.setCountryCode("EN");
        languageDao.save(language2);
        
        language3 = new LanguageModel();
        language3.setActive(false);
        language3.setByDefault(false);
        language3.setCode("en_US");
        language3.setLangCode("en");
        language3.setCountryCode("US");
        languageDao.save(language3);
    }
    
    @After
    public void tearDown() {
        languageDao.removeAll();
    }
    
    @Test
    public void findByActive() {
        List<LanguageModel> languages = languageDao.findByActive(true);
        Assert.assertEquals(2, languages.size());
        
        languages = languageDao.findByActive(false);
        Assert.assertEquals(1, languages.size());
    }
    
    public void findByDefault() {
        List<LanguageModel> languages = languageDao.findByDefault(true);
        Assert.assertEquals(1, languages.size());
        
        languages = languageDao.findByActive(false);
        Assert.assertEquals(2, languages.size());
    }
    
}
