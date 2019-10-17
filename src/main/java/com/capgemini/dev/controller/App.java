package com.capgemini.dev.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.capgemini.dev.One.to.One.Address;
import com.capgemini.dev.One.to.One.Person_OneToOneUnidirectional;
import com.capgemini.dev.util.JPAUtils;

public class App {
	public static void main(String[] args) {

		Person_OneToOneUnidirectional p = new Person_OneToOneUnidirectional();
		p.setName("Jayaprakash");
		p.setAge(21);
		p.setId(1);

		Address address = new Address();
		address.setCity("Berampur");
		address.setPin(760001);
		address.setState("Odisa");
		address.setAddress_id(100);
		p.setAddress(address);

		EntityManagerFactory emf = JPAUtils.geEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		p = em.find(Person_OneToOneUnidirectional.class, 1);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		emf.close();

		/*
		 * DogDAO dao = new DogJPAImpl(); Dog d = new Dog(); d.setBreed("RoteWeiller");
		 * d.setColor("Brown"); d.setDogId(1); d.setName("Tommy");
		 * dao.createDogProfile(d);
		 */

		/*
		 * MovieDAO dao = new HibernateImpl(); boolean m = dao.updateRatings(3, 9);
		 * System.out.println(m);
		 */

		// TO retrive the data from DB -->
		/*
		 * Movie m = dao.searchById(4); System.out.println(m);
		 */

		// TO Update the DB -->
		/*
		 * Movie m = new Movie(); m.setMovieId(7); m.setName("Arjun Reddy");
		 * m.setDescription("$ i am in love with the movie $"); m.setRating(10);
		 * dao.createMovie(m); System.out.println("Added");
		 */

		// Simply printing the HashCodes of Object created -->
		/*
		 * System.out.println(JPAUtils.geEntityManagerFactory().hashCode());
		 * System.out.println(JPAUtils.geEntityManagerFactory().hashCode());
		 * System.out.println(JPAUtils.geEntityManagerFactory().hashCode());
		 */
		/*
		 * how many times if we call the geEntityManagerFactory() it will return the
		 * same Object (Singletone)
		 */

		/*
		 * boolean result = dao.deleteMovie(4); if (result) {
		 * System.out.println("Record Deleted..."); } else {
		 * System.out.println("Record is not present!!!"); }
		 */
	}
}
