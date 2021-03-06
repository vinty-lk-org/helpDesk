<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HelpDesk</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>
<br>
<br>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <A class="button primary hollow expanded" href="${pageContext.request.contextPath}/adminFillPage"><b> Заполнить справочники</b></A>
            <A class="button primary hollow expanded" href="${pageContext.request.contextPath}/registerUser"><b>Посмотреть зарегестрированных пользователей</b></A>
            <A class="button primary hollow expanded" href="${pageContext.request.contextPath}/registerTask"><b>Посмотреть все заявки</b></A>
            <A class="button primary hollow expanded" href="${pageContext.request.contextPath}/registerBranch"><b>Зарегистрированные филиалы</b></A>
            <A class="button primary hollow expanded" href="${pageContext.request.contextPath}/registerSubdivision"><b>Зарегистрированные подразделения</b></A>
            <A class="button primary hollow expanded" href="${pageContext.request.contextPath}/registerSubdivision"><b>Зарегистрированные подразделения</b></A>
            <A class="button primary hollow expanded" href="${pageContext.request.contextPath}/registerCategory"><b>Типовые категории проблем</b></A>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
</div>
<script>$(document).foundation();</script>
</body>
</html>