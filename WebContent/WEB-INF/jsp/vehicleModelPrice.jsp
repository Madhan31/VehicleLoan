<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:textarea path = "vehicleModel.vehicleModelPrice" readonly style = "width: 100px; height: 15px; display:none;'">
<m:out value = "Rs. ${vehicleModel.price}"/>
</form:textarea>