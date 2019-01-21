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
</head>
<body  background="./css/back.jpg">
	<div style="margin-left: 450px;margin-top: 230px;">
	<c:if test="${empty error } ">
		<h1>未登录状态请登录操作</h1>
	</c:if>
	<c:if test="${not empty error}">
		<h1>${error}</h1>
	</c:if>
	<button style="margin-left: 100px;margin-bottom: 5px;" class="btn btn-default  " data-toggle="modal" data-target="#login">点击进入登录页面</button>
	</div>
	<form id="submit" action="/Tenement/userback/login" method="post">	
	<!-- 模态框（Modal） -->
<div style="margin-top: 160px;" class="village_model modal fade  " id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户登录页面</h4>
            </div>
            <div class="modal-body">
			   				
				<label for="name">账号</label>
						<input type="text" name="telephone" class="form-control back_username" 
			   placeholder="请输入手机号码">
			   <label for="name">密码</label>
						<input type="password" name="password"  class="form-control back_password" 
			   placeholder="请输入登录密码">
           
            </div>
            
            <div class="modal-footer">
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="error_span"></span></div>
                <button type="button" class="btn btn-primary back_login">登录</button>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>