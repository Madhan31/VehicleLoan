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
    <title>Display Loan Detail</title>
    <body>
    	<div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Customer Loan Detail</small></h1>
            </div>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBackAv">
                <img src="img/back.png" alt="logout" style="width:47px;height:42px;border:0;" onclick="javascript:history.back()">
            </div>
            <div class = "container">
        <c:if test = "${null != loanDetails}">\
            <table class="table">
                <thead>
                <tr class = "success">
                	<th>Loan id</th>
                	<th>Loan Amount (Rs.)</th>
                    <th>Emi(Rs.)</th>
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
