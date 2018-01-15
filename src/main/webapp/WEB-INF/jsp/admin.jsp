<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.local" var="language"/>

<fmt:message key="link.language" bundle="${language}" var="link_language"/>
<fmt:message key="link.exit" bundle="${language}" var="link_exit"/>
<fmt:message key="h.category_en" bundle="${language}" var="h_category_en"/>
<fmt:message key="h.category_ru" bundle="${language}" var="h_category_ru"/>
<fmt:message key="input.category" bundle="${language}" var="input_category"/>
<fmt:message key="h.unnecessary_properties_en" bundle="${language}" var="h_unnecessary_proterties_en"/>
<fmt:message key="h.unnecessary_properties_ru" bundle="${language}" var="h_unnecessary_proterties_ru"/>
<fmt:message key="h.necessary_properties" bundle="${language}" var="h_necessary_proterties"/>
<fmt:message key="h.description_en" bundle="${language}" var="h_description_en"/>
<fmt:message key="h.description_ru" bundle="${language}" var="h_description_ru"/>
<fmt:message key="button_apply" bundle="${language}" var="button_apply"/>
<fmt:message key="input.power" bundle="${language}" var="input_power"/>
<fmt:message key="input.color" bundle="${language}" var="input_color"/>
<fmt:message key="input.width" bundle="${language}" var="input_width"/>
<fmt:message key="input.height" bundle="${language}" var="input_height"/>
<fmt:message key="input.quality" bundle="${language}" var="input_quality"/>
<fmt:message key="input.velocity" bundle="${language}" var="input_velocity"/>
<fmt:message key="input.price" bundle="${language}" var="input_price"/>
<fmt:message key="input.model" bundle="${language}" var="input_model"/>
<fmt:message key="input.number_available" bundle="${language}" var="input_number_avaliable"/>
<fmt:message key="input.image_path" bundle="${language}" var="input_image_path"/>
<fmt:message key="input.discount" bundle="${language}" var="input_discount"/>
<fmt:message key="input.description" bundle="${language}" var="input_description"/>
<fmt:message key="input.depth" bundle="${language}" var="input_depth"/>
<fmt:message key="input.cleaning_type" bundle="${language}" var="input_cleaning_type"/>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1">
	<link rel="stylesheet" type="text/css" href="../../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../../css/normalize.css">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../../css/adminStyle.css">
	<link rel="shortcut icon" href="../../img/logo.png" type="image/x-icon">
	<title>техно-быт</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-toggleable-md navbar-light bg-faded main-nav">
	  		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
	  		</button>
	 		<a class="navbar-brand" href="/FrontController?command=go_home_page"><img class="logo" src="../../img/logo.png"></a>
	  		<div class="collapse navbar-collapse" id="navbarNavDropdown">
	    		<ul class="navbar-nav">
	      			<li class="nav-item">
	        			<a class="nav-link" href="#">Login-value</a>
	      			</li>
	      			<li class="nav-item dropdown">
	        			<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${link_language}</a>
	        			<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          				<a class="dropdown-item" href="/FrontController?command=change_language&language=en">English</a>
	          				<a class="dropdown-item" href="/FrontController?command=change_language&language=ru">Русский</a>
	        			</div>
	      			</li>
	      			<li class="nav-item">
	        			<a class="nav-link" href="#">${link_exit}</a>
	      			</li>
	    		</ul>
	  		</div>
		</nav>
	</header>
	<div class="wrapper">
		<form action="/FrontController" method="get">
			<input type="hidden" name="command" value="add_new_appliance"/>
			<div class="row">
	    		<div class="col-lg-2 col-md-4 col-sm-12">
                    <h5 class="category-title">${h_category_en}</h5>
                    <input class="property-input" type="text" name="type_en" placeholder="${input_category}">
                    <h5 class="category-title category">${h_category_ru}</h5>
                    <input class="property-input" type="text" name="type_ru" placeholder="${input_category}">
	    		</div>
	    		<div class="col-lg-4 col-md-4 col-sm-12">
	     			<h5 class="category-title">${h_unnecessary_proterties_en}</h5>
	     			<input class="property-input" type="text" name="power_en" placeholder="${input_power}">
	     			<input class="property-input" type="text" name="color_en" placeholder="${input_color}">
	     			<input class="property-input" type="text" name="height_en" placeholder="${input_height}">
	     			<input class="property-input" type="text" name="width_en" placeholder="${input_width}">
	     			<input class="property-input" type="text" name="quality_en" placeholder="${input_quality}">
	     			<input class="property-input" type="text" name="velocity_en" placeholder="${input_velocity}">
                    <input class="property-input" type="text" name="depth_en" placeholder="${input_depth}">
                    <input class="property-input" type="text" name="cleaning_type_en" placeholder="${input_cleaning_type}">
	    		</div>
	    		<div class="col-lg-4 col-md-4 col-sm-12">
	      			<h5 class="category-title">${h_unnecessary_proterties_ru}</h5>
	     			<input class="property-input" type="text" name="power_ru" placeholder="${input_power}">
	     			<input class="property-input" type="text" name="color_ru" placeholder="${input_color}">
	     			<input class="property-input" type="text" name="height_ru" placeholder="${input_height}">
	     			<input class="property-input" type="text" name="width_ru" placeholder="${input_width}">
	     			<input class="property-input" type="text" name="quality_ru" placeholder="${input_quality}">
                    <input class="property-input" type="text" name="velocity_ru" placeholder="${input_velocity}">
                    <input class="property-input" type="text" name="depth_ru" placeholder="${input_depth}">
	     			<input class="property-input" type="text" name="cleaning_type_ru" placeholder="${input_cleaning_type}">
	  	  		</div>
	  	  		<div class="col-lg-2 col-md-12 col-sm-12">
	      			<h5 class="category-title">${h_necessary_proterties}</h5>
	      			<input class="property-input" type="text" name="price" placeholder="${input_price}">
	     			<input class="property-input" type="text" name="model" placeholder="${input_model}">
	     			<input class="property-input" type="text" name="number_available" placeholder="${input_number_avaliable}">
	     			<input class="property-input" type="text" name="image" placeholder="${input_image_path}">
	     			<input class="property-input" type="text" name="discount" placeholder="${input_discount}">
	  	  		</div>

	  	  		<div class="col-lg-12 col-md-12 col-sm-12">
					<h5 class="category-title">${h_description_en}</h5>
					<textarea class="property-input" name="description" placeholder="${input_description}"></textarea>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h5 class="category-title">${h_description_ru}</h5>
					<textarea class="property-input" name="description_ru" placeholder="${input_description}"></textarea>
				</div>
	  		</div>
			<button type="submit" class="btn btn-primary submit-button">${button_apply}</button>
		</form>
	</div>
	<script type="text/javascript" src="../../script/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="../../script/bootstrap.js"></script>
	<script type="text/javascript" src="../../script/admin.js"></script>
</body>
</html>
