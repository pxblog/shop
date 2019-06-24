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
				<!-- 增加的内容开始 -->
				<table
					class="table table-striped table-bordered 
		    		bootstrap-datatable  responsive">
					<thead>
						<tr>
							<th>编号</th>
							<th>发件人</th>
							<th>发件人邮箱</th>
							<th>信件内容</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${messages}" var="message">
							<tr>
								<td>${message.id}</td>
								<td class="center">${message.userName}</td>
								<td class="center">${message.email}</td>
								<td class="center">
									<c:choose>
										<c:when test="${fn:length(message.messageCont)>8 }">
											<c:out value="${fn:substring(message.messageCont,0,7) }" escapeXml="true"></c:out>……
										</c:when>
										<c:otherwise>
											<c:out value="${message.messageCont }" escapeXml="true"></c:out>
										</c:otherwise>
									</c:choose>	
								</td>
								<td>
									<c:if test="${message.status==0 }">
										未读
									</c:if>
									<c:if test="${message.status==1 }">
										已读
									</c:if>
								</td>
								<td class="center">
								<a class="btn btn-success btn-sm" href="<%=basePath %>admin/readMessage/${message.id}" > <i class="glyphicon glyphicon-zoom-in icon-white"></i>详情 </a> 
										<a class="btn btn-danger btn-sm" onclick="测试页面，暂不实现此功能！"> <i class="glyphicon glyphicon-trash icon-white"></i> 删除 </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<ul class="pager">
					<li>第${page.pageNum}页/共${page.totalPage}页</li>
					<li><a href="<%=basePath %>admin/showMessages/${page.startPage}">首页</a>
					</li>
					<li><a href="<%=basePath %>admin/showMessages/${page.prevPageNum}">上一页</a>
					</li>
					<li><a href="<%=basePath %>admin/showMessages/${page.nextPageNum}">下一页</a></li>
					<li><a href="<%=basePath %>admin/showMessages/${page.endPage}">尾页</a></li>
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
