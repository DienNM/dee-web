package com.dee.webdee.dao.common;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.webdee.AbstractTest;
import com.dee.webdee.model.common.AddressModel;

/**
 * @author dien.nguyen
 */

public class AddressDaoTest extends AbstractTest {

    @Autowired
    private AddressDao addressDao;

    private AddressModel addressModel1;
    private AddressModel addressModel2;
    private AddressModel addressModel3;

    @Before
    public void setUp() {
        addressModel1 = new AddressModel();
        addressModel1.setOwner(1);
        addressModel1.setVisibleInAddressBook(true);
        addressModel1.setShippingAddress(true);
        addressModel1.setBillingAddress(true);
        addressModel1.setContactAddress(true);
        addressDao.save(addressModel1);

        addressModel2 = new AddressModel();
        addressModel2.setOwner(1);
        addressModel2.setVisibleInAddressBook(true);
        addressModel2.setShippingAddress(true);
        addressModel2.setBillingAddress(false);
        addressModel2.setContactAddress(true);
        addressDao.save(addressModel2);

        addressModel3 = new AddressModel();
        addressModel3.setOwner(1);
        addressModel3.setVisibleInAddressBook(false);
        addressModel3.setShippingAddress(true);
        addressModel3.setBillingAddress(true);
        addressModel3.setContactAddress(true);
        addressDao.save(addressModel3);
    }

    @After
    public void tearDown() {
        addressDao.removeAll();
    }

    @Test
    public void findByOwner() {
        List<AddressModel> addresses = addressDao.findByOwner(1);
        Assert.assertEquals(3, addresses.size());

        addresses = addressDao.findByOwner(2);
        Assert.assertEquals(0, addresses.size());
    }

    @Test
    public void findByOwnerInBookAndTypeOR() {
        List<AddressModel> addresses = addressDao.findByOwnerInBookAndTypeOR(1, true, true, true);
        Assert.assertEquals(1, addresses.size());

        // Only shipping
        addresses = addressDao.findByOwnerInBookAndTypeOR(1, true, false, false);
        Assert.assertEquals(2, addresses.size());

        // Shipping and Billing
        addresses = addressDao.findByOwnerInBookAndTypeOR(1, true, true, false);
        Assert.assertEquals(1, addresses.size());

        // Shipping and Contact
        addresses = addressDao.findByOwnerInBookAndTypeOR(1, true, false, true);
        Assert.assertEquals(2, addresses.size());
    }

    @Test
    public void findByOwnerInBookAndTypeAND() {
        List<AddressModel> addresses = addressDao.findByOwnerInBookAndTypeAND(1, true, true, true);
        Assert.assertEquals(1, addresses.size());

        // Only shipping
        addresses = addressDao.findByOwnerInBookAndTypeAND(1, true, false, false);
        Assert.assertEquals(0, addresses.size());

        // Shipping and Billing
        addresses = addressDao.findByOwnerInBookAndTypeAND(1, true, true, false);
        Assert.assertEquals(0, addresses.size());

        // Shipping and Contact
        addresses = addressDao.findByOwnerInBookAndTypeAND(1, true, false, true);
        Assert.assertEquals(1, addresses.size());
    }

    @Test
    public void findByOwnerAndInAddBook() {
        List<AddressModel> addresses = addressDao.findByOwnerAndInAddBook(1, true);
        Assert.assertEquals(2, addresses.size());

        // Only shipping
        addresses = addressDao.findByOwnerAndInAddBook(1, false);
        Assert.assertEquals(1, addresses.size());

    }

}
