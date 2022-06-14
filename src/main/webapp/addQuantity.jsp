<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% String menuId=request.getParameter("id");
    session.setAttribute("menuid", menuId);
    %>
    <form action="order">
   Add Quantity : <input type="number" name="quantity"> <br> <br>
   <input type="submit" name="add">
   
   </form>

</body>
</html>