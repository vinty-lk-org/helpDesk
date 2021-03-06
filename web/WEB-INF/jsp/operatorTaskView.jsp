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
        <th width="70">ID</th>
        <th width="250">Краткое содержание</th>
        <th width="100">Имя</th>
        <th width="200">Фамилия</th>
        <th width="150">Подразделение</th>
        <th>Статус</th>
        <th width="300">Выбрать действие</th>
    </tr>
    </thead>
    <tbody>


    <%--<c:if test="${requestScope.operatorTaskView.status eq 'Принята'}">--%>
    <%--</c:if>--%>
    <%--<c:if test="${requestScope.operatorTaskView.status eq 'В ожидании'}">--%>
    <%--</c:if>--%>

    <%--<a href="${pageContext.request.contextPath}/viewCategory/Update?id=${operator.id}&lang=ru">Изменить</a>--%>

    <c:forEach items="${requestScope.operatorTaskView}" var="operator">
        <tr name="taskTableName">
            <td name="taskId">${operator.idTask}</td>
            <td name="taskName">${operator.taskName}</td>
            <td name="data">${operator.userName}</td>
            <td name="data">${operator.userFamily}</td>
            <td name="executor">${operator.subdivision}</td>

            <c:if test="${operator.status eq 'Принята'}">
                <td name="status_id"><span class="primary Label">${operator.status}</span></td>
            </c:if>
            <c:if test="${operator.status eq 'В ожидании'}">
                <td name="status_id"><span class="warning Label">${operator.status}</span></td>
            </c:if>
            <c:if test="${operator.status eq 'Выполнена'}">
                <td name="status_id"><span class="success Label">${operator.status}</span></td>
            </c:if>
            <c:if test="${operator.status eq 'Закрыта'}">
                <td name="status_id"><span class="alert Label">${operator.status}</span></td>
            </c:if>
            <%--<td name="status_id"><span class="alert Label">${operator.status}</span></td>--%>

             <td>
                 <a href="${pageContext.request.contextPath}/operatorChangeStatus?id=${operator.idTask}&lang=ru"><span class="secondary label">Работа с заявкой</span></a>
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
                <A class="button primary hollow" href="${pageContext.request.contextPath}/userDesk"> <b> Вернутся на главную
                    страницу оператора</b> </A>
            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
</div>
<script> $(document).foundation();</script>
</body>
</html>
