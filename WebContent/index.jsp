<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <c:if test="${sessionScope['userName'] == null}" >
        <c:redirect url = "logIn.jsp" />
    </c:if>
    <body>
        <title>Welcome</title>
         <c:redirect url = "welcome" />
    </body>
</html>
