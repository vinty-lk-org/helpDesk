<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>user</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>


<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>
<c:if test="${not empty pageContext.request.userPrincipal}">
    User: <c:out value="${pageContext.request.userPrincipal.name}" />
</c:if>
<br>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
           ${requestScope.myName}
            <select name="problems" id="problems">
                <c:forEach items="${requestScope.problems}" var="problems">
                    <option value="${problems.id}">${problems.name} </option>
                </c:forEach>
            </select>
        </div>
        <div class="medium-3 cell">
        </div>
    </div>
</div>
<br>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <form action="${pageContext.request.contextPath}/user" method="post">
                <p>Введите наименование проблемы<Br>
                    <textarea name="textUser" cols="40" rows="3"></textarea></p>
                <div class="expanded button-group">
                    <button type="submit" class="button success"><b>Отправить заявку</b></button>
                 </div>
            </form>
        </div>
        <div class="medium-3 cell">
        </div>
    </div>
</div>



<form action="${pageContext.request.contextPath}/login" method="post">
    <label>Введите адрес вашей почты. Это ваш логин.
        <input type="text" name="nameUser" placeholder="vinty@i.ua">
    </label>
    <label>Введите ваш пароль, полученный при регистрации.
        <input type="password" name="password" placeholder="mypassword">
    </label>
    <div class="expanded button-group">
        <button type="submit" class="button success">Войти в систему</button>
        <A class="hollow button primary" href="${pageContext.request.contextPath}/registration"
           title="Отзывы"> Регистрация </A>
    </div>
</form>



<script>

    $(document).foundation();
</script>
</body>

</html>