<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="align-center hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/helpDesk" text="Главная"></a></li>
        <c:if test="${sessionScope.privilege eq '1'}">
            <li><a href="/helpDesk" text="Я админ">АДМИН</a></li>
        </c:if>
        <c:if test="${sessionScope.privilege eq '2'}">
            <li><a href="/helpDesk" text="Я админ">Пользователь</a></li>
        </c:if>
        <li>
            <a href="">Меню пользователя</a>

            <ul class="menu vertical">

                <li><a href="/helpDesk">на страницу пользователя</a></li>
            </ul>
        </li>
        <a href="/helpDesk">Пользователь</a>
        <li><a href="/login">Выход</a></li>
        <li>${sessionScope.user}</li>
    </ul>
    <c:if test="${sessionScope.privilege eq '1'}">
        <h3>Я админ</h3>
    </c:if>
    <c:if test="${sessionScope.privilege eq '2'}">
        <h3>Я Юзер</h3>
    </c:if>
</nav>
