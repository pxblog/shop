<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
		<meta charset="utf-8" />
		<title>注册</title>
		<style type="text/css">
			.row-bottom {
				border-bottom: 2px solid #e93854;
				padding-bottom: 20px;
				padding-top: 20px;
				margin-bottom: 20px;
			}
		</style>
		<link rel="stylesheet" href="<%=basePath %>css/base.css" type="text/css"></link>
		<link rel="stylesheet" href="<%=basePath %>css/register.css" type="text/css"></link>
	</head>

	<body>
		<jsp:include page="top.jsp"></jsp:include>
		<div class="register">
			<form action="<%=basePath %>register.action" method="post" name="userForm">
				<div class="userphone_div">
					<label>用户名称</label><i style="color: red;">*</i>
					<input type="text" style="height: 28px;" id="username" onblur="register();" name="username" />
					<i id="error_alert"></i><i>需长于六个字符</i>
				</div>

				<div class="useremail_div">
					<label>电子邮箱</label><i style="color: red;">*</i>
					<input type="email" style="height: 28px;" id="email" onblur="register();" name="email" />
					<i  id="email_alert"></i><i>常用电子邮箱</i>
				</div>

				<div class="userepwd_div">
					<label>设置密码</label><i style="color: red;">*</i>
					<input style="height: 28px;" type="password" id="pwd" name="pwd" onblur="register();" />
					<i  id="pwd_alert"></i><i>仅限6-16个字符</i>
				</div>
 
				<div class="userepwdsecond_div">
					<label>重复密码</label><i style="color: red;">*</i>
					<input style="height: 28px;" type="password" id="rePwd" onblur="register();" />
					<i id="rePwd_alert"></i><i>请再次输入您设置的密码</i>
				</div>

				<div class="clause_div">

					<input type="checkbox" id="checkItem"/>我已阅读并同意<i style="color: green;">《网站服务条款》</i>。
				</div>
				<div class="user_register_button">
					<input type="button" value="注册" id="mySub" />
				</div>

			</form>
		</div>

		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
		
		<script type="text/javascript">
			var basePath = "<%=basePath%>";
			var message = "${requestScope.message}";
		</script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/register.js"></script>
		
	</body>

</html>