package com.dee.webdee.dao.core;

import java.util.List;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.model.core.RoleLangModel;
import com.dee.webdee.model.id.SSCompositeKey;

/**
 * @author dien.nguyen
 */

public interface RoleLangDao extends GenericDao<RoleLangModel, SSCompositeKey> {

    /**
     * Find roles by given RoleCode in all languages
     * @param roleCode Role Code
     * @return List<RoleLangModel>
     */
    List<RoleLangModel> findByRoleCode(String roleCode);

    /**
     * Find roles by given language
     * @param langCode Language Code
     * @return List<RoleLangModel>
     */
    List<RoleLangModel> findByLangCode(String langCode);

}
