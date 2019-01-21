
function getsystemmess() {
	var form = $('#systembody').empty();
	$.ajax ({
		type : 'POST',
		url : '/Tenement/back/searchsystemstate',
		success : function (data) {
			var systems = data.obj;
			$.each(systems,function(index, value) {
				var body_in ='<tr><td >'+value.systemid+'</td><td>'+value.descname+'</td>'+
				'<td >'+value.defaultstate+'</td><td>'+value.stateabout+'</td>'+ 
				'<td>'+value.typeword+'</td>' + '<td><button onclick=searchsystemstatedetail('+value.systemid+') class="btn btn-large btn-primary " data-toggle="modal" data-target="#searchsystemstatedetail">详情</button></td>' + 
				+'</tr>';
				form.append(body_in);
			});
		}
	});
}

function searchsystemstatedetail (systemid) {
	$.ajax ({
		data : {
			'systemid' : systemid
		},
		type : 'POST',
		url : '/Tenement/back/searchsystemstatebyid',
		success : function (data) {
			var systems = data.obj;
			$('.systemstate_descname').val(systems.descname);
			$('.systemstate_state').val(systems.defaultstate);
			$('.systemstate_about').text(systems.stateabout);
			$('.systemstate_systemid').val(systems.systemid);
		}
	});
	
	
	
}





$(function () {
	
	// 打开或者关闭系统参数页面
	$('.systemstate').click(function() {
		var editaddress = $('#systemstate');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			getsystemmess();
		}
		if (cssdisplay === 'block') {
			
			editaddress.hide();
		}
	});
	
	$('.systemstate_update').click(function () {
		var descname = $('.systemstate_descname').val();
		var defaultstate = $('.systemstate_state').val();
		var systemid = $('.systemstate_systemid').val();
		$.ajax ({
			data : {
				'systemid' : systemid,
				'defaultstate' : defaultstate,
				'descname' : descname
			},
			type : 'POST',
			url : '/Tenement/back/updatesystemstate',
			success : function (res) {
				var data = checkaccessexist(res) ;
				if (data.code == 200 || data.code == 900) {
					$('#searchsystemstatedetail').modal('hide');
					getsystemmess();
				}else {
					alert(data.msg);
				}
			}
		});
		
	});
	
	
	
	
	
	
	
	
	
	
});