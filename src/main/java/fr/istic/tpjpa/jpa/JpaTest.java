package fr.istic.tpjpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		test.createFoyer();
		
		tx.commit();

		// TODO run request

		System.out.println(".. done");
	}
	
	public void createFoyer(){
		// TODO create entity
		Person pauline= new Person("Le Verge","Pauline","F","26/01/1992","pauline.leverge@facebook.com");
		Person corinne= new Person("Bechepois","Corinne","F","18/12/1991","corinne.bechepois@facebook.com");
		Home h1=new Home("33 avenue du professeur Charles Fumont",30,"100.7.0",pauline);
		Home h2=new Home("116 rue d'Antrain",50,"100.8.0",corinne);
		Heater he1=new Heater((long)100,h1);
		Heater he2=new Heater((long)150,h1);
		Heater he3=new Heater((long)135,h2);
		ElectronicDevice elDev1=new ElectronicDevice((long)123,pauline);
		ElectronicDevice elDev2=new ElectronicDevice((long)111,corinne);
		ElectronicDevice elDev3=new ElectronicDevice((long)143,corinne);
		
		// TODO persist entity
		manager.persist(pauline);
		manager.persist(corinne);
		manager.persist(h1);
		manager.persist(h2);
		manager.persist(he1);
		manager.persist(he2);
		manager.persist(he3);
		manager.persist(elDev1);
		manager.persist(elDev2);
		manager.persist(elDev3);
		
		pauline.addHome(h1);
		corinne.addHome(h2);
		pauline.addFriend(corinne);
		corinne.addFriend(pauline);
		h1.addHeater(he1);
		h1.addHeater(he2);
		h2.addHeater(he3);
		pauline.addElectronicDevice(elDev1);
		corinne.addElectronicDevice(elDev2);
		corinne.addElectronicDevice(elDev3);
	}
}
