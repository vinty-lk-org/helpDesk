<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>HelpDesk</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <jsp:include page="../jsp/fragments/nav.jsp"/>
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
        <th>Название филиала</th>
        <th width="250">Удалить</th>
        <th width="250">Изменить</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.problems}" var="problem">
        <tr name="taskTableName">
            <td name="taskId">${problem.id}</td>
            <td name="taskName">${problem.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/registerBranch/Delete?id=${problem.id}&lang=ru">Удалить </a>
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
                <A class="button success" href="${pageContext.request.contextPath}/admin"> <b> Вернутся на главную
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