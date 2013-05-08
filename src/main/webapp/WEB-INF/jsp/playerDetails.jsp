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
    <h2>Player Details</h2>
    <div class="row">
        <div class="span2">Player ID:</div>
        <div class="span10">${player.id}</div>
    </div>
    <div class="row">
        <div class="span2">First name:</div>
        <div class="span10">${player.firstName}</div>
    </div>
    <div class="row">
        <div class="span2">Last name:</div>
        <div class="span10">${player.lastName}</div>
    </div>
</body>

</html>
