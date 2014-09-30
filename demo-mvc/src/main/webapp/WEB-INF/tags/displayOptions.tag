<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%@ attribute name="options" required="true" type="come.home.learning.view.model.OptionViewModel" %>
<%@ attribute name="optionsMap" required="false" type="java.util.HashMap" %>
<c:choose>
	<c:when test="${options.multipleAnswer}">
		<span id="${options.id}" class="${options.cssClass}">
            <c:forEach var="option" items="${optionsMap}">
                <input type="checkbox" name="${options.name}" value="${option.key}">${option.value}<br/>
            </c:forEach>
        </span>
	</c:when>
	<c:otherwise>
		<c:choose>
            <c:when test="${options.multipleChoice}">
                <c:choose>
                <c:when test="${fn:length(optionsMap) gt 2}">
                    <select id="${options.id}" name="${options.name}" class="${options.cssClass}">
                        <option value=""></option>
                        <c:forEach var="option" items="${optionsMap}">
                            <option value="${option.key}">${option.value}</option>
                        </c:forEach>
                    </select>
                </c:when>
                <c:otherwise>
                    <span id="${options.id}" class="${options.cssClass}">
                        <c:forEach var="option" items="${optionsMap}">
                            <input type="radio" name="${options.name}" value="${option.key}">${option.value}<br/>
                        </c:forEach>
                    </span>
                </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
            	<input type ="text" name="${options.name}" id="${options.id}" class="${options.cssClass}" />
            </c:otherwise>
        </c:choose>
	</c:otherwise>
</c:choose>