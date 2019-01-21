<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>四级联动地址编辑</title>
</head>
<body>
	 <button class="btn btn-large btn-primary" type="button" onclick="getnextform(0 )">首级城市</button>
	  <button class="btn btn-large btn-primary" type="button" onclick="getpreform()">上级城市</button>
	  <span style="display: none;" class="pre-class"></span>
	<form id="cityfrom" action="/Tenement/area/edit" method="post">
		<table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  width="90px">城市ID</td>
				<td class ='visible-lg' width="90px">城市CODE</td>
				<td  width="90px">城市名称</td>
				<td class ='visible-lg' width="90px">城市父id</td>
				<td width="90px">上级/新增</td>
				<td width="90px">查看</td>
				<td width="90px">编辑</td>
				<td width="90px">新增</td>
			</tr>
			<tbody id="tbody" >

			</tbody>
		</table>
	</form>
	
	
	
	
<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="area_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">地址新增</h4>
            </div>
            <div class="modal-body">
            		<input type="hidden" class="building_buildingid"/>
            		<input type="hidden" class="building_villageid"/>
					当前主键：	<input type="text" class="area_id"  readonly="readonly"
			  /> </br>
			  
					当前编号：	<input type="text" class="area_code" readonly="readonly"
			 /> </br>
		
          
            
          	上级编号：	<input type="text" class="area_parentId" readonly="readonly"
			  /> </br>
          
            
            	当前名称：	<input type="text" class="area_name" readonly="readonly"
			  /> </br>
           
            
            	当前级别：	<input type="text" class="area_level" readonly="readonly"
			 /> </br>
           <input type="text" class="form-control area_typename"
			placeholder="请输入当前名称的下一级地址名称" > 
     
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary area-add">新增</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>