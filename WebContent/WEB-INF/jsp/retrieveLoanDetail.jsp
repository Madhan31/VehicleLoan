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
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
            	color: #add8e6;
                background-color: #sdf2s4;
            }
    </style>
    <body>
        <p><h1 align = "center">Customer Loan Detail:</h1></p>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>
        <form action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
        <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
        <c:if test = "${loanDetail != null}">\
            <table>
                <tr>
                    <th>Balance Loan Amount(Rs.)</th>
                    <th>Balance emi (in months)</th>
                    <th>Your Loan id</th>
                </tr>
                    <tr>
                        <td><c:out value="${loanDetail.balanceAmount}" /></td>
                        <td><c:out value="${loanDetail.balanceEmi}" /></td>
                        <td><c:out value="${loanDetail.loan.loanId}" /></td>
                    </tr>
            </table>
        </c:if>   
        <c:if test = "${null == loanDetail}">
        		<c:out value = "Currently you dont have any loan." />
        </c:if>
    <body>
</html>
