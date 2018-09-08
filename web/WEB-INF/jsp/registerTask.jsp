<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>registerTask</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <jsp:include page="../jsp/fragments/navadmin.jsp"/>
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
        <th width="250">Наименование заявки</th>
        <th>Текст заявки</th>
        <%--<th width="250">Почта</th>--%>
        <%--<th width="250">Исполнитель</th>--%>
        <%--<th>Адрес</th>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.tasks}" var="user">
        <tr name="taskTableName">
            <td name="taskId">${user.id}</td>
            <td name="taskName">${user.name}</td>
            <td name="data">${user.text}</td>
            <%--<td name="data">${task.email}</td>--%>
            <%--<td name="executor">${task.subdivisionName}</td>--%>
            <%--<td name="status_id">${task.branchName}</td>--%>
        </tr>
    </c:forEach>




    </tbody>
</table>

<script>
    $(document).foundation();
</script>
</body>
</html>