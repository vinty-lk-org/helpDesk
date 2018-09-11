<%--
  Created by IntelliJ IDEA.
  User: lk
  Date: 11.09.2018
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>изменить</title>
</head>
<body>
<label for="branches">Выберите из списка ваше местоположение (филиал)
    <select name="branch_id" id="branches">
        <c:forEach items="${requestScope.branches}" var="branches">
            <option value="${branches.id}">${branches.name} ( ${branches.address})</option>
        </c:forEach>
    </select>

    <label>изменить название
        <input type="text" name="family" value="выа" placeholder="Иванов">
    </label>

    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">
                <div class="expanded button-group">
                    <A class="button success" href="${pageContext.request.contextPath}/admin"> <b> Вернутся на главную страницу админки</b> </A>
                </div>
                <div class="medium-3 cell">

                </div>
            </div>
        </div>

</body>
</html>
