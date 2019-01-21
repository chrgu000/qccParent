<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/suggess.js"></script>
<title>用户意见反馈</title>
</head>
<body>		<div>
						<select class="picture_shanxuan">
							<option value="">图片筛选</option>
							<option value="-1">没有图片</option>
							<option value="ht">图片描述</option>
						</select> 
						<select class="message_shanxuan">
							<option value="">留言筛选</option>
							<option value="is null">没有留言</option>
							<option value="is not null">留言回复</option>
						</select> 
		</div>
		
		
		<table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >用户主键</td>
				<td class ='visible-lg'  >用户昵称</td>
				<td class ='visible-lg' >反馈描述</td>
				<td >回复总数</td>
				<td >图片描述</td>
				<td >反馈时间</td>
				<td >详情</td>
			</tr>
			<tbody id="suggess_body" >

			</tbody>
	</table>
		<!-- 显示分页信息 -->
	<div class="row">
		<div class="col-md-3" id="suggess_info_area"></div>
		<div class="col-md-9" id="suggess_nav_area"> </div>
	 </div>
		
		
		
		<!-- 模态框（Modal） -->
<div style="margin-top: -10px;" class="modal fade" id="suggess_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title suggess_title" id="myModalLabel">反馈详情页面</h4>
            </div>
            <div class="modal-body">
            		<div id ="imags">
            			<label class="access_label" for="name">图片：</label>
            			
            		</div>
            		
					<div id="message_sugges" style="margin-top: 20px;">
					
					</div>
            		
			   					
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
		
</body>
</html>