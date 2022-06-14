package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.FoodItem;
import com.ty.dto.FoodOrder;

@Component
public class FoodOrderdao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(foodOrder);
//		for(FoodItem foodItem :foodOrder.getFoodItem())
//		{
//			entityManager.persist(foodItem);
//		}
		entityTransaction.commit();
		return foodOrder;
	}
	
	public FoodOrder getOrderById(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class, id);
		return foodOrder;
	}
	
	public boolean cancelOrderById(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class, id);
		if(foodOrder!=null)
		{
			entityTransaction.begin();
			for(FoodItem foodItem :foodOrder.getFoodItem())
			{
				entityManager.remove(foodItem);
			}
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void updateOrderById(FoodItem foodItem)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		FoodItem foodItem2=entityManager.find(FoodItem.class, foodItem.getId());
		foodItem.setFoodOrder(foodItem2.getFoodOrder());
		if(foodItem2!=null)
		{
		entityTransaction.begin();
		entityManager.merge(foodItem);
		entityTransaction.commit();
		System.out.println("Order Updated");
		}
		else
		{
			System.out.println("No such Order id present");
		}
		
	}
	public void setTotal(double total,int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class,id);
		foodOrder.setTotal(total);
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
	}
	public FoodItem saveFoodItem(FoodItem foodItem) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodItem);
		entityTransaction.commit();
		return foodItem;
	}
	
}
