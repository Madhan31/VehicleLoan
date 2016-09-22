<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <title>Display Customer Detail</title>
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
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Vehicle Model Operation<span class="caret"></span></a>
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
        <li><a href="admin">Add Admin</a></li>
        <li class = "active"><a href="#">Users Detail</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Customer's Detail</small></h1>
            </div> 
            <div class = "container">
        <c:if test = "${null != usersDetail}">
            <table class = "table">
            <thead>
                <tr class = "success">
                	<th>User Id</th>
                	<th>First Name</th>
                    <th>Last Name</th>
                    <th>Contact No.</th>
                    <th>Email Id</th>
                    <th>DOB</th> 
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Eligibility Detail</th>
                    <th>Loan Detail</th>                   
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${usersDetail}" var = "userDetail">
                    <tr class ="info">
                        <td><c:out value="${userDetail.userId}" /></td>
                        <td><c:out value="${userDetail.firstName}" /></td>
                        <td><c:out value="${userDetail.lastName}" /></td>
                        <td><c:out value="${userDetail.mobileNumber}" /></td>
                        <td><c:out value="${userDetail.emailId}" /></td>
                        <td><c:out value="${userDetail.dateOfBirth}" /></td>
                        <td><c:out value="${userDetail.gender}" /></td>
                        <td><a href = "retrieveUserAddress?userId=${userDetail.userId}"> view address</a></td>
                        <td><a href = "retrieveUserEligibilityDetail?userId=${userDetail.userId}"> view eligibility detail</a></td>
                        <td><a href = "retrieveLoanDetail?userId=${userDetail.userId}"> view loan detail</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>         
        </div> 
        <c:if test = "${null == usersDetail}">
        		<c:out value = "Currently you dont have any loan." />
        </c:if>
    <body>
</html>
