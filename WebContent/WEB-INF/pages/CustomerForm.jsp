<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<h3>Add New Customer</h3>
<body>
<c:url var="addAction" value="/saveCustomer" />

<form:form action="${addAction}" modelAttribute="Customer">
<table>
<tr><th>Name :</th><td><input type="text" name="name" value="${Customer.name}"/></td></tr>
<tr><th>Email :</th><td><input type="text" name="email" value="${Customer.email}"/></td></tr>
<tr><th>Address :</th><td><input type="text" name="address" value="${Customer.address}"/></td></tr>
<tr><th>telephone :</th><td><input type="text" name="telephone" value="${Customer.telephone}"/></td></tr>
<tr><th><input type="submit" value="Add" /></th></tr>
</table>
</form:form>
</body>
</html>