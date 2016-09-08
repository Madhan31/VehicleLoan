<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
      <link rel="stylesheet" href="css/style.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<title>Loan Addition</title>
<body>
    <body>
    <br></br><p><h1 align = "center">Register Loan Details :</h1>
    <form:form action="addUser" modelAttribute = "user" method="post">
     <form:input type = "text" name = "firstName" path = "firstName" placeholder = "First Name" required = "required" />		        
        <form:input type="text" name="lastName" placeholder="Last Name" path="lastName" required="required" /><br></br>  
        <form:input type = "text" name="dateOfBirth" placeholder="DD/MM/YYYY" path="dateOfBirth" required="required" /><br></br>
        <form:select path = "gender">
       		<option value = "null">--select gender--</option>        
       		<option value = "male">Male</option>
       		<option value = "female">Female</option>
       		<option value = "others">Others</option>       		
       	</form:select>     
        <form:input type="text" name="emailId" placeholder="Email" path="emailId" required="required" />
        <form:input type="text" name=" mobileNumber" placeholder="Mobile Number" path="mobileNumber" required="required" />
        <form:input type="password" name="password" placeholder="Password" path="password" required="required" />
        <form:input type = "hidden" path = "role.roleId" value = "1" />
        <input type = "submit" name = "button" value = "Register"/>
    </form:form>
</body>
</html>
