$(function () {
	$('.percent').click(function() {
		
		var editaddress = $('#percent');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			searchpercenttype ();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	
	$('.percent_nub').keyup(function () {
		var percentnum = $('.percent_nub').val();
		if (percentnum > 100) {$('.percent_nub').val(100);}
		if (percentnum <0) {$('.percent_nub').val(0);}
	});
	
	$('.percent_add').click(function () {
		var type = $('#percent_type').val();
		$('#percent_error_span').text('');
		$('#notcheck_percent').modal('show');
		$.ajax ({
			url : '/Tenement/back/searchpercenttype',
			method:'POST',
			success : function (data) {
				var type = data.obj;
				var form = $('#perent_add_show').empty();
				$.each(type,function (index,value) {
					var body_in = '<option value='+value.type+'>'+value.typename+'</option>';
					form.append(body_in);
				});
				
			}
		});
		
	});
	
	
	
	
})

function search_percent_bytype() {
	
	var type = $('#percent_type').val();
	$.ajax ({
		data:{type:type},
		url : '/Tenement/back/searpercent',
		method:'POST',
		success : function (data) {
			var percent = data.obj;
			var form = $('#percent_body').empty();
			$.each(percent,function (index,value) {
				var cent = value.percentnum*100 + '%';
				var body_in = '<tr><td>'+value.percentid+'</td><td>'+cent+'</td>'+'<td>'+value.typename+'</td>'
				//  <td><a class="btn btn-xs setsearchword" id="1_10000003_超级管理">编辑 </a></td> '  
				+'  <td><a class="btn btn-xs" onclick="deletepercent('+ value.percentid+ '\,\''+ cent+ '\',\''+ value.typename+ '\')">删除 </a></td>  </tr>';
				form.append(body_in);
			});
			//('+ value.metroid+ '\,\''+ value.code+ '\',\''+ value.finalstop+ '\')
		}
	});
}

function searchpercenttype () {
	$.ajax ({
		url : '/Tenement/back/searchpercenttype',
		method:'POST',
		success : function (data) {
			var type = data.obj;
			var form = $('#percent_type').empty();
			form.append('<option value="">全部设置</option>');
			$.each(type,function (index,value) {
				var body_in = '<option value='+value.type+'>'+value.typename+'</option>';
				form.append(body_in);
			});
			
		}
	});
	search_percent_bytype();
}

function percent_add() {
	var type = $('#perent_add_show').val();
	var percentnum = $('.percent_nub').val();
	percentnum = percentnum * 0.01;
	$.ajax ({
		data:{type :type ,percentnum:percentnum } ,
		url : '/Tenement/back/addpercent',
		method:'POST',
		success : function (data) {
			data = checkaccessexist(data);
			if (data.code == 200) {
				//$('#notcheck_percent').modal('hide');
				search_percent_bytype();
			}
			$('#percent_error_span').text(data.msg);
		}
	});
	
}

// 删除百分比
function deletepercent(percentid ,cent , typename) {
	// 封装提示的主干
	var tip = '[ '+ typename+' -- '+cent+']';
	$('.delete_tip').text(tip);
	//如果没有分页参数自定义一个
	var currentpage = 0;
	//设置参数名称
	var param = 'percentid';
	//执行删除的URL链接
	var deleteurl = '/Tenement/back/deletepercent';
	commondelete(param,  percentid ,deleteurl , currentpage);
} 