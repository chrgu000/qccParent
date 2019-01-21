$(function () {
	
	
	$('.commoninte').click(function() {
		
		var editaddress = $('#commoninte');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			searchcommoninte ();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	
	$('.comm_update').click(function () {
		var commonid = $('.comm_commonid').val();
		var typename = $('.comm_typename').val();
		var typecount = $('.comm_typecount').val();
		var frequency = $('.comm_frequency').val();
		$.ajax({
			data :{commonid:commonid ,typename:typename ,typecount:typecount ,frequency:frequency   },
			method : 'post',
			url : '/Tenement/back/commoninteupdate',
			success : function(data) {
				data = checkaccessexist(data);
				if (data.code == 200) {
					$('#commoninte_detail').modal('hide');
					searchcommoninte ();
				}
			}
		});
		
	});
	
	
	
})


function searchcommoninte () {
	$.ajax({
		method : 'post',
		url : '/Tenement/back/searchcommoninte',
		success : function(data) {
			data = checkaccessexist(data);
			if (data.code == 200) {
				var commoninte = data.obj;
				var form = $('#commoninte_body').empty();
				$.each(commoninte,function(index, value) {
					var body_in ='<tr><td >'+value.commonid+'</td><td>'+value.typename+'</td>'+
					'<td>'+value.typecount+'</td><td>'+value.frequency+'</td><td>'+value.typeword+ value.typecount+'</td>' 
					+'<td> <button onclick=searchbycommonid('+ value.commonid+')  class="btn btn-xm btn-primary " data-toggle="modal" data-target="#commoninte_detail"> 编辑 </button> </td></tr>';
					form.append(body_in);
				});
			}
		}
	});
}


function searchbycommonid(commonid) {
	$.ajax({
		data :{commonid:commonid} , 
		method : 'post',
		url : '/Tenement/back/searchbycommonid',
		success : function(data) {
			if (data.code == 200) {
				var comm = data.obj;
				$('.comm_commonid').val(comm.commonid);
				$('.comm_typename').val(comm.typename);
				$('.comm_typecount').val(comm.typecount);
				$('.comm_frequency').val(comm.frequency);
				$('.comm_typeword').val(comm.typeword+comm.typecount);
			}
		}
	});
}