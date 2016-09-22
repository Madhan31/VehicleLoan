<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <link rel="stylesheet" href="css/style.css">
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <title>Display Loan Detail</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">
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
        <li class = "active"><a href="#">Loan Detail</a></li>
        <li><a href="usersDetail">Go Back</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logIn"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Loan Detail</small></h1>
            </div>
            <div class = "container">
        <c:if test = "${null != loanDetails}">
            <table class="table">
                <thead>
                <tr class = "success">
                	<th>Loan Id</th>
                	<th>Loan Amount (Rs.)</th>
                    <th>EMI (Rs.)</th>
                    <th>Loan Period (in months)</th>
                    <th>Loan Applied Date</th>
                    <th>Vehicle Name</th>
                    <th>Balance Emi</th> 
                    <th>Payment Detail</th>                   
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${loanDetails}" var = "loanDetail">
                    <tr class = "info">
                        <td><c:out value="${loanDetail.loanId}" /></td>
                        <td><c:out value="${loanDetail.loanAmount}" /></td>
                        <td><c:out value="${loanDetail.emi}" /></td>
                        <td><c:out value="${loanDetail.loanPeriod}" /></td>
                        <td><c:out value="${loanDetail.date}" /></td>
                        <td><c:out value="${loanDetail.eligibilityDetail.vehicleModel.vehicleModelName}" /></td>
                        <td><a href = "retrieveLoanBalance?loanId=${loanDetail.loanId}"> view balance</a></td>
                        <td><a href = "retrievePaymentDetail?loanId=${loanDetail.loanId}"> view payment detail</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>   
        </div>
        <c:if test = "${null == loanDetails}">
        		<c:out value = "Currently you dont have any loan." />
        </c:if>
    <body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>
