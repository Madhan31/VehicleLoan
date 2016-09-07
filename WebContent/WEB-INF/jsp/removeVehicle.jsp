<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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
        <form action = "removeVehicle" method="get">
            <fieldset>
                <legend>Delete vehicle detail</legend>         
                <input type = "text" name = vehicleId placeholder =  "Vehicle ID"></br>
                <input type = "submit" name = "button" value = "Delete" />
                <input type="reset" value="Clear" />
            </fieldset>
        </form>
        <a href = "adminOperation">Back to main page</a> 
    </body>
</html>
