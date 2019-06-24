<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:if test="${empty requestScope.productItem }">
	<%
		request.getRequestDispatcher("/queryItems.action?pageNum=1").forward(request, response);
	%>
</c:if>

<html>
	<head>
		<meta charset="UTF-8">
		<title>男女装</title>
		<link href="css/base.css" type="text/css" rel="stylesheet" />
		<link href="css/shop.css" type="text/css" rel="stylesheet" />
		<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
	</head>
	<body>
		<jsp:include page="top.jsp"></jsp:include>
		<nav>
			<ul class="nav-box">
				<a>
					<li>首页</li>
					<li>品牌</li>
					<li>实体店</li>
					<li>最新上市</li>
					<li>热卖</li>
					<li>特价</li>
				</a>
			</ul>
		</nav>
		<!--轮播图-->
		<div class="banner clearfix">
			<ul class="clearfix">
				<li><img src="images/banner/banner1.jpg"></li>
				<li><img src="images/banner/banner2.jpg"></li>
				<li><img src="images/banner/banner3.jpg"></li>
			</ul>
			<span class="iconfont left">&#xe603;</span>
			<span class="iconfont right">&#xe61f;</span>
		</div>
		<!--楼梯-->
		<div class="floor">
			<div class="floor-title clearfix">
				<span class="fl">产品目录</span>
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

		<div class="page">
			<a href="<%=basePath %>queryItems.action?pageNum=1">首页</a>
			<c:choose>
				<c:when test="${requestScope.nowPage-1>=1 }">
					<a href="<%=basePath %>queryItems.action?pageNum=${requestScope.nowPage-1 }">上一页</a>
				</c:when>			
				<c:otherwise>
					<a>上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${requestScope.nowPage+1<=requestScope.allPageNum }">
					<a href="<%=basePath %>queryItems.action?pageNum=${requestScope.nowPage+1 }">下一页</a>
				</c:when>			
				<c:otherwise>
					<a>下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=basePath %>queryItems.action?pageNum=${requestScope.allPageNum }">尾页</a> 第${requestScope.nowPage }页/共${requestScope.allPageNum }页
		</div>
		
	    <div class="gotop  iconfont" >&#xe631;
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/shop.js"></script>
	</body>

</html>