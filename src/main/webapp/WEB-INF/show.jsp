<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Show Language</title>
    </head>
    <body>
        <h1>
            <c:out value="${language.name}"/>
        </h1>
        <p>Creator: <c:out value="${language.creator}"/></p>
        <p>Version: <c:out value="${language.version}"/></p>
     <a href="/languages">Dashboard</a>
    </body>
    </html>