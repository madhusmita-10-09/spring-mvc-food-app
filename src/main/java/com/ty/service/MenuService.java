package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.Menudao;
import com.ty.dto.Menu;
@Component
public class MenuService {
	@Autowired
	Menudao menuDao;
	
	public Menu saveMenu(Menu menu)
	{
		return menuDao.saveMenu(menu);
	}
	
	public Menu getMenuById(int id)
	{
		return menuDao.getMenuById(id);
	}
	
	public List<Menu> getAllMenu()
	{
		return menuDao.getAllMenu();
	}
	
	public  boolean deleteMenu(int id)
	{
		return menuDao.deleteMenu(id);
	}
	public Menu updateMenuById(int id,Menu menu)
	{
		return menuDao.updateMenuById(id, menu);
	}

}
