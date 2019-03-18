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
      data-toggle="modal" data-target="#bd_add_search">添加BD账号</button>
      
      
      <table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >账号</td>
				<td class ='visible-lg'  >联系电话</td>
				<td class ='visible-lg' >用户姓名</td>
				<td class ='visible-lg' >管理区域</td>
				<td class ='visible-lg' >状态</td>
				<td class ='visible-lg' >数据操作</td>
				<td >维护</td>
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
				  <label for="name">用户主键</label>
				  <input type="text" class="form-control bd_userid" readonly="readonly" />
				  <label for="name">联系电话</label>
				  <input type="text" class="form-control bd_telephone" readonly="readonly" />
				  <label for="name">备注信息</label>
				  <input type="text" class="form-control bd_realname"  />
				  <label for="name">管理区域     
				  		<span>   (如果不选默认管理全部)   </span>
				  </label>
				  <div id ="bd_select">
				<select style="width: 100px; "onchange="getnextaddress(bd_1)" id="bd_1">
					<option></option>
				</select>
				
				<select style="width: 100px; "onchange="getnextaddress(bd_2)" id="bd_2">
				</select>
				
				<select style="width: 100px; "onchange="getnextaddress(bd_3)" id="bd_3">
				</select>
				 
				<!-- <select style="width: 100px; " id="bd_4">
				</select> -->
				<div  id="bd_4"></div>
				
				<span id="current"></span>
		</div>
            </div>
            <div class="modal-footer">
            	<span id="living_error"></span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary "  data-toggle="modal" data-target="#bd_add_search">重置用户</button>
                <button type="button" class="btn btn-primary bd_save">确定</button>
            </div>
        </div>
    </div>
</div>





<!-- 添加系统账号 -->
<div style="margin-top: 10px;" class="modal fade"
		id="bd_add_search" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div style="width: 90%; " class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				
					
					<div style="width: 140px;margin-left: 50px;">
					<input width="150px;" type="text" class="form-control bd_searchWhere"  
			   					placeholder="输入电话号码/真实姓名"> 
			   		
		  			</div >
		  			<div style="width: 250px;margin-left: 190px; margin-top: -30px;">
		  				<button type="button" class="btn btn-primary bd_search_btn">
			   		查询</button>
		  			</div>
		  			
		  			
		  			
		  			
			   
	
					
				</div>
				<div class="modal-body">
					<table id="table " class="table	table-hover ">
						<tr>
							<td>用户主键</td>
							<td>用户昵称</td>
							<td>电话号码</td>
							<td>真实姓名</td>
							<td>操作</td>
						</tr>
						<tbody id="search_addBD_body"> </tbody>
					</table>
					
					<div class="row">
						<!--分页文字信息  -->
						<div class="col-md-3" id="search_addbd_info_area"></div>
						<!-- 分页条信息 -->
						<div class="col-md-9" id="search_addbd_nav_area"> </div>
		     		 </div>
					
					
		
				</div>  
				
				<div class="modal-footer" style="clear: both; text-align: right;">
					
					<button type="button"
						class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary bd_put_add">确定</button>
				</div>
			</div>
		</div>
	</div>
</html>