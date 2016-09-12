<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type= "text/javascript" src = "js/stateCity.js"></script>
<title>Insert title here</title>
</head>
<title>Address Addition</title>
    <body onload = "populateStates('state','city');" >	
    <br></br><p><h1 align = "center">Add Address Details :</h1>
    <form:form action="address" modelAttribute = "address" method="post">
        <form:input type = "text" name = "street" path = "street" placeholder = "Street" required = "required"/>
        <form:input type = "text" name = "landmark" path = "landmark" placeholder = "Landmark" required = "required"/>		        
        <form:select id="state" name ="state" path = "state" ></form:select><br></br>  
        <form:select id ="city" name ="city" path = "city" ></form:select><br></br>       
        <form:input type = "text" name = "pincode" path = "pincode" placeholder = "Pincode" required = "required"/>
        <form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" />
        <input type = "submit" name = "button" value = "Register"/>
    </form:form>
</body>
</html>
