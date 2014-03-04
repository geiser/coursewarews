<%@page isELIgnored="false" %>
<%@page language="java" contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
${callback}([<c:forEach varStatus="courseStatus" var="course" items="${courses}"><c:if test="${courseStatus.index != 0}">,</c:if>{"id" : "${course.id}",
"metadata" : "${course.metadata.id}",
"title" : "${course.metadata.title}"}
</c:forEach>]);