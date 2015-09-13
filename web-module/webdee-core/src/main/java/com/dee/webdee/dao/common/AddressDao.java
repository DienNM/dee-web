package com.dee.webdee.dao.common;

import java.util.List;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.model.common.AddressModel;

/**
 * @author dien.nguyen
 */

public interface AddressDao extends GenericDao<AddressModel, Long> {
    
    List<AddressModel> findByOwner(long owner);
    
    List<AddressModel> findByOwnerInBookAndTypeOR(long owner, boolean shipping, boolean billing, boolean contact);
    
    List<AddressModel> findByOwnerInBookAndTypeAND(long owner, boolean shipping, boolean billing, boolean contact);
    
    List<AddressModel> findByOwnerAndInAddBook(long owner, boolean inBook);
    
}
