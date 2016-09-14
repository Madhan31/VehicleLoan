<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<html>
<link rel="stylesheet" href="css/style.css">
<body>
<table>
<tr>
<td>EMI Amount:</td>
<td><input type = "text" name = "emi" value = " <m:out value = "${emi}"/>" readonly /></td>
</tr>
<tr>
<td>Processing Fees:</td>
<td><input type = "text" name = "processingFees" value = " <m:out value = "${processingFees}"/>" readonly /></td>
</tr>
<tr>
<td>Documentation Charge:</td>
<td><input type = "text" name = "documentationCharges" value = " <m:out value = "${documentationCharges}"/>" readonly /></td>
</tr>
</table>
</body>
</html>