<?xml version="1.0" encoding="UTF-8"?>
<%@page isELIgnored="false" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Course ${course.metadata.title}</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
</head>
<body>
<center><h1>Course ${course.id}</h1></center>
<p/>
Title: ${course.metadata.title} (<a href="<c:url value="/uol/${course.metadata.id}.zip" />" >Download</a> - <a href="<c:url value="/uol/${course.metadata.id}/imsmanifest.xml" />">imsmanifest.xml</a>)
<p/>
Participants (CopperCore):
<ul>
<c:forEach var="participant" items="${participants}">
	<li>${participant.value} (<a href="${urlCCBase}/WebPlayer/main3.html?userId=${participant.key}&runId=${runId}" target="_blank">view</a> in CopperCore)</li>
</c:forEach>
</ul>

</body>
</html>