<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.local" var="language"/>

<fmt:message key="link.sign_in" bundle="${language}" var="link_sign_in"/>
<fmt:message key="link.admin_settings" bundle="${language}" var="link_admin_settings"/>
<fmt:message key="link.sign_up" bundle="${language}" var="link_sign_up"/>
<fmt:message key="link.home" bundle="${language}" var="link_home"/>
<fmt:message key="link.orders" bundle="${language}" var="link_orders"/>
<fmt:message key="link.help" bundle="${language}" var="link_help"/>
<fmt:message key="link.language" bundle="${language}" var="link_language"/>
<fmt:message key="link.cart" bundle="${language}" var="link_cart"/>
<fmt:message key="link.no_goods" bundle="${language}" var="link_no_goods"/>
<fmt:message key="h.category" bundle="${language}" var="h_category"/>
<fmt:message key="p.footer_tel" bundle="${language}" var="p_footer_tel"/>
<fmt:message key="link.footer_email" bundle="${language}" var="link_footer_email"/>
<fmt:message key="h.popular" bundle="${language}" var="h_popular"/>
<fmt:message key="button.discounted" bundle="${language}" var="button_discounted"/>
<fmt:message key="button.catalog" bundle="${language}" var="button_catalog"/>

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
	<div class="header">
		<div class="header__top">
			<div id="nav-menu">
				<div class="nav-menu__header">
					<a href="/FrontController?command=go_sign_in_page">${link_sign_in}</a>
					<span>/</span>
					<a href="/FrontController?command=go_sign_up_page">${link_sign_up}</a>
					<span class="cross"><a href="/FrontController?command=go_home_page">&#9747;</a></span>
				</div>
				<div class="nav-menu__body">
					<ul>
						<li><a href="/FrontController?command=go_home_page"><img src="../../img/home-icon.png"><span>${link_home}</span></a></li>
						<li><a href="#"><img src="../../img/order-icon.png"><span>${link_orders}</span></a></li>
						<li><a href="#"><img src="../../img/cart.png"><span>${link_cart}</span></a></li>
						<li><a href="#"><img src="../../img/planet-icon.png"><span>${link_language}</span></a></li>
						<li><a href="#"><img src="../../img/question-icon.png"><span>${link_help}</span></a></li>
						<%--если админ--%>
						<li><a href="/FrontController?command=go_admin_page"><img src="../../img/admin-icon.png"><span>${link_admin_settings}</span></a></li>
					</ul>
				</div>
			</div>
			<div class="menu-wrap">
   			    <nav class="menu">
       				<ul class="clearfix">
						<li><a href="/FrontController?command=go_admin_page">${link_admin_settings}</a></li>
            			<li><a href="#">${link_help}</a></li>
            			<li><a href="/FrontController?command=go_sign_in_page">${link_sign_in}</a></li>
            			<li><a href="/FrontController?command=go_sign_up_page">${link_sign_up}</a></li>
            			<li>
               			    <a href="#">${link_language}<span class="arrow">&#9660;</span></a>
 						    <ul class="sub-menu">
                   				<li><a href="/FrontController?command=change_language&language=en">Engish</a></li>
                   				<li><a href="/FrontController?command=change_language&language=ru">Русский</a></li>
               				</ul>
           				</li>
       				</ul>
   				</nav>
			</div>
		</div>
		<div class="header__bottom">
			<button id="menu-button" onclick="displayNavMenu('nav-menu')">
				<div class="menu-button__container">
					<div class="bar"></div>
					<div class="bar"></div>
					<div class="bar"></div>		
				</div>
			</button>
			<a href="/FrontController?command=go_home_page"><img class="logo" src="../../img/logo.png"></a>
			<div class="search">
				<input type="search" name="search-input">
				<button class="search-button">&#128269;</button>
			</div>
			<a href="#">
				<div class="cart-block">
					<div class="cart-block__left">
						<img src="../../img/cart-main.png">
						<span>${link_cart}</span>
					</div>
					<div class="cart-block__right">
						<span>${link_no_goods}</span>
					</div>
				</div>
			</a>
			<a href="#"><img class="cart" src="../../img/cart.png"></a>
			<a href="#"><img class="loupe" src="../../img/loupe.png"></a>
		</div>	
	</div>
