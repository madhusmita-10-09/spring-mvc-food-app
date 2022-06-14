package com.ty.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.User;

@Component
public class Userdao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public User saveUser(User user)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return entityManager.find(User.class,user.getId());
	}
	
	public User getUserById(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		return entityManager.find(User.class,id);
		
	}
	
	public List<User> getAllUser()
	{
		//List<User> list=new ArrayList<User>();
		EntityManager entityManager=entityManagerFactory.createEntityManager();
        String sql="SELECT u FROM User u";
        Query query=entityManager.createQuery(sql);
        List<User> list=query.getResultList();
        return list;
	}
	
	public List<User> validateUser(String email,String password)
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String sql="SELECT u FROM User u WHERE u.email=?1 AND u.password=?2";
		
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
	    List<User> list=query.getResultList();
		return list;
	}
	
	public boolean deleteUser(int id)
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		User user=entityManager.find(User.class,id);
		if(user!=null)
		{
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}		
	}
	public User updateUserById(int id,User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return entityManager.find(User.class, id);
		
	}

}
