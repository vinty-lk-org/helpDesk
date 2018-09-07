<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="align-center hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/helpDesk" text="Главная"></a></li>
        <li>
            <a href="/helpDesk">Меню пользователя</a>
            <ul class="menu vertical">
                <li><a href="/helpDesk">статистика заявок - базовая информация</a></li>
                <li><a href="/admin">завершенные заявки</a></li>
            </ul>
        </li>
        <a href="/helpDesk">Пользователь</a>
        <li><a href="/login">Выход</a></li>
    </ul>
</nav>
