<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HelpDesk</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>
<body>
<%--<p align="center"><img src="../../resources/png/logo.png"></p>--%>
<jsp:include page="../jsp/fragments/nav.jsp"/>


<form name="textform" id="textform" action="${pageContext.request.contextPath}/userDesk" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">
                <br>
                <label>Краткое наименование заявки
                    <input type="text" name="nameTask" placeholder="Введите краткое описание проблемы">
                </label>
            </div>
            <div class="medium-3 cell">

            </div>
        </div>
    </div>
    <%--<input type="hidden" name="userId" value="${sessionScope.userId}">--%>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">
                <label> Опишите возникшую проблему
                    <textarea name="textTask" placeholder="Подробно опишите возникшую проблему" cols="40"
                              rows="3"></textarea>
                    <div class="expanded button-group">
                        <button type="submit" class="button success"><b>Отправить заявку</b></button>
                    </div>
                </label>
            </div>
            <div class="medium-1 cell">
            </div>
        </div>
    </div>
</form>
<p align="center"><b>Ваши заявки</b></p>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-1 cell">
        </div>
        <div class="medium-10 cell">
            <table>
                <thead>
                <tr>
                    <th width="50">Номер заявки</th>
                    <th>Краткое содержание</th>
                    <th width="250">Отдел</th>
                    <th width="250">Статус</th>
                    <th width="250">Удалить</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.tasks}" var="task">
                    <tr name="taskTableName">
                        <td name="taskId">${task.id}</td>
                        <td name="taskName">${task.name}</td>
                        <td name="executor">${task.listinerName}</td>


                        <c:if test="${task.statusName eq 'Принята'}">
                            <td name="status_id"><span class="primary Label">${task.statusName}</span></td>
                        </c:if>
                        <c:if test="${task.statusName eq 'В ожидании'}">
                            <td name="status_id"><span class="warning Label">${task.statusName}</span></td>
                        </c:if>
                        <c:if test="${task.statusName eq 'Выполнена'}">
                            <td name="status_id"><span class="success Label">${task.statusName}</span></td>
                        </c:if>
                        <c:if test="${task.statusName eq 'Закрыта'}">
                            <td name="status_id"><span class="alert Label">${task.statusName}</span></td>
                        </c:if>


                        <%--<td name="status">${task.statusName}</td>--%>


                        <td>
                            <a href="${pageContext.request.contextPath}/task/Delete?id=${task.id}&lang=ru" ><span class="alert label">Удалить</span></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="medium-1 cell">
        </div>
    </div>
</div>
<script>
    $(document).foundation();
</script>
</body>
</html>