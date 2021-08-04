<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/users.css"/>
</head>
<body>
    <div class="topNav">
        <a href="">Users</a>
        <button class="add">Add User</button>
    </div>
    <br>
    <table>
        <tr>
            <th>Id</th>
            <th>UserName</th>
            <th>Email</th>
            <th>Country</th>
            <th>Age</th>
            <th>Edit</th>
        </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                <td> <c:out value="${user.getId()}" /> </td>
                <td> <c:out value="${user.getUserName()}" /> </td>
                <td> <c:out value="${user.getEmail()}" /> </td>
                <td> <c:out value="${user.getCountry()}" /> </td>
                <td> <c:out value="${user.getAge()}" /> </td>
                <td><a href="">Update</a> &nbsp; &nbsp;<a href="">Delete</a></td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>