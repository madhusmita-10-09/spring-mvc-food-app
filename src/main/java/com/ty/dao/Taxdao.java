package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.Tax;

@Component
public class Taxdao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public void saveTax(Tax tax)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(tax);
		entityTransaction.commit();
	}
	public Tax getTax()
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Tax tax=entityManager.find(Tax.class,1);
		return tax;
	}

}

