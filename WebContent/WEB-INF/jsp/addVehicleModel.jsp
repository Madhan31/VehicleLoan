<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <title>Vehicle Addition</title>
      <link rel="stylesheet" href="css/style.css">
    <body>
        <form align = "right" action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
    <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
    <br></br><p><h1 align = "center">Add Vehicle Details :</h1></p>
    <form:form action = "addVehicleModel" method = "get" modelAttribute = "insertVehicleModel" class= "login"><br></br>
        <fieldset>
            <legand>Insert vehicle model</legand>
            <form:input type = "text" name = "vehicleModelName" path = "vehicleModelName" placeholder = "Model name" required = "required" /><br></br>
            <form:input type = "text" name = "price" path = "price" placeholder = "Price" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..." /><br></br>  
            <input type = "submit" name = "button" value = "Add"/>
        </fieldset>
    </form:form>
    <a href = "adminOperation">Back to main page</a>
</body>
</html>
