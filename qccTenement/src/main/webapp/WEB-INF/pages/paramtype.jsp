<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/paramtype.js"></script>
<title>物品规格参数管理</title>
</head>
<body>
	<button  class="btn btn-large  article_add" data-toggle="modal" data-target="#add_other">新增分类</button>
	<button  class="btn btn-large " onclick="searchparamtype(0 ,'首级')" >首级未知</button>
	<table id="article_table " class = "table	table-hover	 ">
			<thead id = "article_table_thead"></thead>
			
			<tbody id="article_tbody" >
			</tbody>
	</table>
</body>



<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="add_article" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">分类添加规格参数</h4>
            </div>
            <div class="modal-body">
			   				<input type="hidden" class="metro_metroid"/>
			 分类主键：	<input type="text" class="articlt_typeid"  readonly="readonly"
			  > </br>
          
            
          	 分类名称：	<input type="text" class="articlt_typename"  readonly="readonly"
			  > </br>
          
            规格参数：	<input type="text" class="articlt_codename" 
			  > </br>
           
            </div>
           
            <div class="modal-footer">
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="error_span"></span></div>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary article_addone">更新</button>
            </div>
        </div>
    </div>
</div>



<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="edit_article" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">编辑分类名称</h4>
            </div>
            <div class="modal-body">
			   				<input type="hidden" class="metro_metroid"/>
			 分类主键：	<input type="text" class="edit_typeid"  readonly="readonly"
			  > </br>
          
            
          	 分类名称：	<input type="text" class="edit_typename"  
			  > </br>
        
           
            </div>
            
            <div class="modal-footer">
            	<span class="error_span"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary edit_addone">更新</button>
            </div>
        </div>
    </div>
</div>


<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="edit_codename" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">编辑规格参数</h4>
            </div>
            <div class="modal-body">
			   				<input type="hidden" class="metro_metroid"/>
			 分类主键：	<input type="text" class="code_codeid"  readonly="readonly"
			  > </br>
          
            
          	 分类名称：	<input type="text" class="code_typename"   readonly="readonly"
			  > </br>
         
          	 规格参数：	<input type="text" class="code_codename"  
			  > </br>
           
            </div>
            <input type="hidden" class="code_typeid"/>
            <div class="modal-footer">
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="error_span"></span></div>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary edit_onecodename">更新</button>
            </div>
        </div>
    </div>
</div>


<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="add_other" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增分类</h4>
            </div>
            <div class="modal-body">
			   				
			   	<label for="name">上级分类ID</label>
						<input type="text" class="form-control param_type_codeid"
			   readonly="readonly"> 
			   <label for="name">上级分类名称</label>
						<input type="text" class="form-control param_type_prename" 
			   readonly="readonly"> 
			    	<label for="name">分类名称</label>
			<input type="text" class=" form-control add_thertypename"  > 
       
           
            </div>
            
            <div class="modal-footer">
            	<span class="error_span"></span>
                <button type="button" class="btn btn-default " data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary add_othertype">更新</button>
            </div>
        </div>
    </div>
</div>
</html>