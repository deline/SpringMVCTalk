<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<html lang="en">
<head>
    <title>SpringMVCTalk Sample App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>
        Add New Player
    </h2>
    <form:form modelAttribute="player" method="post" class="form-horizontal" id="add-player-form">
        <div>
        <form:label path="firstName" for="firstName">First Name</form:label>
        <form:input path="firstName" id="firstName"/>
        <form:errors path="firstName"/>
        </div>
        <div>
        <form:label path="lastName" for="lastName">Last Name</form:label>
        <form:input path="lastName" id="lastName"/>
        <form:errors path="lastName"/>
        </div>
        <div>
        <form:button name="submit">Submit</form:button>
        </div>
    </form:form>
</div>

</body>

</html>
