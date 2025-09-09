<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>spring MVC Model</title>
</head>

<body>
<!-- 1.ModelAndView -->
<a href="springDMD/testModelAndView">Test ModelAndView</a><br>
<!-- 2.Map or Model -->
<a href="springDMD/testMap">Test Map</a><br>
<!-- 3.@SessionAttributes -->
<a href="springDMD/testSessionAttributes">Test @SessionAttributes</a><br>
</body>
</html>