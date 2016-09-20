<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <title>Display All Balance Loan</title>
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