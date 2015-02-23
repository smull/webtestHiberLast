<%@ page import="com.levelup.model.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>

<%--
  Created by IntelliJ IDEA.
  User: SMULL
  Date: 22.02.2015
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>

<html>
<head>
    <title>ResultBySearch</title>
</head>
<body>

<%--Your firstName = ${sessionScope.accounts}!--%>

<c:if test="${empty sessionScope.accounts}">
<script>
    alert("BankName is not found!")
</script>
</c:if>

<table>
    <c:forEach items="${sessionScope.accounts}" var="account">
        <tr>
            <td><c:out value= "${account.accountNumber}" /></td>
            <td><c:out value="${account.balance}" /></td>
            <td><c:out value="${account.customer.firstName}" /></td>
            <td><c:out value="${account.customer.lastName}" /></td>
            <td><c:out value="${account.customer.birthDate}" /></td>
            <td><c:out value="${account.bank.name}" /></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>