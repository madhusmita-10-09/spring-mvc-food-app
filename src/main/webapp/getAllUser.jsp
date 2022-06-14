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
       <th>Email</th>
       <th>Phone</th>
       <th>Edit</th>
       <th>Delete</th>
       </tr>
       <c:forEach var="std" items="${getallusers}">
         <tr>
         <td>${std.getId()}</td>
         <td>${std.getName()}</td>
         <td>${std.getEmail()}</td>
         <td>${std.getPhone()}</td>
         <td><a href="edituser?id=${std.getId()}">edit</a></td>
         <td><a href="deleteuser?id=${std.getId()}">delete</a></td>
         </tr>
       
       </c:forEach>
    
    </table>
    

</body>
</html>