<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>adminFill</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>

<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>
<c:if test="${not empty pageContext.request.userPrincipal}">
    User: <c:out value="${pageContext.request.userPrincipal.name}"/>
</c:if>
<br>
<br>
<p align="center"> <b>Справочники</b></p>
<form name="textform" id="textform" action="${pageContext.request.contextPath}/user" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
                <label>Заполните название филиала
                <input type="text" name="nameTask" placeholder="Название филиала">
                </label>
            </div>
            <div class="medium-3 cell">
                <label>Заполните адрес филиала
                    <input type="text" name="nameTask" placeholder="Адрес филиала">

                </label>
            </div>
            <div class="medium-3 cell">
                <label> <br>
                <div class="expanded button-group">
                    <button type="submit" class="button success"><b>Заполнить</b></button>
                </div>
                </label>
            </div>
        </div>
    </div>
    <form name="textform" id="textform2" action="${pageContext.request.contextPath}/user" method="post">
        <div class="grid-container">
            <div class="grid-x grid-padding-x">
                <div class="medium-3 cell">
                </div>
                <div class="medium-3 cell">
                    <label> Введите подразделение
                        <input type="text" name="nameTask" placeholder="например отдел маркетинга">
                    </label>
                </div>
                <div class="medium-3 cell">
                    <label> <br>
                        <div class="expanded button-group">
                            <button type="submit" class="button success"><b>Заполнить</b></button>
                        </div>
                    </label>
                </div>
            </div>
        </div>
    </form>
<form name="textform" id="textform3" action="${pageContext.request.contextPath}/user" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-3 cell">
                <label> Введите тип пролемы
                    <input type="text" name="nameTask" placeholder="например картриджи">
                </label>
            </div>
            <div class="medium-3 cell">
                <label> <br>
                <div class="expanded button-group">
                    <button type="submit" class="button success"><b>Заполнить</b></button>
                </div>
                </label>
            </div>
        </div>
    </div>
</form>

    <form name="textform" id="textform4" action="${pageContext.request.contextPath}/user" method="post">
        <div class="grid-container">
            <div class="grid-x grid-padding-x">
                <div class="medium-3 cell">
                </div>
                <div class="medium-3 cell">
                    <label> Введите получателя заявок
                        <input type="text" name="nameTask" placeholder="например Отдел программистов">
                    </label>
                </div>
                <div class="medium-3 cell">
                    <label> <br>
                        <div class="expanded button-group">
                            <button type="submit" class="button success"><b>Заполнить</b></button>
                        </div>
                    </label>
                </div>
            </div>
        </div>
    </form>
<script>

    $(document).foundation();
</script>
</body>

</html>