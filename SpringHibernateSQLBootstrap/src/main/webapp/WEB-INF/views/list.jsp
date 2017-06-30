<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass List</title>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-default">
		<a class="navbar-brand">Online Journal</a>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="thumbnail">
					<img src="<c:url value='/resources/img/1.jpg' />" alt="...">
					<div class="caption">
						<h3 class="text-center">${userInfo.firstName}</h3>
						<h3>${userInfo.lastName} ${userInfo.patronymic}</h3>
						<%-- <h5>${userInfo.patronymic}</h5> --%>
						<c:choose>
						<c:when test="${userInfo.firstName == null}">
							<a href="<c:url value='/newuserinfo'/>" class="btn btn-block btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value='/edit-userinfo-${userInfo.id}'/>" class="btn btn-block btn-default"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
						</c:otherwise>
					</c:choose>
						
					</div>
				</div>
			</div>
			<div class="col-md-2">
				<div class="panel panel-default">
					<div class="panel-footer">Department name</div>
					<div class="panel-body">${userInfo.departmentName}</div>
					<div class="panel-footer">Personnel Number</div>
					<div class="panel-body">${userInfo.personnelNumber}</div>
					<div class="panel-footer">Sector</div>
					<div class="panel-body">${userInfo.sector}</div>
					<div class="panel-footer">Position</div>
					<div class="panel-body">${userInfo.position}</div>
					<div class="panel-footer">Experience</div>
					<div class="panel-body">${userInfo.experience}</div>
				</div>
			</div>
			<div class="col-md-7">
				<table class="table table-bordered">
					<tr>
						<th><p class="text-center">#</p></th>
						<th><p class="text-center">Date</p></th>
						<th colspan="2"><p class="text-center">Time</p></th>
						<th><p class="text-center">Number</p></th>
						<th><p class="text-center">Action</p></th>
						<th><p class="text-center">Status</p></th>
					</tr>
					<c:forEach items="${passList}" var="pass">
						<tr>
							<td><p class="text-center">${pass.id}</p></td>
							<td><p class="text-center">${pass.dayStart}</p></td>
							<td><p class="text-center">${pass.timeStart}</p></td>
							<td><p class="text-center">${pass.timeEnd}</p></td>
							<td><p class="text-center">${pass.passNumber}</p></td>
							<td>
								<div class="btn-group btn-block" role="group">
									<button type="button"
										class="btn btn-block btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="<c:url value='/edit-pass-${pass.id}'/>">Edit<span class="glyphicon glyphicon-pencil pull-right" aria-hidden="true"></span></a></li>
										<li><a href="<c:url value='/delete-pass-${pass.id}'/>">Delete<span class="glyphicon glyphicon-remove  pull-right" aria-hidden="true"></span></a></li>
										<li><a>Show<span class="glyphicon glyphicon-picture  pull-right" aria-hidden="true"></span></a></li>
									</ul>
								</div>
							</td>
							<td><p class="text-center"><span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span></p></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="7"><a href="<c:url value='/newpass'/>" class="btn btn-block btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>