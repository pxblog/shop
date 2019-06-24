<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>

	<head>
		<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
		<meta charset="utf-8" />
		<base href="<%=basePath%>">
		<title>顶部</title>
		<link rel="stylesheet" href="css/base.css" type="text/css"></link>
		<link rel="stylesheet" href="css/top.css" type="text/css"></link>
		<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
	</head>

	<body onclick="searchBox2()">
		<header>
			<div class="header-box">
				<span class="fl"> 
				
				<c:choose>
					<c:when test="${empty sessionScope.userInfo }">
						<a href="<%=basePath %>jsp/login.jsp" target="_parent">登录</a>
					</c:when>
					<c:otherwise>
						当前用户:${sessionScope.userInfo.userName }
						<a href="<%=basePath %>	userSessionClear.action">退出</a>
					</c:otherwise>
				</c:choose>
				
			 </span> <span class="fr"> 
			 <c:if test="${empty sessionScope.userInfo }">
			 	<a href="jsp/register.jsp" target="_parent">
					免费注册
				</a> 
			 </c:if>
			 <c:if test="${not empty sessionScope.userInfo }">
			 	<a href="jsp/feedback.jsp" target="_parent">
					用户反馈
				</a> 
			 </c:if>
			<a href="<%=basePath %>myCart.action" id="gocar" target="_parent"> 
				<em style="margin-left: 10px;">购物车</em> 
				<i class="iconfont" style="color: darkmagenta;">&#xe64c;</i> 
			</a> </span>
			</div>
		</header>
		<div class="serach-box">
			<div class="serach-box-left  fl">
				<a href="<%=basePath %>index.jsp"><img src="images/logo.png" /></a>
			</div>
			<div class="serach-box-right fr">
				<input type="text" maxlength="20" class="fl" id="fl" onfocus="searchBox()" onblur="clearTime()"/><input type="button" value="搜索" class="fl" onclick="searchButton()"/>
				<div id="selectTip" class="selectTip0"></div>
			</div>
		</div>
			
		<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
			//搜索按钮
			function searchButton() {
				window.open("<%=basePath%>searchButton.action?keyWord="+$('#fl').val(), "_blank");
			}
			
			//ajax函数
			function ajaxCon() {
				$.post(
					"<%=basePath%>searchBox.action",
					{
						keyWord:$("#fl").val()
					},
					function (data) {
						if(data!=''&&data!=null){
							$("#selectTip").removeClass("selectTip0")
							$("#selectTip").addClass("selectTip1")
							$("#selectTip").html(data)
						}else{
							searchBox2()
						}
					}
				)
			}
			//调用ajax函数
			var timer;
			function searchBox(){ 
				timer = setInterval("ajaxCon()", 200);
			}
			//搜索框失去焦点，清除定时函数
			function clearTime() {
				clearInterval(timer);
			}
			//点击别处，提示框消失
			function searchBox2(){
				$("#selectTip").removeClass("selectTip1")
				$("#selectTip").addClass("selectTip0")
			}
		</script>
		
	</body>

</html>