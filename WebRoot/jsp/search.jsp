<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索页</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/shop.css" type="text/css" rel="stylesheet" />
</head>
<body>

<jsp:include page="top.jsp"></jsp:include>	
	<div class="floor">
			<div class="floor-title clearfix">
				<span class="fl">搜索结果</span>
				<span class="fr">暂无分页……</span>
			</div>
			
			
			<ul class="clearfix">
				<c:forEach items="${requestScope.productItem }" var="product">
					<li>
						<a href="<%=basePath %>selectProductDetail.action?id=${product.id}">
							<img src="${product.img }" />
							<p>${product.name}</p>
							<span><em>${product.price}</em>
						</a>
					</li>
				</c:forEach>
			
			</ul>
		</div>
		</div>

	    
        <jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/shop.js"></script>
</body>
</html>