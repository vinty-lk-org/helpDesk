<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>admin</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>

<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>
    <br>

    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">
                <div class="expanded button-group">
                    <A href="${pageContext.request.contextPath}/adminFillPage">
                    <button type="submit" class="button success"><b>Заполнить справочники</b></button>
                    </A>
                </div>
                <div class="medium-3 cell">

                </div>
            </div>
        </div>

        <script>
            $(document).foundation();
        </script>
</body>

</html>
