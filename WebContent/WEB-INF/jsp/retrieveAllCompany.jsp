<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
                background-color: #dddddd;
            }
    </style>
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
