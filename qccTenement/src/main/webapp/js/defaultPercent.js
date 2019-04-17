$(function () {
	
	$('.defaultPercent').click(function () {
		var editaddress = $('#defaultPercent');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			listdefaultPercent();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	
	
	
	$('.updateDefault').click(function () {
		var id = $('.default_id').val();
		var descname =  $('.default_descname').val();
		var centnum = $('.default_centnum').val();
		
		$.ajax({
			data: {id:id  , centnum:centnum} , 
			url : '/Tenement/back/updatefaultPercent',
			success : function(data) {
				data = checkaccessexist(data);
				
				if (data.code !=900) {
					if (data.code !=200) {
						alert(data.msg);
					}
					$('#one_default_search').modal('hide');
					 listdefaultPercent();
				}
			}
		});
		
	});
});


function listdefaultPercent() {
	$.ajax({
			url : '/Tenement/back/defaultPercentList',
			success : function(data) {
				var form = $('#defaultPercent_body').empty();
				var list = data.obj;
				var errorparam1 = 0;
				var errorparam2 = 0;
				for (var i=0 ;i<list.length;i++) {
					if (list[i].id == 2 || list[i].id ==3) {
						errorparam1 = errorparam1 + list[i].centnum;
					}
					if (list[i].id == 2 || list[i].id ==4) {
						errorparam2 = errorparam2 + list[i].centnum;
					}
					
					var table_line = '<tr><td>'+list[i].id+'</td><td>'+list[i].descname+'</td>' +
					'<td>'+list[i].centnum+'</td><td><button onclick=editSearchOne('+ list[i].id+ ') class="btn btn-large btn-primary " >编辑</button></td></tr>';
					form.append(table_line);
				}
				
				if (errorparam1 > 1 || errorparam2 > 1 ) {
					$('.error_default').text('警告 :主键 2 + （4或3） 的值已经超过 1 . 请检查对应参数后重新设置!');
					$('.error_default').css("color","red");
				} else {
					$('.error_default').text('提醒: 主键2 +（4或3）的不要超过1,否则可能导致平台亏损!');
					$('.error_default').css("color","Gray");
				}
			}
	});
}

function editSearchOne(id) {
	
	$.ajax({
		data: {id:id} , 
		url : '/Tenement/back/onedefaultPercent',
		success : function(data) {
			$('.default_id').val(data.obj.id);
			$('.default_descname').val(data.obj.descname);
			$('.default_centnum').val(data.obj.centnum);
			
		}
	});
	
	$('#one_default_search').modal('show');
}


