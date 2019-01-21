<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兴趣部落类型的维护</title>
</head>
<body>
	<!-- 按钮触发模态框 -->
<button class="btn btn-large btn-primary add_tribe_show " data-toggle="modal" data-target="#tribe_l_model">新增分类</button>
	 <table id="table " class = "table	table-hover	 ">
			<tr >
				<td class ='visible-lg'  >ID</td>
				<td class ='visible-lg'  >标签</td>
				<td class ='visible-lg' >名称</td>
				<td >编辑</td>
			</tr>
			<tbody id="love_tribe" >

			</tbody>
	</table>

<!-- 模态框（Modal） -->
<div class="modal fade" id="tribe_l_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">兴趣部落分类的添加</h4>
            </div>
            <div class="modal-body">
            		<label for="name">请输入名称</label>
						<input type="text" class="form-control tribelove_typename" 
			   placeholder="请输入发布部落兴趣的类型主题名称">
			   
			    
			   <label for="name">请输入标签</label>
						<input type="text" class="form-control tribep_biaoqian" 
			   placeholder="请输入分类的标签一般第一个中文的英文"> 
            </div>
            <div class="modal-footer">
                <span class="tribe_error" style="margin-right: 250px;color:red;"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary tribelove_in">新增</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>