<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>spring MVC实例初体验</title>
</head>

<body>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>省份</th>
        <th>城市</th>
    </tr>

    <c:forEach items="${users }" var="user">
        <tr>
            <td>${user.username }</td>
            <td>${user.password }</td>
            <td>${user.address.province }</td>
            <td>${user.address.city }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
