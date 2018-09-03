<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../resources/css/foundation.min.css">
<%--<script src="../../resources/js/foundation.min.js"></script>--%>
<%--<script type="text/javascript" src="../../resources/js/jquery.js"></script>--%>
<script type="text/javascript">
    <jsp:include page="../../resources/js/jquery.js" />
</script>
<script type="text/javascript">
    <jsp:include page="../../resources/js/foundation.min.js" />
</script>
<html>
<head>
    <title>Login</title>
</head>
<body>
<nav class="hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/HelpDesk" text="Логин"></a></li>
        <li>
            <a href="/HelpDesk">Test</a>
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
<script type="text/javascript">
    <jsp:include page="../../resources/js/jquery.js" />
</script>
<script type="text/javascript">
    <jsp:include page="../../resources/js/foundation.min.js" />
</script>
</body>
</html>
