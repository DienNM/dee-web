package com.dee.webdee.dao.core.impl;

import org.springframework.stereotype.Repository;

import com.dee.webdee.dao.core.RoleDao;
import com.dee.webdee.dao.impl.GenericDaoImpl;
import com.dee.webdee.model.core.RoleModel;

/**
 * @author dien.nguyen
 */

@Repository
public class RoleDaoImpl extends GenericDaoImpl<RoleModel, String> implements RoleDao {

    public RoleDaoImpl() {
        super(RoleModel.class);
    }
    
    

}
