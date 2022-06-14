<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="3px" cellpadding=20px>
       <tr>
       <th>Id</th>
       <th>Name</th>
       <th>Description</th>
       <th>Cost</th>
       <th>Type</th>
       <th>Offer</th>
       <th>Image</th>
       <th>Edit</th>
       <th>Delete</th>
       </tr>
       <c:forEach var="menu" items="${menus}">
         <tr>
         <td>${menu.getId()}</td>
         <td>${menu.getName()}</td>
         <td>${menu.getDescription()}</td>
         <td>${menu.getCost()}</td>
         <td>${menu.getType()}</td>
         <td>${menu.getOffer()}</td>
         <td>${menu.getImage()}</td>
         <td><a href="editmenu?id=${menu.getId()}">edit</a></td>
         <td><a href="deletemenu?id=${menu.getId()}">delete</a></td>
         </tr>
       
       </c:forEach>
    
    </table>
</body>
</html>