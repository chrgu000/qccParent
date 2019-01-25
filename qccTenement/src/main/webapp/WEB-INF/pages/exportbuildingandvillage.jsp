<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/exportbuildingandvillage.js"></script>
<title>导出小区楼栋</title>
</head>
<body>

<div id ="export_buil_vill">
				省 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(export_1)" id="export_1">
					<option></option>
				</select>
				 市 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(export_2)" id="export_2">
				</select>
				 区 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(export_3)" id="export_3">
				</select>
				 街 ：
				<select style="width: 110px; margin-top: 15px;" id="export_4">
				</select>
</div>

	<div style="margin-top: 40px;margin-left: 40px;">
		是否有房东电话：<select class="export_select">
			<option value="0">全部</option>
		    <option value="1">有</option>
		</select>
		<button class="btn btn-primary btn-sm export_building"  >导出楼栋</button>
	
	</div>


</body>
</html>