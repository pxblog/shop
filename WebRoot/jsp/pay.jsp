<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="http://pxblog.cn:80/admin/image/favicon.ico" >
<meta charset="UTF-8">
<title>购物车结算页</title>
<link rel="stylesheet" href="<%=basePath %>css/base.css" type="text/css"></link>
<link rel="stylesheet" href="<%=basePath %>css/pay.css" type="text/css"></link>
</head>

<c:if test="${empty requestScope.carIds }">
	<%
		response.sendRedirect(basePath+"jsp/cart.jsp");
	%>
</c:if>
<body>
		<jsp:include page="top.jsp"></jsp:include>
		<div  class="add">
		<p>请填写地址信息</p>
			<img src="<%=basePath %>images/icon-delete.gif"  id="close"/>
       	    <div class="info">
       	    <form action="<%=basePath %>addAddress.action"  method="post" name="addressForm">
       		<ul>
       			<li>
       				<label>收货姓名：</label>
					<i style="color: red;">*</i>
					<input type="text" style="height: 28px;"  id="addressee"    name="addressee"/>
       			</li>
       			<li>
       				<label>收货城市：</label>
					<i style="color: red;">*</i>
					<input style="height: 28px;"  id="cityAddress" name="cityAddress"/>
       			</li>
       			<li>
       			<label>收货地址：</label>
					<i style="color: red;">*</i>
					<input style="height: 28px;" type="text" id="streetAddress"  name="streetAddress"/>
       			</li>
       			<li>
       				<label>联系电话：</label>
					<i style="color: red;">*</i>
					<input style="height: 28px;" type="number"  id="phone"  name="phone"/>
       			</li>
       		</ul>
       		<div class="addsub">
       			<input type="button" id="addressSub"   value="提交" />
       		</div>
       		</form>
			
			</div>
       </div>
		
		<div class="order">
			<form action="<%=basePath %>addOrder.action"  method="post"  onsubmit="return checkOrdersub()">
			<input id="maidHid" name="maidHid" type="hidden" value=""/>
			<div>
			<div  class="address">
				<br />
				<p>使用地址</p>
				<div id="addressSpans">
					<c:forEach items="${requestScope.mailingAddresses }" var="address">
						<span  class="addspan">
							<input type="radio" class="fl" name="maid" onclick="changeMaid(this.value)" value="${address.maid}" />
							<i>${address.cityAddress }-${address.streetAddress }-${address.addressee }-${address.phone }</i>
						</span>
					</c:forEach>
				</div>
				<a href="javascript:void(0)"  onclick="go()">
					新增地址
				</a>
			</div>
			
			<h1 >请填写并确认信息</h1>
			<span>收货方式</span>
			<select name="postType">
				<option value="快递">快递</option>
				<option value="平邮">平邮</option>
				<option value="EMS">EMS</option>
				<option value="自取">自取</option>
			</select>
			<span>支付方式</span>
			<select name="payType">
				<option value="货到付款">货到付款</option>
				<option value="网银">网银</option>
				<option value="支付宝">支付宝</option>
				<option value="转账">转账</option>
			</select>
				<p>备注</p>
				<textarea name="remark" cols="120" rows="2"></textarea>
				<br />
				<span>结算金额</span>
				<input  type="text" readonly="readonly" name="totalPrice"
					value="${requestScope.totalPrice}￥">
					<input type="hidden" id="carIds" name="carIds" value="${requestScope.carIds }">
					<input type="submit"  value="提交订单" />
             </div>
			</form>
			 </div>
			<jsp:include page="footer.jsp"></jsp:include>
 
	</body>
	<script type="text/javascript">
		var basePath = "<%=basePath%>";
		var message = "${requestScope.message}";
	</script>
	<script type="text/javascript" src="<%=basePath %>js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/pay.js"></script>
	
</html>