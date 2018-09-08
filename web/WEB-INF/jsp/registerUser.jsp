<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>registerUser</title>
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

<div>
    <select name="registerUser" id="registerUser">
        <c:forEach items="${requestScope.users}" var="reg">
            <option value="${reg.id}" ${reg.name} ${reg.family} ${reg.subdivisionName} ${reg.branchName}</option>
        </c:forEach>
    </select>
</div>


<table>
    <thead>
    <tr>
        <th width="100">ID</th>
        <th width="250">Имя</th>
        <th width="250">Фамилия</th>
        <th width="250">Исполнитель</th>
        <th>Адрес</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.users}" var="reg">
    <tr name="taskTableName">
        <td name="taskId">${reg.id}</td>
        <td name="taskName">${reg.name}</td>
        <td name="data">${reg.family}</td>
        <td name="executor">${reg.subdivisionName}</td>
        <td name="status_id">${reg.branchName}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<script>
    $(document).foundation();
</script>
</body>
</html>


<%--<td name="taskId">33</td>--%>
<%--<td name="taskName">Не работает интернет</td>--%>
<%--<td name="data">22.05.2018</td>--%>
<%--<td name="executor">Зыскунов Ярослав</td>--%>
<%--<td name="status_id">на рассмотрении</td>--%>