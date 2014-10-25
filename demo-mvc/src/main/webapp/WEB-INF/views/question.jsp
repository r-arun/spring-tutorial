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
	<script src="resources/inputValidator.js"></script>
	<div id="alert-box"></div>
	<form onsubmit="return checkInput();">
        <app:displayQuestion questionModel="${question}" />
        <app:displayOptions options="${options}" optionsMap="${options.valueDescriptionMap}" />
        <span> <input type="submit"> </span>
    </form>
</body>
</html>