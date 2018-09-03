<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>

<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <h2>HELP DESK</h2>
    </div>
</div>
<A class="hollow button success" href="${pageContext.request.contextPath}/login" title="Логин">На страницу Логина </A>
<script src="../../resources/js/app.js"></script>
</body>
</html>
