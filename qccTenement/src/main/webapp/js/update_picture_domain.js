$(function () {
	$('.update_picture_domain').click(function () {
		
		var editaddress = $('#update_picture_domain');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			updatepicbytype();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	
});

function updatepicbytype() {
	$.ajax({
		method : 'post',
		url : '/Tenement/updatepic',
		success : function(data) {
			if (data.code == 200) {
				var form = $('#pic_body').empty();
				var obj = data.obj;
				$.each(obj,function (index,value) {
					var allpic = value.picture;
					if ( allpic !== '') {
						var arry = allpic.split(",");
						$.each(arry,function (index,data) {
							var picture = '<img style="width:40px;height:40px;" src='+data+'>';
							form.append(picture);
						});
						
					}
				});
			}
		}
	});
}