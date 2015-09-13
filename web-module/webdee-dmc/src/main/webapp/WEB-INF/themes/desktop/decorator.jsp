<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="resources/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    
    <title><sitemesh:write property='title'/></title>
    
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4"><h3 class="lead">DMC <small>DEE Management Console</small></h3></div>
            <div class="col-md-8">
                
            </div>
        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-7">
                <sitemesh:write property='body'/>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <h4>Using Sitemesh template</h4>
        </div>
    </div>
    
    <script src="resources/js/jquery-1.11.3.min.js"></script>
    <script src="resources/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>