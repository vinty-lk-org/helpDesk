<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
            <select onchange="submit()" name="lang">
                <option value="ru_RU" ${sessionScope.localLang eq 'ru_RU' ? 'selected':''}>Русский</option>
                <option value="en_US" ${sessionScope.localLang eq 'en_US' ? 'selected':''}>English</option>
            </select>
        </div>
        <div class="medium-6 cell">
            <%--<jsp:include page="../jsp/fragments/nav.jsp"/>--%>
            <br>
            <br>
            <br>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <label><fmt:message key="EnterUser"/>
                    <input type="text" name="email" placeholder="vinty@i.ua" required="required">
                </label>
                <label>Введите ваш пароль, полученный при регистрации.
                    <input type="password" name="password" placeholder="qwerty12" required="required">
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
<script src="../../resources/js/app.js"></script>
</body>
</html>
