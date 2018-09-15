<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HelpDesk</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
        </div>
        <div class="medium-3 cell">
        </div>
    </div>
</div>
<br>
<table>
    <thead>
    <tr>
        <th width="100">ID</th>
        <th>Категория проблем</th>
        <th width="250">Удалить</th>
        <th width="250">Изменить</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${requestScope.category}" var="subdivision">
        <tr name="taskTableName">
            <td name="taskId">${subdivision.id}</td>
            <td name="taskName">${subdivision.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/category/Delete?id=${subdivision.id}&lang=ru">Удалить </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/viewCategory/Update?id=${subdivision.id}&lang=ru">Изменить</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <div class="expanded button-group">
                <A class="button primary hollow" href="${pageContext.request.contextPath}/adminFillPage"> <b> Добавить
                    новую
                    категорию</b> </A>
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
                <A class="button primary " href="${pageContext.request.contextPath}/admin"> <b> Вернутся на главную
                    страницу админки</b> </A>
            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
</div>
<script>
    $(document).foundation();
</script>
</body>
</html>