<%@page import="java.util.List"%>
<%@page import="com.ty.dto.FoodItem"%>
<%@page import="com.ty.dto.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%FoodOrder foodOrder=(FoodOrder)session.getAttribute("httpfoodOrder"); %>
	<h1>Food Order Id :</h1>
	<%=foodOrder.getId() %>
	<h1>Name :</h1>
	<%=foodOrder.getName() %>
	<h1>Phone :</h1>
	<%=foodOrder.getPhone() %> <br>

	<c:forEach var="b" items="${bill}">
         
         ${b}
       
       </c:forEach>

</body>
</html>