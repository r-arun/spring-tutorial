<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%@ attribute name="options" required="true" type="java.util.Collection" %>
<%@ attribute name="multipleAnswer" required="true" type="java.lang.Boolean" %>
<%@ attribute name="multipleChoice" required="true" type="java.lang.Boolean" %>
<c:choose>
	<c:when test="${multipleAnswer}">
        <c:forEach var="option" items="${options}">
            <input type="checkbox" name="answer" value="${option}">${option} <br/>
        </c:forEach>
	</c:when>
	<c:otherwise>
		<c:if test="${multipleChoice}">
            <c:choose>
            <c:when test="${fn:length(options) gt 2}">
                <select name="answer">
                    <c:forEach var="option" items="${options}">
                        <option value="${option}">${option}</option>
                    </c:forEach>
                </select>
            </c:when>
            <c:otherwise>
                <c:forEach var="option" items="${options}">
                    <input type="radio" name="answer" value="${option}">${option} <br/>
                </c:forEach>
            </c:otherwise>
            </c:choose>
        </c:if>
	</c:otherwise>
</c:choose>

