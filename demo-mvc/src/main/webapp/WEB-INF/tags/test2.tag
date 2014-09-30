<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ attribute name="question" required="true" type="come.home.learning.model.Question" %>
<p>
${question.text}
</p>
<form>
	<app:optionsDisplay options="${question.options}" multipleAnswer="${question.multipleAnswer}"
	multipleChoice="${question.multipleChoice}"/>
<c:choose>
	<c:when test="${question.multipleChoice}">
		<c:choose>
		<c:when test="${fn:length(question.options) gt 2}">
			Greater than 2
		</c:when>
		<c:otherwise>
			Less than or equal to 2
		</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<input type="text" name="answer" />
	</c:otherwise>
</c:choose>
<input type="submit" />
</form>