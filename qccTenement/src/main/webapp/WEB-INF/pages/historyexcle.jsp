<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/historyexcle.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>历史导出记录</title>
</head>
<body>
		<table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >历史主键</td>
				<td class ='visible-lg'  >导出描述</td>
				<td class ='visible-lg' >更新时间</td>
				<td class ='visible-lg' >点击导出</td>
				<td >编辑</td>
				<td >删除</td>
			</tr>
			<tbody id="exclebody" >

			</tbody>
	</table>
	
	<!-- 显示分页信息 -->
	<div class="row">
		<div class="col-md-3" id="hisexcle_role_info_area"></div>
		<div class="col-md-9" id="hisexcle_role_nav_area"> </div>
	 </div>
	
	
	
	<!-- 模态框（Modal） -->
<div class="modal fade" id="editexcledescname" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">编辑EXCLE名称方便管理</h4>
            </div>
            <div class="modal-body">
            		<label class="access_label" for="name">历史主键</label>
						<input type="text" class="form-control excle_id"  readonly="readonly"
			   					placeholder="-1"> 
            		<label for="name">描述名称</label>
						<input type="text" class="form-control excle_descname"  
			   					placeholder="输入导出EXCLE的描述方便自己管理"> 
			   					
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary excle_update_descname">维护</button>
            </div>
        </div>
    </div>
</div>


	<!-- 模态框（Modal） -->
<div class="modal fade" id="deleteExcle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">是否删除&nbsp;<span style="color: red;" class="deletespan"></span>  &nbsp;的EXCLE？</h4>
            </div>
            <div style="text-align: center;" class="modal-body">
            	  <button style="margin-right: 100px;" type="button" class="btn btn-default delete_sure_excle" ><h1>确认</h1></button>
            	  <button type="button" class="btn btn-default" data-dismiss="modal"><h1>关闭</h1></button>	
            </div>
            <div class="modal-footer">
               
            </div>
        </div>
    </div>
</div>
</body>
</html>