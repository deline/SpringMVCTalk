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
        <h2>Add New Player</h2>
        <div class="row">
            <form:form modelAttribute="player" method="post" class="form-horizontal" id="add-player-form">
                <div class="span12">
                <form:label path="firstName" for="firstName">First Name</form:label>
                <form:input path="firstName" id="firstName"/>
                <form:errors path="firstName" cssClass="alert alert-error"/>
                </div>
                <div class="span12">
                <form:label path="lastName" for="lastName">Last Name</form:label>
                <form:input path="lastName" id="lastName"/>
                <form:errors path="lastName" cssClass="alert alert-error"/>
                </div>
                <div class="span12">
                <form:button name="submit">Submit</form:button>
                </div>
            </form:form>
        </div>
    </div>

</body>

</html>
