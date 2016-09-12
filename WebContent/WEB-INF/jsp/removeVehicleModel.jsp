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
        <form action = "removeVehicleModel" method="get">
            <fieldset>
                <legend>Delete vehicle model detail</legend>         
                <input type = "text" name = vehicleModelId placeholder =  "Model ID"></br>
                <input type = "submit" name = "button" value = "Delete" />
                <input type="reset" value="Clear" />
            </fieldset>
        </form>
        <a href = "adminOperation">Back to main page</a> 
        <c:if test="${remove != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${remove}" />');
            </script>
        </c:if>
    </body>
</html>
