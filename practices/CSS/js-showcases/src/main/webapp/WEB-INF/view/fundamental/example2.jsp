<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
    
    
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/app.css" />' />

    <script type="text/javascript" src='<c:url value="/resources/js/jquery/jquery-1.11.3.js" />'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/fundamental/example2.js" />'></script>
    
    <title>JS Showcase</title>

</head>
    
<body>

<h1>Mini Game</h>

<div id = "guessResult"></div>
<div>
    <script type="text/javascript">miniGameGuess();</script>
</div>

</body>
</html>