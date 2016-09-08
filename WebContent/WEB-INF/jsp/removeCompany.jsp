<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <body>
        <c:if test = "${companies != null}">
            <table>
                <tr>
                    <th>Company ID</th>
                    <th>Company name</th>
                </tr>
                <c:forEach items="${companies}" var="companies">
                    <tr>
                        <td><c:out value="${companies.companyId}" /></td>
                        <td><c:out value="${companies.companyName}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>   
        <form action = "removeCompany" method="get">
            <fieldset>
                <legend>Delete company detail</legend>         
                <input type = "text" name = companyId placeholder =  "Company ID"></br>
                <input type = "submit" name = "button" value = "Delete" />
                <input type="reset" value="Clear" />
            </fieldset>
        </form>
        <a href = "adminOperation">Back to main page</a> 
        <c:if test="${remove != null}" >
            <script language = "javaScript" type = "text/javascript">
                alert('<c:out value = "${remove}" />');
            </script>
        </c:if>
    </body>
</html>
