<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${pageTitle}" /></title>
	<c:url value="/" var="homepage" />
	<link rel="stylesheet" href="resources/bulma/css/bulma.css">
	<link rel="stylesheet" href="resources/fontawesome/css/fontawesome.css">
	<link rel="stylesheet" href="resources/css/site.css">
</head>
<body>
	<nav class="navbar is-light" role="navigation" aria-label="main navigation">
		<div class="navbar-brand">
			<figure class="image">
				<a class="navbar-item" href="${homepage}">
	  				<img id="logo-image" src="img/box-logo-no-background.png" title="box logo">
				</a>
			</figure>
			<div class="navbar-item">
        		<a class="navbar-item" href="${homepage}">
        			<h1 class="title">Find My Boxes</h1>
        		</a>
        	</div>
		</div>
	</nav>
	<section class="main">