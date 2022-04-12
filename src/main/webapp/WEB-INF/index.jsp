<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Languages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container w-100 h-100">
		<h1>All Languages</h1>
		<table class="table table-striped w-100">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Language</th>
				<th scope="col">Creator</th>
				<th scope="col">Version</th>
				<th scope="col">Action</th>
			</tr>
			<c:forEach var="oneLanguage" items="${languages}">
				<tr>
					<th scope="row"><c:out value="${oneLanguage.id}"></c:out></th>
					<td>
						<a href="/languages/${oneLanguage.id}"><c:out value="${oneLanguage.name}"></c:out></a>
					</td>
					<td><c:out value="${oneLanguage.creator}"></c:out></td>
					<td><c:out value="${oneLanguage.version}"></c:out></td>
					<td class="d-flex flex-row">
						<a href="/languages/${oneLanguage.id}/edit">edit</a>
						<form action="/languages/${oneLanguage.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<button class="btn btn-danger">delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container w-25 border border-secondary p-3">
		<h1>New Language</h1>
		<form:form action="/languages/create" method="post"
			modelAttribute="language">
			<p>
				<form:label path="name">Language Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator" />
				<form:textarea path="creator" />
			</p>
			<p>
				<form:label path="version">Version</form:label>
				<form:errors path="version" />
				<form:input path="version" />
			</p>
			
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>