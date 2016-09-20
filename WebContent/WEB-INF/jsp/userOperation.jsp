<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <link rel="stylesheet" href="css/style.css">
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>    
    <body>
        <br></br>
    	<h1 align = "center" style="font-color:#000000;">User Operation</h1>
            <div class="formLogout">
            <a href="logout">
                <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
    <div class="formexample">	   
    <a class = "button" href = homePage>Apply for loan</a><br>
    <a class = "button" href = retrieveUserLoanDetail>View loan detail</a>
    </div>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>
