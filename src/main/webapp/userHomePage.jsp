<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%if(session.getAttribute("httpuser")!=null){ %>
   <h1 style="font-size: 60px">Welcome to HomePage: ${msg} </h1> <br> <br>
   <a href="loaduser" style="font-size: 40px">To save One more user</a> <br> <br> 
   <a href="getalluser" style="font-size: 40px">Get All user</a> <br> <br>
   <a href="loadmenu" style="font-size: 40px">To add item in menu</a> <br> <br>
   <a href="getallmenu" style="font-size: 40px">view menu for edit delete</a> <br> <br>
   <a href="loadfoodOrder" style="font-size: 40px">orderFood</a> <br> <br>
   <a href="loadtax" style="font-size: 40px">Load Tax</a>
   <%}else{
		response.sendRedirect("adminhomepage.jsp");
	} %>
   
</body>
</html>