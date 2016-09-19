<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <link rel="stylesheet" href="css/style.css">
	<c:if test="${null == sessionScope['userId']}" >
        <c:redirect url = "logIn" />
    </c:if>
    <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }
            td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                background-color: #c8897b;
            }
            tr:nth-child(even) {
                background-color: #dddddd;
            }
    </style>
    <body>
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
            <br></br>
            <h1 align = "center">Remove Company Detail</h1>    
            <div class = "formexample">
            <form action = "removeCompany" method="get">
                <input type = "text" name = companyId placeholder =  "Company ID"></br>
                <input type = "submit" name = "button" value = "Delete" />
                <input type="reset" value="Clear" />
            </form>
            </div><br></br><br></br><br></br>
        <div class ="formBackRemoveOperation">
                <a class = "button" href = "companyOperation" style="width:200px;height:20px;border:0;">Back to company operation</a><br></br>
                <a class = "button" href = "deleteVehicle" style="width:200px;height:20px;border:0;">Click to remove vehicle</a><br></br>
                <a class = "button" href = "deleteVehicleModel" style="width:200px;height:28px;border:0;">Click to remove vehicle model</a>
        </div><br></br><br></br>
        <c:if test="${message != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${message}" />');
                window.location.href = "deleteCompany";
            </script>
        </c:if>
    </body>
</html>
