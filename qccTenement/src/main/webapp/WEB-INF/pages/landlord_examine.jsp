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
			<option value="3">未通过</option>
			<option value="4">子账号</option>
			<option value="2">房东</option>
			<option value="1">申请</option>
		</select>

		<table id="table " class = "table	table-hover ">
			<tr>
				<td  >用户主键</td>
				<td >真实姓名</td>
				<td >申请时间</td>
				<td  >账号类型</td>
				<td  >详情信息</td>
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
                <h4 class="modal-title" id="myModalLabel">详细资料</h4>
            </div>
            <div class="modal-body">
            		<label class="access_label" for="name">证件号码：</label>
						<span class="landlord_identity"> </span> <br>
					<label class="access_label" for="name">区域地址：</label>
						<span class="landlord_address"> </span> <br>
            		<label for="name">相关图片:</label>
            		<div class="landlord_idpictures">
            		</div>
					
			   					
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</html>