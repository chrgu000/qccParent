$(function () {
	
	$('.update_test').click(function() {
		var editaddress = $('#updatetest');
		var cssdisplay = editaddress.css('display');
		var userid = $('.sessionuserid').val();
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			gentuserbure (userid);
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	$('.reflash_bure').click(function () {
		$('#test_error_span').text('');
		var userid = $('.test_userid').val();
		gentuserbure (userid);
		
	});
	
	$('.update_bure').click(function () {
		var user_id = $('.test_userid').val();
		var count = $('.test_count').val();
		var intecount = $('.test_jinbi').val();
		var balance = $('.test_yue').val();
		var is_vip = $('.test_vip').val();
		$.ajax({
			data : {
				'user_id' : user_id,
				'count':count ,
				'intecount':intecount,
				'balance':balance,
				'is_vip' : is_vip
			},
			type : 'POST',
			url : '/Tenement/consume/testupdatebure',
			success : function(data) {
				data = checkaccessexist(data);
				$('#test_error_span').text(data.msg);
			}
		});
		
	});
	
	
});


function gentuserbure (userid) {
	$('#test_error_span').text('');
	$.ajax({
		data : {
			'user_id' : userid,
		},
		type : 'POST',
		url : '/Tenement/consume/myburse',
		success : function(data) {
			data = checkaccessexist(data);
			if (data.code == 200) {
				var user = data.obj;
				$('.test_userid').val(user.user_id);
				$('.test_count').val(user.count);
				$('.test_jinbi').val(user.intecount);
				$('.test_yue').val(user.balance);
				$('.test_vip').val(user.is_vip);
			}
		}
	});
}