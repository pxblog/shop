<%@page import="com.shop.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>用户反馈</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="<%=basePath %>layui/css/layui.css"  media="all">
	</head>
	<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div style="width: 1000px;margin: auto;">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
		  <legend>用户反馈</legend>
		</fieldset>
		 <form action="<%=basePath%>feedback.action" method="post" name="messageForm">
		 	<textarea class="layui-textarea" id="LAY_demo1" name="feedBack" style="display: none">  
		  	
			</textarea>
			<div class="site-demo-button" style="margin-top: 20px;">
			  <input class="layui-btn site-demo-layedit" type="button" value="提交" id="mySub" data-type="content"/>
			</div>
		 </form>
		
		
		
		          
		<script src="<%=basePath %>layui/layui.js"></script>
		<script>
			layui.use('layedit', function(){
			  var layedit = layui.layedit
			  ,$ = layui.jquery;
			  
			  //构建一个默认的编辑器
			  var index = layedit.build('LAY_demo1', {
				    tool: ['face',  '|', 'left', 'center', 'right','strong','underline','del']
			    
			  });
			  
			  //编辑器外部操作
			  var active = {
			    content: function(){
			      $("#LAY_demo1").text(layedit.getContent(index)); //获取编辑器内容
			      document.forms["messageForm"].submit();
			    }
			  };
			  $('.site-demo-layedit').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
			});
		</script>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
	
</html>
