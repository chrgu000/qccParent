$(function() {
	
	$('.area_typename').focus(function() {
		$('.area_typename').val('');
	});
	$('.makebuildngcode').click(function () {
		$('.makebuildngcode').hide();
		$('.maketext').text('同步数据中,请耐心等待....');
		$.ajax({
			
			type : 'POST',
			url : '/Tenement/buildingnum',
			success : function(data) {
				data = checkaccessexist(data);
			}
		
	}); })
	
	$('.metro_add').click(function() {
		$('.metro_metroid').val('');
		$('.metro_name').val('');
		$('.metro_stop').val('');
		$('#error_span').text('');
		$('.metro_insert').text('添加');
		var code_1 = $('#metro_1').val();
		var options_1 = $("#metro_1 option:selected");
		var value_1 = options_1.text();

		var code_2 = $('#metro_2').val();
		var options_2 = $("#metro_2 option:selected");
		var value_2 = options_2.text();

		if (code_2 != null && code_2 != '请选择') {
			$('.metro_code').val(code_2);
			$('.metro_city').val(value_2);
		} else {
			$('.metro_code').val(code_1);
			$('.metro_city').val(value_1);
		}
	});
	$('.layout_sure').click(function () {
		$('#lay_out').submit();
	});
	$('.metro_search').click(function() {
		var code = $('#metro_1').val();
		var code_2 = $('#metro_2').val();
		if (code_2 != null && code_2 != '请选择') {
			code = code_2;
		}
		$('.selectcode').val(code);
		getmetrolist(1);
	});

	$('.metro_insert').click(function() {
		var code = $('.metro_code').val();
		var name = $('.metro_name').val();
		var metroid = $('.metro_metroid').val();
		var finalstop = $('.metro_stop').val();
		var currentpage = $('.metro_hidden_currentpage').val();
		$.ajax({
			data : {
				'code' : code,
				'name' : name,
				'finalstop' : finalstop,
				'metroid' : metroid
			},
			type : 'POST',
			url : '/Tenement/metro/add',
			success : function(data) {
				data = checkaccessexist(data);
				$('#error_span').text(data.msg);
				if (data.code == 201) {
					 $('#me_add').modal('hide');
				}
				 getmetrolist(currentpage);
			}
		});
	});
	$('.area-add').click(function() {
		var id = $('.area_id').val();
		var code = $('.area_code').val();
		var parentId = $('.area_parentId').val();
		var name = $('.area_name').val();
		var level = $('.area_level').val();
		var submitname = $('.area_typename').val();
		$.ajax({
			data : {
				'parentId' : parentId,
				'submitname' : submitname,
				'level' : level,
				'code' : code
			},
			type : 'POST',
			url : '/Tenement/area/add',
			success : function(data) {
				if (data.code == 900) {
					$('#area_edit').modal('hide');
				}
				data = checkaccessexist(data);
				$('.area_typename').val(data.msg);
			}
		});
	});
	
	
})

$('.metro').click(function() {
		var editaddress = $('#metro');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			getprovince('metro');
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		//getmetroajax();
});


$('.systemdata').click(function() {
	var editaddress = $('#systemdata');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		getprovince('editaddress');
		editaddress.show();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	
});



$('.editaddress2').click(function() {
	var editaddress = $('#editaddress2');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		editaddress.show();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	getnextform(0);
});


$('.tribep').click(function() {
	var editaddress = $('#tribep');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		editaddress.show();
		searchArticleTypePersion(7 , '找人');
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	
});

$('.tribet').click(function() {
	var editaddress = $('#tribet');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		editaddress.show();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	searchArticleTypeThing(6 , '物品');
});

$('.lovetribe').click(function() {

	var editaddress = $('#lovetribe');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		editaddress.show();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	getlovetribe();
});
$('.tribeaddress').click(function() {

	var editaddress = $('#tribeaddress');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		editaddress.show();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	tribeaddress();
});

$('.village').click(function() {

	var editaddress = $('#village');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		 getprovince ('village');
		editaddress.show();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	//getvillageajax();
});

$('.building').click(function() {

	var editaddress = $('#building');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		getprovince ('building');
		editaddress.show();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
//	getbuildingajax();

});

// 删除地铁
function metrodelete(metroid, code, name, finalstop) {
	// 封装提示的主干
	var tip = '['+name+'-- '+finalstop+']';
	$('.delete_tip').text(tip);
	//删除之后回调的分页
	var currentpage = $('.metro_hidden_currentpage').val();
	//执行的URL
	var deleteurl = '/Tenement/metro/delete';
	// 传入的参数名称
	var param = 'metroid';
	commondelete(param,  metroid ,deleteurl ,currentpage);
}

function getform() {
	$
			.ajax({
				url : '/Tenement/area/getareabycode',
				type : 'POST',
				success : function(a) {
					var obj = a.obj;
					var form = $("#tbody");
					$
							.each(
									obj,
									function(index, value) {
										var td = '<tr  style="margin-top: 22px;"><td class="visible-lg" value = '
												+ value.id
												+ '>'
												+ value.id
												+ '</td class="visible-lg" value='
												+ value.code
												+ '><td class="visible-lg">'
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
												+ '</td><td  class="visible-lg" onmousemove=getpre('
												+ value.parentId
												+ ') vaule='
												+ value.parentId
												+ '>'
												+ value.parentId
												+ '<td >'
												+ value.fname
												+ '</td>'
												+ '<td ><a	class="btn btn-default "  href="javascript:void(0);"  onclick= "getnextform('
												+ value.code
												+ ' )" >查看</a></td>'
												+ '<td></td>' + '</td></tr>'
										form.append(td);
									})
				}
			})
}

