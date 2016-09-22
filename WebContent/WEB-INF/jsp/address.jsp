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
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a onclick="alert('<c:out value = "You already applied for loan kindly enter you address..." />')">Go Back</a></li>
        <li><a href="retrieveUserLoanDetail">View Loan Detail</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in" style = "color:red;"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>      
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Add Address Detail</small></h1>
            </div>                                 
<div class = "panel panel-default col-sm-offset-4 col-sm-4 col">    
    <div class = "panel-body"><br> 
    <form:form action="address" modelAttribute = "address" method="post">
        <div class="form-group">
        <table id = "table td th">
        <tr>
        <td>Street Name:</td>
        <td><form:input type = "text" name = "street" path = "street" placeholder = "Street" required = "required"/></td>
        </tr>
        <tr>
        <td>Land Mark:</td>
        <td><form:input type = "text" name = "landmark" path = "landmark" placeholder = "Landmark" required = "required"/></td>
        </tr>
        <tr>
        <td>State:</td>		        
        <td><form:select id="state" name ="state" path = "state" ></form:select></td>
        </tr>
        <tr>
        <td>City:</td>  
        <td><form:select id ="city" name ="city" path = "city" ></form:select></td>     
        </tr>
        <tr>
        <td>Pincode:</td>
        <td><form:input type = "text" name = "pincode" path = "pincode" placeholder = "Pincode" required = "required"/></td>
        </tr>
        <form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" />
        </table>
       <div class = "panel-footer footer-align"><input type = "submit" name = "button" value = "Add" class="btn btn-info btn-lg pull-right col-sm-4 border input-align"/></div> 
        </div>
    </form:form>
    </div>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
            window.location.href = "userOperation";
        </script>
    </c:if>   
    </body>
</html>
