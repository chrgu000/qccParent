<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理对应用户</title>
</head>
<body>
		<div id="headdiv"></div>
	
		<table id="table " class="table	 ">
	
			<thead id="manager_head">
					<tr><td>用户主键</td><td>用户电话</td><td>用户昵称</td>
				<td>角色主键</td><td>角色昵称</td><td >查看</td></tr>
			 </thead>
			<tbody id="manager_alluser"> </tbody>
		</table>
	
	<!-- 显示分页信息 -->
	<div class="row boot"> </div>


	<div style="margin-top: 10px;" class="modal fade"
		id="add_manager_touser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div style="width: 90%; height: 90%;" class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<input class="chongzhiusersid" type="hidden"/>
						<input class="out_excle_type" type="hidden"/>
						<input class="follow_admin" type="hidden" value="yes"/>
						<input class="currentpage" type="hidden"/>
						<input class="manager_user_roleid" type="hidden"/>
						当前管理编号： <span class="manager_user_id" style="color: red;">
						</span>&nbsp;&nbsp; 角色类型： <span class="manager_user_name"
							style="color: red;"> </span> 
					</h4>
				</div>
				<div class="modal-body">
					<table id="table " class="table	table-hover ">
						<tr>
							<td class='visible-lg'>用户主键</td>
							<td class='visible-lg'>用户昵称</td>
							<td class='visible-lg'>电话号码</td>
							<td > <span class="manager_user_leijichongzhi">累计充值↓</span></td>
							<td > <span class="manager_user_huiyuanchongzhi">会员充值↓</span></td>
							<td> <span class="manager_user_leijixiaofei">累计消费↓</span></td>
							<td><span class="manager_user_keyongyue">可用余额↓</span></td>
							<td><span class="manager_user_fangyufabu">房源发布↓</span></td>
							<td><span class="manager_user_qiuzufabu">求租发布↓</span></td>
							<td><span class="manager_user_yijianfankui">意见反馈↓</span></td>
						</tr>
						<tbody id="user_tobe_manager"> </tbody>
					</table>
					
					
					
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-3" id="manager_user_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-9" id="manager_user_nav_area"> </div>
		</div>
		
				</div>  
			
				<div class="modal-footer" style="clear: both; text-align: right;">
					
					<button type="button"
						class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary checkuser_to_manager">管理</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>