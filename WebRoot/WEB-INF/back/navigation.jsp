<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="navbar navbar-default" role="navigation">
        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"> 
            	<!-- <img alt="Logo" src="image/logo01.png" 
            	class="hidden-xs" style="width:90px;height:24px;"/> -->
                <span>测试后台</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
            	<c:choose>
            		<c:when test="${not empty adminInfo }">
            			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
		                    <i class="glyphicon glyphicon-user"></i>
		                   		 <span class="hidden-sm hidden-xs">${adminInfo.adminName }</span>
		                    <span class="caret"></span>
		                </button>
		                <ul class="dropdown-menu">
		                    <li><a href="#">我的信息</a></li>
		                    <li class="divider"></li>
		                    <li><a href="<%=basePath %>adminClear.action">注销</a></li>
		                </ul>
            		</c:when>
            		<c:otherwise>
	            		<a href="<%=basePath %>admin.action">
	            			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
	            				登陆
	            			</button>
	            		</a>
            		</c:otherwise>
            	</c:choose>
                
            </div>
            
            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i>首页</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> 常见功能 <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="<%=basePath %>admin/updateShop/0">添加产品</a></li>
                        <li><a href="<%=basePath %>admin/userUpdate/0">添加用户</a></li>                    
                        <li class="divider"></li>
                        <li><a href="#">查询产品</a></li>
                        <li class="divider"></li>
                        <li><a href="<%=basePath %>admin">首页</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
