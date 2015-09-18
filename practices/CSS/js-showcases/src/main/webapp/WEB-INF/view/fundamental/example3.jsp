<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/app.css" />' />

    <script type="text/javascript" src='<c:url value="/resources/js/jquery/jquery-1.11.3.js" />'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/fundamental/example3.js" />'></script>
    
    <title>JS Showcase</title>

</head>
    
<body>

<h1>Example of Object Oriented JS</h>

See the result in console

<div>
    <script type="text/javascript">
    	var student = new Student("nmdien61@gmail.com", "Dien Nguyen");
    	student.enroll();
    	student.go2School();

    	var student1 = new Student("diennguyen@gmail.com", "Dien Nguyen");
    	student1.enroll();
    	student1.go2School();
    </script>
</div>

</body>
</html>