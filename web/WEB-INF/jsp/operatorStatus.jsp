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
        <h1>Назначение исполнителя заявки</h1>
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">

        </div>
        <div class="medium-3 cell">
        </div>
    </div>
</div>

<table>
    <thead>
    <tr>
        <th width="70">ID</th>
        <th width="450">Краткое содержание</th>
        <th width="150">Имя</th>
        <th width="200">Фамилия</th>
        <th>Подразделение</th>
        <th width="300">Статус</th>

    </tr>
    </thead>
    <tbody>


    <tr name="taskTableName">
        <td name="taskId">${requestScope.operatorId.taskId}</td>
        <td name="taskName">${requestScope.operatorId.taskName}</td>
        <td name="userName">${requestScope.operatorId.systemUserName}</td>
        <td name="userFamily">${requestScope.operatorId.systemUserFamily}</td>
        <td name="subdivision">${requestScope.operatorId.subdivisionName}</td>
        <td name="status_name">${requestScope.operatorId.statusName}</td>
    </tr>
    </tbody>
</table>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-1 cell">
        </div>
        <div class="medium-9 cell">
            <div class="expanded button-group">
                <table>
                    <thead>
                    <tr>
                        <th>Текст заявки</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr name="taskTableName">
                        <td name="taskId">${requestScope.operatorId.text}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
</div>


<form name="status" id="status" action="${pageContext.request.contextPath}/operatorStatus/Update" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-3 cell">
                <select name="statusNameId" id="statusNameId">
                    <c:forEach items="${requestScope.status}" var="status">
                        <option value="${status.id}"> ${status.name} </option>
                    </c:forEach>
                </select>
                <input type="hidden" name="taskId" value="${requestScope.operatorId.taskId}">
            </div>
            <div class="medium-3 cell">
                <div class="expanded button-group">
                    <button type="submit" class="button primary hollow "><b>Изменить статус</b></button>
                </div>

            </div>
        </div>
    </div>
</form>

<form name="operator" id="operator" action="${pageContext.request.contextPath}/operatorTask/Update" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-3 cell">
                <select name="executorNameId" id="executorNameId">
                    <c:forEach items="${requestScope.executor}" var="operator">
                        <option value="${operator.id}"> ${operator.name} ${operator.family}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="taskId" value="${requestScope.operatorId.taskId}">
            </div>
            <div class="medium-3 cell">

                <div class="expanded button-group">
                    <button type="submit" class="button primary hollow "><b>Назначить исполнителя</b></button>
                </div>

            </div>
        </div>
    </div>
</form>

<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <div class="expanded button-group">
                <A class="button primary " href="${pageContext.request.contextPath}/operatorTaskView"> <b> Вернутся на
                    главную
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
