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
    </head>
    <title>Add Company</title>
    <body>
        <br></br>
        <h1 align = "center">Add Company Details</h1>
            <div class="formLogout">
            	<a href="logout">
                	<img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            	</a> 
            </div>
            <div class ="formBackAv">
                <img src="img/back.png" alt="logout" style="width:42px;height:47px;border:0;" onclick="javascript:history.back()">
            </div> 
        	<form:form action = "addCompany" modelAttribute = "insertCompany" class= "login">
            	<table>
                	<tr>
                    	<td>Company Name:</td>
                    	<td><form:input type = "text" name = "companyName" path = "companyName" placeholder = "Company name" required = "required" /></td>
                	</tr>
                	<tr>
                    	<td></td>
                    	<td><input type = "submit" name = "button" value = "Add"/></td>
                	</tr>
            	</table>
        	</form:form>
 			<div class ="formBackOperation">
                <a class = "button" href = "companyOperation" style="width:200px;height:20px;border:0;">Back to company operation</a><br></br>
                <a class = "button" href = "insertVehicle" style="width:200px;height:20px;border:0;">Click to add vehicle</a><br></br>
                <a class = "button" href = "insertVehicleModel" style="width:200px;height:20px;border:0;">Click to add vehicle model</a>
        	</div>    
        	<c:if test="${message != null}" >
        	<script language = "javaScript" type = "text/javascript">
            	alert('<c:out value = "${message}" />');
            	window.location.href = "insertCompany";
        	</script>
    		</c:if>
    </body>
</html>
