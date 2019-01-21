$(function() { 
	$('.qiuzu_message').click(function () {
		var editaddress = $('#qiuzu_message');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	$('.sendqiuzu_out').click(function () {
		var start = $('#start').val(); 
		var end = $('#end').val(); 
		var content = $('.qiuzu_content').val();
		var num = $('.qiuzu_count').val();
		$.ajax ({
			data :{start:start,end:end,content:content,num:num},
			url : '/Tenement/qiuzu/sendmess',
			method:'POST',
			success : function (data) {
				$('#sendresult').text('成功发送：' +data.obj.success+',失败发送：'+data.obj.error+'。');
			}
		});
	});
	
	$('.sendmess_search').click(function () {
		$('#sendresult').text('群发短信前，请准备编辑好相关参数!'); $('.qiuzu_content').val();
		var from = $('#qiuzu_sendmess').empty();
		var start = $('#start').val(); 
		var end = $('#end').val(); var content = $('.qiuzu_content').val();
		var num = $('.qiuzu_count').val();
		if (start == '') {
			alert('请输入日期');
		}else {
			$.ajax ({
				data :{start:start,end:end,content:'',num:0},
				url : '/Tenement/qiuzu/sendmess',
				method:'POST',
				success : function (data) {
					if (data.obj.length == 0) {
						from.append('<tr><td>没有符合的数据</td></tr>');
						$('#qiuzu_count').text(data.obj.length);
					}else{
					$('#qiuzu_count').text(data.obj.length);
					$('.qiuzu_count').val(data.obj.length)
					$.each(data.obj,function(index, value) {
						var time = setTime(value.update_time);
						var body_in ='<tr><td >'+value.user_id+'</td><td>'+value.user_name+'</td>'+
						'<td>'+value.linkman+'</td><td>'+value.phone+'</td><td>'+time+'</td></tr>';
						
						from.append(body_in);
					});	
					}
				}
			}) ;
		}
		
	});
	$('.qiuzu').click(function() {
		var editaddress = $('#qiuzu');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			getprovince('qiuzu');
			//getqiuzuajax();
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	
	$('.qiuzucount').click(function () {
		var str = '<td class ="visible-lg"  >用户ID</td>'+
		'<td class ="visible-lg"  >用户昵称</td>'+
		'<td class ="visible-lg" >电话号码</td>' +
		'<td >本月发布</td>'+
		'<td>总计发布</td>'+
		'<td>详情</td>';
		var formhead = $('#qiuzu_table');
		formhead.empty();
		formhead.append(str);
		qiuzucount();
	});
	
	
})


function getqiuzuajax() {
	$.ajax({
		url : '/Tenement/area/getareabycode',
		success : function(a) {
			var obj = a.obj;
			var select = $('#qiuzu_1');
			$.each(obj, function(index, value) {
				var option = '<option   value = ' + value.code + '>'
						+ value.name + '</option>'
				select.append(option);
			})
		}
	})
}

function qiuzucount () {
	var searchcode ='';
	
	var  c1 = $('#qiuzu_1').val();
	var c2 = $('#qiuzu_2').val();
	 var c3 = $('#qiuzu_3').val();
	 var c4 = $('#qiuzu_4').val();
	 if (c1 !=null && c1!='请选择') {
		 searchcode = c1;
	 } if (c2 !=null && c2!='请选择') {
		 searchcode = c2;
	 }if (c3 !=null && c3!='请选择') {
		 searchcode = c3;
	 } if (c4 !=null && c4!='请选择') {
		 searchcode = c4;
	 }
	var form = $('#qiuzu_list');
	form.empty();
	 $.ajax ( {
		 data : {
				'code' : searchcode
			},
			type : 'POST',
			url : '/Tenement/qiuzu/total',
			success : function (data) {
				data = checkaccessexist(data);
				var buildings = data.obj;
				if (buildings.length== 0) {
					form.append('<option>暂无数据！</option>');
				}
				$.each(buildings,function(index, value) {
					var body_in ='<tr><td >'+value.user_id+'</td><td>'+value.user_name+'</td>'+
					'<td>'+value.telephone+'</td><td>'+value.bcount+'</td>'+ 
					'<td> '+value.tcount+' </td><td>'+
					'<button onclick=qiuzudetail('+value.user_id+ ') class="btn btn-large btn-primary" data-toggle="modal" > 查看 </button></td> '
					+'</tr>';
					form.append(body_in);
				});
			}
	 });
	
}

function qiuzudetail (userid) {
	var str = '<tr><td>区域</td><td>地铁</td><td>站点</td><td>户型</td><td>电话</td></tr>';
	var form = $('#qiuzu_list');
	form.empty();
	var formhead = $('#qiuzu_table');
	formhead.empty();
	formhead.append(str);
	 $.ajax ( {
		 data : {
				'userid' : userid
			},
			type : 'POST',
			url : '/Tenement/qiuzu/findQiuzuByUserid',
			success : function (data) {
				var buildings = data.obj.list;
				if (buildings.length== 0) {
					form.append('<option>暂无数据！</option>');
				}
				$.each(buildings,function(index, value) {
					var body_in ='<tr><td> '+value.district+'</td><td>'+value.metroname+'</td> '+
					'<td>'+value.finalstop+'</td><td>'+value.housetype+'</td><td>'+value.phone+'</td></tr>';
					form.append(body_in);
				});
			}
	 });
}

