<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="images" href="images">
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <title>Vehicle Operation</title>
    <body>
        <div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Vehicle Operation</small></h1>
            </div>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            <div class ="formBackVp">
                <img src="img/back.png" alt="logout" style="width:47px;height:42px;border:0;" onclick="javascript:history.back()">
            </div>
        <div align = "center" class="formexample">
        <a class = "button" href = insertVehicle>Insert vehicle</a><br></br>
        <a class = "button" href = deleteVehicle>Delete vehicle</a><br></br>
        <a class = "button" href = retrieveAllVehicle>Display all vehicle</a><br></br>
        <a class = "button" href = "adminOperation">Back to main menu</a>
        </div>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>
