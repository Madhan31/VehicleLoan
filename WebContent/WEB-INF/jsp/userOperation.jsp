<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
        <link rel="stylesheet" href="css/style.css">
        <form align = "right" action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
    <a href = retrieveUserLoanDetail>View loan detail</a></br></br>
    <a href = homePage>Apply for loan</a>  
    </body>
</html>
