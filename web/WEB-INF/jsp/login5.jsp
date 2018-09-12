<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.localLang}"/>
<fmt:setBundle basename="translation"/>
<html>
<head>
    <title>HelpDesk</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <div class="expanded button-group">
                <input type="text" name="inputEmail" placeholder="mail@tut.by" required="required">
            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
</div>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <div class="expanded button-group">
                <input type="password" name="inputPassword" placeholder="password" required="required">
            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
</div>

    <button type="submit" class="hollow button success">Войти в систему</button>
    <A class="hollow button primary" href="${pageContext.request.contextPath}/registration"
       title="Регистрация"> Регистрация </A>
</form>

<script>
    $(document).foundation();
</script>
</body>
</html>