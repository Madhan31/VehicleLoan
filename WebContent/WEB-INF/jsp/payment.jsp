<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Payment Addition</title>
<script type="text/javascript">
function getDate()
{
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
    today = dd+"/"+mm+"/"+yyyy;

    document.getElementById("todayDate").value = today;
}
</script>
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <head>        
    </head>
    <title>Add Payment</title>
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
        <li class = "active"><a href="#">Payment</a></li>       
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
            <h1><small>Payment</small></h1>
  </div> 
    
    <body onload = "getDate();">
    <div class = "container">
        <c:if test = "${loans != null}">
            <table class = "table">
                <thead>
                <tr class = "success">
                    <th>Loan ID</th>
                    <th>EMI</th>
                    <th>Period</th>
                    <th>Date</th>
                    <th>Loan Amount</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${loans}" var="loans">
                    <tr class = "info">
                        <td><c:out value="${loans.loanId}" /></td>
                        <td><c:out value="${loans.emi}" /></td>
                        <td><c:out value="${loans.loanPeriod}" /></td>
                        <td><c:out value="${loans.date}" /></td>
                        <td><c:out value="${loans.loanAmount}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>   
        </div>
        <div class = "panel panel-default col-sm-offset-4 col-sm-4 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Payment
      </h2>
   </div>   
      <div class = "panel-body"><br>
        <form:form action = "paymentConfirm" modelAttribute = "payment" class= "login-form"><br></br>
            <div class="form-group">
            <table id = "table td th">
                <tr>
                <td>Loan Id:</td>
                <td><form:input type = "text" name = "loan" path = "loan.loanId" placeholder = "Loan ID" required = "required" /></td>
                </tr>
                <tr>
                <td>Payment Amount:</td>
                <td><form:input type = "text" name = "paymentAmount" path = "paymentAmount" placeholder = "Payment Amount" required = "required" /></td>
                </tr>
                </table>
                <form:input type = "hidden" path = "user.userId" value = "${sessionScope['userId']}" /> <br></br>
                <form:input type = "hidden" path = "date" name = "startdate" id = "todayDate"/>
                <div class = "panel-footer footer-align"><input type = "submit" name = "button" value = "Payment" class="btn btn-info btn-lg pull-right col-sm-4 border input-align"/></div>
       </div>
        </form:form>
        </div>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>
