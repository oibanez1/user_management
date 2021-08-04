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
        Title goes here
    </div>
    <div id="formContainer">
        <form id="formC">
            <div class="rows">
                <div class="column">
                    <label class="theLabels" for="name">
                        UserName:
                    </label>
                    <input class="theInputs" type="text" id="name"/>
                </div>
                <div class="column">
                    <label class="theLabels" for="email">
                        Email:
                    </label>
                    <input class="theInputs" type="text" id="form"/>
                </div>
                <div class="column">
                    <label class="theLabels" for="country">
                        Country:
                    </label>
                    <input class="theInputs" type="text" id="country"/>
                </div>
                <div class="column">
                    <label class="theLabels" for="age">
                        Age:
                    </label>
                    <input class="theInputs" type="number" id="age"/>
                </div>
            </div>
            <div class="save">
                <button>Save</button>
            </div>
        </form>
    </div>
</body>
</html>