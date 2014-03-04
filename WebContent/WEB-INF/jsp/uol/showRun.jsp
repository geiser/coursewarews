<?xml version="1.0" encoding="UTF-8"?>
<%@page isELIgnored="false" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Activity for UoL</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
</head>
<body>
<center><h1>Select Run*</h1></center> 
<ul>
<c:forEach var="learnerRun" items="${learnerRuns}">
<li>${learnerRun.value[0]} (<a href="${urlCCBase}/WebPlayer/main3.html?userId=${learnerRun.key}&runId=${learnerRun.value[1]}" target="_blank">run</a> in CopperCore)</li>
</c:forEach>
</ul>
<hr/>
*This page is necessary in IMS-LD specification (Doesn't exist submanifest files)
</body>
</html>