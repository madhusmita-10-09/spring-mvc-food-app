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

    <form:form action="updatemenu" modelAttribute="edit">
    Id : <form:input path="id" readonly="true"/> <br>
    Name : <form:input path="name"/> <br>
    Description : <form:input path="description"/> <br>
    Cost : <form:input path="cost"/> <br>
    Type : <form:input path="type"/> <br>
    Offer : <form:input path="offer"/> <br>
    Image : <form:input path="image"/> <br> 
    <form:button>Save</form:button>
    </form:form>

</body>
</html>