<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/tribe.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部落找人维护</title>
</head>
<body>


	
<!-- 按钮触发模态框 -->
<button class="btn btn-large btn-primary add_tribe_show " data-toggle="modal" data-target="#tribe_p_model">新增分类</button>
<button class="btn btn-large btn-primary " onclick="searchArticleTypePersion(7,'找人')" >首级分类</button>
	 <table id="table " class = "table	table-hover	 ">
	 		<thead class="tribe_persion_head">
	 			<tr>
				<td class ='visible-lg'  >ID</td>
				<td class ='visible-lg' >名称</td>
				<td >查看</td>
				<td >编辑</td>
			</tr>
	 		
	 		</thead>
			
			<tbody id="tribe_p" >

			</tbody>
	</table>
	
	
<!-- 模态框（Modal） -->
<div class="modal fade" id="tribe_detail_persion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">部落找人编辑</h4>
            </div>
            <div class="modal-body">
            <label for="name">当前的主键</label>
						<input type="text" class="form-control tribep_onetypeid" readonly="readonly"
			   placeholder="请输入发布找人的类型主题名称"> 
            		<label for="name">请输入名称</label>
						<input type="text" class="form-control tribep_typename" 
			   placeholder="请输入发布找人的类型主题名称"> 
            </div>
            <div class="modal-footer">
                <span style="color:red;margin-right: 250px;" class="tribe_error"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary update_tribe_persion">编辑</button>
            </div>
        </div>
    </div>
</div>	
	
	
<!-- 模态框（Modal） -->
<div class="modal fade" id="tribe_p_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">部落找人发布分类</h4>
            </div>
            <div class="modal-body">
                <label for="name">上级主键</label>
						<input type="text" class="form-control tribep_edit_onetypeid" readonly="readonly"
			   placeholder="请输入发布找人的类型主题名称"> 
            		<label for="name">上级名称</label>
						<input type="text" class="form-control tribep_edit_prename" readonly="readonly"
			   placeholder="请输入发布找人的类型主题名称"> 
            		<label for="name">新增名称</label>
						<input type="text" class="form-control tribep_edit_typename" id="name" 
			   placeholder="请输入发布找人的类型主题名称"> 
            </div>
            <div class="modal-footer">
                <span style="color:red;margin-right: 250px;" class="tribe_error"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="addArticleTypePersion()">新增</button>
            </div>
        </div>
    </div>
</div>
		
</body>
</html>