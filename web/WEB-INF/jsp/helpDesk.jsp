<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>user</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>

<body>

<%--<div class="grid-container">--%>
<%--<div class="grid-x grid-padding-x">--%>
<%--<div class="medium-3 cell">--%>
<%--</div>--%>
<%--<div class="medium-6 cell">--%>
<%--${requestScope.myName}--%>
<%--<select name="problems" id="problems">--%>
<%--<c:forEach items="${requestScope.problems}" var="problems">--%>
<%--<option value="${problems.id}">${problems.name} </option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--</div>--%>
<%--<div class="medium-3 cell">--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<form name="textform" id="textform" action="${pageContext.request.contextPath}/helpDesk" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">
                <jsp:include page="../jsp/fragments/nav.jsp"/>
                <br>
                <label>Краткое наименование заявки
                    <input type="text" name="nameTask" placeholder="Введите краткое описание проблемы">
                </label>
            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">

                <label> Опишите возникшую проблему
                    <textarea name="textUser" placeholder="Подробно опишите возникшую проблему" cols="40"
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
                    <th width="150">Исполнитель</th>
                    <th width="250">Статус</th>
                    <th width="250">удалить</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.tasks}" var="task">
                    <tr name="taskTableName">
                        <td name="taskId">${task.id}</td>
                        <td name="taskName">${task.name}</td>
                        <td name="executor">${task.listinerName}</td>
                        <td name="executor">${task.statusName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/registerBranch/Delete?id=${branch.id}&lang=ru">
                                    ${pageContext.request.contextPath}/registerBranch/Delete?id=${branch.id}  </a>
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