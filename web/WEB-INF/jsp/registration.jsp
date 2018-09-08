<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>registration</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
    <script type="text/javascript">
        <%@include file="../../resources/js/myJs.js" %>
    </script>
</head>
<body>
${login}
<form name="form1" id="form1" action="${pageContext.request.contextPath}/registration" method="post">
    <div class="grid-container">
        <%--<jsp:include page="../jsp/fragments/nav.jsp"/>--%>
        <h2>Страница регистрации</h2>
        <br>
        <div class="grid-x grid-padding-x">
            <div class="medium-6 cell">
                <h3>Обязательные поля</h3>
                <div class="row">
                    <div id="divInput1" class="callout secondary border-none" onmouseover="divHover(this)"
                         onmouseout="divNorm(this)">
                        <label>Введите ваш e-mail
                            <input name="email" type="text" id="middle-label">
                            <span style="color:red" id="input1Error"></span>
                            <span style="color:darkgreen" id="input11Error"></span>
                        </label>
                    </div>
                    <div id="divInput2" class="callout secondary border-none" onmouseover="divHover(this)"
                         onmouseout="divNorm(this)">
                        <label>Придумайте пароль ддлинной не менее 4 символа
                            <input name="password" type="text" id="middle-labe2">
                            <span style="color:red" id="input2Error"></span>
                        </label>
                    </div>
                    <div id="divInput3" class="callout secondary border-none" onmouseover="divHover(this)"
                         onmouseout="divNorm(this)">
                        <label>Введите ваш пароль еще раз, что бы убедится в правильности ввода
                            <input name="passwordTwo" type="text" id="middle-labe3">
                            <span style="color:red" id="input3Error"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="medium-6 cell">
                <br>
                <div class="row">
                    <label>Введите ваше имя
                        <input type="text" name="nameUser" placeholder="Иван">
                    </label>
                    <label>Введите вашу фамилию
                        <input type="text" name="family" placeholder="Иванов">
                    </label>
                    <label for="branches">Выберите из списка ваше местоположение (филиал)
                        <select name="branch_id" id="branches">
                            <c:forEach items="${requestScope.branches}" var="branch">
                        <option value="${branch.id}">${branch.name} ( ${branch.address})</option>
                        </c:forEach>
                        </select>
                    </label>
                    <label for="subdivisions">Выберете из списка ваш отдел (подразделение)
                        <select name="subdivision_id" id="subdivisions">
                            <c:forEach items="${requestScope.subdivisions}" var="subdivision">
                                <option value="${subdivision.id}">${subdivision.name}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>
            </div>
        </div>
        <div class="expanded button-group">
            <button name="but1" type="submit" class="button success color-bar"><b>Зарегистритовать
                пользователя</b></button>
            <A class="hollow button primary" href="${pageContext.request.contextPath}/login"
               title="На страницу Логина">
                На страницу Логина </A>
            </button>
        </div>
    </div>
</form>
</div>
<script>
    function getUrl() {
        return `${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}`;

    }
    console.log(getUrl());
</script>
<%--<script type="text/javascript">--%>
    <%--function natIP() {--%>
        <%--var w = window.location;--%>
        <%--var host = w.host;--%>
        <%--var port = w.port || 80;--%>
        <%--var Socket = (new java.net.Socket(host,port)).getLocalAddress().getHostAddress();--%>
        <%--return Socket;--%>
    <%--}--%>
<%--</script>--%>

<script src="../../resources/js/app.js"></script>
<script src="../../resources/js/myJs.js"></script>
</body>
</html>