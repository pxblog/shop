<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 去掉了id="bs-css" -->
<link  href="<%=basePath%>bootstrap/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="<%=basePath%>bootstrap/css/charisma-app.css" rel="stylesheet">
    <link href='<%=basePath%>bootstrap/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%=basePath%>bootstrap/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/css/jquery.noty.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/css/noty_theme_default.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/css/elfinder.min.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/css/elfinder.theme.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/css/uploadify.css' rel='stylesheet'>
    <link href='<%=basePath%>bootstrap/css/animate.min.css' rel='stylesheet'>
    
    <script src="<%=basePath%>bootstrap/bower_components/jquery/jquery.min.js"></script>
    <link rel="shortcut icon" href="http://pxblog.cn/admin/image/favicon.ico">