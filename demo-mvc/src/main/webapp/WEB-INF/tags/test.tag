 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="question" required="true" %>
<%@ attribute name="dummyParam" required="false" %>
<c:choose>
    <c:when test="${dummyParam}">
        <h2>
        ${question}
        </h2>
    </c:when>
    <c:otherwise>
    	Empty demo
    </c:otherwise>
</c:choose>