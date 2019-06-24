<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
  <head>
  <link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
    <base href="<%=basePath%>">
    <title>订单详情</title>
    <style type="text/css">
    </style>
  </head>
  <c:if test="${empty sessionScope.userInfo }">
		<%
			response.sendRedirect(basePath+"jsp/login.jsp");
		%>
  </c:if>
  <c:if test="${empty requestScope.odlist }">
		<%
			response.sendRedirect(basePath+"jsp/order.jsp");
		%>
  </c:if>
  <body>
  <jsp:include page="top.jsp"></jsp:include>
  <div style="width:1000px;margin:10px auto">
    <p>订单详情如下</p>
    <div style="margin:10px auto; border:1px #ccc solid;  text-align:center;">
    	<table border="0" cellspacing="0" width="500px">
    		<tr><td>订单号：${order.orderId }</td><td>下单日期：${order.createTime }</td></tr>
    		<tr><td>收货人：${order.addressee }</td><td>收货地址：${order.cityAddress }  &nbsp;&nbsp;${order.streetAddress}</td></tr>
    		<tr><td>联系电话：${order.phone }</td><td>发货方式：${order.postType }</td></tr>
    		<tr><td>订单总额：${order.sumPrice }</td><td>订单状态：
			<c:if test="${order.state==0 }">未付款</c:if><c:if test="${order.state==1 }">已付款</c:if><c:if test="${order.state==2 }">已发货</c:if></td></tr>
    	</table>
    
    <hr/>
    <div style="width:1000px;text-align:center;">
    	<table style="width:1000px;text-align:center;">
    		<tr><th>编号</th><th>商品名称</th><th>照片</th><th>单价</th><th>数量</th></tr>
    		<c:forEach var="detail" items="${odlist }">
    		<tr>
    			<td>${detail.id }</td>
    			<td>${detail.productname }</td>
    			<td><img src="${detail.image}"></td>
    			<td>${detail.price }</td>
    			<td>${detail.num }</td>
    		</tr>
    		</c:forEach>
    	</table>
    </div>      
    </div>
    </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
