package org.mel.hibernate.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Interface containing common access methods for managed entities.
 *
 * @param <T> The entity type.
 */
public interface IDao<T> {

    /**
     * Find an entity in the session by its id
     */
    @Transactional
    T getById(Long id);

    /**
     * Create an entity in the session
     */
    @Transactional
    void save(T entity);

    /**
     * Delete an entity from the session
     */
    @Transactional
    void remove(T entity);

    /**
     * Update an entity in the session
     */
    @Transactional
    T update(T entity);

    public EntityManager getEntityManager();

    public void setEntityManager(EntityManager entityManager);

}
