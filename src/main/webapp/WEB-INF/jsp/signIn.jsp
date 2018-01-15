<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.local" var="language"/>

<fmt:message key="h.sign_in" bundle="${language}" var="h_sign_in"/>
<fmt:message key="input.login" bundle="${language}" var="input_login"/>
<fmt:message key="input.password" bundle="${language}" var="input_password"/>
<fmt:message key="button.sign_in" bundle="${language}" var="button_sign_in"/>
<fmt:message key="span.sign_in_question" bundle="${language}" var="span_question"/>
<fmt:message key="link.registration" bundle="${language}" var="link_registration"/>
<fmt:message key="p.footer_tel" bundle="${language}" var="p_footer_tel"/>
<fmt:message key="link.footer_email" bundle="${language}" var="link_footer_email"/>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
	<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1">
	<link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="stylesheet" type="text/css" href="../../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <link rel="shortcut icon" href="../../img/logo.png" type="image/x-icon">
	<title>техно-быт</title>
</head>
<body>
	<header>
		<div class="header__bottom">
			<a href="/FrontController?command=go_home_page"><img class="logo" src="../../img/logo.png"></a>
		</div>
	</header>
	<div class="wrapper">
		<div class="main-form">
			<div class="container">
				<h2>${h_sign_in}</h2>
				<form name="login_form" onsubmit="return vlidateLoginData()" action="/FrontController" method="post">
					<input type="hidden" name="command" value="sign_in"/>
					<div class="input-block">
						<input id="login" type="text" name="login" placeholder="${input_login}">
						<div id="login_error" class="error"></div>
					</div>
					<div class="input-block">
						<input id="password" type="password" name="password" placeholder="${input_password}">
						<div id="password_error" class="error"></div>
					</div>
					<button type="submut" id="login-submit-button">${button_sign_in}</button>
				</form>
				<p><span>${span_question} </span><a href="/FrontController?command=go_sign_up_page">${link_registration}</a></p>
			</div>	
		</div>
	</div>
	<footer>
		<div class="footer__wrapper">
			<div class="container">
				<ul class="content">
					<li>${p_footer_tel}+375-(25)-955-11-23</li>
					<li>${link_footer_email}<a href="#">technoBit@gmail.com</a></li>
				</ul>
			</div>
		</div>
	</footer>
<%--<script type="text/javascript" src="script/signIn.js"></script>--%>
</body>
</html>