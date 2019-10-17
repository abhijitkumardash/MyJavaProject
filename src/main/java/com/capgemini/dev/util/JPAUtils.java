package com.capgemini.dev.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils 
{
	
	//private Constructor
	private JPAUtils ( ) { }
	
	//private,static & final "ref variable" of EntityManagerFactory
	private static final EntityManagerFactory emf = getEMF();
	
	//Declare a private,static method to create EMF object
	private static EntityManagerFactory getEMF()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		return emf;
	}
	
	//Declare another public,static method to return the EMF Object 
	public static EntityManagerFactory geEntityManagerFactory()
	{
		return emf;
	}
	
}
