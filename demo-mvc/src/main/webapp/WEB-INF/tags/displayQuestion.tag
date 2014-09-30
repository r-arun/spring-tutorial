<%@ attribute name="questionModel" type="come.home.learning.view.model.QuestionViewModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${questionModel.type == 'paragraph'}">
        <p id="${questionModel.id}" class="${questionModel.cssClass}">${questionModel.description}</p>
    </c:when>
    <c:otherwise>
    	<span id="${questionModel.id}" class="${questionModel.cssClass}">${questionModel.description}</span>
    </c:otherwise>
</c:choose>