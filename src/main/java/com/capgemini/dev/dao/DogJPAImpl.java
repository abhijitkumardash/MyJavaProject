package com.capgemini.dev.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.capgemini.dev.beans.Dog;
import com.capgemini.dev.util.JPAUtils;

public class DogJPAImpl implements DogDAO 
{
		EntityManagerFactory emf = JPAUtils.geEntityManagerFactory();
		
		public void createDogProfile(Dog d) 
		{
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unused")
			boolean state = false;
			em.getTransaction().begin();
			em.persist(d);
			state = true ;
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
}