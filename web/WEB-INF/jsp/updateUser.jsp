<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>HelpDesk</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
    <script type="text/javascript">
        <%@include file="../../resources/js/myJs.js" %>
    </script>
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

<%--this.id = id;--%>
<%--this.name = name;--%>
<%--this.family = family;--%>
<%--this.email = email;--%>
<%--this.password = password;--%>
<%--this.branchId = branchId;--%>
<%--this.branchName = branchName;--%>
<%--this.subdivisionId = subdivisionId;--%>
<%--this.subdivisionName = subdivisionName;--%>
<%--}--%>



<form name="textform" id="textform" action="${pageContext.request.contextPath}/user/Update" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-3 cell">
                <label> Новая категория
                    <input type="hidden" name="userId" value="${requestScope.use.id}"
                           placeholder="введите категорию">
                    <input type="text" name="userName" value="${requestScope.use.name} ${requestScope.use.family}"
                           placeholder="введите категорию">
                </label>
            </div>
            <div class="medium-3 cell">
                <label> <br>
                    <div class="expanded button-group">
                        <button type="submit" class="button primary hollow "><b>изменить2</b></button>
                    </div>
                </label>
            </div>
        </div>
    </div>
</form>

<br>
<br>
<br>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <div class="expanded button-group">
                <A class="button primary hollow" href="${pageContext.request.contextPath}/registerUser"> <b>
                    Вернутся на предыдущую страницу</b> </A>
            </div>
            <div class="medium-3 cell">

            </div>
        </div>
    </div>
</div>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            <div class="expanded button-group">
                <A class="button primary " href="${pageContext.request.contextPath}/admin"> <b> Вернутся на главную
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
