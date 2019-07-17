<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${pageTitle}" /></title>
	<c:url value="/" var="homepage" />
	<%-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.min.css"> --%>
	<link rel="stylesheet" href="/resources/bulma/css/bulma.min.css">
	<link rel="stylesheet" href="/resources/fontawesome/css/fontawesome.css">
</head>
<body>
	<nav class="navbar" role="navigation" aria-label="main navigation">
		<div class="navbar-brand">
			<c:url value="/img/findmyboxes-logo.png" var="logo_img_url" />
			<a class="navbar-item" href="${homepage}"> <img
				src="${logo_img_url}" height="28" title="box logo">
			</a> <a role="button" class="navbar-burger burger" aria-label="menu"
				aria-expanded="false" data-target="navbarBasicExample"> <span
				aria-hidden="true"></span> <span aria-hidden="true"></span> <span
				aria-hidden="true"></span>
			</a>
		</div>
	</nav>
	<section class="main">