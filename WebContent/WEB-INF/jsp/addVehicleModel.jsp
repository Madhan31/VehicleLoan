<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <title>Add Vehicle Model</title>
    <body>
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
        <li><a href="adminOperation">Home</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Vehicle Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertVehicle">Add Vehicle</a></li>
              <li><a href="deleteVehicle">Delete Vehicle</a></li>
              <li><a href="retrieveAllVehicle">Display All Vehicle</a></li> 
            </ul>
          </li>
        <li class="dropdown"><a class="dropdown-toggle" class = "active" data-toggle="dropdown" href="#">Model Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">Add Vehicle Model</a></li>
              <li><a href="deleteVehicleModel">Delete Vehicle Model</a></li>
              <li><a href="retrieveAllVehicleModel">Display All Vehicle Model</a></li> 
            </ul>
          </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Company Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertCompany">Add Company</a></li>
              <li><a href="deleteCompany">Delete Company</a></li>
              <li><a href="retrieveAllCompany">Display All Company</a></li> 
            </ul>
          </li>
        <li><a href="admin">Add Admin</a></li>
        <li><a href="usersDetail">Users Detail</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logIn"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
 <div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Add Vehicle Detail</small></h1>
            </div>
  <div class = "panel panel-default col-sm-offset-4 col-sm-4 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Add Vehicle Model
      </h2>
   </div>   
      <div class = "panel-body"><br>
        <form:form action = "addVehicleModel" modelAttribute = "insertVehicleModel" class= "login-form">
        	<div class="form-group">
            <table id = "table td th">
                	<tr>
                <td>Vehicle Name:</td>
        <td><form:select path = "vehicle.vehicleId" >
		   <option value="0"> -- Select vehicle -- </option>
		<c:forEach items="${vehicleList}" var="vehicle">
		 <option value="${vehicle.vehicleId}">${vehicle.vehicleName}</option>
		</c:forEach>
		 </form:select></td>
		 </tr>
		 <tr>
		     <td>Model Name:</td>             
             <td><form:input type = "text" name = "vehicleModelName" path = "vehicleModelName" placeholder = "Model name" required = "required" /></td>
         </tr>
         <tr>
             <td>Price:</td>    
             <td><form:input type = "text" name = "price" path = "price" placeholder = "Price" required = "required" data-validation="number" data-validation-error-msg="Please enter number only..." /></td>
         </tr>  
         </table>
        <div class = "panel-footer footer-align"><input type = "submit" name = "button" value = "Add" class="btn btn-info btn-lg pull-right col-sm-4 border input-align"/></div>
         </div>
        </form:form>
        </div>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
            window.location.href = "insertVehicleModel";
        </script>
    </c:if>
</html>
