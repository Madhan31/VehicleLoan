<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="css/style.css">
    <c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <br></br>
        <h1 align = "center">Add Vehicle Details</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div> 
        <form:form align = "center" action = "addVehicle" modelAttribute = "insertVehicle" class= "login">
            <fieldset>
                <form:input type = "text" name = "vehicleName" path = "vehicleName" placeholder = "Vehicle name" required = "required" /><br></br>
                 <input type = "submit" name = "button" value = "Add"/>
            </fieldset>
        </form:form>
        <div class ="formBackOperation">
                <a class = "button" href = "vehicleOperation" style="width:200px;height:20px;border:0;">Back to vehicle operation</a><br></br>
                <a class = "button" href = "insertVehicleModel" style="width:200px;height:20px;border:0;">Click to add vehicle model</a><br></br>
                <a class = "button" href = "insertCompany" style="width:200px;height:20px;border:0;">Click to add company</a>
        </div><br></br><br></br>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
            window.location.href = "insertVehicle";
        </script>
    </c:if>
</html>
