<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
        <link rel="stylesheet" href="css/style.css">
    <c:if test="${sessionScope['userId'] == null}" >
        <c:redirect url = "index.jsp" />
    </c:if>
    <c:if test="${sessionScope['role'] != 'admin'}" >
        <c:redirect url = "index.jsp" />
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <p><h1 align = "center">Vehicle Model Operation</h1></p>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a> 
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div> 
        <div class="formexample">
        <a class = "button" href = insertVehicleModel>Insert vehicle model</a></br></br>
        <a class = "button" href = removeVehicleModel>Delete vehicle model</a></br></br>
        <a class = "button" href = retrieveAllVehicleModel>Display all vehicle model</a>
        </div>
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${Message}" />');
        </script>
    </c:if>
</html>
