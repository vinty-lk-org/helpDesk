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
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/change-locale?language=ru_RU" class="btn btn-secondary btn-lg active" role="button">Русский</a>
            <a href="${pageContext.request.contextPath}/change-locale?language=en_US" class="btn btn-secondary btn-lg active" role="button">English</a>

            <strong><em><fmt:message key="${message}"/></em></strong>
            <br>
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
                    <input type="text" name="inputEmail" placeholder="vinty@i.ua" required="required">
                </label>
                <label><fmt:message key="EnterPass"/>
                    <input type="password" name="inputPassword" placeholder="qwerty12" required="required">
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
<script>
    $(document).foundation();
</script>
</body>
</html>