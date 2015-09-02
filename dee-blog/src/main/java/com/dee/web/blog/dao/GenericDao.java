package com.dee.web.blog.dao;

import java.util.List;
import java.util.Set;

import com.dee.web.blog.util.param.PageableData;

/**
 * @author dien.nguyen
 */

public interface GenericDao<Entity, Identifier> {
    
    List<Entity> findAll();
    
    List<Entity> findAll(PageableData pageData);
    
    Entity findById(Identifier id);
    
    void save(Entity entity);
    
    void update(Entity entity);
    
    void update(List<Entity> entities);
    
    boolean remove(Identifier id);
    
    void remove(Set<Identifier> ids); 
    
    void removeAll();
    
}
