<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <title>Loan balance Detail</title>
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
        <li class = "active"><a href="#">Balance Detail</a></li>
        <li><a href="usersDetail">Customer Detail</a></li>
        <li><a onclick="javascript:history.back()">Go Back</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logIn"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
</nav>      
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Loan Balance Detail</small></h1>
            </div>
            <div class = "container">   
        <c:if test = "${null != loanBalance}">
            <table class="table">
                <thead>
                <tr class = "success">
                    <th>Loan Id</th>
                    <th>Balance amount(Rs.)</th>
                    <th>Balance emi (in months)</th>
                </tr>
                </thead>
                <tbody>
                    <tr class = "info">
                    	<td><c:out value="${loanBalance.loan.loanId}" /></td>
                        <td><c:out value="${loanBalance.balanceAmount}" /></td>
                        <td><c:out value="${loanBalance.balanceEmi}" /></td>             
                    </tr>
                    </tbody>
            </table>
        </c:if>
        </div>
</body>
</html>