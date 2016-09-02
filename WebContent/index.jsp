<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
        <title>Welcome</title>
    <c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
<<<<<<< HEAD
=======
    <body>
	Vehicle Loan
   
    </body>
>>>>>>> 422b51232604120b55de99016654d82cb35fd5f6
</html>
