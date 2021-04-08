<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student registration</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />
		<br><br>
		Last name: <form:input path="lastName" />
		<br><br>
		Country: 
		<form:select path="country">
			<form:options items="${countryOptions}" />
		</form:select>	
		<br><br>
		Favorite language: <br>
		 Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		 PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		 C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		 Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		<br><br>
		OS used: <br>
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="OSX"/>
		MS Windows <form:checkbox path="operatingSystems" value="Windows"/>

		<input type="submit" />
	</form:form>
</body>
</html>