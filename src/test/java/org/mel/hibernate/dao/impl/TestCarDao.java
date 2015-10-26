package org.mel.hibernate.dao.impl;


import org.mel.hibernate.dao.ICarIDao;
import org.mel.hibernate.model.CarEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@ContextConfiguration(locations = {"/application-context.xml"})
public class TestCarDao extends AbstractTestNGSpringContextTests {

    private Logger logger = Logger.getLogger("myLog");

    @Inject
    private ICarIDao carDao;

    //Test Car1 properties
    private String car1Company = "Ford";
    private String car1Model ="Focus";
    private Long car1Price = 20000L;

    // Test Car2 properties
    private String car2Company = "Ford";
    private String car2Model ="Mustang";
    private Long car2Price = 35000L;


    @Test
    @Transactional
    public void testInsert() {

        Assert.assertNotNull(carDao.getEntityManager());

        // Insert first Car
        CarEntity car1 = new CarEntity();
        car1.setCompany(car1Company);
        car1.setModel(car1Model);
        car1.setPrice(car1Price);

        carDao.save(car1);

        Assert.assertEquals(car1.getId().intValue(), 1);

        // Insert second car
        CarEntity car2 = new CarEntity();
        car2.setCompany(car2Company);
        car2.setModel(car2Model);
        car2.setPrice(car2Price);

        carDao.save(car2);

        Assert.assertEquals(car2.getId().intValue(), 2);
    }

    @Test(dependsOnMethods="testInsert")
    @Transactional
    public void getById() {
        CarEntity car1 = carDao.getById(1L);

        Assert.assertEquals(car1.getId().intValue(), 1);
        Assert.assertEquals(car1.getModel(), car1Model);

        CarEntity car2 = carDao.getById(2L);

        Assert.assertEquals(car2.getId().intValue(), 2);
        Assert.assertEquals(car2.getModel(), car2Model);


    }

    @Test(dependsOnMethods="getById")
    @Transactional
    public void listCarsTest() {
        List<CarEntity> cars = carDao.findCarByCompany(car1Company);
        logger.info("Cars: " + cars.size());
        Assert.assertEquals(cars.size(), 2);

    }

    @Test(dependsOnMethods="listCarsTest")
    @Transactional
    public void updateTest() {

        CarEntity car2 = carDao.getById(2L);

        Long newPrice = 1L;

        // Update car2 with new price
        car2.setPrice(newPrice);
        carDao.update(car2);

        Assert.assertEquals(car2.getPrice(), newPrice);

    }

    @Test(dependsOnMethods="updateTest")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void removeTest() {

        // Remove car2
        CarEntity car = carDao.getById(2L);
        carDao.remove(car);
    }

}
