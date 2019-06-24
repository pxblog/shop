<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE">
<html>
  <head>
  <link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
    <base href="<%=basePath%>">
    <title>商品详情</title>
	 <link rel="stylesheet" href="css/base.css" type="text/css"></link></head>
   <link rel="stylesheet" href="css/productDetial.css" type="text/css"></link>
   <link rel="stylesheet" type="text/css" href="css/fangDa.css"/>
 	</head>
 	<c:if test="${empty requestScope.productDetail }">
		<%
			request.getRequestDispatcher("/selectProductDetail.action?id="+request.getAttribute("id")).forward(request, response);
		%>
	</c:if> 
  <body>
  	<jsp:include page="top.jsp"></jsp:include>
  	<div class="detail clearfix">
		<div class="product">
			
		<div id="main">
				<div class="left fl little_image"> 
					<img src="${productDetail.img}"/>
				</div>
				<div class="select"> 
					
				</div>
		</div>
		<div id="max">
			<img src="${productDetail.img}" class="large"/>
		</div>
			<div class="right fl">
			<p>
				商品详情：${productDetail.desc}
			</p>
			<p>
				价格：${productDetail.price}
			</p>
			<p>
				库存：${productDetail.stock}
			</p>
				<a href="<%=basePath %>addShopping.action?id=${productDetail.id}">
					<input type="button"  value="加入购物车"/>
				</a>
				<div id="message">${requestScope.message }&nbsp;&nbsp;<a href="<%=basePath %>myCart.action" class="toCart">去购物车</a></div>
			</div>
		
		</div>
		</div>
		<script src="js/fangDa.js" type="text/javascript" charset="utf-8"></script>
<jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
