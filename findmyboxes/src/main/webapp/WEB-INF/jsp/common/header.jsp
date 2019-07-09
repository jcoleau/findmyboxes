<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${pageTitle}"/></title>
	<c:url value="/" var="homepage"/>
	<c:url value="/css/site.css" var="cssHref" />
	<link rel="stylesheet" href="${cssHref}">
</head>
<body>
	<header>
		<c:url value="/img/findmyboxes-logo.png" var="logo_img_url"/>
		<a href="${homepage}"><img src="${logo_img_url}" title="box logo"/></a>
	</header>
	<section class="main">