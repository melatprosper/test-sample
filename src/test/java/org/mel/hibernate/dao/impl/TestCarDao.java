package org.mel.hibernate.dao.impl;


import org.mel.hibernate.model.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.logging.Logger;

@ContextConfiguration(locations = {"/application-context.xml"})
public class TestCarDao extends AbstractTestNGSpringContextTests {

    private Logger logger = Logger.getLogger("myLog");

    @Autowired
    private CarDao carDao;

    private Long id;
    private String company = "Ford";
    private String model ="Focus";
    private long price = 25000;

    @BeforeTest
    public void init() {
       // Integer carNumber = carDao.getCars().size();
        id = 1L;
    }

    /* @Test
    public void listCarsTest() {
        List<CarEntity> cars = carDao.getCars();
        logger.info("Cars: " + cars.size());
        Assert.assertNotNull(cars);
        Assert.assertEquals(15, cars.size());
    }
*/

    @Test
    @Transactional
    public void testInsert() {

        Assert.assertNotNull(carDao.getEntityManager());

        CarEntity car = new CarEntity();
        car.setCompany(company);
        car.setModel(model);
        car.setPrice(price);

        carDao.save(car);
        Assert.assertEquals(id, car.getId());
    }

    @Test(dependsOnMethods="testInsert")
    @Transactional
    public void getById() {
        CarEntity car = carDao.getById(id);

        Assert.assertEquals(id, car.getId());
        Assert.assertEquals(model, car.getModel());
    }
}
