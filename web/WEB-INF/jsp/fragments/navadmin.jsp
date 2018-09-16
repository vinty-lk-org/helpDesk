<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="align-center hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/userDesk" text="Главная"></a></li>
        <li>
            <a href="">Админка</a>
            <ul class="menu vertical">
                <c:if test="${sessionScope.privilege eq '1'}">
                    <li><a href="/admin" text="Я админ">на страницу админа</a></li>
                </c:if>
                <c:if test="${sessionScope.privilege eq '2'}">
                    <li><a href="/userDesk" text="Я админ">на страницу пользователя</a></li>
                </c:if>
                <%--<li><a href="/admin">на страницу админа</a></li>--%>
                <%--<li><a href="/helpDesk">на страницу пользователя</a></li>--%>
            </ul>
        </li>
        <a href="/admin">Администратор</a>
        <li><a href="/login">Выход</a></li>
    </ul>

</nav>
