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
    <title>Display Customer Detail</title>
    <body>
    <br></br>
    <br>
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
        <c:if test = "${null != usersDetail}">
            <table class = "table">
            <thead>
                <tr class = "success">
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
                </thead>
                <tbody>
                <c:forEach items = "${usersDetail}" var = "userDetail">
                    <tr class ="info">
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
                </tbody>
            </table>
        </c:if>         
        </div> 
        <c:if test = "${null == usersDetail}">
        		<c:out value = "Currently you dont have any loan." />
        </c:if>
    <body>
</html>
