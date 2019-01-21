<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理对应角色</title>
</head>
<body>
	
		<div style="width: 150px;">
				<input width="150px;" type="text" class="form-control search_phone"  
			   					placeholder="输入电话号码的关键字"> 
			   
		</div >
		<div style="width: 150px;margin-top: -35px;margin-left: 180px;">
				<input width="150px;" type="text" class="form-control search_rolename"  
			   					placeholder="输入角色关键字"> 
		</div>
	<div style="margin-top: -30px;margin-left: 360px;">
		<button class="btn btn-large btn-primary firstsearch" >开始查询</button>
	</div>
			
			
	 <table id="table " class = "table	table-hover ">
			<tr>
				<td class ='visible-lg'  >用户主键</td>
				<td class ='visible-lg'  >用户电话</td>
				<td class ='visible-lg' >用户昵称</td>
				<td class ='visible-lg' >角色主键</td>
				<td class ='visible-lg' >角色昵称</td>
				<td >维护</td>
			</tr>
			<tbody id="user_allrole" >
					
			</tbody>
	</table>	
	
	<!-- 显示分页信息 -->
	<div class="row">
		<div class="col-md-3" id="user_role_info_area"></div>
		<div class="col-md-9" id="user_role_nav_area"> </div>
	 </div>


		<!-- 模态框（Modal） -->
<div class="modal fade" id="user_role_target" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">管理对应角色   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <span class="user_role_id" style="color: red;"> </span>  <span class="user_role_show" style="color: red;"> </span> </h4>
            </div>
            <div class="modal-body"  >
            <input type="hidden" class="hidden_roleid" />
	          	<div id="isnotuser_role" ></div>
			</div>
            <div class="modal-footer" style="clear: both;text-align: left;" >
            	<span class="user_role_error" style="color: red;">*打钩的表示已经管理的权限</span>
                <button style="margin-left:80px;" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary changge_user_role">更新</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>