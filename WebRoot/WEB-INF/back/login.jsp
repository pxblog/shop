<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>用户登录</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<jsp:include page="topinc.jsp"></jsp:include>

  </head>
  
  <body>
    <div class="ch-container">
	    <div class="row"  style="margin-left:0px; margin-right: 0px; ">
	        
		    <div class="row">
		        <div class="col-md-12 center login-header">
		            <h2>后台管理模块</h2>
		        </div>
		        <!--/span-->
		    </div><!--/row-->
	
		    <div class="row">
		        <div class="well col-md-5 center login-box">
		            <div class="alert alert-info">
		                	请输入用户名和密码.
		            </div>
		            <form class="form-horizontal" action="<%=basePath %>adminCheck.action" method="post">
		                <fieldset>
		                    <div class="input-group input-group-lg">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
		                        <c:choose>
		                        	<c:when test="${empty cookie.adminName.value}">
		                        		<input type="text" name="adminName" class="form-control" placeholder="用户名"/>
		                        	</c:when>
		                        	<c:otherwise>
		                        		<input type="text" name="adminName" class="form-control" value="${cookie.adminName.value}"/>
		                        	</c:otherwise>
		                        </c:choose>
		                        
		                    </div>
		                    <div class="clearfix"></div><br>
		
		                    <div class="input-group input-group-lg">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                         <c:choose>
		                        	<c:when test="${empty cookie.passWord.value}">
		                        		<input type="password" name="password" class="form-control" placeholder="密码"/>
		                        	</c:when>
		                        	<c:otherwise>
		                        		<input type="password" name="password" class="form-control" value="${cookie.passWord.value}"/>
		                        	</c:otherwise>
		                        </c:choose>
		                        
		                    </div>
		                    <div class="clearfix"></div>
		
		                    <div class="input-prepend">
		                        <label class="remember" for="remember"><input type="checkbox" name="checked" value="true" id="remember" checked="checked"> 记住我</label>
		                    </div>
		                    <div class="clearfix"></div>
		
		                    <p class="center col-md-5">
		                        <button type="submit" class="btn btn-primary">登录</button>
		                    </p>
		                </fieldset>
		            </form>
		        </div>
		        
		    </div>
		</div>
	</div>
    <c:if test="${not empty message }">
    	<script type="text/javascript">
			alert("${message}")    	
    	</script>
    </c:if>
    <jsp:include page="bottominc.jsp"></jsp:include>
  </body>
</html>
