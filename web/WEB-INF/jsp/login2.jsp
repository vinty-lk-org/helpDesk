<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="../../resources/css/foundation.min.css">
    <title>Login</title>
    <script type="text/javascript">
        <%@include file="../../resources/js/myJs.js" %>
    </script>
    <script type="text/javascript">
        <%@include file="../../resources/js/vendor/jquery-3.3.1.min.js" %>
    </script>
    <script type="text/javascript">
        <%@include file="../../resources/js/vendor/foundation.min.js" %>
    </script>
</head>
<body>
<nav class="hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/HelpDesk" text="Главная"></a></li>
        <li>
            <a href="/HelpDesk">Test</a>
            <ul class="menu vertical">
                <li><a href="/HelpDesk">Test - базовая информация</a></li>
                <li><a href="/HelpDesk">Test - общее описание</a></li>
            </ul>
        </li>
        <a href="/Admin">Администратор</a>
        <a href="/Operator">Оператор</a>
        <li><a href="/logout">Выход</a></li>
    </ul>
</nav>
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
                    <button class="hollow button success" href="#">Войти в систему</button>
                    <button class="hollow button alert" href="#">Регистрация"</button>
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
