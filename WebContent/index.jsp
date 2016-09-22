<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <title>Welcome</title>
    <c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <c:if test="${sessionScope['role'] == 'admin'}" >
        <c:redirect url = "adminOperation" />
    </c:if>
    <c:if test="${sessionScope['role'] == 'user'}">
        <c:redirect url = "userOperation" />
    </c:if>
</html>
