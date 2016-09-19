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
                background-color: #dddddd;
            }
    </style>
    <body>
        <br></br>
        <h1 align = "center">Customer Loan Detail:</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>
        <c:if test = "${null != loanDetails}">\
            <table>
                <tr>
                	<th>Loan id</th>
                	<th>Loan Amount (Rs.)</th>
                    <th>Emi(Rs.)</th>
                    <th>Loan Period (in months)</th>
                    <th>Loan applied Date</th>
                    <th>Vehicle Name</th>                    
                </tr>
                <c:forEach items = "${loanDetails}" var = "loanDetail">
                    <tr>
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
            </table>
        </c:if>   
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
