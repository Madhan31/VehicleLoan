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
            td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                background-color: #c8897b;
            }            
            tr:nth-child(even) {
                background-color: #dddddd;
            }
    </style>
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <title>Display Eligibility Detail</title>
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
        <c:if test = "${null != eligibilityDetails}">
            <table>
                <tr>
                	<th>Salary</th>
                	<th>Down Payment</th>
                    <th>Company Name</th>
                    <th>Current City</th>
                    <th>Vehicle Name</th>                
                </tr>
                <c:forEach items = "${eligibilityDetails}" var = "eligibilityDetail">
                    <tr>
                        <td><c:out value="${eligibilityDetail.salary}" /></td>
                        <td><c:out value="${eligibilityDetail.downPayment}" /></td>
                        <td><c:out value="${eligibilityDetail.company.companyName}" /></td>
                        <td><c:out value="${eligibilityDetail.currentCity}" /></td>
                        <td><c:out value="${eligibilityDetail.vehicleModel.vehicleModelName}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>          
        <c:if test = "${null == eligibilityDetails}">
        		<c:out value = "There is no eligibility detail for this user." />
        </c:if>
    <body>
</html>
