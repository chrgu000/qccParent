<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/landlord.js"></script>
<title>Insert title here</title>
</head>
<body> 
	         房东状态 ：
		<select style="width: 110px; margin-top: 15px;"onchange="getlandlordbystate(1)" id="select_land">
		    <option value="">全部</option>
			<option value="0">禁用</option>
			<option value="1">申请</option>
			<option value="2">通过</option>
			<option value="3">不通过</option>
		</select>

		<table id="table " class = "table	table-hover ">
			<tr>
				<td  >房东主键</td>
				<td >房东姓名</td>
				<td >入驻时间</td>
				<td >BD 账号</td>
				<td >BD 姓名</td>
				<td >状态</td>
				<td >操作</td>
			</tr>
			<tbody  id="landlord_examine_tbody" >
		
			</tbody>
	</table>
	
	<!-- 显示分页信息 -->
	<div class="row">
		<div class="col-md-3" id="land_info_area"></div>
		<div class="col-md-9" id="land_nav_area"> </div>
	 </div>

</body>


<!-- 模态框（Modal） -->
<div style="width: 800px;height: 1200px;margin-left: 100px;margin-top: -10px;" class="modal fade" id="show_idpicture" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">房东详细资料   (禁用/删除房东清空对应的 管理员)</h4>
            </div>
            <div class="modal-body">
            	
            	<input class="land_userid" type="hidden">
            	
            	证件号码：	
            	<input type="text" class=" form-control land_identity" 
            	style="width:200px; display: inline-block;" readonly="readonly"> <br>
            	
            	房东电话：	
            	<input type="text" class=" form-control land_landphone " 
            	style="width:200px; display: inline-block;" readonly="readonly" > <br>
            	
            	房东姓名：	
            	<input type="text" class=" form-control land_landname " 
            	style="width:200px; display: inline-block;" readonly="readonly" > <br>
            	
            	
            	房东区域：	
            	<input type="text" class=" form-control land_address " 
            	style="width:200px; display: inline-block;" > <br>
            	
            	
            	联系人名：	
            	<input type="text" class=" form-control land_linkman" 
            	style="width:200px; display: inline-block;" > <br>
            	
            	
            	联系电话：	
            	<input type="text" class=" form-control land_linkphone " 
            	style="width:200px; display: inline-block;" > <br>
            
            
				品牌名称：	
            	<input type="text" class=" form-control land_brandname " 
            	style="width:200px; display: inline-block;" > <br>	
            	
            	执照编号：	
            	<input type="text" class=" form-control land_businessnum " 
            	style="width:200px; display: inline-block;" > <br>	
            	
            	公司名称：	
            	<input type="text" class=" form-control land_corporate " 
            	style="width:200px; display: inline-block;" > <br>	
            	
            	 <div style="margin-top: 10px;margin-left: 3px;" >
			  	 房东状态：<select   id = "land_landstate"   name="numUnit" class="form-control metro_byname"
			  	  style="width:200px; display: inline-block;"></select>
			     </div>
			   					
            </div>
            <div class="modal-footer">
           <button type="button" class="btn btn-danger delete_land">删除</button>
           <button id="update_landlord" type="button" class="btn btn-primary ">更新</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</html>