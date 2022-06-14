package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.Menu;
@Component
public class Menudao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public Menu saveMenu(Menu menu)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return entityManager.find(Menu.class,menu.getId());
		
		
	}
	
	public Menu getMenuById(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Menu menu2=entityManager.find(Menu.class,id);
		return menu2;
	}
	
	public List<Menu> getAllMenu()
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//Menu menu2=entityManager.find(Menu.class,id);
		String sql="select m from Menu m";
		Query query=entityManager.createQuery(sql);
        List<Menu> list=query.getResultList();
        return list;
	}
	
	public boolean deleteMenu(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Menu menu2=entityManager.find(Menu.class,id);
		if(menu2!=null)
		{
			entityTransaction.begin();
			entityManager.remove(menu2);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public Menu updateMenuById(int id,Menu menu)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
		return entityManager.find(Menu.class, id);
	}
	

}
