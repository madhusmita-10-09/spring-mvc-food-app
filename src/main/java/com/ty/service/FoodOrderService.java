package com.ty.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.FoodOrderdao;
import com.ty.dao.Taxdao;
import com.ty.dto.FoodItem;
import com.ty.dto.FoodOrder;
import com.ty.dto.Tax;

@Component
public class FoodOrderService {
	@Autowired
	FoodOrderdao foodOrderdao;
	@Autowired
	Taxdao taxdao;
	public FoodOrder saveFoodOrder(FoodOrder foodOrder)
	{
		return foodOrderdao.saveFoodOrder(foodOrder);
	}
	public FoodOrder getOrderById(int id)
	{
		return foodOrderdao.getOrderById(id);
	}
	public FoodItem saveFoodItem(FoodItem foodItem) {
		return foodOrderdao.saveFoodItem(foodItem);
	}
	public void saveTax(Tax tax)
	{
		taxdao.saveTax(tax);
	}
	public Tax getTax()
	{
		return taxdao.getTax();
	}
	
	
	public List<Double> bill(int id)
	{
		List<Double> list=new ArrayList();
		double total=0;
		FoodOrder foodOrder=foodOrderdao.getOrderById(id);
		for(FoodItem foodItems:foodOrder.getFoodItem())
		{
			total=total+foodItems.getCost()*foodItems.getQuantity();
		}
		//sgst
		Tax tax1=taxdao.getTax();
		double sgst=total*tax1.getIgst()/100;
		double cgst=total*tax1.getCgst()/100;
		total=total+cgst+sgst;
		//discount
		if(total>500)
		{
			total=(1-tax1.getDiscount()/100)*total;
			
			foodOrderdao.setTotal(total, id);
		}
		list.add(cgst);
		list.add(sgst);
		list.add(total);
		//list.add(foodOrder);
		return list;
	}
	
	

}



