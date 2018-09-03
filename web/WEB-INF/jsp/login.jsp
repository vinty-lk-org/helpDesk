<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>

<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <label>Введите адрес вашей почты. Это ваш логин.
                    <input type="text" name="nameUser" placeholder="vinty@i.ua">
                </label>
                <label>Введите ваш пароль, полученный при регистрации.
                    <input type="password" name="password" placeholder="mypassword">
                </label>
                <div class="expanded button-group">
                    <button type="submit" class="button success">Войти в систему</button>
                    <A class="hollow button primary" href="${pageContext.request.contextPath}/registration" title="Отзывы"> Регистрация </A>
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
