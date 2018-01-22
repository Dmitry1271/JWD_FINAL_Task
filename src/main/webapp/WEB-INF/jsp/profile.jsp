<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.local" var="language"/>

<fmt:message key="link.language" bundle="${language}" var="link_language"/>
<fmt:message key="link.exit" bundle="${language}" var="link_exit"/>
<fmt:message key="link.cart" bundle="${language}" var="link_cart"/>
<fmt:message key="link.orders" bundle="${language}" var="link_orders"/>
<fmt:message key="h.personal_info" bundle="${language}" var="h_personal_info"/>
<fmt:message key="h.email" bundle="${language}" var="h_email"/>
<fmt:message key="h.phone_number" bundle="${language}" var="h_phone_number"/>
<fmt:message key="h.address" bundle="${language}" var="h_address"/>
<fmt:message key="link.redact_profile" bundle="${language}" var="link_redact_profile"/>
<fmt:message key="link.change_password" bundle="${language}" var="link_change_password"/>
<fmt:message key="input.new_password" bundle="${language}" var="input_new_password"/>
<fmt:message key="input.old_password" bundle="${language}" var="input_old_password"/>
<fmt:message key="input.reenter_password" bundle="${language}" var="input_reenter_password"/>
<fmt:message key="button.save_changes" bundle="${language}" var="button_save_changes"/>
<fmt:message key="p.footer_tel" bundle="${language}" var="p_footer_tel"/>
<fmt:message key="link.footer_email" bundle="${language}" var="link_footer_email"/>



<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="../../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/normalize.css">
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="shortcut icon" href="../../img/logo.png" type="image/x-icon">
    <title>техно-быт</title>
</head>
<body>
<header>
    <nav class="navbar navbar-toggleable-md navbar-light bg-faded main-nav">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/FrontController?command=go_home_page&page=0"><img class="logo" src="../../img/logo.png"></a>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" style="color:#000;" href="#"><b>${requestScope.user.login}</b></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><img class="cart-img" src="../../img/cart-main.png"> ${link_cart}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">${link_orders}</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${link_language}</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/FrontController?command=change_language&language=en">English</a>
                        <a class="dropdown-item" href="/FrontController?command=change_language&language=ru">Русский</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/FrontController?command=exit">${link_exit}</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<div class="wrapper">
    <div class="wrapper__container">
        <h5>${h_personal_info}</h5>
        <div class="card">
            <div class="card-block">
                <h6>${h_email}</h6>
                <p>${requestScope.user.email}</p>
                <h6>${h_phone_number}</h6>
                <p>${requestScope.user.phoneNumber}</p>
                <h6>${h_address}</h6>
                <p>${requestScope.user.address}</p>
                <a href="#redact-profile" data-toggle="collapse" aria-expanded="false"
                   aria-controls="redact-profile">${link_redact_profile}</a>
                <a class="change-pass-link" href="#change-password" data-toggle="collapse" aria-expanded="false"
                   aria-controls="change-password">${link_change_password}</a>
            </div>
        </div>
        <div class="collapse" id="redact-profile">
            <div class="card card-block">
                <form action="/FrontController" name="change_profile_form" onsubmit="return validateInputProfileData()" method="post">
                    <input type="hidden" name="command" value="change_profile"/>
                    <div class="form-group">
                        <label for="formGroupExampleInput">${h_email}</label>
                        <input type="email" class="form-control redact-input" id="formGroupExampleInput"
                               value="${requestScope.user.email}" name="email">
                        <div id="email_error" class="error" style="margin-left: 0;"></div>
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">${h_phone_number}</label>
                        <input type="text" class="form-control redact-input" id="formGroupExampleInput2"
                               value="${requestScope.user.phoneNumber}" name="phone_number">
                        <div id="phone_number_error" class="error" style="margin-left: 0;"></div>
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput3">${h_address}</label>
                        <input type="text" class="form-control redact-input" id="formGroupExampleInput3"
                               value="${requestScope.user.address}" name="address">
                    </div>
                    <button type="submit" class="btn btn-primary">${button_save_changes}</button>
                </form>
            </div>
        </div>
        <div class="collapse" id="change-password">
            <div class="card card-block">
                <form action="/FrontController" name="change_password_form" onsubmit="return validateInputPasswordsData()" method="post">
                    <input type="hidden" name="command" value="change_password"/>
                    <div class="form-group">
                        <input type="password" class="form-control redact-input" id="formGroupExampleInput4"
                               name="old_password" placeholder="${input_old_password}">
                        <div id="old_password_error" class="error" style="margin-left: 0;"></div>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control redact-input" id="formGroupExampleInput5"
                               name="password" placeholder="${input_new_password}">
                        <div id="password_error" class="error" style="margin-left: 0;"></div>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control redact-input" id="formGroupExampleInput6"
                               name="password_confirmation" placeholder="${input_reenter_password}">
                        <div id="password_conf_error" class="error" style="margin-left: 0;"></div>
                    </div>
                    <button type="submit" class="btn btn-primary">${button_save_changes}</button>
                </form>
            </div>
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
<script type="text/javascript" src="../../script/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../../script/bootstrap.js"></script>
<script type="text/javascript" src="../../script/profile.js"></script>
</body>
</html>
