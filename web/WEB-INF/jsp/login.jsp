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

<p align="right">
    <a href="${pageContext.request.contextPath}
            /change-locale?language=ru_RU" class="btn btn-secondary btn-lg active"><img
            src="../../resources/png/ru.png"></a>
    <a href="${pageContext.request.contextPath}
            /change-locale?language=en_US" class="btn btn-secondary btn-lg active"><img
            src="../../resources/png/eng.png"></a>
</p>
<p align="center"><a href="${pageContext.request.contextPath}/helpDesk"><img src="../../resources/png/logo.png"
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
                    <input type="text" name="inputEmail" placeholder="mail@belint.by" required="required">
                </label>
                <label><fmt:message key="label.password"/>
                    <input type="password" name="inputPassword" placeholder="123456" required="required">
                </label>
                <div class="expanded button-group">
                    <button type="submit" class="hollow button success"> <fmt:message key="label.systementer"/></button>
                    <A class="hollow button primary" href="${pageContext.request.contextPath}/registration"
                       title="Регистрация"> <fmt:message key="label.register"/> </A>
                </div>
            </form>

        </div>
        <div class="medium-3 cell">


        </div>
    </div>
</div>

<script> $(document).foundation();</script>
</body>
</html>