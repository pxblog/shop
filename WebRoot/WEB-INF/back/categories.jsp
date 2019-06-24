<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>管理首页</title>
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
	            
	            <div>
				    <ul class="breadcrumb">
				        <li>
				            <a href="#">首页</a>
				        </li>
				        
				        <li>
				            <a href="#">商品分类</a>
				        </li>  
				        
				    </ul>
				</div> 
				<!-- 增加的内容开始 -->
				<table class="table table-striped table-bordered 
		    		bootstrap-datatable  responsive">
					<c:forEach items="${requestScope.categories}" var="firstCategory">
						<tr>
							<td>
								${firstCategory.cname}
							</td>
						</tr>
						<c:forEach items="${firstCategory.childCategories}" var="secondCategory">
							<tr>
							<td style="text-indent: 2em;">
								${secondCategory.cname}
							</td>
						</tr>
						</c:forEach>
					</c:forEach>
				</table>
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
