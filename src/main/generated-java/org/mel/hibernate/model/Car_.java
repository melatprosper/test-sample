package org.mel.hibernate.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CarEntity.class)
public abstract class Car_ {

	public static volatile SingularAttribute<CarEntity, Long> price;
	public static volatile SingularAttribute<CarEntity, String> company;
	public static volatile SingularAttribute<CarEntity, String> model;
	public static volatile SingularAttribute<CarEntity, Long> id;

}

