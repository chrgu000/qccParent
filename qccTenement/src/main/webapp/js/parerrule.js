$(   function ()  {
	$('.parerrule').click(function () {
		var editaddress = $('#parerrule');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			searchparaulist();
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	
	$('.parar_update').click(function () {
		var pararuledetail = $('.parar_pararuledetail').val();
		var pararuleid =  $('.parar_id').val();
		$.ajax ({
			data : {pararuledetail : pararuledetail  ,pararuleid:pararuleid} ,
			type : 'POST',
			url : '/Tenement/updatepararule' , 
			success : function (data) {
				$('#update_parerrule').modal('hide');
			}
		});
		
	});
	
});


function searchparaulist() {
	$.ajax({
		url : '/Tenement/paraulelist' ,
		success : function (data) {
			var par = data.obj;
			var form = $('#parerrule_body').empty();
			$.each(par ,function (index ,value) {
				var body = '<tr><td>'+value.pararuleid+'</td><td>'+value.pararulename+'</td>'+
				'<td><button onclick=singlepararu('+value.pararuleid+')  class="btn btn-large btn-primary" data-toggle="modal" data-target="#update_parerrule"> 详情</button></td></tr>';
				form.append(body);
			});
			
			
		}
		
	});
}


function singlepararu(pararuleid) {
	$.ajax({
		data : {pararuleid : pararuleid} ,
		url : '/Tenement/searchpararulebyid' ,
		type : 'POST',
		success : function (data) {
			var parar = data.obj;
			$('.parar_pararuledetail').val(parar.pararuledetail);
			$('.parar_name').text(parar.pararulename);
			$('.parar_id').val(parar.pararuleid);
		}
	}) ;
}