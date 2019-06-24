<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>订单</title>
<link rel="stylesheet" href="css/base.css" />
<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
<style type="text/css">
.order {
	width: 1000px;
	margin: 0 auto;
}

.top-menu ul li {
	float: left;
	color: #FFFFFF;
	padding: 12px 30px;
	border: 1px solid white;
	background: darkmagenta;
}

.top-menu {
	width: 90%;
	margin-left: 160px;
	border-bottom: 1px solid darkmagenta;
}

.left-menu ul {
	border: 1px gainsboro solid;
	width: 150px;
}

.left-menu ul li {
	text-align: center;
	padding: 20px 30px;
}

.content {
	text-align: center;
	border-bottom: 1px gainsboro solid;
	width: 80%;
	min-height: 400px;
}

#tab .change {
	background: white;
	color: black;
	border: 1px solid gainsboro;
}

table {
	border: none;
	border-collapse: collapse;
	border-top: gainsboro solid 1px;
	border-bottom: gainsboro solid 1px;
	margin: 0 auto;
	text-align: center;
	width: 100%;
}

table td {
	padding: 6px 6px;
}
</style>
</head>

<c:if test="${not empty sessionScope.userInfo}">
	<c:if test="${empty requestScope.orders }">
		<%
			response.sendRedirect(basePath+"getOrders.action");
		%>
	</c:if>
</c:if>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="order clearfix">
		<p>我的订单</p>
		<div class="top-menu clearfix" id="top">
			<ul class="clearfix" id="tab">
				<li>所有订单</li>
				<li>等待付款</li>
				<li>已付款</li>
				<li>交易完成</li>
			</ul>
		</div>
		<div class="left-menu fl">

			<ul class="clearfix">
				<li class="current"><a href="index.html">个人信息</a></li>
				<li><a href="#">地址管理</a></li>
				<li><a href="#">我的收藏</a></li>
				<li><a href="#">我的红包</a></li>
				<li><a href="#">我的现金券</a></li>
				<li><a href="#">我的尺码</a></li>
				<li><a href="#">我的心愿单</a></li>
			</ul>
		</div>

		<div class="content fl">
			<div id="content-mailingaddress">
				<c:choose>
					<c:when test="${empty sessionScope.userInfo}">
						您还未登录，所以无法查看订单
						<a href="<%=basePath %>jsp/login.jsp">登录</a>
					</c:when>
					<c:otherwise>
						<table border="1">
							<tr>
								<th>订单号</th>
								<th>下单时间</th>
								<th>订单总价</th>
								<th>订单状态</th>
								<th>操作</th>
							</tr>
							<tbody id="forEachTr">
								<c:forEach var="order" items="${requestScope.orders}" >
									<tr>
										<td>${order.orderId }</td>								
										<td>${order.createTime }</td>								
										<td>${order.sumPrice }</td>								
										<td>
											<c:choose>
												<c:when test="${order.state==1 }">未发货</c:when>
												<c:when test="${order.state==2 }">已发货</c:when>
												<c:when test="${order.state==3 }">已完成</c:when>
											</c:choose>
										
										</td>								
										<td><a href="<%=basePath %>showOrderDetail.action?orderId=${order.orderId }">查看详情</a></td>								
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
				<h3>
					<a href="<%=basePath %>index.jsp">继续购物</a>
				</h3>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	var basePath = "<%=basePath%>";
	var index = 0;
	var tableHtml = $('#forEachTr').html();
	$('#tab li:first').addClass("change");
	$('#tab li').click(function() {
	
		index = $(this).index();
		$(this).addClass("change").siblings().removeClass("change");
		getOrder(index);
		getOrder(index);
	}
	);
	
   function getOrder(index){
	   if(index == 0){
		   $('#forEachTr').html(tableHtml)
	   }else{
		   $.post(
			basePath+"changeOrdersByOrderStatus.action",
			{
				status : index
			},
			function (data) {
				if(data!=''&&data!=null){
					$('#forEachTr').html(data)
				}else{
					$('#forEachTr').html("<tr><td  colspan='4' >空荡荡的，啥也没有<td></tr>")
				}
			}
		)
	   }
		
   }
   /* $.ajax({
	type : "post",
	url : "ShowMyOrdersServlet",
	data : {
		state : index
	},
	dataType : "json",
	success : function(data) {
	    $('tr').remove();
		var msg = data.massege;
		var jsonObj = eval(msg);
		if(jsonObj!=null)
		for ( var i = 0; i < jsonObj.length; i++) {
			var order = jsonObj[i];
			var orderId = order.orderId;
			var state = 0;
			switch (jsonObj[i].state) {
			case 1:
          state="未发货";
				break;
          case 2:
          state="已发货";
				break;
				
			case 3:
          state="已完成";
				break;
			}
			$('table').append(
					'<tr><td>' + order.orderId + '</td><td>'
							   + order.createTime + '</td><td>'
							   + order.sumPrice
							   + '</td><td>'+state+'</td><td><a href="ShowOrderDetailServlet?oid='+orderId+'">查看详情</a></td>');

		}

	}
}); */
</script>
</html>
