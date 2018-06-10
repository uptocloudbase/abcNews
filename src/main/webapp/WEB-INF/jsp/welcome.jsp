<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Ms ABC</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<security:authorize access="hasRole('ROLE_EDITOR')">
					<li><a href="#">Create new page</a></li>
					</security:authorize>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>${title}</h1>
			<p>Welcome to the news website, please click on an article.</p>

            <c:forEach var="entry" items="${articleList}">
            <ul>
                <li>

                <a href ="viewPage?id=${entry.id}">${entry.title}</a> (${entry.numLikes} likes)
                <security:authorize access="hasRole('ROLE_EDITOR')">
                    <b>${entry.publishStatus}</b> <a href ="editPage?id=${entry.id}">EDIT</a>&nbsp;
                </security:authorize>
            </ul>
            </c:forEach>


		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
