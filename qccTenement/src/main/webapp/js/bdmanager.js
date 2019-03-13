$(function () {
	
	$('.bd_search_btn').click(function (){
		searchAddBd(1);
	});
	$('.bd_put_add').click(function () {
		obj = document.getElementsByName("bd_search_checkd");
		var userids = '';
		for (k in obj) {
			if (obj[k].checked)
				userids += obj[k].value ;
		}
		var userid = userids.split('_')[0];
		var telephone = userids.split('_')[1];
		var realname = userids.split('_')[2];
		$('.bd_userid').val(userid);
		$('.bd_telephone').val(telephone);
		$('.bd_realname').val(realname);
		$('#bd_add_search').modal('hide');
		$('#bd_add_update').modal('show');
		getprovince('bd');
	});
	
	$('.bdmanager').click(function () {
		var editaddress = $('#bdmanager');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			listbd ();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	
	$('.bd_model_alert').click(function () {
		 $('.bd_telephone').val('');
		 $('.bd_realname').val('');
		 $('.bd_id').val('');
		 //getprovince('bd');
		 $('.bd_searchWhere').val('');
			//加载第一页数据
			searchAddBd(1);
			// 加载角色列表
			var select = $('#select_role').empty();
			$.ajax({
				method : 'post',
				url : '/Tenement/bd/searchAddBd',
				success : function(data) {
					select.append('<option value="">请选择</option>');
					$.each(data.obj,function(index, value) {
						var option = '<option value="'+value.roleid+'">'+value.rolename+'</option>';
						select.append(option);
					})
				}
			});
		
	});
	
	
	
	$('.bd_save').click(function () {
		var searchcode ='';
		var  c1 = $('#bd_1').val();
		var c2 = $('#bd_2').val();
		 var c3 = $('#bd_3').val();
		 var c4 = $('#bd_4').val();
		 var current = $('.currentSelect').val();
		
		 if (c1 !=null && c1!='请选择') {
			 searchcode = c1;
		 } if (c2 !=null && c2!='请选择') {
			 searchcode = c2;
		 }if (c3 !=null && c3!='请选择') {
			 searchcode = c3;
		 } if (c4 !=null && c4!='请选择') {
			 searchcode = c4;
		 }if (current !=null && current!='') {
			 searchcode = current;
		 }
		
		var bdid= $('.bd_id').val();
		var telephone= $('.bd_telephone').val();
		var userid= $('.bd_userid').val();
		var realname = $('.bd_realname').val();
		$.ajax({
			data : {bdid:bdid ,telephone:telephone , realname:realname ,code:searchcode,
				userid:userid},
			method : 'post',
			url : '/Tenement/bd/save',
			success : function(data) {
				alert(data.msg);
				$('#bd_add_update').modal('hide');
				listbd ();
			}
		});
	});
});
var bdState = ['禁用' , '正常'];
var showState = ['恢复' , '冻结'];

var isEditState = ['只读' , '编辑'];
var showEditState = ['可编辑' ,'仅可读'];
function listbd () {
	var form = $('#bd_body');
	$.ajax({
		method : 'post',
		url : '/Tenement/bd/list',
		success : function(data) {
			form.empty();
			$.each(data.obj,function(index, value) {
				var body_in ='<tr><td >'+value.bdid+'</td><td>'+value.telephone+'</td>'+
				'<td>'+value.realname+'</td><td>'+value.address+'</td><td>'+bdState[value.state]+'</td><td>'+isEditState[value.isedit]+'</td>'+
				'<td><a onclick=searchOneBd(\''+value.bdid+'\') class="btn   btn-primary" data-toggle="modal" data-target="#bd_add_update">编辑 </a>'
				+'<a style="margin-left: 15px"; onclick=changestate(\''+value.bdid+'\') class="btn   btn-primary" >'+showState[value.state]+'</a>' +
				'<a style="margin-left: 15px"; onclick=changeEditstate(\''+value.bdid+'\') class="btn   btn-primary" >'+showEditState[value.isedit]+'</a></td></tr>';
				form.append(body_in);
			});	
		}
	});
}

function changestate(bdid) {
	$.ajax({
		data : {bdid:bdid},
		method : 'post',
		url : '/Tenement/bd/changeState',
		success : function(data) {
			listbd ();
		}
	});
}

function changeEditstate(bdid) {
	$.ajax({
		data : {bdid:bdid},
		method : 'post',
		url : '/Tenement/bd/changeEditstate',
		success : function(data) {
			listbd ();
		}
	});
}


function searchAddBd(currentpage) {
	var searchWhere = $('.bd_searchWhere').val();
	$ .ajax({ 
		data : {currentpage:currentpage,searchWhere:searchWhere},
		url : '/Tenement/bd/searchAddBd',
		method : 'POST',
		success : function(data) {
			if(data.code == 200){
				// 创建分页条
				build_common_nav('search_addbd_nav_area',data);
				//显示分页数据
				build_common_page('search_addbd_info_area',data);
				// 加载数据
				buil_searchAddBD_list(data);
			}
		}
	});
}

function buil_searchAddBD_list(data) {
	var form = $('#search_addBD_body').empty();
	var objuser = data.obj.userList;
	$.each( objuser, function(index, value) {
	var str = '<tr><td>'+ value.userid+ '</td><td>'+ value.user_name+ '</td><td>'
				+ value.telephone+ '</td><td>'+ value.realname+ '</td><td> <input name=bd_search_checkd value='
				+ value.userid +'_' + value.telephone +'_' + value.realname + ' type="radio"/></td></tr>';
	form.append(str);
	});
}

function searchOneBd (bdid) {
	getprovince('bd');
	
	$.ajax({
		data : {bdid:bdid},
		method : 'post',
		url : '/Tenement/bd/searchOne',
		success : function(data) {
			 $('.bd_telephone').val(data.obj.telephone);
			 $('.bd_realname').val(data.obj.realname);
			 $('.bd_id').val(data.obj.bdid);
			 $('.bd_userid').val(data.obj.userid);
			 $('#bd_select div').empty();
			 $('#bd_select').append('<div><span>当前选中：'+data.obj.address+'</span>' +
					 '<input class="currentSelect" type="hidden"   value="'+data.obj.code+'"/></div>');
		}
	});
}