<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css"
	href="../resources/css/screen/template/layout_1.css">
<title>Example</title>
</head>

<body>
	<div id="container">
		<div id="masthead">
			<h1>
				DEE <small>Dragon 88</small>
			</h1>
		</div>
		<div class="main-col">
			<div>
				<ul class="navigation">
					<li>Java</li>
					<li>Spring Framework</li>
					<li>CSS</li>
					<li>Javascript</li>
					<li>Guidance</li>
				</ul>
			</div>

			<div>
				<a href="#">Clagnut example</a>
				<p>A pixel is an unscalable dot on a computer screen, whereas an
					em is a square of its font size. Because font sizes vary, the em is
					a relative unit that responds to user text-size preferences.</p>
				<a href="#">Clagnut example</a>
				<p>A pixel is an unscalable dot on a computer screen, whereas an
					em is a square of its font size. Because font sizes vary, the em is
					a relative unit that responds to user text-size preferences.</p>
				<a href="#">Clagnut example</a>
				<p>A pixel is an unscalable dot on a computer screen, whereas an
					em is a square of its font size. Because font sizes vary, the em is
					a relative unit that responds to user text-size preferences.</p>
				<a href="#">Clagnut example</a>
				<p>A pixel is an unscalable dot on a computer screen, whereas an
					em is a square of its font size. Because font sizes vary, the em is
					a relative unit that responds to user text-size preferences.</p>
			</div>
		</div>

		<div class="slidebar">
			<h4>Login</h4>
			<form>
				<div>Username</div>
				<div>
					<input type="text" />
				</div>
				<div>Password</div>
				<div>
					<input type="password" />
				</div>
			</form>
		</div>
		<div id="footer">
			<img class="footer-img" alt=""
				src=' <c:url value="/resources/images/background1.gif" />' " />
			<ul class ="footer-nav">
				<li>Java</li>
				<li>Spring Framework</li>
				<li>CSS</li>
				<li>Javascript</li>
				<li>Guidance</li>
			</ul>
			<p>Copy right by DEE</p>
			<p>Current Visitors: 100</p>
		</div>
	</div>


</body>
</html>