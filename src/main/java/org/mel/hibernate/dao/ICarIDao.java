package org.mel.hibernate.dao;

import org.mel.hibernate.model.CarEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mel on 10/25/15.
 */
public interface ICarIDao extends IDao<CarEntity> {

    @Transactional
    List<CarEntity> findCarByCompany(String company);

}
