<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/bdmanager.js"></script>
<title>Insert title here</title>
</head>
<body>

    <button style="margin-left: 100px;" class="btn btn-large btn-primary bd_model_alert" 
      data-toggle="modal" data-target="#bd_add_update">添加BD账号</button>
      
      
      <table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >账号</td>
				<td class ='visible-lg'  >联系电话</td>
				<td class ='visible-lg' >用户姓名</td>
				<td class ='visible-lg' >状态</td>
				<td >操作</td>
			</tr>
			<tbody id="bd_body">
				
			</tbody>
	</table>

</body>






<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="bd_add_update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">管理BD账号</h4>
            </div>
            <div class="modal-body">
            	  <label for="name">账号名称</label>
				  <input type="text" class="form-control bd_id" readonly="readonly" />
				  <label for="name">手机号码</label>
				  <input type="text" class="form-control bd_telephone"  />
				  <label for="name">备注信息</label>
				  <input type="text" class="form-control bd_realname"  />
            </div>
            <div class="modal-footer">
            	<span id="living_error"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary bd_save">保存</button>
            </div>
        </div>
    </div>
</div>
</html>