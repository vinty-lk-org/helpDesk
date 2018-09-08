<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="align-center hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/helpDesk" text="Главная"></a></li>
        <li>
            <a href="">Админка</a>
            <ul class="menu vertical">
                <li><a href="/admin">на страницу админа</a></li>
                <li><a href="/helpDesk">на страницу пользователя</a></li>
            </ul>
        </li>
        <a href="/admin">Администратор</a>
        <li><a href="/login">Выход</a></li>
    </ul>
</nav>
