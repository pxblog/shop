<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>用户登录</title>
<link rel="stylesheet" href="css/base.css" type="text/css"></link>
<link rel="stylesheet" href="css/login.css" type="text/css"></link>
<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="login">
		<form action="<%=basePath %>login.action" method="post">
			<div class="usercode_div">
				<label>账号</label><i style="color: red;">*</i> <input type="text"
					placeholder="邮箱/手机号码" name="username" /> <i>没有账号？</i><a
					style="color: darkmagenta;" href="<%=basePath %>jsp/register.jsp">免费注册</a>
			</div>

			<div class="userpwd_div">
				<label>密码</label><i style="color: red;">*</i> <input type="password"
					name="pwd" placeholder="请输入密码" /> <i>密码忘了？</i><a
					style="color: darkmagenta;" href="#">找回密码</a>
			</div>
			<div style="color:red;margin-left:30px" id="error_msg"> ${requestScope.message } </div>
			<div class="user_login_button">
				<input type="submit" value="登录" onclick="return checkUser();"
					id="my_denglu" />
			</div>
		</form>
	</div>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript"></script>

</html>