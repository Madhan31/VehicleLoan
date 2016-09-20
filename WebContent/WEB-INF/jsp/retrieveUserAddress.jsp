<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
    <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/style.css">
    <style>
            textarea {
    			display: block;
			    margin-left: auto;
    			margin-right: auto;
    			resize:none;
			}         
    </style>
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <title>Display Customer Address</title>
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
	<textarea rows="5" cols="50" readonly>Address:
	<m:out value="${userAddress.street}"></m:out>,
	<m:out value="${userAddress.city}"></m:out>,
	<m:out value="${userAddress.state}"></m:out>-<m:out value="${userAddress.pincode}"></m:out>.
	Landmark: <m:out value="${userAddress.landmark}"></m:out>.
	</textarea>
</body>
</html>