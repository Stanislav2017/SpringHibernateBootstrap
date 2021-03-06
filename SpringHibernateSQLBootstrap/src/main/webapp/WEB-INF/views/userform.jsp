<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${contextPath}/resources/css/bootstrap-theme.css">
</head>
<body>
	<form:form modelAttribute="userInfo" method="POST">
		<div class="modal-dialog">
			<div class="modal-content">
				<form:input type="hidden" path="id" id="id" />
				<div class="modal-header">
					<c:choose>
						<c:when test="${edit}">
							<h4 class="modal-title" id="exampleModalLabel">Change pass</h4>
						</c:when>
						<c:otherwise>
							<h4 class="modal-title" id="exampleModalLabel">Create new pass</h4>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="firstName" class="control-label">First Name</label>
								<form:input type="text" path="firstName" id="firstName" class="form-control" placeholder="First Name"/>
							</div>
							<div class="form-group">
								<label for="lastName" class="control-label">Last Name</label>
								<form:input type="text" path="lastName" id="lastName" class="form-control" placeholder="Last Name"/>
							</div>
							<div class="form-group">
								<label for="patronymic" class="control-label">Patronymic</label>
								<form:input type="text" path="patronymic" id="patronymic" class="form-control" placeholder="Patronymic"/>
							</div>
							<div class="form-group">
								<label for="departmentName" class="control-label">Department Name</label>
								<form:input type="text" path="departmentName" id="departmentName" class="form-control" placeholder="Department Name"/>
							</div>
							<div class="form-group">
								<label for="personnelNumber" class="control-label">Personnel Number</label>
								<form:input type="text" path="personnelNumber" id="personnelNumber" class="form-control" placeholder="Personnel Number"/>
							</div>
							<div class="form-group">
								<label for="sector" class="control-label">Sector</label>
								<form:input type="text" path="sector" id="sector" class="form-control" placeholder="Sector"/>
							</div>
							<div class="form-group">
								<label for="position" class="control-label">Position</label>
								<form:input type="text" path="position" id="position" class="form-control" placeholder="Position"/>
							</div>
							<div class="form-group">
								<label for="experience" class="control-label">Experience</label>
								<form:input type="text" path="experience" id="experience" class="form-control" placeholder="Experience"/>
							</div>
						</form>
					</div>
				<div class="modal-footer">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm" />
						</c:otherwise>
					</c:choose>
					<a href="<c:url value='/list'/>" class="btn btn-default">Close</a>
				</div>
			</div>
		</div>
	</form:form>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>