package com.capgemini.dev.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.capgemini.dev.beans.Movie;

public class HibernateImpl implements MovieDAO 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
	
	public boolean createMovie(Movie m) 
	{
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		//Transaction begins here using EntityManager & EntityTransaction Object
		em.getTransaction().begin();
		boolean state = false;
		try 
		{
			em.persist(m);
			state = true;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
		return state;
	}

	public boolean deleteMovie(int movieId) 
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		//1st Retrival operation done to check the RECORD is PRESENT or NOT
		Movie m = em.find(Movie.class, movieId );
		//Transaction begins here using EntityTransaction Object
		transaction.begin();
		boolean state = false;
		try 
		{
			//used remova() to delete the record
			em.remove(m);
			state = true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			state = false;
		}
		//Transaction has to be closed !!!
		transaction.commit();
		//EntityManager has to be closed !!!
		em.close();
		return state;
	}

	public boolean updateRatings(int movieId, int rating)
	{
		EntityManager em = emf.createEntityManager();
		boolean state = false;
		try 
		{
			em.getTransaction().begin();
			Movie m = em.find(Movie.class, movieId);
			m.setRating(rating);
			em.getTransaction().commit();
			state = true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		return state;
	}

	public Movie searchById(int id) 
	{
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		//used find() for the Retrival operation
		Movie m = em.find(Movie.class, id);
		em.close();
		emf.close();
		return m;
	}
}