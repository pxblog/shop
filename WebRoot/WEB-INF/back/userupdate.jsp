<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <c:choose>
       	<c:when test="${empty userInfo.id}">
	             <title>添加用户</title>
       	</c:when>
       	<c:otherwise>
	             <title>更新用户</title>
       	</c:otherwise>
       </c:choose>
   
  </head>
  <jsp:include page="topinc.jsp"></jsp:include>
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
				        <li>
				            <a href="#">首页</a>
				        </li>
				        <c:choose>
				        	<c:when test="${empty userInfo.id}">
				        		 <li>
						            <a href="#">添加用户</a>
						        </li> 
				        	</c:when>
				        	<c:otherwise>
				        		<li>
						            <a href="#">更新用户</a>
						        </li> 
				        	</c:otherwise>
				        </c:choose>
				    </ul>
				</div> 
				<!-- 增加的内容开始 -->
		    	<div class="main">
		<c:if test="">
		<h2>修改商品</h2>
		</c:if>
		<c:if test="">
		<h2>新增商品</h2>
		</c:if>
		<div class="manage">
			<form action="<%=basePath %>admin/updateUser.action" method="post" enctype="multipart/form-data" id="productAdd">
				<table class="form">
					<tr>
						<td class="field">用户名：(*)</td>
						<td>
						<input type="hidden" name="userId"  value="${userInfo.id}"/>
						<input type="text" class="text" name="userName" value="${userInfo.userName}" />
							<span></span>
						</td>
					</tr>
					 <tr>
						<td class="field">密码(*)：</td>
						<td><input type="text" class="text tiny" name="pwd" value="${userInfo.pwd}"  /> <span></span>	
						</td>
					</tr>
					    <tr>
						<td class="field">邮箱(*)：</td>
						<td><input type="text" class="text tiny" name="email" value="${userInfo.email}"  /><span></span>
						</td>
					</tr>
								
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="确定" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	   <!-- 增加的内容结束 -->  
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
