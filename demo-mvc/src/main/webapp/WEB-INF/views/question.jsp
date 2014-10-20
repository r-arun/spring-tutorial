<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="app"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<script>
	function isInputMandatory() {
        var questionElement = $("#question");
		if (questionElement !== null) {
            var classArray = questionElement.attr("class").split(" ");
            var index = $.inArray("answer-required", classArray);
            return (index >= 0);
		}
		return false;
	}
	function checkInput() {
		var validity = true;
		if(isInputMandatory())	{
			optionElement = $("#option");
			if (optionElement !== null)  {
				var tagName = optionElement[0].tagName;
				if (tagName === "INPUT") {
					if (optionElement.attr("type").toLowerCase() === "text") {
						validity = optionElement.val() !== "";	
					}
				} else if (tagName === "SELECT") {
					validity = optionElement.val() !== "";
				}
			}
			//TODO display an alert saying that input is invalid and ask
			//use to try again.
			console.log("Validity of input is " + validity);
            return validity;
		}
	}
	</script>
	<form onsubmit="return checkInput();">
        <app:displayQuestion questionModel="${question}" />
        <app:displayOptions options="${options}" optionsMap="${options.valueDescriptionMap}" />
        <span> <input type="submit"> </span>
    </form>
</body>
</html>