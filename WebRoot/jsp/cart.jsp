<%@page import="com.shop.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>购物车页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/gouWuChe.css" />
		<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
	</head>
	
	<body>
	<jsp:include page="top.jsp"></jsp:include>
		<div id="wapper">
			<form action="<%=basePath %>carSettlement.action" method="post" name="carForm">
				<table cellspacing="0" id="gwTable">
					<thead class="fixed_head">
						<tr class="TableName">
							<th style="border: none;">
								<h2>购物车</h2></th>
						</tr>
						<tr class="tableMu">
							<th>选择</th>
							<th>商品</th>
							<th>单价(元)</th>
							<th>数量</th>
							<th>金额(元)</th>
						</tr>
					</thead>
					<tbody class="scroll_body">
						<c:if test="${empty requestScope.carts }">
							<tr align="center"><td colspan="5">购物车空荡荡的，快去购物吧！</td></tr>
						</c:if>
						<c:forEach items="${requestScope.carts }" var="cart">
							<tr>
								<td class="cheak_td"><input type="checkbox" class="cheak" /><span class="cartId" style="display: none;"> ${cart.carId }</span></td>
								<td><img src="<%=basePath %>${cart.product.img}" /> ${cart.product.name } <br/>
								</td>
								<td>￥<span class="danJia">${cart.product.price}</span></td>
								<td class="changeNum">
									<input type="button" class="changeButton" name="jian" value="-" /><input type="text" class="shopNum" name="shopNum" value="${cart.num }" /><input type="button" class="changeButton" name="jia" value="+" />
								</td>
								<td>
									￥<span class="moneySum"></span>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot class="fixed_foot">
						<tr class="tableEnd">
							<td class="cheakAll_td">
								<input type="checkbox" id="cheakAll" />
								<lable class="quanXuan">全部选中</lable>
							</td>
							<td class="foot_left">
	
								&nbsp;&nbsp;<span class="delete" onclick="del();">删除</span>
							</td>
							<td colspan="2" class="foot_right">
								总共：<span class="zongJi"></span>元&nbsp;&nbsp;&nbsp;
									<input type="hidden" id="carIds" name="carIds" value="">
							</td>
							<td>
								<button style="display: block; width: 5em;text-align:center;border: 1px solid gray; cursor: pointer;background: white;" onclick="settlement();">立即结算</button>
							</td>
						</tr>
					</tfoot>
				</table>
			
			
			</form>
			
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		var basePath = "<%=basePath %>"
	</script>
	
	<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
	<script src="<%=basePath %>js/gouWuChe.js" type="text/javascript" charset="utf-8"></script>
	</body>
	
</html>
