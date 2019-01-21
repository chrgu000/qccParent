<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 按钮触发模态框 -->
<button class="btn btn-large btn-primary new_role" data-toggle="modal" data-target="#role_add">新建角色</button>

 <table id="table " class = "table	table-hover ">
			<tr>
				<td class ='visible-lg'  >角色主键</td>
				<td class ='visible-lg'  >角色名称</td>
				<td class ='visible-lg'  >角色改名</td>
				<td >维护</td>
			</tr>
			<tbody id="role_all" >

			</tbody>
	</table>

		<!-- 模态框（Modal） -->
<div style="margin-top: 20px;margin-left: 20px;" class="modal fade" id="role_access_show" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 90%; height: 90%;">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">角色权限控制    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <span class="role_show" style="color: red;"> </span>  </h4>
           		<input style="width: 200px;margin-top: -28px;margin-left: 350px;" type="text" class="form-control searchurlname"  
	placeholder="输入权限名称" /> 
            </div>
            <div class="modal-body searchspan"  >
            <input type="hidden" class="hidden_roleid" />
				<div id="isinrole" ></div>
			</div>
            <div class="modal-footer" style="clear: both;text-align: left;" >
            	<span class="errlr_title" style="color: red;">*打钩的表示已经管理的权限 , 用【】的表示是导航条,其他的是操作链接</span>
                <button style="margin-left:80px;" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary changge_access">更新</button>
            </div>
        </div>
    </div>
</div>




<!-- 模态框（Modal） -->
<div class="modal fade" id="role_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">角色管理</h4>
            </div>
            <div class="modal-body">
            		<label class="access_label" for="name">角色主键</label>
						<input type="text" class="form-control role_updateid"  readonly="readonly"
			   					placeholder="-1"> 
            		<label for="name">角色名称</label>
						<input type="text" class="form-control role_updatename"  
			   					placeholder="请输入角色名称"> 
			   				
            </div>
            <div class="modal-footer">
            	<span class="error_role_span" style="margin-right: 150px;color: red;" >*根据自己的需要创建角色</span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary role_access_update">维护</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>