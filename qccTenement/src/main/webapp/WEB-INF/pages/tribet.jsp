<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部落物品发布分类</title>
</head>
<body>
<!-- 按钮触发模态框 -->
<button class="btn btn-large btn-primary inser_alert_thing " data-toggle="modal" data-target="#tribe_t_model">新增分类</button>
<!-- 按钮触发模态框 -->
<button class="btn btn-large btn-primary " onclick="searchArticleTypeThing(6)">首级位置</button>
	 <table id="table " class = "table	table-hover	 ">
	 		<thead id="tribe_thing_head">
	 			<tr>
				<td class ='visible-lg'  >ID</td>
				<td class ='visible-lg' >名称</td>
				<td >查看</td>
				<td >编辑</td>
			</tr>
	 		</thead>
			<tbody id="tribe_t" >

			</tbody>
	</table>
	
	<!-- 模态框（Modal） -->
<div class="modal fade" id="tribe_t_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">部落物品发布分类</h4>
            </div>
            <div class="modal-body">
             	<label for="name">上级分类ID</label>
						<input type="text" class="form-control tribet_onetypeid" value="6"
			   readonly="readonly"> 
			   <label for="name">上级分类名称</label>
						<input type="text" class="form-control tribet_prename" 
			   readonly="readonly"> 
            		<label for="name">请输入名称</label>
						<input type="text" class="form-control tribet_typename" id="name" 
			    placeholder="请输入发布物品的类型主题名称"> 
            </div>
            <div class="modal-footer">
                <span class="error_span_persion"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="addArticleType()">新增</button>
            </div>
        </div>
    </div>
</div>



<!-- 模态框（Modal） -->
<div class="modal fade" id="tribe_detail_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">部落物品维护</h4>
            </div>
            <div class="modal-body">
            		<input type="hidden" class="village_villageid"/>
            		<input type="hidden" class="village_code"/>
					主键：	<input type="text" class="typedetail_articleid" readonly="readonly"
			  > </br>
			  
					名称：	<input type="text" class="typedetail_typename" 
			  > </br>
			   
			     规格参数：
			     <div class="paramListThing"></div>
            </div>
            <div class="modal-footer">
            	<span class="error_span"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary update_articletype">新增</button>
            </div>
        </div>
    </div>
</div>
		
		
		<!-- 模态框（Modal） -->
<div class="modal fade" id="change_guige" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">规格参数管理</h4>
            </div>
            <div class="modal-body"  >
            <input type="hidden" class="hidden_typedetailid" />
			<div id="isin" >
				
			</div>
           <div id="isnot" ></div>
          
					
            </div>
            <div class="modal-footer" style="clear: both;text-align: left;" >
            	<span style="color: red;">*打钩的表示已经有的规格参数</span>
                <button style="margin-left:80px;" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary add">更新</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>