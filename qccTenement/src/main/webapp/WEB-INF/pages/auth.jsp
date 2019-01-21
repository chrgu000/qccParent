<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/auth.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>房东发布委托</title>
</head>
<body>

	<table id="table " class="table	table-hover	 ">
		<tr>
			<td>用户昵称</td>
			<td>用户电话</td>
			<td>区域</td>
			<td>类型</td>
			<td>面积</td>
			<td>价格</td>
			<td>联系人</td>
			<td>联系电话</td>
			<td>更新时间</td>
			<td>
				<select id ="authstate_select">
					<option value="">状态</option>
					<option value="0">冻结</option>
					<option  value="1">上架</option>
					<option value="2">下架</option>
					<option value="3">移除</option>
				</select>
				
			</td>
		</tr>
		<tbody id="auth_list">

		</tbody>
	</table>
			<div style="text-align: center;">
						<ul style="" class="pagination authpagequery_list">
						</ul>
		</div>	
</body>
</html>