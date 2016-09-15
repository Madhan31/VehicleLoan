<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <c:if test="${sessionScope['userId'] == null}" >
        <c:redirect url = "index.jsp" />
    </c:if>
    <c:if test="${sessionScope['role'] != 'admin'}" >
        <c:redirect url = "index.jsp" />
    </c:if>
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
        p><h1 align = "center">Remove Company Details :</h1></p>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>
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
        <form action = "removeCompany" method="get">
            <fieldset>
                <legend>Delete company detail</legend>         
                <input type = "text" name = companyId placeholder =  "Company ID"></br>
                <input type = "submit" name = "button" value = "Delete" />
                <input type="reset" value="Clear" />
            </fieldset>
        </form>
        <a href = "adminOperation">Back to main page</a> 
        <c:if test="${message != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${remove}" />');
            </script>
        </c:if>
    </body>
</html>
