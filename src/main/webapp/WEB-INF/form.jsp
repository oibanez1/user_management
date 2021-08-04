<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>
    <div class="topNav">
        <a href="">Users</a>
    </div>
    <br>
    <div class="title">
        <c:if test="${selectedUser != null}">
            Edit User
        </c:if>
        <c:if test="${selectedUser == null}">
            Add User
        </c:if>
    </div>
    <div id="formContainer">
        <c:if test="${selectedUser != null}">
            <form action="update" id="formC" method="POST">
        </c:if>
        <c:if test="${selectedUser == null}">
            <form action="add"id="formC" method="POST">
        </c:if>
            <div class="rows">
                <c:if test="${selectedUser != null}">
                    <input type="hidden" name="id" value="<c:out value='${selectedUser.getId()}'/>" />
                </c:if>
                <div class="column">
                    <label class="theLabels" for="name">
                        UserName:
                    </label>
                    <input class="theInputs" type="text" name="name" value="<c:out value='${selectedUser.getUserName()}'/>"/>
                </div>
                <div class="column">
                    <label class="theLabels" for="email">
                        Email:
                    </label>
                    <input class="theInputs" type="text" name="email" value="<c:out value='${selectedUser.getEmail()}'/>"/>
                </div>
                <div class="column">
                    <label class="theLabels" for="country">
                        Country:
                    </label>
                    <input class="theInputs" type="text" name="country" value="<c:out value='${selectedUser.getCountry()}'/>"/>
                </div>
                <div class="column">
                    <label class="theLabels" for="age">
                        Age:
                    </label>
                    <input class="theInputs" type="text" name="age" value="<c:out value='${selectedUser.getAge()}'/>"/>
                </div>
            </div>
            <div class="save">
                <button type="submit">Save</button>
            </div>
        </form>
    </div>
</body>
</html>