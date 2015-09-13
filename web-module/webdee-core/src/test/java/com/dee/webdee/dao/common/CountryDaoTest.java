package com.dee.webdee.dao.common;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.model.common.CountryModel;

/**
 * @author dien.nguyen
 */

public class CountryDaoTest extends AbstractTest {

    @Autowired
    private CountryDao countryDao;
    
    private CountryModel countryVN1;
    private CountryModel countryVN2;
    private CountryModel countryUS1;

    @Before
    public void setUp() {
        countryVN1 = new CountryModel();
        countryVN1.setActive(true);
        countryVN1.setIsoCode("VN");
        countryVN1.setLangCode("vn");
        countryVN1.setName("Viet Nam");
        countryDao.save(countryVN1);
        
        countryVN2 = new CountryModel();
        countryVN2.setActive(true);
        countryVN2.setIsoCode("VN");
        countryVN2.setLangCode("en");
        countryVN2.setName("VietNam");
        countryDao.save(countryVN2);
        
        countryUS1 = new CountryModel();
        countryUS1.setActive(false);
        countryUS1.setIsoCode("EN");
        countryUS1.setLangCode("vn");
        countryUS1.setName("Nuoc Anh");
        countryDao.save(countryUS1);
        
    }

    @After
    public void tearDown() {
        countryDao.removeAll();
    }

    @Test
    public void findByActive() {
        List<CountryModel> countries = countryDao.findByActive(true);
        Assert.assertEquals(2, countries.size());
        
        countries = countryDao.findByActive(false);
        Assert.assertEquals(1, countries.size());
    }
    
    @Test
    public void findByLangCode() {
        List<CountryModel> countries = countryDao.findByLangCode("en");
        Assert.assertEquals(1, countries.size());
        
        countries = countryDao.findByLangCode("vn");
        Assert.assertEquals(2, countries.size());
    }
    
    @Test
    public void findByIsoCode() {
        List<CountryModel> countries = countryDao.findByIsoCode("VN");
        Assert.assertEquals(2, countries.size());
        
        countries = countryDao.findByLangCode("EN");
        Assert.assertEquals(1, countries.size());
    }
    
    @Test
    public void findByIsoCodeAndLangCode() {
        CountryModel country = countryDao.findByIsoCodeAndLangCode("VN", "en");
        Assert.assertNotNull(country);
        
        country = countryDao.findByIsoCodeAndLangCode("VN", "vn");
        Assert.assertNotNull(country);
        
        country = countryDao.findByIsoCodeAndLangCode("VN", "fr");
        Assert.assertNull(country);
        
        country = countryDao.findByIsoCodeAndLangCode("EN", "vn");
        Assert.assertNotNull(country);
    }

}
