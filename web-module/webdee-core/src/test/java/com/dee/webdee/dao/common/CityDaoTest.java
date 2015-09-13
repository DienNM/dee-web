package com.dee.webdee.dao.common;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.model.common.CityModel;

/**
 * @author dien.nguyen
 */

public class CityDaoTest extends AbstractTest {

    @Autowired
    private CityDao cityDao;

    private CityModel cityModel1;
    private CityModel cityModel2;
    private CityModel cityModel3;

    @Before
    public void setUp() {
        cityModel1 = new CityModel();
        cityModel1.setCode("ho-chi-minh_vn");
        cityModel1.setCountryId(1);
        cityModel1.setLangCode("vn");
        cityModel1.setName("TP. Ho Chi Minh");
        cityDao.save(cityModel1);

        cityModel2 = new CityModel();
        cityModel2.setCode("ho-chi-minh_vn");
        cityModel2.setCountryId(1);
        cityModel2.setLangCode("en");
        cityModel2.setName("Ho Chi Minh City");
        cityDao.save(cityModel2);

        cityModel3 = new CityModel();
        cityModel3.setCode("new_york_us");
        cityModel3.setCountryId(2);
        cityModel3.setLangCode("vn");
        cityModel3.setName("Thanh Pho New York");
        cityDao.save(cityModel3);
    }

    @After
    public void tearDown() {
        cityDao.removeAll();
    }

    @Test
    public void findByCode() {
        List<CityModel> cities = cityDao.findByCode("ho-chi-minh_vn");
        Assert.assertEquals(2, cities.size());
        
        cities = cityDao.findByCode("new_york_us");
        Assert.assertEquals(1, cities.size());
    }
    
    @Test
    public void findByCodeAndLangCode() {
        CityModel city = cityDao.findByCodeAndLangCode("ho-chi-minh_vn", "vn");
        Assert.assertNotNull(city);
        
        city = cityDao.findByCodeAndLangCode("ho-chi-minh_vn", "en");
        Assert.assertNotNull(city);
        
        city = cityDao.findByCodeAndLangCode("new_york_us", "vn");
        Assert.assertNotNull(city);
        
        city = cityDao.findByCodeAndLangCode("ho-chi-minh_vn", "fr");
        Assert.assertNull(city);
        
        city = cityDao.findByCodeAndLangCode("new_york_us", "en");
        Assert.assertNull(city);
    }

    @Test
    public void findByCountryIdAndLangCode() {
        List<CityModel> cities = cityDao.findByCountryIdAndLangCode(1L, "vn");
        Assert.assertEquals(1, cities.size());
        
        cities = cityDao.findByCountryIdAndLangCode(1L, "en");
        Assert.assertEquals(1, cities.size());
        
        cities = cityDao.findByCountryIdAndLangCode(2L, "vn");
        Assert.assertEquals(1, cities.size());
        
        cities = cityDao.findByCountryIdAndLangCode(2L, "en");
        Assert.assertEquals(0, cities.size());
    }

}
