$(function () {
	
	$('#authstate_select').change(function (){
		var value = $('#authstate_select').val();
		getallauth (1);
	});
	//隐藏或者打开意见反馈的页面
	$('.auth').click(function() {
		var editaddress = $('#auth');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			getallauth (1);
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});

});
function getnextauth(currentpage){
	var page = Number(currentpage) + 1;
	getallauth(page);
}
function getfirstauth (currentpage) {
	getallauth(1);
}
function getnowauth(currnetpage) {
	getallauth(currnetpage);
}
function getendauth (currnetpage) {
	getallauth(currnetpage);
}
function getpreauth (currentpage) {
	var page = Number(currentpage) - 1;
	getallauth(page);
}
//根据条件查询所有的房东委托
function getallauth (currentpage) {
	var state = $('#authstate_select').val();
	var form = $('#auth_list').empty();
	var pagequerylist = $('.authpagequery_list').empty();
	var type = '';
	$.ajax ( {
		data : {currentpage:currentpage,'authCustomer.state':state},
		url :'/Tenement/auth/getallauth',
		method : 'POST',
		success : function (data) {
			$.each( data.obj.auths,function(index, value) {
				if (value.state == 0) {type = '冻结';}
				if (value.state == 1) {type = '上架';}
				if (value.state == 2) {type = '下架';}
				if (value.state == 3) {type = '移除';}
				var time = setTime(value.update_time);
				var td = '<tr><td>'+value.user_name+'</td><td>'+value.telephone+'</td><td>'+value.trading+'</td>'+
				'<td>'+value.classification+'</td><td>'+value.area+'</td><td>'+value.prices+'</td><td>'+value.linkman+'</td>'+
				'<td>'+value.linkphone+'</td><td>'+time+'</td><td>'+type+'</td></tr>';
				form.append(td);
			})
			var pagequery = data.obj.pagequery;
			var headpage = '<li><a onclick=getpreauth('+pagequery.currentpage+')>上一页</a></li><li><a onclick=getfirstauth('
				+pagequery.currentpage+')>首页</a></li>';
			pagequerylist.append(headpage);
			for (var i = pagequery.currentpage; i < pagequery.currentpage + 7
			&& i <= pagequery.totalpage; i++) {
				pagequerylist.append('<li><a onclick=getnowauth('+i+')>' + i + '</a></li>');
			}
			var endpage = '<li><a onclick=getendauth('
				+ pagequery.totalpage+') >尾页</a></li><li><a onclick=getnextauth(' + pagequery.currentpage + ')>下一页</a></li>';
				pagequerylist.append(endpage);
		}
	}) ;
	
	
	
}