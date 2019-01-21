<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/qiuzu.js"></script>
<title>求租发布统计</title>
</head>
<body>

			<div id ="qiuzu_first">
				省 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(qiuzu_1)" id="qiuzu_1">
					<option></option>
				</select>
				 市 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(qiuzu_2)" id="qiuzu_2">
				</select>
				 区 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(qiuzu_3)" id="qiuzu_3">
				</select>
				 街 ：
				<select style="width: 110px; margin-top: 15px;" id="qiuzu_4">
				</select>
		</div>

			<div style="margin-left: 120px;margin-top: 5px;">
				<button class="btn btn-large  qiuzucount" >开始统计</button>
			</div>	
			
			<table id="table " class = "table	table-hover	 ">
			<thead id= "qiuzu_table">
			<tr>
				<td class ='visible-lg'  >用户ID</td>
				<td class ='visible-lg'  >用户昵称</td>
				<td class ='visible-lg' >电话号码</td>
				<td >本月发布</td>
				<td>总计发布</td>
				<td>详情</td>
			</tr>
			</thead>
			<tbody id="qiuzu_list" >

			</tbody>
			</table>
		

</body>
</html>