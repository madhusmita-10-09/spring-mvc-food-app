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

    <form:form action="savetax" modelAttribute="loadtax1">
    CGST : <form:input path="cgst"/> <br>
    Discount : <form:input path="discount"/> <br>
    IGST : <form:input path="igst"/> <br>
    <form:button>save</form:button>
    </form:form>

</body>
</html>