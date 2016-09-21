<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <title>Signup Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
         <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         </head>
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
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Model Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertVehicleModel">Add Vehicle</a></li>
              <li><a href="deleteVehicleModel">Delete Vehicle</a></li>
              <li><a href="retrieveAllVehicleModel">Display All Vehicle</a></li> 
            </ul>
          </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Company Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertCompany">Add Company</a></li>
              <li><a href="deleteCompany">Delete Company</a></li>
              <li><a href="retrieveAllCompany">Display All Company</a></li> 
            </ul>
          </li>
          <li><a href="loanDetail">Loan Payment</a></li>
        <li class = "active"><a href="#">Add Admin</a></li>
        <li><a href="usersDetail">Users Detail</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logIn"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
         <div class = "panel panel-default col-sm-offset-4 col-sm-4 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Add admin detail
      </h2>
   </div>   
      <div class = "panel-body"><br>
        <form:form action="addUser" class="login-form" modelAttribute = "user" method="post">
               <div class="form-group">
            <table id = "table td th">
                <tr>
                <td>First Name</td>
                <td><form:input type = "text" name = "firstName" class="form-control" path = "firstName" placeholder = "First Name" required = "required" /></td>	        
                </tr>
                <tr>
                <td>Last Name</td>
                <td><form:input type="text" name="lastName" class="form-control" placeholder="Last Name" path="lastName" required="required" /></td>
                </tr>
                <tr>
                <td>Date Of Birth</td>
                <td><form:input type = "text" name="dateOfBirth" class="form-control" placeholder="DD/MM/YYYY" path="dateOfBirth" required="required" /></td>
                </tr>
                <tr>
                <td>Gender</td>
                <td><form:select path = "gender" class="form-control">
       		        <option value = "null">--select gender--</option>        
       		        <option value = "male">Male</option>
       		        <option value = "female">Female</option>
       		        <option value = "others">Others</option>       		
         	    </form:select></td>
         	    </tr>
         	    <tr>
         	    <td>Email ID</td>     		
                <td><form:input type="text" name="emailId" class="form-control" placeholder="Email" path="emailId" required="required" /></td>
                </tr>
                <tr>
                <td>Mobile Number</td>
                <td><form:input type="text" name=" mobileNumber" class="form-control" placeholder="Mobile Number" path="mobileNumber" required="required" /></td>
                </tr>
                <tr>
                <td>Password</td>
                <td><form:input type="password" name="password" placeholder="Password" path="password" required="required" /></td>
                </tr>
                <form:input type = "hidden" path = "role.roleId" value = "1" />
                </table>
				<div class = "panel-footer footer-align"><input type = "submit" name = "button" value = "Register" class="btn btn-info btn-lg pull-left col-sm-4 border input-align"/></div>                </div>
            </form:form>
            </div>
<style>
input[type=text]:focus { background:#e4f0f8 }
.formLogout {
	width:75%;
	margin:20px auto;
	text-align:right;
	cursor:pointer;
}
.title {
    font-family: "Times New Roman", Times, serif; 
  }
.title-style {
  font-size: 150%;
}
.footer-align {
height : 75px;
}
.border {
border-style: solid double
}
.image-width {
width:250px;
}
.myCarousel-width {
  width:500px;
}
.image-body {
margin-left :50%;
}
.input-align{
margin-left:40%;
}
.r-116 {
right:163px;
}
.carousel {
    margin-bottom: 0;
    padding: 0 40px 30px 40px;
}

/* The controlsy */
.carousel-control {
	left: -12px;
    height: 40px;
	width: 40px;
    background: none repeat scroll 0 0 #222222;
    border: 4px solid #FFFFFF;
    border-radius: 23px 23px 23px 23px;
    margin-top: 90px;
}
.carousel-control.right {
	right: -12px;
}
/* The indicators */
.carousel-indicators {
	right: 50%;
	top: auto;
	bottom: -10px;
	margin-right: -19px;
}
/* The colour of the indicators */
.carousel-indicators li {
	background: #cecece;
}
.carousel-indicators .active {
background: #428bca;
}
</style>            
        </body>
       <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>