package org.mel.hibernate.dao;

/**
 * Interface containing common access methods for managed entities.
 *
 * @param <T> The entity type.
 */
public interface Dao<T> {

    /**
     * Find an entity in the session by its id
     */
    T getById(long id);

    /**
     * Create an entity in the session
     */
    void save(T entity);

    /**
     * Delete an entity from the session
     */
    void remove(T entity);

    /**
     * Update an entity in the session
     */
    T update(T entity);


}
