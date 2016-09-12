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
        <h>Company operation</h></br></br>
        <link rel="stylesheet" href="css/style.css">
        <form align = "right" action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
        <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
        </br></br>
        <a href = insertCompany>Insert company</a></br></br>
        <a href = removeCompany>Delete company</a></br></br>
        <a href = retrieveAllComapny>Display all company</a>
    </body>
</html>
