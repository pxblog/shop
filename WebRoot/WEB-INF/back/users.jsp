<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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

<title>用户管理</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<jsp:include page="topinc.jsp"></jsp:include>

<c:if test="${empty userInfos }">
	<jsp:forward page="/admin/showUsers"/>
</c:if>

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
				        <li>
				            <a href="#">首页</a>
				        </li>
				        
				        <li>
				            <a href="#">用户信息</a>
				        </li> 
				        
				    </ul>
				</div> 
				<!-- 增加的内容开始 -->
		    	<table class="table table-striped table-bordered 
		    		bootstrap-datatable  responsive">
				    <thead>
				    <tr>
				        <th>编号</th>
				        <th>账号</th>
				        <th>密码</th>
				        <th>邮箱</th>
				        <th>操作</th>
				    </tr>
	    			</thead>
	    			<tbody>
	    			<c:forEach items="${requestScope.userInfos }" var="user">
		    			<tr>
					        <td>${user.id }</td>
					        <td class="center">${user.userName }</td>
					        <td class="center">${user.pwd }</td>
					        <td class="center">
					            <span class="label-success label label-default">${user.email }</span>
					        </td>
					        <td class="center">
					            <a class="btn btn-success btn-sm" href="#" onclick="alert('暂无详情')">
					                <i class="glyphicon glyphicon-zoom-in icon-white"></i>
					                	详情
					            </a>
					            <a class="btn btn-info btn-sm" href="<%=basePath %>admin/userUpdate/${user.id}">
					                <i class="glyphicon glyphicon-edit icon-white"></i>
					                	编辑
					            </a>
					            <a class="btn btn-danger btn-sm" href="admin/deleteUser/${user.id}/${pages.pageNum }">
					                <i class="glyphicon glyphicon-trash icon-white"></i>
					                	删除
					            </a>
					        </td>
					    </tr>
	    			
	    			</c:forEach>
				   
				    </tbody>
	   			 </table>
	   			      
	   			 <ul class="pager">
	   			  	<li>第${pages.pageNum }页/共${pages.totalPage }页</li>
	   			  	<li><a href="<%=basePath %>admin/showUsers/${pages.startPage}">首页</a></li>
				    <li><a href="<%=basePath %>admin/showUsers/${pages.prevPageNum}">上一页</a></li>
				    <li><a href="<%=basePath %>admin/showUsers/${pages.nextPageNum}">下一页</a></li>
				    <li><a href="<%=basePath %>admin/showUsers/${pages.endPage}">末页</a></li>
				  </ul> 
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
