package com.ty.one_to_one_uni2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.ty.one_to_one_uni2.dto.PersonPc;

public class PersonPcCRUD {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(PersonPc pc) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(pc);
		entityManager.persist(pc.getCard());
		entityTransaction.commit();
		System.out.println("saved succesfully");
	}
	
	public void updatePersonPc(int id,String name) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PersonPc pc = entityManager.find(PersonPc.class, id);
		pc.setPerson_name(name);
		entityTransaction.begin();
		entityManager.merge(pc);
		entityManager.merge(pc.getCard());
		entityTransaction.commit();
		System.out.println("data updated");
	}
	
	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PersonPc pc = entityManager.find(PersonPc.class, id);
		entityTransaction.begin();
		entityManager.remove(pc);
		entityTransaction.commit();
		System.out.println("deleted");
	}
	
	public void displayPersonPcById(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PersonPc pc = entityManager.find(PersonPc.class, id);
		System.out.println(pc);
	}

	public void displayAllPersonPc() {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("Select apc from PersonPc apc");
		List<PersonPc> list = query.getResultList();
		System.out.println(list);
	}
}

























