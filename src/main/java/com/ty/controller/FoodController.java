package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dto.FoodItem;
import com.ty.dto.FoodOrder;
import com.ty.dto.Menu;
import com.ty.dto.Tax;
import com.ty.dto.User;
import com.ty.service.FoodOrderService;
import com.ty.service.MenuService;
import com.ty.service.UserService;

@Controller
public class FoodController {
	@Autowired
	MenuService menuService;
	@Autowired
	UserService userService;
	@Autowired
	FoodOrderService foodOrderService;
	
	
	@RequestMapping("/loaduser")
	public ModelAndView loadUser() {
		ModelAndView mv=new ModelAndView("createuser.jsp");
		mv.addObject("user", new User());
		return mv;
	}
	@PostMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute User user)
	{
		userService.saveUser(user);
		ModelAndView modelAndView=new ModelAndView("userHomePage.jsp");
		modelAndView.addObject("msg", user.getName()+" saved");
		return modelAndView;
	}
	@GetMapping("/getalluser")
	public ModelAndView getAllUser() {
		ModelAndView modelAndView=new ModelAndView("getAllUser.jsp");
		modelAndView.addObject("getallusers", userService.getAllUser());
		return modelAndView;
	}
	
	
	@GetMapping("/edituser")
	public ModelAndView editUser(@RequestParam(name="id") int id,ModelAndView modelAndView) {
		User user=userService.getUserById(id);
		modelAndView.setViewName("editUser.jsp");
		modelAndView.addObject("edit", user);
		return modelAndView;
	}
	@PostMapping("/updateuser")
	public ModelAndView updateUser(@ModelAttribute User user) {
		userService.updateUserById(user.getId(), user);
		ModelAndView modelAndView=new ModelAndView("getAllUser.jsp");
		modelAndView.addObject("getallusers", userService.getAllUser());
		return modelAndView;
	}
	@GetMapping("/deleteuser")
	public ModelAndView deleteStudent(@RequestParam(name = "id") int id,ModelAndView mv)
	{
		userService.deleteUser(id);
		mv.setViewName("getAllUser.jsp");
		mv.addObject("getallusers", userService.getAllUser());
		return mv;
	}
	
	@RequestMapping("/loadforvalidation")
	public ModelAndView loadToValidateUser()
	{
		ModelAndView mv=new ModelAndView("userLogin.jsp");
		mv.addObject("user", new User());
		return mv;	
	}
	@PostMapping("/validateUser")
	public ModelAndView validateUser(@ModelAttribute User user,HttpServletRequest req) {
		ModelAndView modelAndView=new ModelAndView();
		List<User> user2=userService.validateUser(user.getEmail(), user.getPassword());
		if(user2.size()>0) {
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("httpuser", user2.get(0));
			modelAndView.setViewName("userHomePage.jsp");
		    modelAndView.addObject("menus", "Welcome To Home Page");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("invalid.jsp");
			modelAndView.addObject("invalid","Invalid Email id or password");
			return modelAndView;
		}
		
	}
	
	@RequestMapping("/loadmenu")
	public ModelAndView loadMenu()
	{
		ModelAndView modelAndView=new ModelAndView("createMenu.jsp");
		modelAndView.addObject("menu", new Menu());
		return modelAndView;
		
	}
	@PostMapping("/savemenu")
	public ModelAndView saveMenu(@ModelAttribute Menu menu)
	{
		menuService.saveMenu(menu);
		ModelAndView modelAndView=new ModelAndView("menuHomePage.jsp");
		modelAndView.addObject("msg", menu.getName()+" item saved");
		return modelAndView;
		
	}
	
	@GetMapping("/getallmenu")
	public ModelAndView getAllMenu() {
		ModelAndView modelAndView = new ModelAndView("getallmenu.jsp");
		modelAndView.addObject("menus", menuService.getAllMenu());
		return modelAndView;
	}
	
	@GetMapping("/editmenu")
	public ModelAndView editMenu(@RequestParam(name="id") int id,ModelAndView modelAndView) {
		Menu menu=menuService.getMenuById(id);
		modelAndView.setViewName("editMenu.jsp");
		modelAndView.addObject("edit", menu);
		return modelAndView;
	}
	@PostMapping("/updatemenu")
	public ModelAndView updateMenu(@ModelAttribute Menu menu) {
	    menuService.updateMenuById(menu.getId(), menu);
		ModelAndView modelAndView = new ModelAndView("getallmenu.jsp");
		modelAndView.addObject("menus", menuService.getAllMenu());
		return modelAndView;
		
	}
	@GetMapping("/deletemenu")
	public ModelAndView deleteMenu(@RequestParam(name="id") int id) {
		menuService.deleteMenu(id);
		ModelAndView modelAndView = new ModelAndView("getallmenu.jsp");
		modelAndView.addObject("menus", menuService.getAllMenu());
		return modelAndView;
		
	}
	
	@RequestMapping("/loadfoodOrder")
	public ModelAndView loadFoodOrder() {
		ModelAndView modelAndView=new ModelAndView("customer.jsp");
	    modelAndView.addObject("loadfoodOrder1", new FoodOrder());
	    return modelAndView;
	}
	@PostMapping("/saveFoodOrder")
	public ModelAndView saveFoodOrder(@ModelAttribute FoodOrder foodOrder,HttpServletRequest req)
	{
		ModelAndView modelAndView=new ModelAndView();
		FoodOrder foodOrder2=foodOrderService.saveFoodOrder(foodOrder);
		if(foodOrder2!=null)
		{
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("httpfoodOrder", foodOrder2);
			modelAndView.setViewName("getallmenu2.jsp");
			modelAndView.addObject("menus", menuService.getAllMenu());
			return modelAndView;
		}
		else {
			return null;
		}
	}
	
	
	@GetMapping("/order")
	public ModelAndView saveItem(HttpServletRequest req)
	{
		HttpSession httpSession=req.getSession();
		//int id=Integer.parseInt((String)httpSession.getAttribute("AccHolderId"));
		int id=Integer.parseInt((String)httpSession.getAttribute("menuid"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		//HttpSession httpSession2=req.getSession();
		//httpSession2.setAttribute("listofitem",new ArrayList<FoodItem>());
		ModelAndView modelAndView=new ModelAndView();
		Menu menu=menuService.getMenuById(id);
		FoodItem foodItem=new FoodItem();
		foodItem.setName(menu.getName());
		foodItem.setQuantity(quantity);
		foodItem.setCost(menu.getCost());
		HttpSession httpSession1=req.getSession();
		FoodOrder foodOrder=(FoodOrder)httpSession1.getAttribute("httpfoodOrder");
		foodItem.setFoodOrder(foodOrder);
		FoodItem foodItem2=foodOrderService.saveFoodItem(foodItem);
		if(foodItem2!=null) {
			modelAndView.setViewName("getallmenu2.jsp");
			modelAndView.addObject("menus", menuService.getAllMenu());
			return modelAndView;
		}
		else {
			return null;
		}
	}
	
	
	@RequestMapping("/loadtax")
	public ModelAndView loadTax() {
		ModelAndView modelAndView=new ModelAndView("savetax.jsp");
	    modelAndView.addObject("loadtax1", new Tax());
	    return modelAndView;
		
	}
	
	@PostMapping("/savetax")
	public ModelAndView saveTax(@ModelAttribute Tax tax) {
		ModelAndView modelAndView=new ModelAndView();
		foodOrderService.saveTax(tax);
		modelAndView.setViewName("userHomePage.jsp");
	    modelAndView.addObject("menus", "Welcome To Home Page");
		return modelAndView;
		
		
	}
//	@GetMapping("/billi")
//	public ModelAndView generateFoodOrderBill(HttpServletRequest req)
//	{
//		HttpSession httpSession=req.getSession();
//		FoodOrder foodOrder=(FoodOrder)httpSession.getAttribute("httpfoodOrder");
//		
//	}
	
	@GetMapping("/billgenerate")
	public ModelAndView generateBill(HttpServletRequest req)
	{
		HttpSession httpSession=req.getSession();
		FoodOrder foodOrder=(FoodOrder)httpSession.getAttribute("httpfoodOrder");
		List<Double> price=foodOrderService.bill(foodOrder.getId());
		ModelAndView modelAndView=new ModelAndView("generatebill.jsp");
		modelAndView.addObject("bill", price);
		return modelAndView;
	}
	
		

}
