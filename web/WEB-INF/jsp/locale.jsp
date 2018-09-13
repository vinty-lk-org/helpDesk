<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'ru_RU'}"/>
<fmt:setBundle basename="translations"/>

<html>
<head>
    <title>testLocale</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/change-locale?language=ru_RU" class="btn btn-secondary btn-lg active" role="button">Русский</a>
<a href="${pageContext.request.contextPath}/change-locale?language=en_US" class="btn btn-secondary btn-lg active" role="button">English</a>
<%--<fmt:setLocale value="en_US"/>--%>
<%--<fmt:setBundle basename="translations"/>--%>

<p>
        <fmt:message key="greeting.message"/>
        <fmt:message key="greeting.message"/>
        <fmt:message key="button.login"/>
    </p>


</body>
</html>