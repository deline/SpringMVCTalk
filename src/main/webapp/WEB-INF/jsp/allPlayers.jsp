<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <title>SpringMVCTalk Sample App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/resources/vendor/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

        <h1><a href="/">SpringMVCTalk Sample</a></h1>
        <h2>All Players</h2>
        <c:forEach items="${players}" var="player">
            <div class="row">
                <div class="span12">
                    <a href="<c:url value="${player.id}"/>">${player.firstName} ${player.lastName}</a>
                </div>
            </div>
        </c:forEach>
    </div>

</body>

</html>
