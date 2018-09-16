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
            <li class="menu-text"><a href=${pageContext.request.contextPath}"/helpDesk">Написать заявку</a></li>

            <c:if test="${sessionScope.privilege eq '2'}">
                <ul class="dropdown-menu" data-dropdown-menu>
                    <li class="menu-text"><a href="">Пользователь</a>
                        <ul class="menu">
                            <li><a href=${pageContext.request.contextPath}"/helpDesk">Посмотреть история заявок</a></li>
                            <li><a href=${pageContext.request.contextPath}"/helpDesk">Посмотреть выполненые</a></li>
                            <li><a href=${pageContext.request.contextPath}"/helpDesk">Посмотреть отклоненные</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
            <c:if test="${sessionScope.privilege eq '1'}">
                <ul class="dropdown-menu" data-dropdown-menu>
                    <li class="menu-text"><a href="">Администратор</a>
                        <ul class="menu">
                            <li><a href=${pageContext.request.contextPath}"/admin">В меню администратора</a></li>
                            <li><a href=${pageContext.request.contextPath}"admin">Все пользователи</a></li>
                            <li><a href=${pageContext.request.contextPath}"admin">Все заявки</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
            <c:if test="${sessionScope.privilege eq '3'}">
                <ul class="dropdown-menu" data-dropdown-menu>
                    <li class="menu-text"><a href="">Оператор</a>
                        <ul class="menu">
                            <li><a href=${pageContext.request.contextPath}"/operatorTaskView">Назначить заявку</a></li>
                            <li><a href=${pageContext.request.contextPath}"/operatorTaskView">Посмотреть все заявки</a>
                            <li><a href=${pageContext.request.contextPath}"/saveReport">Сформировать отчет</a>
                            </li>
                        </ul>

                    </li>
                </ul>
            </c:if>
            <c:if test="${sessionScope.privilege eq '4'}">
                <ul class="dropdown-menu" data-dropdown-menu>
                    <li class="menu-text"><a href="">Исполнитель</a>
                        <ul class="menu">
                            <li><a href=${pageContext.request.contextPath}"/helpDesk">посмотреть заявки</a></li>
                            <li><a href=${pageContext.request.contextPath}"helpDesk">Открытые заявки</a></li>
                            <li><a href=${pageContext.request.contextPath}"helpDesk">Заявки</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
        </ul>
    </div>
    <div class="top-bar-right">
        <ul class="menu">
            <li class="menu-text"><a href=${pageContext.request.contextPath}"/logout">Выход: ${sessionScope.user}</a>
            </li>
            <li class="menu-text"><a
                    href=${pageContext.request.contextPath}"/helpDesk"><%= formatForDateNow.format(dateNow) %>
            </a>
            </li>
        </ul>
    </div>
</div>