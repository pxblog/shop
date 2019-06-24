<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<title>消息处理</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath %>layui/css/layui.css"  media="all">
<jsp:include page="topinc.jsp"></jsp:include>

</head>

<body>
	<!-- 页眉导航开始 -->
	<jsp:include page="navigation.jsp"></jsp:include>
	<!-- 页眉导航结束 -->

	<div class="ch-container">
		<div class="row">
			<!-- 左边的菜单开始 -->
			<jsp:include page="menu.jsp"></jsp:include>
			<!-- 左边的菜单结束 -->
			<!-- 右边的内容区开始 -->
			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->
				<div>
					<ul class="breadcrumb">
						<li><a href="#">首页</a></li>

						<li><a href="#">消息处理</a></li>

					</ul>
				</div>
				
				<div id="wapper">
					 <div class="layui-card">
				        <div class="layui-card-header">发件人：${message.userName }&nbsp;&nbsp;|&nbsp;&nbsp;发件人邮箱：${message.email }</div>
				        <div class="layui-card-body">
				         	<c:out value="${message.messageCont }" escapeXml="false"></c:out>
				        </div>
				      </div>
				    </div>
				    <br/>
				    <a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=${message.email }" target="_blank">
				    	<button class="layui-btn layui-btn-primary layui-btn-radius">回复</button>
				    </a>
				</div>
				
			</div>
			<!-- 右边的内容区结束 -->
		</div>
	
		<!-- 页脚开始 -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- 页脚结束 -->
	</div>
	<jsp:include page="bottominc.jsp"></jsp:include>
	

</body>
</html>
