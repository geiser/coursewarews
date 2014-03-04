<%@page language="java" contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
${callback}([<c:forEach varStatus="taskStatus" var="task" items="${tasks}"><c:if test="${taskStatus.index != 0}">,</c:if>{"identifier" : "${task.identifier}",
"goals" : [ <c:forEach varStatus="goalStatus" var="goal" items="${task.goals}">
<c:if test="${goalStatus.index != 0}">,</c:if>{"compId" : "${goal.comp.id}", "title": "${goal.comp.title}", "level" : "${goal.level}"} </c:forEach>],
		<c:if test="${not empty task.skills}">
		"skills" : [
		<c:forEach varStatus="skillStatus" var="skill" items="${task.skills}">
			<c:if test="${skillStatus.index != 0}">,</c:if>{"skillId" : "${skill.id}", "title" : "${skill.title}" }
		</c:forEach>],
		</c:if>
		<c:if test="${not empty task.attitudes}">
		"attitudes" : [
		<c:forEach varStatus="attitudeStatus" var="attitude" items="${task.attitudes}">
			<c:if test="${attitudeStatus.index != 0}">,</c:if>{"attitudeId" : "${attitude.id}", "title" : "${attitude.title}" }
		</c:forEach>],
		</c:if>
"groups" : [ <c:forEach varStatus="groupStatus" var="group" items="${task.groups}">
<c:if test="${groupStatus.index != 0}">,</c:if>{ "learners" : [<c:forEach varStatus="learnerStatus" var="learner" items="${group.learners}">
<c:if test="${learnerStatus.index != 0}">,</c:if>{ "learnerId" : "${learner.id}", "username" : "${learner.title}" }</c:forEach>] }
		</c:forEach>]}
</c:forEach>]);