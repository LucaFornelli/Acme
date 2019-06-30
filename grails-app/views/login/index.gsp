<%--
  Created by IntelliJ IDEA.
  User: lucafornelli
  Date: 2019-06-26
  Time: 15:54
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'temp.label', default: 'Login')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hello;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>
<div id="create-user" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    <div class="message" role="status">${flash.message}</div>
    <g:form resource="${this.user}" method="POST">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:actionSubmit action="login" class="enter-icon" value="${message(code: 'default.login.label', default: 'Create')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
