<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Привет из сервлета "hello.jsp"</h2>
<select name="users" id="users">
    <c:forEach items="${requestScope.users}" var="user">
        <option value="${user.id}">${user.name} ${user.family} ${user.email} </option>
    </c:forEach>
</select>
</body>
</html>
