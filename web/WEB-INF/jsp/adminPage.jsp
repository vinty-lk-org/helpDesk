<%--
  Created by IntelliJ IDEA.
  User: lk
  Date: 06.09.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminPage</title>
</head>
<body>
<form name="textform" id="textform" action="${pageContext.request.contextPath}/redirectLogin" method="post">
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">
                <div class="expanded button-group">
                    <button type="submit" class="button success"><b>Заполнить справочники</b></button>
                </div>
            </div>
            <div class="medium-3 cell">

            </div>
        </div>
    </div>
</form>
</body>
</html>
