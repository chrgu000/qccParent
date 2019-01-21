<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/common.js"></script>
<script type="text/javascript" src="/Tenement/js/useraccount.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户钱包统计


</title>
</head>
<body>
	<div id="user_account_head_div">
		<input style="width: 200px;" type="text" class="form-control searchwhere "  
	placeholder="昵称/电话/真实姓名" /> 
	<button style="margin-left: 230px;margin-top: -60px;" type="button" class="btn btn-primary make_sure_search">确定</button>
	
	<button data-toggle="modal" data-target="#export_alluser_bure"  class="btn btn-default export_alluser_bure" style="margin-left: 250px;margin-top: -62px;">导出文件 </button>
	</div>
	
	
	
	
	<table id="table" class = "table	table-hover	 ">
		<thead id="user_account_head_thead">
			<tr>
				<td >电话</td>
				<td >昵称</td>
				<td ><span class="user_shouyi">收益↓</span></td>
				<td ><span class="user_hongbi">红币↓</span> </td>
				<td ><span class="user_jinbi">金币↓</span></td>
				<td ><span class="user_qicaibi">七彩币↓</span></td>
				<td ><span class= "user_cishu">求租次数↓</span></td>
				<td ><input  checked='checked' type='checkbox' class="set_useraccout_check"/></td></td>
			</tr>
		</thead>
			<tbody id="all_user_account" >

			</tbody>
	</table>
	
	   <!-- 显示分页信息 -->
		<div class="row" id="user_account_head_page">
			<!--分页文字信息  -->
			<div class="col-md-3" id="page_info_area" style="float: left;"></div>
			<!-- 分页条信息 -->
			<div class="col-md-9" id="page_nav_area" style="float: left;margin-top: -10px;" > </div>
		</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="export_alluser_bure" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">导出用户钱包信息EXCLE</h4>
            </div>
            <div class="modal-body">
            		<label for="name">请输入导出数量</label>
						<input type="number" class="form-control expert_all_user_number" value="7"
			   placeholder="请数量导出数量">
			   <label for="name">输入EXCLE描述</label>
						<input type="text" class="form-control expert_all_descname" 
			   placeholder="EXCLE 别名">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary expert_all_user_excle">新增</button>
            </div>
        </div>
    </div>
</div>




<div style="margin-top: 10px;" class="modal fade"
		id="detail_all_account" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div style="width: 90%; height: 90%;" class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<input type="hidden" value="searchsymx" class="commonmx"/>
						<button  style='margin-left: 55px;' class='btn btn-default setsearchcommonval'>
						<span style="display: none;">searchsymx</span>
						收益明细 </button>
						<button  style='margin-left: 55px;' class='btn btn-default setsearchcommonval'>
						<span style="display: none;">searchhbmx</span>
						红币明细 </button>
						<button  style='margin-left: 55px;' class='btn btn-default setsearchcommonval '>
						<span style="display: none;">searchjbmx</span>
						金币明细   </button>
						<button  style='margin-left: 55px;' class='btn btn-default setsearchcommonval'>
						<span style="display: none;">searchxfmx</span>
						消费明细 </button>
						<button  style='margin-left: 55px;' class='btn btn-default setsearchcommonval'>
						<span style="display: none;">searchhymx</span>
						会员明细 </button>
					</h4>
				</div>
				<div class="modal-body">
					<table id="table " class="table	table-hover ">
						<tr>
							<td class='visible-lg'>用户主键</td>
							<td class='visible-lg'>用户昵称</td>
							<td class='visible-lg'>电话号码</td>
							<td> 币种数目 </td>
							<td> 币种状态 </td>
							<td>类目事件 </td>
							<td > 操作时间</td>
						</tr>
						<tbody id="user_jbmx"> </tbody>
					</table>
					
					
					
		
		
				</div>  
			
				
					
				<div class="row" id="usermx" style="height: 45px;"> </div>
				
			</div>
		</div>
	</div>

</body>
</html>