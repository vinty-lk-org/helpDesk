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
        <th width="250">Название филиала</th>
        <th>Адрес филиала</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.branch}" var="branch">
        <tr name="taskTableName">
            <td name="taskId">${branch.id}</td>
            <td name="taskName">${branch.name}</td>
            <td name="data">${branch.address}</td>
                <%--<td name="data">${task.email}</td>--%>
                <%--<td name="executor">${task.subdivisionName}</td>--%>
                <%--<td name="status_id">${task.branchName}</td>--%>
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
