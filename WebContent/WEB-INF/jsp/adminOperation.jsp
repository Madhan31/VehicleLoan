<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
        <link rel="stylesheet" href="css/style.css">
    <c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <br></br>
        <h1 align = "center" style="font-color:#000000;">Admin Operation</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a> 
            </div>
        <div class="formexample">
        <a class = "button" href = vehicleOperation>Vehicle operation</a><br>
        <a class = "button" href = vehicleModelOperation>Vehicle model operation</a><br>
        <a class = "button" href = companyOperation>Company operation</a><br>
        <a class = "button" href = loanDetail>Loan payment </a><br>
        <a class = "button" href = admin>Add admin</a><br>
        <a class = "button" href = usersDetail>Users Details</a><br>
        </div>
    </body>
</html>
