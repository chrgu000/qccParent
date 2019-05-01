<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/Tenement/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/Tenement/js/userback.js"></script>

<link href="css/bootstrap.min.css" rel="stylesheet">
<title>登录页面</title>

<style type="text/css">
	  input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {

　　color: #666;font-size:70px;

　　}

　　input:-moz-placeholder, textarea:-moz-placeholder {

　　color:#666;font-size:200px;

　　}

　　input::-moz-placeholder, textarea::-moz-placeholder {

　　color:#666;font-size:200px;

　　}

　　input:-ms-input-placeholder, textarea:-ms-input-placeholder {

　　color:#666;font-size:200px;

　　}

	body {
		background-image: /webProject/img/ad.jpg;
		background-color: gray;
	}
	.container-fluid{
	background-url: "../img/ad.jpg";
}
	</style>


</head>
<body  background="./css/back.jpg">
	<%-- <div style="margin-left: 450px;margin-top: 230px;">
	<c:if test="${empty error } ">
		<h1>未登录状态请登录操作</h1>
	</c:if>
	<c:if test="${not empty error}">
		<h1>${error}</h1>
	</c:if>
	<button style="font-size: 50px;height: 70px;" class="btn btn-danger  " data-toggle="modal" data-target="#login">
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登
	&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
	</div>
	<form id="submit" action="/Tenement/userback/login" method="post">	
	<!-- 模态框（Modal） -->
<div style="margin-top: 10px;" class="village_model modal fade  " id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户登录页面</h4>
            </div>
            <div class="modal-body">
			   				
				<label style="font-size: 50px;" for="name">账号</label>
						<input style="font-size: 50px;height: 70px;" type="text" name="telephone" class="form-control back_username" 
			   placeholder="请输入手机号码">
			   <label style="font-size: 50px;" for="name">密码</label>
						<input style="font-size: 50px;height: 70px;" type="password" name="password"  class="form-control back_password" 
			   placeholder="请输入登录密码">
           
            </div>
            
            <div class="modal-footer">
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="error_span"></span></div>
                <button style="font-size: 50px;height: 70px;" type="button" class="btn btn-primary back_login">登录</button>
            </div>
        </div>
    </div>
</div>
</form> --%>






<form id="submit" action="/Tenement/userback/login" method="post">	

<div style="margin-top: 150px;margin-left: 220px;">
	<span style="font-size: 80px;color:black;text-align: center;font-family: cursive;">七彩管理</span>
	</div>
<div class="container-fluid" style="margin-top: 150px; "  >
	
	<form class="bs-example bs-example-form" role="form">
		<div class="input-group">
			<span style="font-size: 70px;" class="input-group-addon">账号:</span>
			<input  style="height: 200px; font-size: 70px;"
			 type="number"  name="telephone" class="form-control" placeholder="输入手机号码或者注册账号">
		</div>
		
		<div class="input-group" style="margin-top: 20px;">
			<span style="font-size: 70px;" class="input-group-addon ">密码:</span>
			<input  style="height: 200px; font-size: 70px;"
			type="password"  name="password" class="form-control back_password" placeholder="请输入你设置的密码">
		</div>
		<br>
	</form>
</div>

<div style="width: 100%;margin-top: 200px;">
<button class="btn btn-success back_login"  style="font-size: 80px;width: 100%;" 
 	>		
 <span style="margin-left: 10px;" >登 &nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</span>
 </button>

</div>
<c:if test="${not empty error}">
		<h1  style="font-size: 70px;" >${error}</h1>
	</c:if>
</form>
</body>
</html>