</header>
<div class="wrapper">
	<div class="wrapper__center">
		<div class="menu-category">
			<ul class="menu">
				<li class="menu__item main-item"><b>${h_category}</b></li>
				<c:forEach var="type" items="${requestScope.appliance_types}">
					<li class="menu__item"><a href="#">${type}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="wrapper__img">
			<img class="main-img" src="../../img/main-img.jpg">
		</div>	
		<button id="catalog-button">${button_catalog}</button>
		<button id="dicount-goods-button">${button_discounted}</button>
		<div class="title">
			<h5><b>${h_popular}</b></h5>
		</div>
		<div class="cards">
			<div class="card">
				<div class="card__container">
					<div class="card__img">
						<a href="#"><img src="../../img/goods/televisor/tel1.png"></a>
					</div>
					<div class="card__info">
						<a href=""><h3>Televisor</h3></a>
						<a href=""><h3>Sumsung</h3></a>
						<div class="rating">
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
						</div>
						<div class="info__price">
							<div class="price__line"></div>
							<p class="price">2400.00</p>
							<p class="discounted-price"><b>2000.00</b></p>
						</div>
						<button class="cart-button"><b>Add to cart</b></button>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card__container">
					<div class="card__img">
						<a href="#"><img src="../../img/goods/vacuumcleaner/vac1.jpg"></a>
					</div>
					<div class="card__info">
						<a href=""><h3>Vacuum cleaner</h3></a>
						<a href=""><h3>LG</h3></a>
						<div class="rating">
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star"></div>
						</div>
						<div class="info__price">
							<div class="price__line"></div>
							<p class="price">3000.00</p>
							<p class="discounted-price"><b>2700.00</b></p>
						</div>
						<button class="cart-button"><b>Add to cart</b></button>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card__container">
					<div class="card__img">
						<a href="#"><img src="../../img/goods/washingmashine/wash1.jpg"></a>
					</div>
					<div class="card__info">
						<a href=""><h3>Washing mashine</h3></a>
						<a href=""><h3>Sumsung</h3></a>
						<div class="rating">
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star"></div>
						</div>
						<div class="info__price">
							<div class="price__line"></div>
							<p class="price">4000.00</p>
							<p class="discounted-price"><b>3500.00</b></p>
						</div>
						<button class="cart-button"><b>Add to cart</b></button>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card__container">
					<div class="card__img">
						<a href="#"><img src="../../img/goods/televisor/tel1.png"></a>
					</div>
					<div class="card__info">
						<a href=""><h3>Televisor</h3></a>
						<a href=""><h3>Sumsung</h3></a>
						<div class="rating">
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
						</div>
						<div class="info__price">
							<div class="price__line"></div>
							<p class="price">2400.00</p>
							<p class="discounted-price"><b>2000.00</b></p>
						</div>
						<button class="cart-button"><b>Add to cart</b></button>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card__container">
					<div class="card__img">
						<a href="#"><img src="../../img/goods/televisor/tel2.jpg"></a>
					</div>
					<div class="card__info">
						<a href=""><h3>Televisor</h3></a>
						<a href=""><h3>LG</h3></a>
						<div class="rating">
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
						</div>
						<div class="info__price">
							<div class="price__line"></div>
							<p class="price">2800.00</p>
							<p class="discounted-price"><b>2200.00</b></p>
						</div>
						<button class="cart-button"><b>Add to cart</b></button>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card__container">
					<div class="card__img">
						<a href="#"><img src="../../img/goods/vacuumcleaner/vac1.jpg"></a>
					</div>
					<div class="card__info">
						<a href=""><h3>Vacuum cleaner</h3></a>
						<a href=""><h3>LG</h3></a>
						<div class="rating">
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star star-blue"></div>
							<div class="star"></div>
						</div>
						<div class="info__price">
							<div class="price__line"></div>
							<p class="price">3000.00</p>
							<p class="discounted-price"><b>2700.00</b></p>
						</div>
						<button class="cart-button"><b>Add to cart</b></button>
					</div>
				</div>
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
<script type="text/javascript" src="../../script/index.js"></script>
</body>
</html>