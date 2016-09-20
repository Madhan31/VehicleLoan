<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type= "text/javascript" src = "js/stateCity.js"></script>
</head>
    <c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <title>Add Address</title>
    <body onload = "populateStates('state','city');" >	
    <div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>User Address Detail</small></h1>
            </div>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <img src="img/back.png" alt="logout" style="width:42px;height:47px;border:0;" onclick="alert('<c:out value = "You already applied for loan kindly enter you address..." />')"/>
            </div>
    <form:form action="address" modelAttribute = "address" method="post">
        <table>
        <tr>
        <td>Street Name:</td>
        <td><form:input type = "text" name = "street" path = "street" placeholder = "Street" required = "required"/></td>
        </tr>
        <tr>
        <td>Land Mark:</td>
        <td><form:input type = "text" name = "landmark" path = "landmark" placeholder = "Landmark" required = "required"/></td>
        </tr>
        <tr>
        <td>State</td>		        
        <td><form:select id="state" name ="state" path = "state" ></form:select></td>
        </tr>
        <tr>
        <td>City:</td>  
        <td><form:select id ="city" name ="city" path = "city" ></form:select></td>     
        </tr>
        <tr>
        <td>Pincode</td>
        <td><form:input type = "text" name = "pincode" path = "pincode" placeholder = "Pincode" required = "required"/></td>
        </tr>
        <form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" />
        <tr>
        <td></td>
        <td><input type = "submit" name = "button" value = "Register"/></td>
        </tr>
        </table>
    </form:form>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
            window.location.href = "userOperation";
        </script>
    </c:if>   
    </body>
</html>
