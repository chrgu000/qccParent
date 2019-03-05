$(function () {
	
	$('.bdmanager').click(function () {
		var editaddress = $('#bdmanager');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			listbd ();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	
	$('.bd_model_alert').click(function () {
		 $('.bd_telephone').val('');
		 $('.bd_realname').val('');
		 $('.bd_id').val('');
		
	});
	
	
	$('.bd_save').click(function () {
		var bdid= $('.bd_id').val();
		var telephone= $('.bd_telephone').val();
		var realname = $('.bd_realname').val();
		$.ajax({
			data : {bdid:bdid ,telephone:telephone , realname:realname },
			method : 'post',
			url : '/Tenement/bd/save',
			success : function(data) {
				alert(data.msg);
				$('#bd_add_update').modal('hide');
				listbd ();
			}
		});
	});
});
var bdState = ['禁用' , '正常'];
var showState = ['恢复' , '冻结'];

function listbd () {
	var form = $('#bd_body');
	$.ajax({
		method : 'post',
		url : '/Tenement/bd/list',
		success : function(data) {
			form.empty();
			$.each(data.obj,function(index, value) {
				var body_in ='<tr><td >'+value.bdid+'</td><td>'+value.telephone+'</td>'+
				'<td>'+value.realname+'</td><td>'+bdState[value.state]+'</td>'+
				'<td><a onclick=searchOneBd(\''+value.bdid+'\') class="btn   btn-primary" data-toggle="modal" data-target="#bd_add_update">编辑 </a>'
				+'<a style="margin-left: 15px"; onclick=changestate(\''+value.bdid+'\') class="btn   btn-primary" >'+showState[value.state]+'</a></td></tr>';
				form.append(body_in);
			});	
		}
	});
}

function changestate(bdid) {
	$.ajax({
		data : {bdid:bdid},
		method : 'post',
		url : '/Tenement/bd/changeState',
		success : function(data) {
			listbd ();
		}
	});
}

function searchOneBd (bdid) {
	$.ajax({
		data : {bdid:bdid},
		method : 'post',
		url : '/Tenement/bd/searchOne',
		success : function(data) {
			 $('.bd_telephone').val(data.obj.telephone);
			 $('.bd_realname').val(data.obj.realname);
			 $('.bd_id').val(data.obj.bdid);
		}
	});
}