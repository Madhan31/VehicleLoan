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
    <link rel="stylesheet" href="css/style.css">
        <form align = "right" action = "logout" method = "get">
            <input type = "submit" name = "button" value = "logout" style ="width:80px; height:30px;" />
        </form>    
        <br></br>
        <button type="button" onclick="javascript:history.back()" style ="width:80px; height:30px;" >go back</button>
        <c:if test = "${loanDetails != null}">
            <table>
                <tr>
                    <th>Model ID</th>
                    <th>Model name</th>
                    <th>Price</th>
                </tr>
                <c:forEach items="${loanDetails}" var="loanDetail">
                    <tr>
                        <td><c:out value="${loanDetail.balanceAmount}" /></td>
                        <td><c:out value="${loanDetail.balanceEmi}" /></td>
                        <td><c:out value="${loanDetail.getLoan().loanId()}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>   
    <body>
</html>
