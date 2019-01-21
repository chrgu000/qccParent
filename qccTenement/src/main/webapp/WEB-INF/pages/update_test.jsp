<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/updatetest.js"></script>
<title>修改测试数据</title>
</head>
<body>
	<div class="modal-body" style="width: 300px;">   
        <label for="name" >用户主键:</label>
		<input  type="number" class="test_userid" > 			
		<label for="name" >求租次数:</label>
		<input  type="number"  class="test_count" >
		<label for="name" >可用金币:</label>
		<input   type="number" class="test_jinbi" >
        <label for="name" >是否会员:</label>
		<input   type="number" class="test_vip" > 
		<label for="name" >账户余额:</label>
		<input   type="number" class="test_yue">    
		
    </div><span id="test_error_span" style="color:red;"></span>
    <div style="margin-left: 400px;">
    	 <div style="margin-left: -200px; font-size: 15">1-会员,0-普通 </div>
    	 <button type="button" class="btn btn-primary update_bure">一键维护</button>
    	 <button type="button" class="btn btn-primary reflash_bure">刷新钱包</button>
    </div>
</body>
</html>