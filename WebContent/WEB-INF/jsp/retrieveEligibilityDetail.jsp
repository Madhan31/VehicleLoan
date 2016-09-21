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
    <title>Display Eligibility Detail</title>
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
        <li class = "active"><a href="#">Eligibility Detail</a></li>
        <li><a href="usersDetail">Go Back</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logIn"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
  <div id="contact" class="container">
  <h3 class="text-center">Customer Eligibility Detail</h3>
  </div>
            <div class = "container">
        <c:if test = "${null != eligibilityDetails}">
            <table class="table">
                <thead>
                <tr class = "success">
                	<th>Salary</th>
                	<th>Down Payment</th>
                    <th>Company Name</th>
                    <th>Current City</th>
                    <th>Vehicle Name</th>                
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${eligibilityDetails}" var = "eligibilityDetail">
                    <tr class = "info">
                        <td><c:out value="${eligibilityDetail.salary}" /></td>
                        <td><c:out value="${eligibilityDetail.downPayment}" /></td>
                        <td><c:out value="${eligibilityDetail.company.companyName}" /></td>
                        <td><c:out value="${eligibilityDetail.currentCity}" /></td>
                        <td><c:out value="${eligibilityDetail.vehicleModel.vehicleModelName}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>     
        </div>     
        <c:if test = "${null == eligibilityDetails}">
        		<c:out value = "There is no eligibility detail for this user." />
        </c:if>
    <body>
</html>
