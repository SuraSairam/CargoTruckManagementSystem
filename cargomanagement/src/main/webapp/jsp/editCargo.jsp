<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="update" modelAttribute="crg">
 <form:hidden path="cid"/>
 CargoName : <form:input path="cname"/><br><br>

Email  : <form:input path="cmail"/><br><br>

PhoneNumber    : <form:input path="cphone"/> <br><br>

Address    : <form:input path="caddress"/> <br><br>

<input type="submit" value="EditCargo">



</form:form>


<a href="viewAll">ViewAllCargos </a>

</body>
</html>
