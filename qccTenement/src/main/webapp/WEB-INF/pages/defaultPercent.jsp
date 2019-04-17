<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/Tenement/js/defaultPercent.js"></script>
<title>房东佣金管理</title>
</head>
<body>

	<h4 class="error_default" style="margin-left: 50px;color: red;"> </h4>
	<table id="table " class = "table	table-hover	 ">
			<tr>
				<td> 主键</td>
				<td >描述</td>
				<td >百分比</td>
				<td >操作</td>
			</tr>
			<tbody id="defaultPercent_body" > </tbody>
	</table>





<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="one_default_search" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">房东佣金维护</h4>
            </div>
            <div class="modal-body">
          
          
            <label for="name">主键</label>
			<input  type="text"
			 class="form-control  default_id  " readonly="readonly">
			 
			 <label for="name">描述</label>
			<input type="text"
			 class="form-control default_descname" readonly="readonly">
			 
			  <label for="name">百分比</label>
			<input type="number"
			 class="form-control default_centnum" >
          
          
          
          
            </div>
            
            <div class="modal-footer">
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="error_span"></span></div>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary updateDefault">更新</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>