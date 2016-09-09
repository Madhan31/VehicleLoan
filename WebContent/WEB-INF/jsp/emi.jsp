<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<input type = "text" name = "emi" value = " <m:out value = "${emi}"/>" readonly />
<input type = "text" name = "processingFees" value = " <m:out value = "${processingFees}"/>" readonly />
<input type = "text" name = "documentationCharges" value = " <m:out value = "${documentationCharges}"/>" readonly />