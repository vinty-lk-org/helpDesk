<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>user</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>

<body>

<%--<c:if test="${not empty pageContext.request.userPrincipal}">--%>
    <%--User: <c:out value="${pageContext.request.userPrincipal.name}"/>--%>
<%--</c:if>--%>

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

<form name="textform" id="textform" action="${pageContext.request.contextPath}/user" method="post">
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
                    <th width="150">Дата заявки</th>
                    <th width="250">Исполнитель</th>
                    <th width="250">Статус</th>
                </tr>
                </thead>
                <tbody>
                <%--<c:if test="${not empty pageContext.request.userPrincipal}">--%>
                <%--User: <c:out value="${pageContext.request.userPrincipal.name}"/>--%>
                <%--</c:if>--%>
                <%--<c:if test="${not empty pageContext.request.taskTableName}">--%>
                <%--<tr name="taskTableName">--%>
                <%--<td name="taskTableName">taskTableName.taskId</td>--%>
                <%--<td name="taskTableName.taskName">taskTableName.taskName</td>--%>
                <%--<td name="taskTableName.taskType">taskTableName.taskType</td>--%>
                <%--<td name="taskTableName.taskDate">taskTableName.taskDate</td>--%>
                <%--</tr>--%>
                <%--</c:if>--%>
                <tr name="taskTableName">
                    <td name="taskId">33</td>
                    <td name="taskName">Не работает интернет</td>
                    <td name="data">22.05.2018</td>
                    <td name="executor">Зыскунов Ярослав</td>
                    <td name="status_id">на рассмотрении</td>
                </tr>


                <tr>
                    <td>34</td>
                    <td>Не работает монитор</td>
                    <td>Компьютер</td>
                    <td>01/07/2018</td>
                </tr>
                <tr>
                    <td>35</td>
                    <td>Не работает программа Электронные счет фактуры</td>
                    <td>Электронные счет факутры</td>
                    <td>03/03/2018</td>
                </tr>
                <tr>
                    <td>36</td>
                    <td>Не работает МФУ в холле приемной</td>
                    <td>принтеры</td>
                    <td>03/09/2018</td>
                </tr>
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