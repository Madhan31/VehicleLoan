<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<textarea  readonly style = "width: 150px; height: 15px;">
    <m:out value = "Rs. ${vehicleModel.price}"/>
</textarea>

