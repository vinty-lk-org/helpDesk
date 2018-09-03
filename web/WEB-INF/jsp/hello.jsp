<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../resources/css/foundation.min.css">
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        <%@include file="../../resources/js/myJs.js" %>
    </script>
    <script type="text/javascript">
        <%@include file="../../resources/js/jquery.js" %>
    </script>
    <script type="text/javascript">
        <%@include file="../../resources/js/foundation.min.js" %>
    </script>
    <title>Hello</title>
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
        <h2>Привет из сервлета "hello.jsp"</h2>
        ${requestScope.myName}

        <select name="users" id="users">
            <c:forEach items="${requestScope.users}" var="user">
                <option value="${user.id}">${user.name} ${user.family} ${user.subdivisionName} </option>
            </c:forEach>
        </select>


        <div class="medium-6 cell">
            <select name="users" id="users">
                <c:forEach items="${requestScope.users}" var="u">
                    <option value="${u.id}">${u.name} ${u.family} ${u.subdivisionName} ${u.branchName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="medium-6 cell">
            <a href="#features" class="button">View All Features</a>
        </div>

    </div>
</div>

<form>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-6 cell">
                <label>Input Label
                    <input type="text" placeholder=".medium-6.cell">
                </label>
            </div>
            <div class="medium-6 cell">
                <label>Input Label
                    <input type="text" placeholder=".medium-6.cell">
                </label>
            </div>
        </div>
    </div>
</form>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-12 cell">
            <label>Input Label
                <input type="text" placeholder=".medium-12.cell">
            </label>
        </div>
    </div>
</div>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <label>Введите адрес вашей почты. Это ваш логин.
                <input type="text" placeholder="vinty@i.ua">
            </label>
            <label>Введите ваш пароль, полученный при регистрации.
                <input type="password" placeholder="mypassword">
            </label>
            <div class="expanded button-group">
                <button class="hollow button success" href="#">Войти в систему</button>
                <button class="hollow button alert" href="#">Отказаться</button>
            </div>

            <form action="${pageContext.request.contextPath}/hello" method="post">
                <label>Ведите Филиал.
                    <input type="text" name="nameBranch" placeholder="филиал на Московской" required="required">
                </label>
                <label>Ведите Адрес.
                    <input type="text" name="addressBranch" placeholder="Кропоткина 91" required="required">
                </label>
                <button type="submit" class="hollow button success">Ввести филиал</button>
            </form>

        </div>
        <div class="medium-3 cell">
        </div>
    </div>
</div>
</body>
</html>
