<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:if test="${empty categories }">
	<jsp:forward page="/admin/addShop"/>
</c:if>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <c:choose>
       	<c:when test="${empty product.id}">
	             <title>添加商品</title>
       	</c:when>
       	<c:otherwise>
	             <title>更新商品</title>
       	</c:otherwise>
       </c:choose>
   
  </head>
  <jsp:include page="topinc.jsp"></jsp:include>
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
				        <c:choose>
				        	<c:when test="${empty product.id}">
				        		 <li>
						            <a href="#">添加商品</a>
						        </li> 
				        	</c:when>
				        	<c:otherwise>
				        		<li>
						            <a href="#">更新商品</a>
						        </li> 
				        	</c:otherwise>
				        </c:choose>
				    </ul>
				</div> 
				<!-- 增加的内容开始 -->
		    	<div class="main">
		<c:if test="">
		<h2>修改商品</h2>
		</c:if>
		<c:if test="">
		<h2>新增商品</h2>
		</c:if>
		<div class="manage">
			<form action="<%=basePath %>admin/updateProduct" method="post" enctype="multipart/form-data" id="productAdd">
				<table class="form">
					<tr>
						<td class="field">商品名称：(*)</td>
						<td>
						<input type="hidden" name="productId"  value="${product.id}"/>
						<input type="text" class="text" name="name" value="${product.name}" />
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="desc" value="${product.desc}"/></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="categoryId">
								<c:forEach items="${categories}" var="category"  >								
									<option value="${category.cid}"  disabled >								         
										           ${category.cname}
									</option>
									<c:if test="${fn:length(category.childCategories)!=0}"> 
										<c:forEach  items="${category.childCategories}"  var="childrencate">
											<c:choose>
												<c:when test="${childrencate.cid==product.categoryId }">
													<option value='${childrencate.cid}' selected="selected">								         
														&nbsp;&nbsp;${childrencate.cname}
													</option>
												</c:when>
												<c:otherwise>
													<option value='${childrencate.cid}' >								         
														&nbsp;&nbsp;${childrencate.cname}
													</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if>								
								</c:forEach>
							</select>
					       </td>
					       </tr>
					       <tr>
						<td class="field">商品价格(*)：</td>
						<td><input type="number" class="text tiny" name="price" value="${product.price}"  /> 元<span></span>	
						</td>
					</tr>
					    <tr>
						<td class="field">库存(*)：</td>
						<td><input type="number" class="text tiny" name="stock" value="${product.stock}"  /><span></span>
						</td>
					    </tr>
					<tr> 
						<td class="field">商品图片(*)：</td>
						<td><input type="file" class="text" name="imgUpload" />
						
						<c:if test="${not empty product.img}">
							<span>此前 ： ${product.img}</span>
						</c:if>
						</td>
					</tr>					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="确定" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
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
