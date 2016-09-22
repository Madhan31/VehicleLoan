<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>   
    <title>Display Payment Detail</title> 
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
        <li class = "active"><a href="#">Payment Detail</a></li>
        <li><a href="usersDetail">Customer Detail</a></li>
        <li><a onclick="javascript:history.back()">Go Back</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
</nav>      
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Loan Payment Detail</small></h1>
            </div>
            <div class = "container">
            <c:if test = "${null != paymentDetails}">
            <table class = "table">
            <thead>
                <tr class = "success">
                	<th>Your Payment id</th>
                	<th>Payment Amount (Rs.)</th>
                    <th>Payment Date</th>
                    <th>Loan id</th>                    
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${paymentDetails}" var = "paymentDetail">
                    <tr class = "info">
                        <td><c:out value="${paymentDetail.paymentId}" /></td>
                        <td><c:out value="${paymentDetail.paymentAmount}" /></td>
                        <td><c:out value="${paymentDetail.date}" /></td>
                        <td><c:out value="${paymentDetail.loan.loanId}" /></td>                        
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>   
        </div>
        <c:if test = "${null == paymentDetails}">
        		<c:out value = "There is no payment." />
        </c:if>
    <body>
</html>
