<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <body>
        <c:if test = "${companies != null}">
            <table>
                <tr>
                    <th>Company ID</th>
                    <th>Company name</th>
                </tr>
                <c:forEach items="${companies}" var="companies">
                    <tr>
                        <td><c:out value="${companies.companyId}" /></td>
                        <td><c:out value="${companies.companyName}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>   
        <a href = "adminOperation">Back to main page</a>
    </body>
</html>
