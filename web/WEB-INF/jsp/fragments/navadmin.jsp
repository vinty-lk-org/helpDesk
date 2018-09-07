<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="align-center hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/user" text="Главная"></a></li>
        <li>
            <a href="/user">Test</a>
            <ul class="menu vertical">
                <li><a href="/user">Test - базовая информация</a></li>
                <li><a href="/user">Test - общее описание</a></li>
            </ul>
        </li>
        <a href="/admin">Администратор</a>
        <a href="/helpDesk">Пользователь</a>
        <li><a href="/login">Выход</a></li>
    </ul>
</nav>
