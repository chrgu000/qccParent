<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/livingset.js"></script>
<title>活动规则设置</title>
</head>
<body>
	<button style="margin-left: 100px;margin-right: 10px;" class="btn btn-primary" 
	onclick="searchLivingByTypeId(0)">首级位置</button>
	<button  style="margin-left: 0px;margin-right: 100px;" class="btn btn-primary living_add_or_update" 
   data-toggle="modal" data-target="#living_add_update"	>新增分类</button>
	<span id="head_tip" style="color: red;font-size: 20px;">当前位置:首级</span>
	 <table id="living" class = "table	table-hover	 ">
			<thead id="living_head" ></thead>
			<tbody id="living_body"> </tbody>
	</table>





<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="living_add_update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">活的规则设置</h4>
            </div>
            <div class="modal-body">
            <input type="hidden" class="  living_livingid"  readonly="readonly"
			  > </br>
     			<span>	关键字述：</span><input type="text" class="  living_keyword" 
			  > </br>
			   <span>	所属分类：</span>
			  <select id="living_select" style="width: 170px; height: 30px;">
			  </select>
			   <textarea style="height:80px;" class="form-control living_content" rows="3" name=textarea></textarea>
            </div>
            <div class="modal-footer">
            	<span id="living_error"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary living_add">保存</button>
            </div>
        </div>
    </div>
</div>



<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="living_father_update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">活的规则设置</h4>
            </div>
            <div class="modal-body">
            <input type="hidden" class="  father_livingid"  readonly="readonly"
			  > </br>
     			<span>	关键字述：</span><input type="text" class="father_keyword" 
			  > </br>
			   <span>	类容描述：</span><input type="text" class="father_content" 
			  > </br>
            </div>
            <div class="modal-footer">
            	<span id="living_error"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary living_father_update">保存</button>
            </div>
        </div>
    </div>
</div>


</body>
</html>