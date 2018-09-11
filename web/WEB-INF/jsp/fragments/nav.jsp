<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    Date dateNow = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy");
%>
<div class="title-bar" data-responsive-toggle="my-nav-menu" data-hide-for="medium">
    <button class="menu-icon" type="button" data-toggle></button>
    <div class="title-bar-title">Адаптивное меню</div>
</div>
<div class="top-bar" id="my-nav-menu">
    <div class="top-bar-left">
        <ul class="menu">
            <li class="menu-text"><a href="/helpDesk">ТЕХПОДДЕРЖКА</a></li>

            <c:if test="${sessionScope.privilege eq '2'}">
                <li class="menu-text"><a href="/helpDesk">на страницу Пользователя</a></li>
            </c:if>
            <li class="menu-text"><a href="/login">Статистика</a></li>
            <li class="menu-text"><a href="/login">Отчет</a></li>
            <c:if test="${sessionScope.privilege eq '1'}">
                <ul class="dropdown-menu" data-dropdown-menu>
                    <li class="menu-text"><a href="">Администратор</a>
                        <ul class="menu">
                            <li><a href="/admin">Список 1</a></li>
                            <li><a href="">Список 2</a></li>
                            <li><a href="">Список 3</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
        </ul>
    </div>
    <div class="top-bar-right">
        <ul class="menu">
            <li class="menu-text"><a href="/login">Выход: ${sessionScope.user}</a>
            </li>
            <li class="menu-text"><a href="/helpDesk"><%= formatForDateNow.format(dateNow) %>
            </a>
            </li>
        </ul>
    </div>
</div>