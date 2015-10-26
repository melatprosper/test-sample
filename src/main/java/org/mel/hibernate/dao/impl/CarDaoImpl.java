package org.mel.hibernate.dao.impl;

import org.mel.hibernate.dao.AbstractIDao;
import org.mel.hibernate.dao.ICarIDao;
import org.mel.hibernate.model.CarEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("carDao")
public class CarDaoImpl extends AbstractIDao<CarEntity> implements ICarIDao {

    @Override
    public List<CarEntity> findCarByCompany(String company) {

        Query query = entityManager.createNamedQuery("CarEntity.findCarByCompany", CarEntity.class);
        query.setParameter(1, company);

        List<CarEntity> carList = query.getResultList();

        return carList;
    }
}
