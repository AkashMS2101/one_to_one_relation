package com.ty.one_to_one_uni2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.one_to_one_uni2.dto.PanCard;
import com.ty.one_to_one_uni2.dto.PersonPc;

public class PancardCRUD {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}
	
	public void updatePanCard(int id,String name) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard pc = entityManager.find(PanCard.class, id);
		pc.setName(name);
		entityTransaction.begin();
		entityManager.merge(pc);
		entityTransaction.commit();
		System.out.println("data updated");
	}
	
	public void deletePanCard(int id) {
		PersonPcCRUD crud = new PersonPcCRUD();
		crud.deletePerson(id);
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PanCard pc = entityManager.find(PanCard.class, id);
		entityTransaction.begin();
		entityManager.remove(pc);
		entityTransaction.commit();
		System.out.println("deleted");
	}
}
