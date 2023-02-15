<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zero
  Date: 2022/6/4
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ page isELIgnored="false" %>
</head>
<style>
    body{
        background-image: url('img/log.jpg');
        background-size: 100% 100% ;
        background-attachment: fixed;

    }
    table{
        border-collapse:collapse;
        table-layout:fixed;
        border-radius:5px;
        overflow:hidden;
        margin: 100px auto;
        border:2px solid wheat;
        background-color: rgba(201, 197, 197, 0.8);
        color: white;
    }
    table td,th{

        text-align: center;
        border:1px solid wheat ;
        vertical-align:middle;

        height: 40px;
        width: 200px;
    }
</style>
<body>
<table>
    <caption style="margin:20px 30px; font-size: 20px;">日志信息表&nbsp;
        <img src="img/搜索.png" width="2.5%">
    </caption>
    <thead>
    <tr>
        <th >用户id</th>
        <th >状态（1：登入  2：登出）</th>
        <th >ip</th>
        <th >时间</th>
    </tr>
    </thead>
    <tbody>
    <!-- 开始循环 -->
    <c:forEach items="${userList}" var="user" varStatus="vs">
        <tr>
            <td class='center'>${user.uid}</td>
            <td class='center'>${user.status}</td>
            <td class='center'>${user.ip}</td>
            <td class="center">${user.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