function metroedit(metroid, code, cityname, name, finalstop) {
	$('.metro_metroid').val(metroid);
	$('.metro_code').val(code);
	$('.metro_city').val(cityname);
	$('.metro_name').val(name);
	$('.metro_stop').val(finalstop);
	$('#error_span').text('');
	$('.metro_insert').text('编辑');
}

function getnextform(attr) {
	$('.pre-class').html(attr);
	var form = $("#tbody");
	form.empty();
	$
			.ajax({
				data : {
					'code' : attr
				},
				type : 'POST',
				url : '/Tenement/area/getareabycode',
				success : function(a) {
					var obj = a.obj;
					$
							.each(
									obj,
									function(index, value) {
										var td = '<tr ><td class="visible-lg" value = '
												+ value.id
												+ '>'
												+ value.id
												+ '</td value='
												+ value.code
												+ '><td class="visible-lg">'
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
												+ '</td><td class="visible-lg" onmousemove=getpre('
												+ value.parentId
												+ ') vaule='
												+ value.parentId
												+ '>'
												+ value.parentId
												+ '<td>'
												+ value.fname
												+ '</td>'
												+ '<td><a class="btn btn-default" href="javascript:void(0);"  onclick= "getnextform('
												+ value.code
												+ ' )" >查看</a></td>'
												+ '</td>'
												+ '<td><a class="btn btn-default" href="javascript:void(0);" onclick = editform('
												+ value.id
												+ '\,\''
												+ value.name
												+ '\',\''
												+ value.code
												+ '\',\''
												+ value.parentId
												+ '\')  >编辑</a></td>'
												+ '<td><a class="btn btn-large btn-primary " onclick= areadetail('
												+ value.code
												+ ')  data-toggle="modal" data-target="#area_edit">详情</a></td></tr>'
										form.append(td);
									})
				}
			});
};

function editform(id, name, code, pid) {
	var code = '.' + code
	valuesumbit = $(code).text();
	if (confirm('你确定要把  [  ' + name + '  ]  改成 [  ' + valuesumbit + '  ]  ?')) {
		$.ajax({
			data : {
				'id' : id,
				'name' : valuesumbit
			},
			type : 'POST',
			url : '/Tenement/area/edit',
			success : function(data) {
				data = checkaccessexist(data);
				if (data.code == 200) {
					alert('恭喜你修改成功');
					getnextform(pid);
				}
			}
		});
	}
}

function addform(code, name, fname, parentId) {
	var code = '.' + code
	valuesumbit = $(code).text();
	if (confirm('你确定要在  [  ' + fname + '  ]  下加下一级地址 [  ' + valuesumbit
			+ '  ]  ?')) {
		$.ajax({
			data : {
				'parentId' : parentId,
				'name' : valuesumbit
			},
			type : 'POST',
			url : '/Tenement/area/add',
			success : function(data) {
				if (data.code == 900) {
					$('#area_edit').modal('hide');
				}
				data = checkaccessexist(data);
				if (data.code == 200 ) {
					getnextform(parentId);
				}
			}
		});
	}
}

function areadetail(code) {
	$.ajax({
		data : {
			'code' : code,
		},
		url : '/Tenement/area/areadetail',
		success : function(data) {
			$('.area_id').val(data.obj.id);
			$('.area_code').val(data.obj.code);
			$('.area_parentId').val(data.obj.parentId);
			$('.area_name').val(data.obj.name);
			$('.area_level').val(data.obj.level);
		}
	});
}

function getpreform() {
	var valuesearch = $('.pre-class').text();
	$.ajax({
		data : {
			'code' : valuesearch,
		},
		url : '/Tenement/area/areadetail',
		success : function(data) {
			getnextform(data.obj.parentId);
		}
	});
}

function getmetrolist(currentpage) {
	var code = $('.selectcode').val();
	$ .ajax({ data : { 'code' : code ,
			'currentpage':currentpage},
	url : '/Tenement/metro/search',
	success : function(data) {
		data = checkaccessexist(data);
		
			if (data.code == 200) {
			//显示分页信息
			build_common_page('metro_info_area' , data);
			
			//3、解析显示分页条数据
			build_common_nav('metro_nav_area' , data);
			
			//显示分页数据
			build_metro_list(data);	
			
			}
		}
	});
}


function build_metro_list(data) {
	var metrolist = data.obj.metrolist;
	var pagequery = data.obj.pagequery;
	var form = $("#metro_table").empty();
	$.each(metrolist,function(index, value) {
		var td = '<tr><td >' + value.code + '</td> <td>' + value.cityname + '</td><td>'
			+ value.name+ '</td><td>'+ value.finalstop+ '</td><td><a onclick = metroedit('
			+ value.metroid+ '\,\''+ value.code+ '\',\''+ value.cityname+ '\',\''+ value.name
			+ '\',\''+ value.finalstop+ '\') data-toggle="modal" data-target="#me_add" class="btn btn-xs metro_edit"   >编辑</a></td><td>'
			+ '<a onclick = metrodelete('+ value.metroid+ '\,\''+ value.code+ '\',\''+ value.name
			+ '\',\''+ value.finalstop+ '\')  class="btn btn-xs"   >删除</a></td></tr>';
	form.append(td);
	});
	form.append(' <input type="hidden" class="metro_hidden_currentpage" value='+pagequery.currentpage+' /> ');
	$('metro_edit').click(function () {
		$('.metro_insert').text('更新');
	});
	
}

function checkaccessexist(res) {
	var data ;
	if (res.code === undefined) {
		data =   JSON.parse(res);
	}else {
		data = res;
	}
	
	if (data.code==900) {
		var urlname = data.obj;
		$('.urlname').text('需要权限：  '+urlname);
		$('#accessnotinfull').modal('show');
	}
	return data ;
}

function setattr(code) {
	var code = '.' + code
	valuesumbit = $(code).text();
}