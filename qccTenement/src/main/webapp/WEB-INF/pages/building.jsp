<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body onload="getprovince ('building');">
		
		<div id ="building_css">
	
				省 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(b_1)" id="b_1">
					
				</select>
				 市 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(b_2)" id="b_2">
					
				</select>
				 区 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(b_3)" id="b_3">
					
				</select>
				 街 ：
				<select class="building_v4" style="width: 110px; margin-top: 15px;" id="b_4">
					
				</select>
	
		</div>
		
		
			<div style="margin-top: 15px;">
				<button class="btn btn-primary btn-sm bildingcount" >楼栋统计</button>
				<button style="margin-top: -15px;margin-left: 20px;" class="btn btn-primary btn-sm villagecount" >小区统计</button>
				<button style="margin-top: -15px;margin-left: 20px;" class="btn btn-primary btn-sm building_excle_upload">导出EXCLE文件</button>
				<span>有房 ---- 表示有房东电话  |||||     有联 -----表示有联系人电话</span>
			</div>	
			 
			<table id="table " class = "table	table-hover	 ">
			<thead class="cellhead">
				<tr>
				<td class ='visible-lg'  >用户ID</td>
				<td  >用户昵称</td>
				<td class ='visible-lg' >电话号码</td>
				<td >本月</td>
				<td >有联</td>
				<td>无联</td>
				<td >有房</td>
				<td>无房</td>
				<td>总计</td>
				<td >有联</td>
				<td>无联</td>
				<td >有房</td>
				<td>无房</td>
			</tr>
			</thead>
			
			<tbody id="building_list" >

			</tbody>
			</table>
		<!-- 	
			<form action="batchpicure" method="post" enctype="multipart/form-data">
   				<input class="filePrew"  tabIndex="9" type="file" size="9" name="images" multiple  />
   	<input value="上传" type="submit">

 		</form>
 		
 		<button class="btn btn-primary btn-sm beforesend" >BEFORESEND</button>
 		 -->
 		<!--  <button class="btn btn-primary btn-sm testhtml" >TESTHMLT</button> -->
 		<!--  <div id="append"></div> -->
</body>
</html>