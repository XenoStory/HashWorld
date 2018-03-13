package com.lei.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton 
{
	private static EntityManagerFactory factory;
	
	private EntityManagerFactorySingleton() {}
	
	public static EntityManagerFactory getInstance()
	{
		if(factory == null)
		{
			factory = Persistence.createEntityManagerFactory("2tdsa");
		}
		return factory;
	}
}