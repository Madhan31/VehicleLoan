<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m" %>
<option value="null"> Select Vehicle Model -- </option>	
<m:forEach items="${vehicleModelList}" var="vehicleModel">
    <option value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>
</m:forEach>
