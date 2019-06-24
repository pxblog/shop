<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html>
  <head>
  <link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
    <meta charset="utf-8" />    
    <title>支付成功页面</title>
    <meta http-equiv="refresh" content="3;URL=<%=basePath%>jsp/order.jsp">
  </head>
  <body  style="text-align:center;margin-top:20px">
     模拟支付成功，<i id="time">3</i>秒后自动跳转到订单页面<a href="<%=basePath%>jsp/order.jsp">我的订单</a> <br>
  </body>
  <script type="text/javascript">
            var i = 3;
            var tim = document.getElementById("time");
            var timer = setInterval(function () {
                if (i == -1) {
                    clearInterval(timer);
                } else {
                    tim.innerHTML = i;
                    --i;
                }
            }, 1000);
  </script>
</html>
