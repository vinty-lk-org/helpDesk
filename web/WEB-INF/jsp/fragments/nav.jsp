<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="hover-underline-menu" data-menu-underline-from-center>
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="/HelpDesk" text="Главная"></a></li>
        <li>
            <a href="/HelpDesk">Test</a>
            <ul class="menu vertical">
                <li><a href="/HelpDesk">Test - базовая информация</a></li>
                <li><a href="/HelpDesk">Test - общее описание</a></li>
            </ul>
        </li>
        <a href="/Admin">Администратор</a>
        <a href="/Operator">Оператор</a>
        <li><a href="/logout">Выход</a></li>
    </ul>
</nav>
