$(function () {
	$('.landlord_examine').click(function () {
		var editaddress = $('#landlord_examine');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			getlandlordbystate(1);
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
});

// 获取所有房东信息
function getlandlordbystate(currentpage) {
	var landstate = $('#select_land').val();
	$.ajax({
		data : {landstate :landstate ,pagesize:7 , currentpage:currentpage },
		url : '/Tenement/landloadsearch',
		success : function(data) {
			data = checkaccessexist(data);
			if (data.code == 200) {
				//加载分页条信息
				build_common_nav('land_nav_area',data);
				//显示记录数目和总记录
				build_common_page('land_info_area' , data) ;
				//加载数据列表
				build_landlord_list(data);
			}
		}
	})
}
// 加载查询到的房东数据
function build_landlord_list(data) {
	var item  = data.obj.landlist;
	var form = $('#landlord_examine_tbody').empty();
	if (item.length == 0 ) {
		form.append('<tr><td>暂无数据!</td></tr>');
	} else {
		$.each(item,function(index, value) {
			var state = value.landstate;
			var typeword = '';
			var setword = '';
			if (state == 1 || state == 3) {
				typeword = state == 1 ? '申请房东': '不通过'       // '\,\''
				setword = state == 1 ? '<button style="margin-right:10px;width:70px;" onclick=examineland('+value.userid+ '\,\''+2+'\') class="btn btn-large btn-primary" data-toggle="modal" > 通过 </button>' +
				          '<button style="width:70px;" onclick=examineland('+value.userid+ '\,\''+3+'\') class="btn btn-large btn-primary" data-toggle="modal" > 不通过 </button>' : '';
			}
			if (state == 2 || state==4) {
				typeword = state == 2 ? '房东':'子账号';
				//setword = state == 2 ?   '<button style="width:70px;" onclick=examineland('+value.userid+ '\,\''+5+'\') class="btn btn-large btn-primary" data-toggle="modal" > 移出 </button>' :'';
			}
			var time = setTime(value.update_time);
			var body = '<tr><td>'+value.userid+'</td><td>'+value.realname+'</td>'
			+'<td>'+time+'</td><td>'+typeword+'</td> <td><button onclick=show_idpicture('+value.userid+') class="btn btn-large btn-primary serach_id_pitures" > 浏览 </button></td><td>'+setword+'</td></tr>';
			form.append(body);
		});	
		var currentpage =  data.obj.pagequery.currentpage ;
		form.append('<input class="land_currentpage" type="hidden" value='+currentpage+'>');
	}
}
//审核房东是否通过
function examineland (userid ,state) {
	var descname = '';
	if (state == 2) {descname = userid + ' -- ' + '审核为房东'}
	if (state == 3) {descname = userid + ' -- ' + '审核不通过'}
	// 封装提示的主干
	var tip = '[ '+ descname+']';
	$('.update_tip').text(tip);
	//如果没有分页参数自定义一个
	var currentpage = $('.land_currentpage').val();
	var param = 'updatelanduser' ;
	//执行删除的URL链接
	var updateurl = '/Tenement/checklandstate';
	commonupdate(userid,state , updateurl,currentpage ,param) ;
	/*//alert(userid);alert(type);
	$.ajax({
		data :  {userid :userid ,state :state} ,
		url : '/Tenement/checklandstate' ,
		success : function (data){
			data = checkaccessexist(data);
			if (data.code == 200) {
				// 提示用户
				alert(data.msg);
				// 刷新数据
				getlandlordbystate();
			}
		}
	});*/
}
// 获取更多信息
function show_idpicture(userid){
	$('#show_idpicture').modal('show');
	$.ajax({
		data : {userid : userid} , 
		url : '/Tenement/landloadsearchdetail' , 
		success : function (data) {
			if (data.code == 200) {
				$('.landlord_identity').text(data.obj.identity);
				$('.landlord_address').text(data.obj.address);
				var picture = data.obj.idpictures;
				var divpic = $('.landlord_idpictures').empty();
				if (picture != '') {
					var str = picture.split(",");
					$.each(str,function (index,value) {
						var image = '<img style="height: 250px; width:500px; " alt="" src="'+value+'">';
						divpic.append(image);
					})
				}else {
					divpic.append('<span>暂无</span>');
				}
			}
		}
	});
}