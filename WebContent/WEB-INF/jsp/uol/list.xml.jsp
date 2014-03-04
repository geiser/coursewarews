<%@page isELIgnored="false" %>
<%@page language="java" contentType="text/xml" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<courses>
<c:forEach varStatus="taskStatus" var="task" items="${tasks}">
	<course>
		<metadata>
		</metadata>
    </course>
</c:forEach>
</courses>