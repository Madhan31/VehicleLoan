<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<input type = "text" name = "emi" value = " <m:out value = "Rs. ${emi}"/>" readonly />
<input type = "text" name = "processingFees" value = " <m:out value = "Rs. ${processingFees}"/>" readonly />
<input type = "text" name = "documentationCharges" value = " <m:out value = "Rs. ${documentationCharges}"/>" readonly />