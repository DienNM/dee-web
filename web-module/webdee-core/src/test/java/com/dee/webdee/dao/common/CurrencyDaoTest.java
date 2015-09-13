package com.dee.webdee.dao.common;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.model.common.CurrencyModel;

/**
 * @author dien.nguyen
 */

public class CurrencyDaoTest extends AbstractTest {

    @Autowired
    private CurrencyDao currencyDao;
    
    private CurrencyModel currencyVN1;
    private CurrencyModel currencyVN2;
    private CurrencyModel currencyUS1;
    private CurrencyModel currencyUS2;

    @Before
    public void setUp() {
        currencyVN1 = new CurrencyModel();
        currencyVN1.setActive(true);
        currencyVN1.setByDefault(true);
        currencyVN1.setIsoCode("VND");
        currencyVN1.setLangCode("vn");
        currencyVN1.setName("D^ong");
        currencyVN1.setSymbol("D");
        currencyDao.save(currencyVN1);
        
        currencyVN2 = new CurrencyModel();
        currencyVN2.setActive(true);
        currencyVN2.setByDefault(true);
        currencyVN2.setIsoCode("VND");
        currencyVN2.setLangCode("en");
        currencyVN2.setName("Dong");
        currencyVN2.setSymbol("D");
        currencyDao.save(currencyVN2);
        
        currencyUS1 = new CurrencyModel();
        currencyUS1.setActive(true);
        currencyUS1.setByDefault(false);
        currencyUS1.setIsoCode("USD");
        currencyUS1.setLangCode("vn");
        currencyUS1.setName("Do La My");
        currencyUS1.setSymbol("$");
        currencyDao.save(currencyUS1);
        
        currencyUS2 = new CurrencyModel();
        currencyUS2.setActive(false);
        currencyUS2.setByDefault(false);
        currencyUS2.setIsoCode("USD");
        currencyUS2.setLangCode("en");
        currencyUS2.setName("Dolar");
        currencyUS2.setSymbol("$");
        currencyDao.save(currencyUS2);
    }

    @After
    public void tearDown() {
        currencyDao.removeAll();
    }

    @Test
    public void findByActive() {
        List<CurrencyModel> currencies = currencyDao.findByActive(true);
        Assert.assertEquals(3, currencies.size());
        
        currencies = currencyDao.findByActive(false);
        Assert.assertEquals(1, currencies.size());
    }

    @Test
    public void findByDefault() {
        List<CurrencyModel> currencies = currencyDao.findByDefault(true);
        Assert.assertEquals(2, currencies.size());
        
        currencies = currencyDao.findByDefault(false);
        Assert.assertEquals(2, currencies.size());
    }

    @Test
    public void findByLangCode() {
        List<CurrencyModel> currencies = currencyDao.findByLangCode("vn");
        Assert.assertEquals(2, currencies.size());
        
        currencies = currencyDao.findByLangCode("en");
        Assert.assertEquals(2, currencies.size());
        
        currencies = currencyDao.findByLangCode("fr");
        Assert.assertEquals(0, currencies.size());
    }

    @Test
    public void findByIsoCode() {
        List<CurrencyModel> currencies = currencyDao.findByIsoCode("VND");
        Assert.assertEquals(2, currencies.size());
        
        currencies = currencyDao.findByIsoCode("USD");
        Assert.assertEquals(2, currencies.size());
        
        currencies = currencyDao.findByIsoCode("ERU");
        Assert.assertEquals(0, currencies.size());
    }

    @Test
    public void findByIsoCodeAndLangCode() {
        CurrencyModel currency = currencyDao.findByIsoCodeAndLangCode("VND", "vn");
        Assert.assertNotNull(currency);
        
        currency = currencyDao.findByIsoCodeAndLangCode("VND", "en");
        Assert.assertNotNull(currency);
        
        currency = currencyDao.findByIsoCodeAndLangCode("VND", "fr");
        Assert.assertNull(currency);
        
        currency = currencyDao.findByIsoCodeAndLangCode("USD", "vn");
        Assert.assertNotNull(currency);
    }

}
