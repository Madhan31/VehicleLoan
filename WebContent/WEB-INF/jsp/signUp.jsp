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
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
   .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

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
        <li><a href="logIn">Home</a></li>
        <li><a href="about">About</a></li>
        <li><a href="contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class = "active"><a href="#"><span class="glyphicon glyphicon-log-in"></span> New User</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class = "panel panel-default col-sm-offset-4 col-sm-4 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Sign up
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