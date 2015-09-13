package com.dee.webdee.dao.common;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.model.common.DistrictModel;

/**
 * @author dien.nguyen
 */

public class DistrictDaoTest extends AbstractTest {

    @Autowired
    private DistrictDao districtDao;

    private DistrictModel districtModel1;
    private DistrictModel districtModel2;
    private DistrictModel districtModel3;

    @Before
    public void setUp() {
        districtModel1 = new DistrictModel();
        districtModel1.setCode("tan_phu_hcm");
        districtModel1.setCityId(1);
        districtModel1.setLangCode("vn");
        districtModel1.setName("Quan Tan Phu");
        districtDao.save(districtModel1);

        districtModel2 = new DistrictModel();
        districtModel2.setCode("tan_phu_hcm");
        districtModel2.setCityId(1);
        districtModel2.setLangCode("en");
        districtModel2.setName("Tan Phu");
        districtDao.save(districtModel2);

        districtModel3 = new DistrictModel();
        districtModel3.setCode("abc_us");
        districtModel3.setCityId(2);
        districtModel3.setLangCode("vn");
        districtModel3.setName("Quan ABC");
        districtDao.save(districtModel3);
    }

    @After
    public void tearDown() {
        districtDao.removeAll();
    }

    @Test
    public void findByCode() {
        List<DistrictModel> cities = districtDao.findByCode("tan_phu_hcm");
        Assert.assertEquals(2, cities.size());
        
        cities = districtDao.findByCode("abc_us");
        Assert.assertEquals(1, cities.size());
    }
    
    @Test
    public void findByCodeAndLangCode() {
        DistrictModel district = districtDao.findByCodeAndLangCode("tan_phu_hcm", "vn");
        Assert.assertNotNull(district);
        
        district = districtDao.findByCodeAndLangCode("tan_phu_hcm", "en");
        Assert.assertNotNull(district);
        
        district = districtDao.findByCodeAndLangCode("abc_us", "vn");
        Assert.assertNotNull(district);
        
        district = districtDao.findByCodeAndLangCode("tan_phu_hcm", "fr");
        Assert.assertNull(district);
        
        district = districtDao.findByCodeAndLangCode("abc_us", "en");
        Assert.assertNull(district);
    }

    @Test
    public void findByCityIdAndLangCode() {
        List<DistrictModel> cities = districtDao.findByCityIdAndLangCode(1L, "vn");
        Assert.assertEquals(1, cities.size());
        
        cities = districtDao.findByCityIdAndLangCode(1L, "en");
        Assert.assertEquals(1, cities.size());
        
        cities = districtDao.findByCityIdAndLangCode(2L, "vn");
        Assert.assertEquals(1, cities.size());
        
        cities = districtDao.findByCityIdAndLangCode(2L, "en");
        Assert.assertEquals(0, cities.size());
    }

}
