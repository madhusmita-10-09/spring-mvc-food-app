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

    <form:form action="saveuser" modelAttribute="user">
    Name : <form:input path="name"/> <br>
    Email : <form:input path="email"/> <br>
    Phone : <form:input path="phone"/> <br>
    Password : <form:input path="password"/> <br>
    <form:button>Register</form:button>
    </form:form>

</body>
</html>