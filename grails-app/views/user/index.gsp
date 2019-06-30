<%--
  Created by IntelliJ IDEA.
  User: lucafornelli
  Date: 2019-06-27
  Time: 09:58
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
    <style type="text/css">
        label{
            float: left;
            width: 65px;
        }

    </style>
</head>

<body>
    <div class="container">
        <h1>Login</h1>
        <g:if test="${flash.message}">
            <div class="message">
                ${flash.message}
            </div>
        </g:if>
        <g:if test="${session.user}">
            <br />
            Login as: ${session.user} | <g:link action="logout">Logout</g:link>
        </g:if>
        <g:else>
            <g:form action="login">
                <div style="width: 220px;">
                    <label style="display: none">Fullname:</label> <input type="text" name="fullname" style="display: none">
                    <label>Username:</label> <input type="text" name="username">
                    <label>Password:</label> <input type="password" name="password">
                    <br><input type="submit" name="login" style="margin-top: 20px" class="btn-info">
                    <g:actionSubmit name="create" value="create" action="create" class="btn-info"></g:actionSubmit>
                    <!-- <input type="submit" name="create" style="margin-top: 20px" class="btn-info" value="register"> -->
                </div>
            </g:form>
        </g:else>
    </div>
</body>
</html>