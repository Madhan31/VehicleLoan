<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "m" %>
<table>
<tr>
<td>EMI Amount:</td>
<td><input type = "text" name = "emi" value = " <m:out value = "${emi}"/>" class="form-control" readonly /></td>
</tr>
<tr>
<td>Processing Fees:</td>
<td><input type = "text" name = "processingFees" value = " <m:out value = "${processingFees}"/>" class="form-control" readonly /></td>
</tr>
<tr>
<td>Documentation Charge:</td>
<td><input type = "text" name = "documentationCharges" value = " <m:out value = "${documentationCharges}"/>" class="form-control" readonly /></td>
</tr>
</table>