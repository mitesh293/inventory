<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="/Inventory/resources/styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <title>Customer List</title>
</head>
<body>${mainCss}
<div id='cssmenu'>
<ul>
   <li class='active'><a href='#'><span>Home</span></a></li>
   <li><a href='#'><span>Products</span></a></li>
   <li><a href='#'><span>Company</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div>
    <div align="center">
        <h1>Customer List</h1>
        <h3>
            <a href="newCustomer">New Customer</a>
        </h3>
        <table border="1">
 
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Action</th>
 
            <c:forEach var="Customer" items="${listCustomer}">
                <tr>
 
                    <td>${Customer.name}</td>
                    <td>${Customer.email}</td>
                    <td>${Customer.address}</td>
                    <td>${Customer.telephone}</td>
                    <td><a href="editCustomer?id=${Customer.id}">Edit</a>
                             <a
                        href="deleteCustomer?id=${Customer.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>