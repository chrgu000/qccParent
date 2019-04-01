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
	
	$('.delete_land').click(function () {
		var descname =	$('.land_landname').val();
		if (descname == '') {
			descname ='房东';
		}
		var userid = $('.land_userid').val();
		// 封装提示的主干
		var tip = '[ '+ userid +'=='+ descname+']';
		$('.delete_tip').text(tip);
		//如果没有分页参数自定义一个
		var currentpage = $('.land_currentpage').val();
		//设置参数名称
		var param = 'landuserid';
		//执行删除的URL链接
		var deleteurl = '/Tenement/back/deletelandlord';
		commondelete(param,userid,deleteurl,currentpage) ;
	});
	
	
	$('#update_landlord').click(function () {
		var address = $('.land_address').val();
		var brandname = $('.land_brandname').val();
		var corporate = $('.land_corporate').val();
		var businessnum = $('.land_businessnum').val();
		var linkman = $('.land_linkman').val();
		var linkphone = $('.land_linkphone').val();
		var landstate = $('#land_landstate').val();
		var userid = $('.land_userid').val();
		var currentpage = $('.land_currentpage').val();
		$.ajax({
			data : {address :address ,brandname:brandname , 
				corporate:corporate ,  businessnum:businessnum ,landuserid:userid ,
				linkman:linkman ,linkphone:linkphone ,landstate:landstate},
			url : '/Tenement/back/updateland',
			method:'POST',
			success : function(data) {
				data = checkaccessexist(data);
				if (data.code == 200) {
					$('#show_idpicture').modal('hide');
					getlandlordbystate(currentpage);
				} else {
					data.msg;
				}
			}
		})
	});
});

// 获取所有房东信息
function getlandlordbystate(currentpage) {
	$('#show_idpicture').modal('hide');
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
var stateword = ['禁用' , '申请'  ,'通过' , '不通过'];
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
			var time = setTime(value.update_time);
			var body = '<tr><td>'+value.userid+'</td><td>'+value.realname+'</td>'
			+'<td>'+time+'</td><td>'+value.bdid+'</td> <td>'+value.bdname+'</td><td>'+stateword[state]+'</td><td><button onclick=show_idpicture('+value.userid+') class="btn btn-large btn-primary serach_id_pitures" > 浏览 </button></td><td>'+setword+'</td></tr>';
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
				$('.land_userid').val(data.obj.userid);
				$('.land_identity').val(data.obj.identity);
				$('.land_address').val(data.obj.address);
				$('.land_brandname').val(data.obj.brandname);
				$('.land_corporate').val(data.obj.corporate);
				$('.land_businessnum').val(data.obj.businessnum);
				$('.land_linkman').val(data.obj.linkman);
				$('.land_linkphone').val(data.obj.linkphone);
				$('.land_landname').val(data.obj.realname);
				$('.land_landphone').val(data.obj.telephone);
				
				var selectState = $('#land_landstate').empty();
				$.each( stateword ,function (index ,value) {
					var option = '<option value='+index+' > '+value+' </option>'
					selectState.append(option);
					if (index == data.obj.landstate) {
						selectState.find("option:contains('"+value+"')").attr("selected",true);	
					}
				}) ;
			}
		}
	});
}