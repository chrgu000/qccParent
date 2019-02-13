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
		
		
		<button style="margin-left: 100px;" class="btn btn-large btn-primary role_model_alert" 
		data-toggle="modal" data-target="#user_role_add">添加系统账号</button>
	</div>
			
			
	 <table id="table " class = "table	table-hover ">
			<tr>
				<td class ='visible-lg'  >用户主键</td>
				<td class ='visible-lg'  >用户电话</td>
				<td class ='visible-lg' >用户昵称</td>
				<td class ='visible-lg' >账号状态</td>
				<td class ='visible-lg' >角色昵称</td>
				<td >操作</td>
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
                <h4 class="modal-title" id="myModalLabel">系统账号管理   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <span class="user_role_id" style="color: red;"> </span>  <span class="user_role_show" style="color: red;"> </span> </h4>
            </div>
            <div class="modal-body"  >
            <input type="hidden" class="hidden_roleid" />
	          	<div id="isnotuser_role" ></div>
	          	<div style="margin-top: 20px;">
	          			<span>状态 ：</span>
						<select id="role_state_selected" style="width: 100px; height: 30px;"> 
							<option value="1">正常</option>
							<option value="2">冻结</option>
						</select>
	          	</div>
	          
			</div>
			
			
            <div class="modal-footer" style="clear: both;text-align: left;" >
            	<span class="user_role_error" style="color: red;">*打钩的表示已经管理的权限</span>
                <button style="margin-left:80px;" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary changge_user_role">更新</button>
            </div>
        </div>
    </div>
</div>






<!-- 添加系统账号 -->
<div style="margin-top: 10px;" class="modal fade"
		id="user_role_add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div style="width: 90%; " class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				
					
					<div style="width: 250px;margin-left: 150px;">
					<input width="150px;" type="text" class="form-control role_searchWhere"  
			   					placeholder="输入电话号码/真实姓名"> 
			   		
		  			</div >
		  			<div style="width: 250px;margin-left: 410px; margin-top: -30px;">
		  				<button type="button" class="btn btn-primary role_search_btn">
			   		查询</button>
		  			</div>
		  			
		  			<div style="width: 250px;margin-left: 510px; margin-top: -28px;">
		  			选择角色：
		  			<select style="width: 100px;height: 30px;" id="select_role">
		  				<option value="">请选择</option>
		  				<option value="1">1</option>
		  				<option>1</option>
		  				<option>1</option>
		  				<option>1</option>
		  				
		  			</select>
		  			
		  			</div>
		  			
		  			
			   
	
					
				</div>
				<div class="modal-body">
					<table id="table " class="table	table-hover ">
						<tr>
							<td>用户主键</td>
							<td>用户昵称</td>
							<td>电话号码</td>
							<td>真实姓名</td>
							<td>操作</td>
						</tr>
						<tbody id="search_add_body"> </tbody>
					</table>
					
					<div class="row">
						<!--分页文字信息  -->
						<div class="col-md-3" id="search_adduserrole_info_area"></div>
						<!-- 分页条信息 -->
						<div class="col-md-9" id="search_adduserrole_nav_area"> </div>
		     		 </div>
					
					
		
				</div>  
				
				
			
				<div class="modal-footer" style="clear: both; text-align: right;">
					
					<button type="button"
						class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary user_role_save">管理</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>