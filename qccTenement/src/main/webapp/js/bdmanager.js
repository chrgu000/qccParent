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
		var c4 = '';
		var level = 0 ;
		  obj = document.getElementsByName("bdCheckBox");
			for (k in obj) {
				if (obj[k].checked)
					c4 += obj[k].value + ",";
			}
		 var current = $('.currentSelect').val();
		
		 if (c1 !=null && c1!='请选择') {
			 searchcode = c1;
			 level = 1;
		 } if (c2 !=null && c2!='请选择') {
			 searchcode = c2;
			 level = 2;
		 }if (c3 !=null && c3!='请选择') {
			 searchcode = c3;
			 level = 3;
		 } if (c4 !='' && c4!='请选择') {
			 searchcode = c4;
			 level = 4;
		 }if (current !=null && current!='') {
			 searchcode = current;
		 }
		
		var bdid= $('.bd_id').val();
		var telephone= $('.bd_telephone').val();
		var userid= $('.bd_userid').val();
		var realname = $('.bd_realname').val();
		$.ajax({
			data : {bdid:bdid ,telephone:telephone , realname:realname ,code:searchcode, level:level,
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

function getlevel2() {
	
	alert(1);
}

function searchOneBd (bdid) {
	$.ajax({
		data : {bdid:bdid},
		method : 'post',
		url : '/Tenement/bd/searchOne',
		success : function(data) {
			var bdmanager = data.obj.bdmanager;
			var level1 = data.obj.level1;
			var level4 = data.obj.level4;
			var level2 = data.obj.level2;
			var level3 = data.obj.level3;
			var bd1= $('#bd_1').empty().append('<option>请选择</option>');
			var bd2= $('#bd_2').empty().append('<option >请选择</option>');
			var bd3= $('#bd_3').empty().append('<option>请选择</option>');
			var bd4= $('#bd_4').empty();
			$('.bd_telephone').val(bdmanager.telephone);
			$('.bd_realname').val(bdmanager.realname);
			$('.bd_id').val(bdmanager.bdid);
			$('.bd_userid').val(bdmanager.userid);
			
			$.each(level1, function(index, value) {
				var selected=''
				if (value.level == -1) {
					selected= 'selected';
				}	
				var option = '<option  value = '+value.code+'  '+selected+'   >'  
					+ value.name + '</option>'
					bd1.append(option);
			})
			
			
			$.each(level2, function(index, value) {
				var selected=''
				if (value.level == -1) {
					selected= 'selected';
				}	
				var option = '<option  value = '+value.code+'  '+selected+'   >'  
					+ value.name + '</option>'
					bd2.append(option);
			})
			
			$.each(level3, function(index, value) {
				var selected=''
				if (value.level == -1) {
					selected= 'selected';
				}	
				var option = '<option  value = '+value.code+'  '+selected+'   >'  
					+ value.name + '</option>'
					bd3.append(option);
			})
			
			$.each(level4, function(index, value) {
				var option = '<input style="width: 10px;margin-left: 10px;" name="bdCheckBox"' + 
				'type="checkbox" value = '+value.code+'   >'
					+ value.name + '</>'
				if (value.level == -1) {
					 option = '<input style="width: 10px;margin-left: 10px;" name="bdCheckBox"' + 
					'type="checkbox" value = '+value.code+'  checked=true >'
						+ value.name + '</>'
				}
				
				bd4.append(option);
			})
			
			// 加载下一级地址
			getLastAddress(bdmanager);
			
			
			
		}
	});
}


function getLastAddress(bdmanager) {
	
	// 调出第四级
	if (bdmanager.level == 3 ) {
		$.ajax({
			data : {
				'code' : bdmanager.code
			},
			url : '/Tenement/area/getareabycode',
			success : function(a) {
				var obj = a.obj;
				if (bdmanager.level == 3) {
					var select = $('#bd_4').empty();;
					$.each(obj, function(index, value) {
						var option = '<input style="width: 10px;margin-left: 10px;" name="bdCheckBox"' + 
							'type="checkbox" value = '+value.code+'>'
								+ value.name + '</>'
						select.next().append(option);
					})
				}
			}
		});
	}
	
	// 调出第第三级
	if (bdmanager.level == 2) {
		$.ajax({
			data : {
				'code' : bdmanager.code
			},
			url : '/Tenement/area/getareabycode',
			success : function(a) {
				var obj = a.obj;
				var select = $('#bd_3').empty().append('<option>请选择</option>');;
				$.each(obj, function(index, value) {
					var option = '<option  value = '+value.code+'     >'  
						+ value.name + '</option>'
						select.append(option);
				})
			}
		});
	}
	
	
	// 调出第第二级
	if (bdmanager.level == 1) {
		$.ajax({
			data : {
				'code' : bdmanager.code
			},
			url : '/Tenement/area/getareabycode',
			success : function(a) {
				var obj = a.obj;
				var select = $('#bd_2').empty().append('<option>请选择</option>');;
				$.each(obj, function(index, value) {
					var option = '<option  value = '+value.code+'     >'  
						+ value.name + '</option>'
						select.append(option);
				})
			}
		});
	}
	
	// 调出第第二级
	if (bdmanager.level == 0) {
		$.ajax({
			data : {
				'code' : 0
			},
			url : '/Tenement/area/getareabycode',
			success : function(a) {
				var obj = a.obj;
				var select = $('#bd_1').empty().append('<option>请选择</option>');;
				$.each(obj, function(index, value) {
					var option = '<option  value = '+value.code+'     >'  
						+ value.name + '</option>'
						select.append(option);
				})
			}
		});
	}
	
	
	
}