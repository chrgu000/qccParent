$(function () {
	$('.solr_add').click(function() {
		
		var editaddress = $('#solr_add');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	$('.add_buildings_solr').click(function () {
		$.ajax({
			url : '/Tenement/building/builidingtosolr',
			method : 'POST',
			success : function(data) {
				alert(data.msg);
			}
		});
	});
	$('.add_qiuzus_solr').click(function () {
		$.ajax({
			url : '/Tenement/qiuzu/qiuzuaddtosolr',
			method : 'POST',
			success : function(data) {
				alert(data.msg);
			}
		});
	});
	
});