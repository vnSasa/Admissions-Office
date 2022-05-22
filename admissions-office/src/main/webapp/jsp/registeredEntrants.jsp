<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registered Entrants</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
@media screen and (max-width: 455px) {
    .h3 {
        font-size:16px;
    }
}
</style>

</head>
<body style="background:#e6e6e6;color:black;">

<!-- Sidebar -->

	<div class="w3-sidebar w3-light-grey w3-card-4 w3-animate-left"
		style="width: 200px" id="mySidebar">
		
		<div class="w3-bar w3-dark-grey">
			<span class="w3-bar-item w3-padding-16"><spring:message code='home.content'/><br>${pageContext.request.userPrincipal.name}</span>
			<button onclick="w3_close()"
				class="w3-bar-item w3-button w3-right w3-padding-16"
				title="close Sidebar">&times;
			</button>
		</div>
		
		<div class="w3-bar-block">
			
			<a class="w3-bar-item w3-button w3-green" href="/home"><spring:message code='home.home'/></a> 
			<a class="w3-bar-item w3-button" href="/statement"><spring:message code='home.statement'/></a> 
			<a class="w3-bar-item w3-button" href="/entrantRegistration">Entrant Registration (NOT WORK)</a>
			<security:authorize access="hasRole('ROLE_ADMIN')">
			<a class="w3-bar-item w3-button" href="/registeredEntrants"><spring:message code='home.entrant_register'/></a>
			</security:authorize>
			
			<div class="w3-dropdown-hover">
				<a class="w3-button" href="javascript:void(0)"><spring:message code='home.select_faculty'/> (NOT WORK)<i class="fa fa-caret-down"></i></a>
				<div class="w3-dropdown-content w3-bar-block w3-card-4">
					<a class="w3-bar-item w3-button"
						href="${contextPath}/enrolledEntrants?facId=1"><spring:message code='home.economical'/></a> 
					<a class="w3-bar-item w3-button"
						href="${contextPath}/enrolledEntrants?facId=2"><spring:message code='home.biological'/></a> 
					<a class="w3-bar-item w3-button"
						href="${contextPath}/enrolledEntrants?facId=3"><spring:message code='home.languages'/></a> 
					<a class="w3-bar-item w3-button"
						href="${contextPath}/enrolledEntrants?facId=4"><spring:message code='home.geographical'/></a>
				</div>
			</div>
			
		</div>
	</div>

<!-- Page Content -->

	<div id="main" style="margin-left: 200px">

		<div class="w3-container w3-display-container">
			<span title="open Sidebar" style="display: none" id="openNav"
				class="w3-button w3-transparent w3-display-topleft w3-xlarge"
				onclick="w3_open()">&#9776;
			</span>
		</div>

		<div class="container" style="margin-left: 100px">

		<div class="navigation">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>

				<a class="button" onclick="document.forms['logoutForm'].submit()" style="cursor: pointer">
				
					<div class="logout"><spring:message code='home.logout'/></div>
					
				</a>
				
			</c:if>
			
		</div>

			<table class="w3-table-all w3-large">

				<tr>
					<th><spring:message code='re.photo'/></th>
					<th><spring:message code='re.first_name'/></th>
					<th><spring:message code='re.last_name'/></th>
					<th><spring:message code='re.faculty'/></th>
					<th><spring:message code='re.marks'/></th>
					<th><spring:message code='re.total_mark'/></th>
					<th><spring:message code='re.accept'/></th>
				</tr>

				<c:forEach items="${entrants}" var="currentEntrant">
					<tr>
						<td><img src="data:image/jpg;base64, ${currentEntrant.encodedImage}" alt="Norway" style="width: 100%"></td>
						<td>${currentEntrant.user.firstName}</td>
						<td>${currentEntrant.user.lastName}</td>
						<td>${currentEntrant.faculty.name}</td>
						<td>${currentEntrant.marks}</td>
						<td>${currentEntrant.totalMark}</td>
						<td><form:form action="${contextPath}/registeredEntrants" method="POST">
								<input type="hidden" value="${currentEntrant.id}" class="form-control" name="entrantId"> 
								<input type="submit" class="w3-button w3-block w3-dark-grey" value="<spring:message code='re.add'/>">
							</form:form></td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

<script>

function w3_open() {
  document.getElementById("main").style.marginLeft = "180px";
  document.getElementById("mySidebar").style.width = "180px";
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("openNav").style.display = 'none';
}
function w3_close() {
  document.getElementById("main").style.marginLeft = "0";
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("openNav").style.display = "inline-block";
}

</script>

</body>
</html> 