package org.mel.hibernate.dao.impl;

import org.mel.hibernate.dao.AbstractDao;
import org.mel.hibernate.dao.Dao;
import org.mel.hibernate.model.CarEntity;
import org.springframework.stereotype.Repository;

@Repository("carDao")
public class CarDao extends AbstractDao<CarEntity> implements Dao<CarEntity> {

}


/*
public interface CarDao {
    List<Car> getCars() throws DataAccessException;
    Car getCar(Long carId) throws DataAccessException;

    @Transactional
    public List<CarEntity> getCars() throws DataAccessException {
        Query query = getEntityManager().createQuery("select c from car c");
        List<CarEntity> resultList = query.getResultList();
        return resultList;
    }
    @Transactional
    public CarEntity getCar(Long carId) throws DataAccessException {
        return getEntityManager().find(CarEntity.class, carId);
    }

}*/
