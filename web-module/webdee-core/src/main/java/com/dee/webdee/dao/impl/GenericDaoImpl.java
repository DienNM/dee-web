package com.dee.webdee.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dee.webdee.dao.GenericDao;
import com.dee.webdee.util.param.PageableData;

/**
 * @author dien.nguyen
 */


public class GenericDaoImpl<Entity, Identifier> implements GenericDao<Entity, Identifier> {
    
    @PersistenceContext
    protected EntityManager entityManager;
     
    private Class<Entity> clazz;
    
    public GenericDaoImpl(Class<Entity> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    public List<Entity> findAll() {
        return findAll(new PageableData());
    }
    
    @Override
    public List<Entity> findAll(PageableData pageData) {
        TypedQuery<Entity> query = entityManager.createQuery("FROM " + clazz.getName(), clazz);
        query.setMaxResults(pageData.getPageSize());
        query.setFirstResult(pageData.getPageIndex() * pageData.getPageSize());
        return query.getResultList();
    }

    @Override
    public Entity findById(Identifier id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public void save(Entity entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Entity entity) {
        entityManager.merge(entityManager);
    }

    @Override
    public void update(List<Entity> entities) {
        for(Entity entity : entities) {
            entityManager.merge(entity);
        }
    }

    @Override
    public boolean remove(Identifier id) {
        Entity entity = entityManager.find(clazz, id);
        if(entity == null) {
            return false;
        }
        entityManager.remove(entity);
        return true;
    }

    @Override
    public void remove(Set<Identifier> ids) {
        for(Identifier id : ids) {
            Entity entity = entityManager.find(clazz, id);
            if(entity != null) {
                entityManager.remove(entity);
            }
        }
    }
    
    @Override
    public void removeAll() {
        entityManager.createQuery("DELETE FROM " + clazz.getName()).executeUpdate();
    }

}
