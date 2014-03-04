<%@page language="java" contentType="text/xml" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tasks>
<c:forEach varStatus="taskStatus" var="task" items="${tasks}">
    <task identifier="${task.identifier}">
    <c:forEach varStatus="goalStatus" var="goal" items="${task.goals}">
        <goal id="${goal.comp.id}" level="${goal.level}">
            <competency id="${goal.comp.id}">${goal.comp.title}</competency>
            <level id="${goal.level}">${goal.level}</level>
            <learners>
            <c:forEach varStatus="learnerStatus" var="learner" items="${goal.learners}">
                <learner id="${learner.id}">${learner.title}</learner>
            </c:forEach>
            </learners>
        </goal>
        <c:if test="${not empty task.skills}">
        <skills>
        <c:forEach varStatus="skillStatus" var="skill" items="${task.skills}">
            <skill id="${skill.id}">${skill.title}</skill>
        </c:forEach>
        </skills>
        </c:if>
        <c:if test="${not empty task.attitudes}">
        <attitudes>
        <c:forEach varStatus="attitudeStatus" var="attitude" items="${task.attitudes}">
            <attitude id="${attitude.id}">${attitude.title}</attitude>
        </c:forEach>
        </attitudes>
        </c:if>
    </c:forEach>
    </task>
</c:forEach>
</tasks>