package org.mel.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by mel on 10/11/15.
 */
public abstract class AbstractIDao<T> implements IDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    Class<T> clazz;

    public AbstractIDao() {
        this.clazz = (Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(T entity) {

        if (entityManager.contains(entity))
        {
            entityManager.remove(entity);
        }
        else
        {
            entityManager.remove(entityManager.merge(entity));
        }

    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

}
