<%@ page import="com.levelup.webtest.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: denis_zavadsky
  Date: 2/21/15
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <script src="js/main.js"></script>
    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
<div class="main">
    <form action="account" id="saveForm" method="POST">
    <div class="bank-content">
        <div>Bank Name:</div>
        <input name="<%=Constants.BANK_NAME_PARAMETER%>" type="text">

    </div>
    <div class="customer-content">
        <div>First Name:</div>
        <input name="<%=Constants.FIRST_NAME_PARAMETER%>" type="text">
        <div>Last Name:</div>
        <input name="<%=Constants.LAST_NAME_PARAMETER%>" type="text">
        <div>Birth Date:</div>
        <input name="<%=Constants.BIRTH_DATE_PARAMETER%>" type="date">
    </div>
    <div class="account-content">
        <div>Account Number:</div>
        <input name="<%=Constants.ACCOUNT_NUMBER_PARAMETER%>" type="text">
        <div>Account Balance:</div>
        <input name="<%=Constants.ACCOUNT_BALANCE_PARAMETER%>" type="text">
    </div>
    <input type="submit">
    </form>
</div>

</body>
</html>
