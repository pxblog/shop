<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="col-sm-2 col-lg-2">
	            <div class="sidebar-nav">
	                <div class="nav-canvas">
	                    <div class="nav-sm nav nav-stacked">
	                    </div>
	                    <ul class="nav nav-pills nav-stacked main-menu">
	                        <li class="nav-header">管理功能菜单</li>
	                        <li class="accordion">
	                            <a href="#"><i class="glyphicon glyphicon-user"></i><span>用户管理</span></a>
	                            <ul class="nav nav-pills nav-stacked">
	                                <li><a href="<%=basePath %>admin/userUpdate/0">添加用户</a></li>
	                                <li><a href="<%=basePath %>admin/showUsers/1">查看用户</a></li>
	                            </ul>
	                        </li>
	                        <li class="nav-header hidden-md">其他功能</li>
	                        
	                        <li class="accordion">
	                            <a href="#"><i class="glyphicon glyphicon-globe"></i><span>商品信息</span></a>
	                            <ul class="nav nav-pills nav-stacked">
	                                <li><a href="<%=basePath %>admin/showShops/1" >查看商品</a></li>
	                                <li><a href="<%=basePath %>admin/updateShop/0" >上传商品</a></li>
	                            </ul>
	                        </li>
	                        
	                        <li class="accordion">
	                            <a href="#"><i class="glyphicon glyphicon-globe"></i><span>订单管理</span></a>
	                            <ul class="nav nav-pills nav-stacked">
	                                <li><a href="<%=basePath %>admin/showOrders/1">查看订单</a></li>
	                            </ul>
	                        </li>
	                        
	                        <li class="accordion">
	                            <a href="#"><i class="glyphicon glyphicon-tags"></i><span>消息管理</span></a>
	                            <ul class="nav nav-pills nav-stacked">
	                                <li><a href="#" onclick="alert('请使用邮箱回复')">回复消息</a></li>
	                                <li><a href="<%=basePath %>admin/showMessages/1">查看消息</a></li>
	                            </ul>
	                        </li>
	                        <li><a href="<%=basePath %>adminClear.action"><i class="glyphicon glyphicon-lock"></i><span>注销</span></a>
	                        </li>
	                    </ul>
	                </div>
	            </div>
	        </div>
