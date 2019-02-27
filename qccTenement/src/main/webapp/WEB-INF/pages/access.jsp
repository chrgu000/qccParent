<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/access.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限管理</title>
</head>
<body>
<!-- 按钮触发模态框 -->
<button class="btn btn-large btn-primary new_access" data-toggle="modal" data-target="#access_add">新建权限</button>
 	<table id="table " class = "table	table-hover ">
			<tr>
				<td class ='visible-lg'  >权限主键</td>
				<td class ='visible-lg'  >权限链接</td>
				<td class ='visible-lg' >权限名称</td>
				<td >维护</td>
			</tr>
			<tbody id="access_all" >

			</tbody>
	</table>
	
	
	<!-- 显示分页信息 -->
	<div class="row">
		<div class="col-md-3" id="access_url_info_area"></div>
		<div class="col-md-9" id="access_url_nav_area"> </div>
	 </div>
	

<!-- 模态框（Modal） -->
<div class="modal fade" id="access_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div style="width: 40%; " class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">权限维护</h4>
            </div>
            <div class="modal-body">
            		<label class="access_label" for="name">权限主键</label>
						<input type="text" class="form-control access_updateid"  readonly="readonly"
			   					placeholder="-1"> 
            		<label for="name">权限链接</label>
						<input type="text" class="form-control access_updateurl"
			   					placeholder="请输入控制权限的链接"> 
            		
            		<label for="name">权限名称</label>
						<input type="text" class="form-control access_updatename"  
			   					placeholder="请输入控制权限的名称"> 
			   					
            </div>
            <div class="modal-footer">
            	<span style="margin-right: 150px;color: red;" >*非系统开发人员请勿随意维护</span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary access_insert_update">维护</button>
            </div>
        </div>
    </div>
</div>









</body>
</html>