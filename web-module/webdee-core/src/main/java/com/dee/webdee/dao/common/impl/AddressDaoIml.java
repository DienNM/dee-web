package com.dee.webdee.dao.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.common.AddressDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.common.AddressModel;

/**
 * @author dien.nguyen
 */

@Repository
public class AddressDaoIml extends GenericDaoImpl<AddressModel, Long> implements AddressDao {

    public AddressDaoIml() {
        super(AddressModel.class);
    }

    @Override
    public List<AddressModel> findByOwner(long owner) {
        TypedQuery<AddressModel> query = entityManager.createNamedQuery("findAddressByOwner", AddressModel.class);
        query.setParameter("owner", owner);
        return query.getResultList();
    }

    @Override
    public List<AddressModel> findByOwnerInBookAndTypeOR(long owner, boolean shipping, boolean billing, boolean contact) {
        StringBuilder sql = new StringBuilder("FROM AddressModel WHERE owner = :owner AND visibleInAddressBook = 1 ");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("owner", owner);
        if(shipping) {
            sql.append(" AND shippingAddress = :shipping");
            params.put("shipping", shipping);
        }
        if(billing) {
            sql.append(" AND billingAddress = :billing");
            params.put("billing", billing);
        }
        if(contact) {
            sql.append(" AND contactAddress = :contact");
            params.put("contact", contact);
        }
        TypedQuery<AddressModel> query = entityManager.createQuery(sql.toString(), AddressModel.class);
        
        for(String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return query.getResultList();
    }

    @Override
    public List<AddressModel> findByOwnerInBookAndTypeAND(long owner, boolean shipping, boolean billing, boolean contact) {
        TypedQuery<AddressModel> query = entityManager.createNamedQuery("findAddressByOwnerInBookAndType",
                AddressModel.class);
        query.setParameter("owner", owner);
        query.setParameter("shipping", shipping);
        query.setParameter("billing", billing);
        query.setParameter("contact", contact);
        return query.getResultList();
    }

    @Override
    public List<AddressModel> findByOwnerAndInAddBook(long owner, boolean inBook) {
        TypedQuery<AddressModel> query = entityManager.createNamedQuery("findAddressAddressByOwnerAndInBook",
                AddressModel.class);
        query.setParameter("owner", owner);
        query.setParameter("inBook", inBook);
        return query.getResultList();
    }

}
