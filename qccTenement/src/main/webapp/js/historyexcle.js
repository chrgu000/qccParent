$(function (){
	$('.historyexcle').click(function() {
		$('#exclesuccess').modal('hide');
		var editaddress = $('#historyexcle');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			gethistoryexclebyuserid(1);
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	$('.excle_update_descname').click(function (){
		var historyexclid =$('.excle_id').val();
		var currentpage = $('.history_currentpage').val();
		var descname =$('.excle_descname').val();
		$.ajax({
			data: {historyexclid:historyexclid,descname:descname},
			url:'/Tenement/back/updatexclebyid',
			method:'POST',
			success:function (data) {
				if (data.code == 200) {
					$('#editexcledescname').modal('hide');
					 gethistoryexclebyuserid (currentpage);
				}
			}
		});
		
	});
	
});

function gethistoryexclebyuserid (currentpage) {
	var userid = $('.sessionuserid').val();
	$.ajax({
		data: {userid:userid,
			currentpage:currentpage,
			pagesize:7},
		url:'/Tenement/back/getexclebyuserid',
		method:'POST',
		success:function (data) {
			//加载分页条信息
			build_common_nav('hisexcle_role_nav_area',data);
			//显示记录数目和总记录
			build_common_page('hisexcle_role_info_area' , data) ;
			//渲染历史导出数据
			build_gethistoryexclebyuserid (data);
		}
	});
}
function build_gethistoryexclebyuserid (data) {
	var form = $('#exclebody').empty();
	var str = '无历史记录';
	var currentpage = data.obj.pagequery.currentpage;
	if (data.obj.historyexcles) {
		$.each(data.obj.historyexcles,function(index, value) {
			var time = setTime(value.update_time);
			 str = '<tr><td>'+value.historyexclid+'</td><td>'+value.descname+'</td><td>'+time+'</td>'+
			 '<td><a class="btn btn-large btn-primary new_access" href='+value.historyexcleurl+' >导出</a></td>'+
			 '<td><button onclick=updatedescname('+ value.historyexclid+ '\,\''+ value.descname+ '\') class="btn btn-large btn-primary " data-toggle="modal" data-target="#editexcledescname">编辑</button></td>'
			+ '<td><button onclick=deletebyid('+ value.historyexclid+ '\,\''+ value.descname+ '\') class="btn btn-large btn-primary " >删除</button></td></tr>';
			 form.append(str);
		})
		form.append('<input type="hidden" class="history_currentpage" value='+currentpage+' />');
	}
	
}




// 删除EXCLE
function deletebyid(historyexclid,descname) {
	// 封装提示的主干
	var tip = '[ '+ descname+']';
	$('.delete_tip').text(tip);
	//如果没有分页参数自定义一个
	var currentpage = $('.history_currentpage').val();
	//设置参数名称
	var param = 'historyexclid';
	//执行删除的URL链接
	var deleteurl = '/Tenement/back/deletexclebyid';
	commondelete(param,historyexclid,deleteurl,currentpage) ;
}
function updatedescname(historyexclid,descname) {
	$('.excle_id').val(historyexclid);
	$('.excle_descname').val(descname);
}