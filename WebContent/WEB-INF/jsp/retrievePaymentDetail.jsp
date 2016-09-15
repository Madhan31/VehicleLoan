<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/style.css">
    <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td, th {
                border: 1px solid #000000;
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
            	color: #000000;
                background-color: #sdf2s4;
            }
    </style>
    <body>
        <p><h1 align = "center">Customer Loan Detail:</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>
        <c:if test = "${null != paymentDetails}">\
            <table>
                <tr>
                	<th>Your Payment id</th>
                	<th>Payment Amount (Rs.)</th>
                    <th>Payment Date</th>
                    <th>Loan id</th>                    
                </tr>
                <c:forEach items = "${paymentDetails}" var = "paymentDetail">
                    <tr>
                        <td><c:out value="${paymentDetail.paymentId}" /></td>
                        <td><c:out value="${paymentDetail.paymentAmount}" /></td>
                        <td><c:out value="${paymentDetail.date}" /></td>
                        <td><c:out value="${paymentDetail.loan.loanId}" /></td>                        
                    </tr>
                </c:forEach>
            </table>
        </c:if>   
        <c:if test = "${null == paymentDetails}">
        		<c:out value = "There is no payment." />
        </c:if>
    <body>
</html>