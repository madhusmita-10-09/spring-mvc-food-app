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
    <form:form action="saveFoodOrder" modelAttribute="loadfoodOrder1">
    Name : <form:input path="name"/> <br>
    Phone : <form:input path="phone"/> <br>
    <form:button>Register</form:button>
    </form:form>

</body>
</html>