<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<textarea  readonly style = "width: 300px; height: 33px; resize:none" class="form-control">
    EMI Amount : <m:out value = "Rs. ${emi}"/>
    Processing Fees : <m:out value = "Rs. ${processingFees}"/>
    Documentation Charges : <m:out value = "Rs. ${documentationCharges}"/>
</textarea>