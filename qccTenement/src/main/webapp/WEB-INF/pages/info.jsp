<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
option: {
	width: 40px;
	height: 20px;
}

tr : {
	margin-top: 10px;
}
</style>
<script type="text/javascript" src="/Tenement/js/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四级联动</title>
</head>
<body>
	省 ：
	<select style="width: 110px; margin-top: 15px;"
		onchange="getnext(areaone)" id="areaone">
		<option>-请选择-</option>
	</select>
	<br /> 市 ：
	<select style="width: 110px; margin-top: 15px;"
		onchange="getnext(areatwo)" id="areatwo"></select>
	<br /> 区 ：
	<select style="width: 110px; margin-top: 15px;"
		onchange="getnext(areathree)" id="areathree">
	</select>
	<br /> 街 ：
	<select style="width: 110px; margin-top: 15px;"
		onchange="getnext(areafour)" id="areafour"></select>

	<br />
	<br />
	<br />
	<br />


	<a href="javascript:void(0);" onclick="getnextform(0 )">首级城市</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;四级联动----------->>>>地址编辑
	<form id="cityfrom" action="/Tenement/area/edit" method="post">
		<table id="table">
			<tr>
				<td width="90px">城市ID</td>
				<td width="90px">城市CODE</td>
				<td width="90px">城市名称</td>
				<td width="90px">城市父id</td>
				<td width="90px">上级/新增</td>
				<td width="90px">查看</td>
				<td width="90px">编辑</td>
				<td width="90px">新增</td>
			</tr>
			<tbody id="tbody">

			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		getajax();
		getform();
	})
	function tt() {
		alert(this.text())
	}
	var valuesumbit = '';
	function setattr(code) {
		var code = '.' + code
		valuesumbit = $(code).text();
	}
	function getform() {
		$.ajax({
			url : '/Tenement/area/getareabycode',
			success : function(a) {
				var obj = a.obj;
				var form = $("#tbody");
				$.each(obj,function(index, value) {
				var td = '<tr  style="margin-top: 22px;"><td  value = '+value.id+'>'
													+ value.id
													+ '</td value='+value.code+'><td>'
													+ value.code
													+ '</td><td class='
													+ value.code
													+ ' onkeyup=setattr('
													+ value.code
													+ ') contentEditable="true" value='
													+ value.name
													+ '>'
													+ '<span>'
													+ value.name
													+ '</span>'
													+ '</td><td vaule='+value.parentId+'>'
													+ value.parentId
													+ '<td >'
													+ value.fname
													+ '</td>'
													+ '<td><a  href="javascript:void(0);"  onclick= "getnextform('
													+ value.code
													+ ' )" >查看</a></td>'
													+ '<td><a   href="javascript:void(0);" onclick = editform('
													+ value.id
													+ '\,\''
													+ value.name
													+ '\',\''
													+ value.code
													+ '\')  >编辑</a></td>'
													+ '</td></tr>'
											form.append(td);
										})
					}
				})
	}

	function getajax() {
		$.ajax({
			url : '/Tenement/area/getareabycode',
			success : function(a) {
				var obj = a.obj;
				var select = $('#areaone');
				$.each(obj, function(index, value) {
					var option = '<option   value = '+value.code+'>'
							+ value.name + '</option>'
					select.append(option);
				})
			}
		})
	}
	function getnext(attr) {
		var select = attr.id;
		var selectValue = attr.value;
		select = $('#' + select);
		select.next().nextAll().empty();
		$.ajax({
			data : {
				'code' : selectValue
			},
			url : '/Tenement/area/getareabycode',
			success : function(a) {
				var obj = a.obj;
				$.each(obj, function(index, value) {
					var option = '<option  value = '+value.code+'>'
							+ value.name + '</option>'
					select.next().next().append(option);
				})
			}
		});
	};
	function getnextform(attr) {
		var form = $("#tbody");
		form.empty();
		$.ajax({
			data : {
						'code' : attr
					},
			url : '/Tenement/area/getareabycode',
			success : function(a) {var obj = a.obj;
				$.each(obj,function(index, value) {
		var td = '<tr ><td  value = '+value.id+'>'+ value.id+ '</td value='+value.code+'><td>'+ value.code+ '</td><td class='+ value.code+ ' onkeyup=setattr('+ value.code+ ') contentEditable="true" value='
		+ value.name+ '>'+ '<span>'+ value.name+ '</span>'
		+ '</td><td vaule='+value.parentId+'>'+ value.parentId
		+ '<td>'+ value.fname+ '</td>'+ '<td><a ha href="javascript:void(0);"  onclick= "getnextform('+ value.code+ ' )" >查看</a></td>'
		+ '</td>'+ '<td><a href="javascript:void(0);" onclick = editform('+ value.id+ '\,\''+ value.name+ '\',\''+ value.code+ '\',\''+value.parentId+'\')  >编辑</a></td>'
		+ '</td><td><a href="javascript:void(0);" onclick = addform('+ value.code+ '\,\''+ value.name+ '\',\''+ value.fname+ '\',\''+value.parentId+'\')  >新增</a></td></tr>'
											form.append(td);
						})
					}
				});
	};

	function editform(id, name, code,pid) {
		var code = '.' + code
		valuesumbit = $(code).text();
		if (confirm('你确定要把  [  ' + name + '  ]  改成 [  '  + valuesumbit + '  ]  ?')) {
			$.ajax({
				data : {
					'id' : id,
					'name' : valuesumbit
				},
				url : '/Tenement/area/edit',
				success : function(data) {
					if (data.code == 200) {
						alert('恭喜你修改成功');
						getnextform(pid);
					}
				}
			});
		}
	}
	
	function addform  (code,name,fname,parentId) {
		var code = '.' + code
		valuesumbit = $(code).text();
		if (confirm('你确定要在  [  ' + fname + '  ]  下加下一级地址 [  '  + valuesumbit + '  ]  ?')) {
			$.ajax({
				data : {
					'parentId' : parentId,
					'name' : valuesumbit
				},
				url : '/Tenement/area/add',
				success : function(data) {
					if (data.code == 200) {
						getnextform(parentId);
					}
				}
			});
		}
	}
</script>
</html>