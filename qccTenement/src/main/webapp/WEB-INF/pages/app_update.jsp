<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/app_update.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 按钮触发模态框 -->
	<button class="btn btn-large btn-primary app_show" data-toggle="modal" 
	data-target="#app_add">发布版本</button>
	<span style="margin-left: 30px;">1====七彩巢客户端APP</span>
	<span style="margin-left: 200px;">2====七彩巢服务端APP</span>
	
	<table id="table " class = "table	table-hover	 ">
			<thead >
				<tr>
				<td>版本号</td>
				<td>类型</td>
				<td >发布时间</td>
				<td>文件链接</td>
				<td></td>
			</tr>
			</thead>

		<tbody id="app_all_body">

		</tbody>
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<form id="app_insert_form"  method="post" enctype="multipart/form-data">
	<!-- 模态框（Modal） -->
			<div class="modal fade" id="app_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                <h4 class="modal-title" id="myModalLabel">发布一个新的APP版本</h4>
			            </div>
			            
			            <select name="type" style="margin-left: 25px; height: 30px;">
									<option value="1">七彩巢客户端APP</option>
									<option value="2">七彩巢服务端APP</option>
								
						</select>
			            <div class="modal-body">
								<input type="file" name="file"> 
								
								
								
			            		<label for="name">版本名称</label>
									<input name="versionid" type="text" class="form-control access_updateurl"
						   					placeholder="输入版本名称"> 
			            		
			            		<label for="name">版本描述</label>
									<input name="descname" type="text" class="form-control access_updatename"  
						   					placeholder="输入版本描述"> 
						   					
			            </div>
			            <div class="modal-footer">
			            	<span class="app_err_span" style="color: red;"></span>
			                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			                <button type="button" class="btn btn-primary app_insert">添加</button>
			            </div>
			        </div>
			    </div>
			</div>
		</form>
</body>
</html>