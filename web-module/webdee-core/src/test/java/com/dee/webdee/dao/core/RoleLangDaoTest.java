package com.dee.webdee.dao.core;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.model.core.RoleLangModel;
import com.dee.webdee.model.id.SSCompositeKey;

/**
 * @author dien.nguyen
 */

public class RoleLangDaoTest extends AbstractTest{
    
    @Autowired
    private RoleLangDao roleLangDao;
    
    private RoleLangModel roleLang1;
    private RoleLangModel roleLang2;
    private RoleLangModel roleLang3;
    
    @Before
    public void setUp() {
        roleLang1 = new RoleLangModel();
        roleLang1.setId(new SSCompositeKey("ROLE_USER", "vn"));
        roleLang1.setName("Role Nguoi Dung");
        roleLangDao.save(roleLang1);
        
        roleLang2 = new RoleLangModel();
        roleLang2.setId(new SSCompositeKey("ROLE_USER", "en"));
        roleLang2.setName("User Role");
        roleLangDao.save(roleLang2);
        
        roleLang3 = new RoleLangModel();
        roleLang3.setId(new SSCompositeKey("ROLE_ADMIN", "en"));
        roleLang3.setName("Admin Role");
        roleLangDao.save(roleLang3);
    }
    
    @After
    public void tearDown() {
        roleLangDao.removeAll();
    }
    
    @Test
    public void findByRoleCode() {
        List<RoleLangModel> roleLangModels = roleLangDao.findByRoleCode("ROLE_USER");
        Assert.assertEquals(2, roleLangModels.size());
        
        roleLangModels = roleLangDao.findByRoleCode("ROLE_ADMIN");
        Assert.assertEquals(1, roleLangModels.size());
    }
    
    @Test
    public void findByLangCode() {
        RoleLangModel roleLangModel = roleLangDao.findById(new SSCompositeKey("ROLE_USER", "vn"));
        Assert.assertNotNull(roleLangModel);
        
        roleLangModel = roleLangDao.findById(new SSCompositeKey("ROLE_USER", "en"));
        Assert.assertNotNull(roleLangModel);
        
        roleLangModel = roleLangDao.findById(new SSCompositeKey("ROLE_USER", "fr"));
        Assert.assertNull(roleLangModel);
        
        roleLangModel = roleLangDao.findById(new SSCompositeKey("ROLE_ADMIN", "en"));
        Assert.assertNotNull(roleLangModel);
        
    }
    
    @Test
    public void findById() {
        List<RoleLangModel> roleLangModels = roleLangDao.findByLangCode("vn");
        Assert.assertEquals(1, roleLangModels.size());
        
        roleLangModels = roleLangDao.findByLangCode("en");
        Assert.assertEquals(2, roleLangModels.size());
    }
    
}
