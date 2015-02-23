<%@ page import="com.levelup.webtest.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: SMULL
  Date: 22.02.2015
  Time: 19:11
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
<div class="search">
    <form action="search" id="searchForm" method="POST">
        <div>Search by BankName: </div>
        <input name="<%=Constants.BANK_NAME_PARAMETER%>" type="text">
        <input type="submit">
    </form>

    <form action="search" id="searchFormCus" method="post">
        <div>Search by CustomerName</div>
        <div>First Name: </div>
        <input name="<%= Constants.FIRST_NAME_PARAMETER%>" type="text">
        <div>Last Name: </div>
        <input name="<%= Constants.LAST_NAME_PARAMETER%>" type="text">
        <input type="submit">
    </form>
</div>

</body>
</html>