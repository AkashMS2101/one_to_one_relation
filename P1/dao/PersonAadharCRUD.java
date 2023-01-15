package one_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni.dto.AadharCard;
import one_to_one_uni.dto.PersonAdhc;

public class PersonAadharCRUD {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void savePersonAadhar(PersonAdhc adhc) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(adhc);
		entityManager.persist(adhc.getAadharCard());
		entityTransaction.commit();
		System.out.println("data saved");
	}

	public void updatePersonAadhar(int id, String name) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PersonAdhc adhc2 = entityManager.find(PersonAdhc.class, id);
		adhc2.setName(name);
		entityTransaction.begin();
		entityManager.merge(adhc2);
		entityManager.merge(adhc2.getAadharCard());
		entityTransaction.commit();
		System.out.println("data saved");

	}

	public void deletePersonAadhar(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonAdhc adhc = entityManager.find(PersonAdhc.class, id);
		entityTransaction.begin();
		entityManager.remove(adhc);
		entityTransaction.commit();
		System.out.println("deleted");
	}

	public void displayPersonAadharById(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonAdhc adhc = entityManager.find(PersonAdhc.class, id);
		System.out.println(adhc);
	}

	public void displayAllPersonAadhar() {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("Select ad from PersonAdhc ad");

		List<PersonAdhc> list = query.getResultList();

		System.out.println(list);
	}
}
