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
        <c:if test = "${vehicleModels != null}">
            <table>
                <tr>
                    <th>Model ID</th>
                    <th>Model name</th>
                    <th>Price</th>
                </tr>
                <c:forEach items="${vehicleModels}" var="vehicleModels">
                    <tr>
                        <td><c:out value="${vehicleModels.vehicleModelId}" /></td>
                        <td><c:out value="${vehicleModels.vehicleModelName}" /></td>
                        <td><c:out value="${vehicleModels.price}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>   
         <p><h1 align = "center">Delete Vehicle Model:</h1></p>
            <div class="formLogout">
            <a href="logout">
                 <img src="img/logout.png" alt="logout" style="width:42px;height:42px;border:0;">
            </a> 
            </div>
            <div class ="formBack">
                <button type="button" onclick="javascript:history.back()">Go back</button>
            </div>   
        <form action = "removeVehicleModel" method="get">
            <table>
                <tr>
                <td>Vehicle ID</td>
                <td><input type = "text" id ="vehicleId" name = "vehicleId" placeholder =  "Vehicle Model ID"></td>
                </tr>
                <tr>
                <td></td>
                <td><input type = "submit" name = "button" value = "Delete" />
                <input type="reset" value="Clear" /></td>
                </tr>
                </table>
        </form>
        <a href = "vehicleModelOperation">Back to vehicle model operation</a> 
    </body>
    <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
        alert('<c:out value = "${message}" />');
        window.location.href = "deleteVehicleModel";
        </script>
    </c:if>
</html>
