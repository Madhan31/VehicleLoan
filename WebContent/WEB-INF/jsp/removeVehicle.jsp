<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <link rel="stylesheet" href="css/style.css">
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
        <c:if test = "${vehicles != null}">
            <table>
                <tr>
                    <th>Vehicle ID</th>
                    <th>Vehicle name</th>
                </tr>
                <c:forEach items="${vehicles}" var="vehicles">
                    <tr>
                        <td><c:out value="${vehicles.vehicleId}" /></td>
                        <td><c:out value="${vehicles.vehicleName}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>   
        <p><h1 align = "center">Remove Vehicle Details :</h1></p>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a>
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>
        <form action = "removeVehicle" method="get">
            <fieldset>
                <legend>Delete vehicle detail</legend>         
                <input type = "text" name = vehicleId placeholder =  "Vehicle ID"></br>
                <input type = "submit" name = "button" value = "Delete" />
                <input type="reset" value="Clear" />
            </fieldset>
        </form>
        <c:if test="${message != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${message}" />');
                window.location.href = "deleteVehicle";
            </script>
        </c:if>
    </body>
</html>
