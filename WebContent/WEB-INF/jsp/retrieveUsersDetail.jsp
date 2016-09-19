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
    <body>
    <br></br>
    <br>
        <p><h1 align = "center">Customer Loan Detail:</h1>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>
        <c:if test = "${null != usersDetail}">
            <table>
                <tr>
                	<th>User id</th>
                	<th>First Name</th>
                    <th>Last Name</th>
                    <th>Contact No.</th>
                    <th>Email Id</th>
                    <th>DOB</th> 
                    <th>Gender</th>
                    <th>Address</th>
                    <th>EligibilityDetail</th>
                    <th>Loan Detail</th>                   
                </tr>
                <c:forEach items = "${usersDetail}" var = "userDetail">
                    <tr>
                        <td><c:out value="${userDetail.userId}" /></td>
                        <td><c:out value="${userDetail.firstName}" /></td>
                        <td><c:out value="${userDetail.lastName}" /></td>
                        <td><c:out value="${userDetail.mobileNumber}" /></td>
                        <td><c:out value="${userDetail.emailId}" /></td>
                        <td><c:out value="${userDetail.dateOfBirth}" /></td>
                        <td><c:out value="${userDetail.gender}" /></td>
                        <td><a href = "retrieveUserAddress?userId=${userDetail.userId}"> view address</a></td>
                        <td><a href = "retrieveUserEligibilityDetail?userId=${userDetail.userId}"> view eligibility detail</a></td>
                        <td><a href = "retrieveLoanDetail?userId=${userDetail.userId}"> view loan detail</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>          
        <c:if test = "${null == usersDetail}">
        		<c:out value = "Currently you dont have any loan." />
        </c:if>
    <body>
</html>
