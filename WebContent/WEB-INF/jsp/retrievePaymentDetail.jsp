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
    <title>Display Payment Detail</title> 
    <body>
        <p><h1 align = "center">Customer Loan Detail:</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBackAv">
                <img src="img/back.png" alt="logout" style="width:47px;height:42px;border:0;" onclick="javascript:history.back()">
            </div>
            <div class = "container">
            <c:if test = "${null != paymentDetails}">\
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
