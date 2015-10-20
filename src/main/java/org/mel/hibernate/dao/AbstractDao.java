package org.mel.hibernate.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by mel on 10/11/15.
 */
public abstract class AbstractDao<T> implements Dao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    Class<T> clazz;

    public AbstractDao() {
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
    @Transactional
    public T getById(long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    @Transactional
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    public T update(T entity) {
        return entityManager.merge(entity);
    }

}
