<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
    <title>Admin Operation</title>
        <link rel="stylesheet" href="css/style.css">
    <c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <head>
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
    
    <body>
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
        <li class = "active"><a href="#">Home</a></li>
       
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Vehicle Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertVehicle">Add Vehicle</a></li>
              <li><a href="deleteVehicle">Delete Vehicle</a></li>
              <li><a href="retrieveAllVehicle">Display All Vehicle</a></li> 
            </ul>
          </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Model Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertVehicleModel">Add Vehicle Model</a></li>
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
         <li><a href="loanDetail">Loan Payment</a></li>
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
            <h1><small>Admin Operation</small></h1>
  </div>
</body>
</html>
