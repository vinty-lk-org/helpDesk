<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'ru_RU'}"/>
<fmt:setBundle basename="translations"/>



<html>
<head>
    <title>HelpDesk</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>

<p align="center"><a href="/helpDesk"><img src="../../resources/png/logo.png"
                             width="1500"></a></p>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
            <br>
            <br>

        </div>
        <div class="medium-6 cell">

            <br>
            <br>
            <br>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <label><fmt:message key="button.login"/>
                    <input type="text" name="inputEmail" placeholder="vinty@i.ua" required="required">
                </label>
                <label><fmt:message key="label.password"/>
                    <input type="password" name="inputPassword" placeholder="qwerty12" required="required">
                </label>
                <div class="expanded button-group">
                    <button type="submit" class="hollow button success">Войти в систему</button>
                    <A class="hollow button primary" href="${pageContext.request.contextPath}/registration"
                       title="Регистрация"> Регистрация </A>
                </div>
            </form>

        </div>
        <div class="medium-3 cell">
        </div>
    </div>
</div>

<a href="${pageContext.request.contextPath}/change-locale?language=ru_RU" class="btn btn-secondary btn-lg active" role="button">Русский</a>
<a href="${pageContext.request.contextPath}/change-locale?language=en_US" class="btn btn-secondary btn-lg active" role="button">English</a>

<script> $(document).foundation();</script>
</body>
</html>