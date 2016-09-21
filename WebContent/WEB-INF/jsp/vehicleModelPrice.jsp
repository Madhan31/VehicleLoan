<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<textarea  readonly style = "width: 300px; height: 33px; resize:none" class="form-control">
    <m:out value = "Rs. ${vehicleModel.price}"/>
</textarea>

