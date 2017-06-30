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
	<form:form modelAttribute="pass" method="POST">
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
							<label for="dayStart" class="control-label">Day of the month</label>
							<form:input type="text" path="dayStart" id="dayStart" class="form-control" placeholder="dd/MM/yyyy"/>
						</div>
						<div class="form-group">
							<label for="timeStart" class="control-label">From time</label>
							<form:input type="text" path="timeStart" id="timeStart" class="form-control" placeholder="HH:mm"/>
						</div>
						<div class="form-group">
							<label for="timeEnd" class="control-label">To time</label>
							<form:input type="text" path="timeEnd" id="timeEnd" class="form-control" placeholder="HH:mm"/>
						</div>
						<div class="form-group">
							<label for="passNumber" class="control-label">Pass Number</label>
							<form:input type="text" path="passNumber" id="passNumber" class="form-control"/>
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
</html>