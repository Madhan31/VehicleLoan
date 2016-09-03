<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <title>Employee Addition</title>
      <link rel="stylesheet" href="css/style.css">
    <body>
        <form align = "right" action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
    <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
    <br></br><p><h1 align = "center">Register Eligibility Details :</h1></p>
    <form action = "addeligibilitydetail" method = "get" modelAttribute = "EligibilityDetail" class= "login"><br></br>
        <input type = "text" name = "id" path = "id" placeholder = "Eligibility id" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..." /><br></br>
        <input type = "text" name = "currentcity" path = "currentCity" placeholder = "Current City" required = "required" /><br></br>
        <input type = "text" name = "employment" path = "employment" placeholder = "Employment" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..." /><br></br>  
        <input type = "text" name = "company" path = "company" placeholder = "company" required = "required" /><br></br>
        <input type = "text" name = "salary" path = "salary" placeholder = "salary" required = "required" /><br></br>
        <input type = "text" name = "downpayment" path = "downPayment" placeholder = "Down Payment" required = "required" /><br></br>                
        <input type = "submit" name = "button" value = "Register"/>
    </form>
</body>
</html>