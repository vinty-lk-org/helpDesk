<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>registration</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>

<jsp:include page="../jsp/fragments/nav.jsp"/>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <h2>Страница регистрации</h2>
            <form action="${pageContext.request.contextPath}/registration" method="post">
                <label>Введите адрес вашей почты (это будет вашим логином)
                    <input type="text" name="email" placeholder="vinty@i.ua">
                </label>
                <label>Введите ваш пароль
                    <input type="password" name="password" placeholder="mypassword">
                </label>
                <label>Введите ваш пароль еще раз, что бы убедится в правильности ввода
                    <input type="password" name="password2" placeholder="mypassword">
                </label>
                <label>Введите ваше имя
                    <input type="text" name="nameUser" placeholder="mypassword">
                </label>
                <label>Введите вашу фамилию
                    <input type="text" name="family" placeholder="Иванов">
                </label>

                <div class="expanded button-group">
                    <button type="submit" class="hollow button success color-bar" href="#"><b>Зарегистритовать
                        пользователя</b></button>
                    <A class="hollow button alert" href="${pageContext.request.contextPath}/login" title="Отмена"> Отмена </A>
                    </button>
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