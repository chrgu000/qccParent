$(function() {
	$('.searchurlname').keyup(function () {
		var currentval = $(this).val();
		var span = $('.searchspan span');
		var boolean = false;
		var inputcheckboolean = false ;
		// 先遍历所有的span 
		for (var i = 0; i < span.length; i++) {
			// 获取span的下一个input标签
			var nextinput = span[i].nextElementSibling;
			// 这里拿到当前span 的下一个input 是否选中
			inputcheckboolean = nextinput.checked;
			 //如果之前是选中的状态则黑色,如果是没有选中状态为灰色
			 if (inputcheckboolean == true) {
				 span[i].style.color = 'black'; 
			 }else {
				 span[i].style.color = 'Gray'; 
			 }
			// 如果输入框中有值
			if (currentval != '') {
				boolean = span[i].innerHTML.indexOf(currentval) != -1
				 //说明和输入框的 值类型变红
			     if (boolean == true ) { span[i].style.color = 'red';  }
			}
			
		}
	});
	
	$('.role_search_btn').click(function (){
		searchAddRole(1);
	});
	
	$('.role_model_alert').click(function () {
		//加载第一页数据
		searchAddRole(1);
		// 加载角色列表
		var select = $('#select_role').empty();
		$.ajax({
			method : 'post',
			url : '/Tenement/back/rolenotinuser',
			success : function(data) {
				select.append('<option value="">请选择</option>');
				$.each(data.obj,function(index, value) {
					var option = '<option value="'+value.roleid+'">'+value.rolename+'</option>';
					select.append(option);
				})
			}
		});
			
	});
	
	$('.user_role_save').click(function () {
		var roleid = $('#select_role').val();
		obj = document.getElementsByName("role_checkd");
		var userids = '';
		for (k in obj) {
			if (obj[k].checked)
				userids += obj[k].value + ",";
		}
		if (userids == '') {alert('选择用户');return ;}
		if (roleid == '') {alert('请选择角色');return ;}
		$.ajax({
			data : {
				roleid : roleid,
				userids : userids
			},
			method : 'post',
			url : '/Tenement/back/userRoleAdd',
			success : function(data) {
				if (data.code == 200) {
					searchmanager_in_user(1);
					$('#user_role_add').modal('hide');
				}
			}
		});
		
		
		
	});
	
	$('.mymanager_persion').click(function (){
		var userid = $('.sessionuserid').val();
		$('.setsearchuserid').val(userid);
		var roleid = $('.sessionroleid').val();
		var rolename = $('.sessionrolename').val();
		$('.follow_admin').val('no');
		var editaddress = $('#manager_to_user');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			searchmanager_in_user(1);
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	
	
	$('.manager_user_leijichongzhi').click(function () {
		common_orderbywords('manager_user_leijichongzhi' ,'累计充值','inm.inmonetary')
	});
	$('.manager_user_leijixiaofei').click(function () {
		common_orderbywords('manager_user_leijixiaofei' ,'累计消费','outm.outmonetary')
	});
	$('.manager_user_huiyuanchongzhi').click(function () {
		common_orderbywords('manager_user_huiyuanchongzhi' ,'会员充值','inm.inmonetary')
	});
	$('.manager_user_keyongyue').click(function () {
		common_orderbywords('manager_user_keyongyue' ,'可用余额','blm.balance')
	});
	$('.manager_user_fangyufabu').click(function () {
		common_orderbywords('manager_user_fangyufabu' ,'房源发布','hm.fcount')
	});
	$('.manager_user_qiuzufabu').click(function () {
		common_orderbywords('manager_user_qiuzufabu' ,'求租发布','qm.qcount')
	});
	$('.manager_user_yijianfankui').click(function () {
		common_orderbywords('manager_user_yijianfankui' ,'意见反馈','sm.scount')
	});
	
	
	$('.checkuser_to_manager').click(function() {
		var userid = $('.manager_user_id').text();
		var rolename = $('.manager_user_name').text();
		var roleid = $('.manager_user_roleid').val();
		obj = document.getElementsByName("managercheckuser");
		var userids = '';
		for (k in obj) {
			if (obj[k].checked)
				userids += obj[k].value + ",";
		}
		$.ajax({
			data : {
				userid : userid,
				userids : userids
			},
			method : 'post',
			url : '/Tenement/back/usertobemanager',
			success : function(data) {
				if (data.code == 200) {
					searchmanager_in_user(1);
					$('#add_manager_touser').modal('hide');
				}
			}
		});
	});
	$('.changge_access').click(function() {
		var roleid = $('.hidden_roleid').val();
		$('.errlr_title').text('真正同步中......');
		$('.changge_access').hide();
		obj = document.getElementsByName("isinrole");
		var role_accid = '';
		for (k in obj) {
			if (obj[k].checked)
				role_accid += obj[k].value + ",";
		}
		$.ajax({
			data : {
				roleid : roleid,
				role_accid : role_accid
			},
			method : 'post',
			url : '/Tenement/back/changge_access',
			success : function(data) {
				$('.errlr_title').text(data.msg);
				if (data.code == 200) {
					$('#role_access_show').modal('hide');
					getallrole();
				}
			}

		});

	});
	$('.firstsearch').click(function() {
		getalluser_role(1);
	});
	$('.managersearch').click(function() {
		getallmanager_user(1);
	});
	$('.role_access_update').click(function() {
		var roleid = $('.role_updateid').val();
		var rolename = $('.role_updatename').val();
		$.ajax({
			data : {
				roleid : roleid,
				rolename : rolename
			},
			method : 'post',
			url : '/Tenement/back/inserorupdaterole',
			success : function(data) {
				$('.error_role_span').text(data.msg);
				if (data.code == 200) {
					$('#role_add').modal('hide');
					getallrole();
				}
			}
		});

	});
	$('.changge_user_role').click(function() {
		var userid = $('.user_role_id').text();
		var roleid = $("input[name='userradio']:checked").val();
		var state = $('#role_state_selected').val();
		var currentpage = $('.changeuser_role_page').val();
		if (roleid === undefined) {
			$('.user_role_error').text('请先选择一个角色');
		} else {
		$.ajax({data : {userid : userid,roleid : roleid,state:state},
				url : '/Tenement/back/changgeuserrole',
				method : 'POST',
				success : function(data) {
					data = checkaccessexist(data);
					if (data.code == 200 || data.code == 900) {
						$('#user_role_target').modal('hide');
						getalluser_role(currentpage);
					}
				}
			});
		}
	});
	$('.access_to_url').click(function() {
		var editaddress = $('#access');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			getallaccess(1);
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});

	$('.manager_to_user').click(function() {
		$('.follow_admin').val('yes');
		var editaddress = $('#manager_to_user');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			$('.typeword').val('');
			getallmanager_user(1);
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});

	$('.user_to_role').click(function() {
		var editaddress = $('#user_to_role');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			getalluser_role(1);
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});

	$('.role_to_access').click(function() {
		var editaddress = $('#role');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			getallrole()
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	$('.new_role').click(function() {
		$('.role_updateid').val('');
		$('.role_updatename').val('');
		$('.error_role_span').text('*根据自己的需要创建角色');
	});
	$('.new_access').click(function() {
		$('.access_updateid').val('');
		$('.access_updateurl').val('');
		$('.access_updatename').val('');
	});
	$('.access_insert_update').click(function() {
		var accessid = $('.access_updateid').val();
		var accessurl = $('.access_updateurl').val();
		var accessname = $('.access_updatename').val();
		var currentpage = $('.build_getallaccess_page').val();
		$.ajax({
			data : {
				accessid : accessid,
				accessname : accessname,
				accessurl : accessurl
			},
			url : '/Tenement/back/inserorupdateaccess',
			method : 'POST',
			success : function(data) {
				data = checkaccessexist(data);
				if (data.code == 200 || data.code == 900) {
					$('#access_add').modal('hide');
					getallaccess(currentpage);
				}
			}

		});

	});

})

function getallaccess(cuttentpage) {
	
	$.ajax({ url : '/Tenement/back/allaccess',
		data :{currentpage:cuttentpage},
		success : function(data) {
			build_common_nav('access_url_nav_area',data);
			build_common_page('access_url_info_area' , data);
			//渲染页面数据
			build_getallaccess(data);
		}
	});
}

function build_getallaccess(data){
	var form = $('#access_all').empty();
	var obj = data.obj.acces;
	var currentpage = data.obj.pagequery.currentpage;
	$.each(obj,function(index, value) {
	var td = '<tr><td>'+ value.accessid+ '</td><td>'+ value.accessurl+ '</td><td>'
		+ value.accessname+ '</td>'+ '<td><a class="btn btn-xs "  " onclick= getoneaccess('
		+ value.accessid+ '\,\''+ value.accessname+ '\',\''+ value.accessurl
		+ '\') data-toggle="modal" data-target="#access_add">维护 </a></td></tr>'
		form.append(td);
	})
	form.append(' <input type="hidden" class="build_getallaccess_page" value='+currentpage+' /> ');
}

function getallrole() {
	var form = $('#role_all');
	form.empty();
	$
			.ajax({
				url : '/Tenement/back/roletoaccess',
				success : function(data) {
					var obj = data.obj;
					$
							.each(
									obj,
									function(index, value) {
										var td = '<tr><td><input type="hidden" value='
												+ value.role_accid
												+ ' class="role_'
												+ value.roleid
												+ '"></input>'
												+ value.roleid
												+ '</td>'
												+ '<td><input type="hidden" value='
												+ value.rolename
												+ ' class="name_'
												+ value.roleid
												+ '"></input>'
												+ value.rolename
												+ '</td>'
												+ '<td><a class="btn btn-default" onclick=searchupdata('
												+ value.roleid
												+ ') data-toggle="modal" data-target="#role_add" >改名</a></td>'
												+ '<td><a class="btn btn-default "  " onclick= update_role_access('
												+ value.roleid
												+ ') data-toggle="modal" data-target="#role_access_show">维护 </a></td></tr>'
										form.append(td);
									})
				}

			});

}
function searchupdata(roleid) {
	var rolename = $('.name_' + roleid + '').val();
	$('.role_updateid').val(roleid);
	$('.role_updatename').val(rolename);

}
function update_role_access(roleid) {
	$('.errlr_title').text('*打钩的表示已经管理的权限 ,     用【】的表示是导航条,其他的是操作链接');
	var formisin = $('#isinrole');
	$('.changge_access').show();
	formisin.empty();
	var role_accid = $('.role_' + roleid + '').val();
	var rolename = $('.name_' + roleid + '').val();
	$('.hidden_roleid').val(roleid);
	$('.role_show').text('[' + rolename + ']');
	$.ajax({
				data : {
					'role_accid' : role_accid
				},
				url : '/Tenement/back/getallrole_access',
				type : 'POST',
				success : function(data) {
					var isin = data.obj.isin;
					var isnot = data.obj.isnot;
					if (isin.length > 0) {
						$.each(isin,function(index, value) {
						if (value.type == 1) {
							var tr = '<span style="color:black;" >'+ value.accessname
							+ '</span><input style="margin-right:15px;" checked="true" type="checkbox" name=isinrole value='
							+ value.accessid + '> ';
						}
						if (value.type == 2) {
							var tr = '<span style="color:Gray;" >'+ value.accessname+ '</span><input style="margin-right:15px;" type="checkbox" name=isinrole value='
							+ value.accessid + '> ';
						}
						formisin.append(tr);
						});
					}
				}
			});
}
function getoneaccess(accessid, accessname, accessurl) {
	$('.access_updateid').val(accessid);
	$('.access_updateurl').val(accessurl);
	$('.access_updatename').val(accessname);
}

function getalluser_role(currentpage) {
	var rolename = $('.search_rolename').val();
	var telephone = $('.search_phone').val();
	$.ajax({ data : {
					telephone : telephone,
					rolename : rolename,
					currentpage :currentpage
				},
				url : '/Tenement/back/getalluser_role',
				method : 'POST',
				success : function(data) {
					//加载分页
					build_common_page('user_role_info_area' , data);
					//加载分页条
					build_common_nav('user_role_nav_area',data)
					//加载分页数据
					build_getalluser_role(data,currentpage) ;
				
				}

	});
}

function build_getalluser_role(data,currentpage) {
	var form = $('#user_allrole').empty();
	var user = data.obj.user;
	var stateString = ['' , '正常' ,'冻结'];
	$.each(user, function(index, value) {
	var td = '<tr><td>' + value.userid + '</td><td>' + value.telephone + '</td><td>' + value.user_name
			+ '</td><td>' + stateString[value.state] + '</td><td>' + value.rolename + '</td>'
			+ '<td><a id="'+value.roleid+'_'+value.userid+'_'+value.rolename+'_'+stateString[value.state]+'_user_role" class="btn btn-xs setsearchword"' +
			'data-toggle="modal" data-target="#user_role_target">维护 </a><a id="'+value.roleid+'_'+value.userid+'_'+value.rolename+'_'+stateString[value.state]+'_delete_role" class="role_delete btn btn-xs">删除</a></td></tr>'
	form.append(td);
	})
	
	$('.setsearchword').click(function () {
		$('.jbxi').addClass("active");
		$('.jbxi').siblings().removeClass('active');
		$('.checkword').val('-1');
		$('.searchwhere').val('');
		var roleid_userid_rolename = $(this).attr('id');
		var roleid = roleid_userid_rolename.split('_')[0];
		var userid = roleid_userid_rolename.split('_')[1];
		var rolename = roleid_userid_rolename.split('_')[2];
		var stateString = roleid_userid_rolename.split('_')[3];
		$('.setsearchuserid').val(userid);
		$('.setsearchroleid').val(roleid);
		$('.setsearchrolename').val(rolename);
		changeuser_role_search(currentpage ,stateString);
	});
	
	$('.role_delete').click(function () {
		var roleid_userid_rolename = $(this).attr('id');
		var roleid = roleid_userid_rolename.split('_')[0];
		var userid = roleid_userid_rolename.split('_')[1];
		var rolename = roleid_userid_rolename.split('_')[2];
		var stateString = roleid_userid_rolename.split('_')[3];
		// 封装提示的主干
		var tip = '[ '+ userid+']';
		$('.delete_tip').text(tip);
		//设置参数名称
		var param = 'userroleid';
		//执行删除的URL链接
		var deleteurl = '/Tenement/back/deleterole';
		commondelete(param,userid,deleteurl,currentpage) ;
	});
	
}


function changeuser_role_search(currentpage,stateString) {
	var select = $('#role_state_selected').empty();
	select.append('<option value="1">正常</option><option value="2">冻结</option>');
	select.find("option:contains('"+stateString+"')").attr("selected",true);
	var userid = $('.setsearchuserid').val();
	var roleid = $('.setsearchroleid').val();
	var rolename = $('.setsearchrolename').val();
	$('.user_role_error').text('*打钩的已经分配的角色');
	var form = $('#isnotuser_role');
	form.empty();
	$('.user_role_id').text(userid);
	$('.user_role_show').text('-----[' + rolename + ']');
	$ .ajax({ data : {
					roleid : roleid
				},
	url : '/Tenement/back/rolenotinuser',
	method : 'POST',
	success : function(data) {
		$.each(data.obj,function(index, value) {
		var tr1 = '';
		if (value.roleid == roleid) {
		tr1 = '<span >'+ value.rolename+ '</span><input style="margin-right:20px;" type="radio" checked=true; name=userradio value='
			+ value.roleid + '> ';
		} else {
		tr1 = '<span>'+ value.rolename+ '</span><input style="margin-right:20px;" type="radio" name=userradio value='
		+ value.roleid + '> ';}

		form.append(tr1);

		});
		form.append(' <input type="hidden" class="changeuser_role_page" value='+currentpage+' /> ');
		}
	});
}


function creat_head_getallmanager_user (rolename,telephone) {
	var headdivstr = '<div  style="width: 150px;"><input width="150px;" type="text" class="form-control search_managerphone"  '
		+ 'placeholder="输入电话号码的关键字"> </div ><div style="width: 150px;margin-top: -35px;margin-left: 180px;">'
		+ '<input width="150px;" type="text" class="form-control search_managername"  placeholder="输入角色关键字"> '
		+ '</div><div style="margin-top: -30px;margin-left: 360px;"><button class="btn btn-large btn-primary " onclick=getallmanager_user(1) >开始查询</button></div>';
	var bootstr = '<div class="col-md-3" id="user_role_info"></div><div class="col-md-9" id="user_role_nav"> </div>';
	var headdiv = $('#headdiv');
	var bootdiv = $('.boot');
	headdiv.empty().append(headdivstr);
	bootdiv.empty().append(bootstr);
	var hearstr = '<tr>' + '<td>用户主键</td>' + '<td>用户电话</td>' + '<td>用户昵称</td>'
			+ '<td>角色主键</td>' + '<td>角色昵称</td>' + '<td >查看</td></tr>';
	var fromhead = $('#manager_head');
	fromhead.empty().append(hearstr);
	$('.search_managername').val(rolename);
	$('.search_managerphone').val(telephone);
}

function getallmanager_user(currentpage) {
	var rolename = $('.search_managername').val();
	var telephone = $('.search_managerphone').val();
	if (currentpage == 1) {creat_head_getallmanager_user(rolename,telephone); }
	$ .ajax({ 
		data : { telephone : telephone, rolename : rolename,currentpage:currentpage},
		url : '/Tenement/back/getallmanager_user',
		method : 'POST',
		success : function(data) {		
		// 建立数据
		build_common_page('user_role_info' , data);		
		//建立分页条
		build_common_nav('user_role_nav',data);		
		// 加载分页数据
		build_allmanager_user(data);
		}
	});
	
}
function build_allmanager_user(data) {
	var form = $('#manager_alluser');
	var obj = data.obj.manageruser;
	form.empty();
	$.each(obj,function(index, value) {
	var td = '<tr><td >'+ value.userid+ '</td><td>'+ value.telephone+ '</td><td>'
		+ value.user_name+ '</td><td>'+ value.roleid+ '</td><td>'+ value.rolename
		+ '</td>'+ '<td><a class="btn btn-xs setsearchword" id="'+value.roleid+'_'+value.userid+'_'+value.rolename+'" >详情 </a></td></tr>'
	form.append(td);
	})
	
	$('.setsearchword').click(function () {
		$('.typeword').val('');
		$('.checkword').val('-1');
		var roleid_userid_rolename = $(this).attr('id');
		var roleid = roleid_userid_rolename.split('_')[0];
		var userid = roleid_userid_rolename.split('_')[1];
		var rolename = roleid_userid_rolename.split('_')[2];
		$('.setsearchuserid').val(userid);
		$('.setsearchroleid').val(roleid);
		$('.setsearchrolename').val(rolename);
		searchmanager_in_user(1);
	});
	

};

function searchmanager_in_user_head(currentpage) {
	var typeword = $('.checkword').val();
	if (typeword > 0) {return -1 ;}
	if (currentpage == 1) {
		var follow_admin = $('.follow_admin').val();
		var commonstr = '';
		if (follow_admin == 'yes') {
			commonstr = "<a onclick=add_manager_user(1) class='btn btn-default ' style='margin-left: 15px;' data-toggle='modal' data-target='#add_manager_touser'>添加用户 </a>"
		}
		var bootstr = '<div class="col-md-3" id="totlauser_role_info"></div><div class="col-md-9" id="totaluser_role_nav"> </div>';
		var headstr = commonstr+ "<a  style='margin-left: 15px;' class='btn btn-default conn_jbxi'>基本信息 </a>"
		+ "<a class='btn btn-default czjl' style='margin-left: 15px;' >充值记录 </a><a class='btn btn-default xfjl' style='margin-left: 15px;' >消费记录 </a>"
		+ "<a  class='btn btn-default huiyuan' style='margin-left: 15px;' >会员充值 </a>"
		+"<a  class='btn btn-default fangyuan' style='margin-left: 15px;' >房源发布 </a>"
		+"<a  class='btn btn-default qiuzu' style='margin-left: 15px;' >求租发布 </a>"
		+"<a onclick=getexcle() class='btn btn-default' style='margin-left: 15px;' >导出文件 </a>"
		+"<a onclick=delete_mananger_user("+currentpage+") class='btn btn-default delete_manager_user' style='margin-left: 15px;' >删除用户 </a>";
		var fromheadstr = "<tr><td>用户主键</td><td>用户昵称</td><td>电话号码</td>"
			+"<td><span class='order_ljcz'>累计充值↓</span></td>"
			+ "<td><span class='order_hycz'>会员充值↓</span></td>"
			+"<td><span class='order_ljxf'>累计消费↓</span></td>" 
			+"<td><span class='order_kyye'> 可用余额↓</span></td>" 
			+"<td><span class='order_fyfb'> 房源发布↓</span></td>"
			+"<td><span class='order_qzfb'>求租发布↓ </span></td>"
			+"<td><span class='order_yjfk'>意见反馈↓</span></td></tr>";
		;
		var divhead = $('#headdiv');
		divhead.empty().append(headstr);
		var fromhead = $('#manager_head');
		var bootdiv = $('.boot');
		bootdiv.empty().append(bootstr);
		fromhead.empty().append(fromheadstr);
		$('.conn_jbxi').click(function () {
			 $(this).addClass("active");
			 $(this).siblings().removeClass('active');
			 searchmanager_in_user(1);
		});
		
		$('.czjl').click(function () { 
			 $(this).addClass("active");
			 $(this).siblings().removeClass('active');
			 $('.checkword').val('-1');
			$('.typeword').val('2'); getmanagerinmonery(1); });
		$('.xfjl').click(function () {
			 $(this).addClass("active");
			 $(this).siblings().removeClass('active');
			 $('.checkword').val('-1');
			$('.typeword').val('4'); getmanageroutmonery(1) ; });
		$('.huiyuan').click(function () {
			 $(this).addClass("active");
			 $(this).siblings().removeClass('active');
			 $('.checkword').val('-1');
			$('.typeword').val('3'); getmanagervipmonery(1) });
		$('.fangyuan').click(function () {
			 $(this).addClass("active");
			 $(this).siblings().removeClass('active');
			 $('.checkword').val('-1');
			$('.typeword').val('1');gethousefabu(1) });
		$('.qiuzu').click(function () { 
			 $(this).addClass("active");
			 $(this).siblings().removeClass('active');
			 $('.checkword').val('-1');
			 $('.typeword').val('5');gethouseqizu(1) });
		
		$('.order_hycz').click(function () {
			common_orderbywords('order_hycz' ,'会员充值','vipm.vipmonetary')
		});
		$('.order_ljxf').click(function () {
			common_orderbywords('order_ljxf' ,'累计消费','outm.outmonetary')
		});
		$('.order_ljcz').click(function () {
			common_orderbywords('order_ljcz' ,'累计充值','inm.inmonetary')
		});
		$('.order_kyye').click(function () {
			common_orderbywords('order_kyye' ,'可用余额','blm.balance')
		});
		$('.order_fyfb').click(function () {
			common_orderbywords('order_fyfb' ,'房源发布','hm.fcount')
		});
		$('.order_qzfb').click(function () {
			common_orderbywords('order_qzfb' ,'求租发布','qm.qcount')
		});
		$('.order_yjfk').click(function () {
			common_orderbywords('order_yjfk' ,'意见反馈','sm.scount')
		});
		
	}
	

	
	
}


function delete_mananger_user(currentpage){
	$('.checkword').val('-1');
	var userids = ''; // 选中的userid
	obj = document.getElementsByName("managerusersearch");
	for (k in obj) {
		if (obj[k].checked)
			userids += obj[k].value + ",";
	}
	if (userids != '') {
		var userid = $('.setsearchuserid').val()=='' ? $('.sessionuserid').val() : $('.setsearchuserid').val(); // 获取管理的userid
		userids = userids.substr(0,userids.length-1)
		// 封装提示的主干
		var tip = '[ '+ userid+' 管理的  '+obj.length+' 位用户]';
		$('.delete_tip').text(tip);
		//设置参数名称
		var param = 'userid_deleteid';
		var senddate = userid + '_' + userids;
		//执行删除的URL链接
		var deleteurl = '/Tenement/back/deletemanageruser' ;
		commondelete(param,  senddate ,deleteurl , currentpage);
	}
}

function searchmanager_in_user(currentpage) {
	var userid = $('.setsearchuserid').val();
	var roleid = $('.setsearchroleid').val();
	var rolename = $('.setsearchrolename').val();
	var orderbyvalue = $('.orderbyvalue').val();
	$('.manager_user_leijichongzhi').text('累计充值↓');
	$('.out_excle_type').val('基本信息');
	$('.chongzhiusersid').val('');
	$('.manager_user_roleid').val(roleid);
	searchmanager_in_user_head (currentpage);
	$('.checkword').val(currentpage);
	$.ajax({
		data : {
			userid : userid ,
			currentpage:currentpage ,
			searchwhere : orderbyvalue 
		},
		url : '/Tenement/back/totaluser',
		method : 'POST',
		success : function(data) {
			
			// 加载分页数目
			build_common_page('totlauser_role_info',data);
			
			//加载分页条
			build_common_nav('totaluser_role_nav',data)
			
			// 加载分页数据
			build_manager_totoaluser(data);
			
		}
	});
}

function build_manager_totoaluser (data) {
	var totaluser = data.obj.totaluser;
	if (totaluser) {
		var form = $('#manager_alluser');
		form.empty();
		$.each(totaluser, function(index, value) {
			var str = '<tr><td>' + value.userid + '</td><td>'
					+ value.user_name + '</td><td>' + value.telephone
					+ '</td><td>' + value.inmonetary + '</td>' + '<td>'
					+ value.vipmonetary + '</td><td>'
					+ value.outmonetary + '</td><td>' + value.balance
					+ '</td><td>' + value.fcount + '</td><td>'
					+ value.qcount + '</td><td>' + value.scount
					+ '</td><td> <input name=managerusersearch value='
					+ value.userid + ' type="checkbox" checked="checked" /></td></tr>';
			form.append(str);
		});
	}
	
}

function getexcle () {
	var userid = $('.setsearchuserid').val();
	var roleid = $('.setsearchroleid').val();
	var rolename = $('.setsearchrolename').val();
	var sessionid = $('.sessionuserid').val();
	var housestatus = $('.housechange').val();
	$('.checkword').val('-1');
	if (housestatus === undefined) {
		housestatus = '9';
	}
	var qiuzuhousestatus = $('.qiuzuchange').val();
	if (qiuzuhousestatus === undefined) {
		qiuzuhousestatus = '9';
	}
	obj = document.getElementsByName("managerusersearch");
	var userids = $('.chongzhiusersid').val();
	if (userids == '') {
		for (k in obj) {
			if (obj[k].checked)
				userids += obj[k].value + ",";
		}
		$('.chongzhiusersid').val(userids);
	}
	var outtype = $('.out_excle_type').val();
	
	$('#sure_excle_export').modal('show');
	$('.default_exportname').val('');
	setCommonDiv();
	$('.excle_usre_click').click(function (){
		$('#sure_excle_export').modal('hide');
		var descname = $('.default_exportname').val();
		$.ajax({
			data:{'roleid' :roleid,
				'userid':userid,
				'rolename':rolename,
				'outtype':outtype,
				'userids':userids,
				'housestatus':housestatus,
				'qiuzuhousestatus':qiuzuhousestatus},
			url:'/Tenement/upload',
			method:'POST',
			success: function (data) {
				if (data.code == 200) {
					var successstr = '<h2 style="color: red;" ><a href="https://www.zzw777.com/upload/hisexcle'+data.obj+'">文件导出成功，请点击下载</a></h2>';
					var topersionstr = '<button onclick=getpersion_history() class="btn btn-large btn-primary " >进入历史导出</button>';
					var historyexcleurl = 'https://www.zzw777.com/upload/hisexcle'+data.obj+'';
					$.ajax({
						data : {userid:sessionid,historyexcleurl:historyexcleurl,descname:descname},
						url:'/Tenement/back/excleurladd',
						method:'POST',
						success: function (data){}
					});
					$('.download').empty().append(successstr);
					$('.success_topersion').empty().append(topersionstr);
					$('#exclesuccess').modal('show');
					
				}
			}
		
		});
		
		
	});
	
}



function setformhead () {
	
	var bootstr = '<div class="col-md-3" id="user_role_info"></div><div class="col-md-9" id="user_role_nav"> </div>';
	var title = $('.typeword').val();
	obj = document.getElementsByName("managerusersearch");
	var userids = $('.chongzhiusersid').val();
	if (userids == '') {
		for (k in obj) {
			if (obj[k].checked)
				userids += obj[k].value + ",";
		}
		$('.chongzhiusersid').val(userids);
	}
	var fromheadstr = '';
	if (title == 1) {
		$('.out_excle_type').val('房源发布');
		fromheadstr = "<tr><td>用户昵称</td><td>手机号码</td><td>街道名称</td><td>小区名称</td>"
			+ "<td>楼栋名称</td><td>租金(元/月)</td><td>户型</td><td>联系人</td><td>联系人电话</td><td>更新时间</td><td>" +
					"<select class=housechange onchange=gethousefabuchange()><option value=9>状态</option ><option value=0 >冻结</option><option value=1>未租</option><option value=2>已租</option><option value=3>移除</option></select></td></tr>";
		 bootstr =  '<div class="col-md-3" id="fangyuan_user_info"></div><div class="col-md-9" id="fangyuan_user_nav"> </div>';
	}
	if (title == 2) {
		$('.out_excle_type').val('充值记录');
		 fromheadstr = "<tr><td>充值单号</td><td>用户编号</td><td>用户昵称</td><td>手机号码</td><td>充值金额</td>"
				+ "<td>充值时间</td></tr>";
		 bootstr =  '<div class="col-md-3" id="chongzi_user_info"></div><div class="col-md-9" id="chongzi_user_nav"> </div>';
	}
	if (title == 3) {
		$('.out_excle_type').val('会员充值');
		 fromheadstr = "<tr><td>会员单号</td><td>用户编号</td><td>用户昵称</td><td>手机号码</td><td>会员金额</td>"
				+ "<td>消费时间</td></tr>";
		 bootstr =  '<div class="col-md-3" id="huiyuan_user_info"></div><div class="col-md-9" id="huiyuan_user_nav"> </div>';
	}
	
	if (title == 4) {
		$('.out_excle_type').val('消费记录');
		 fromheadstr = "<tr><td>消费单号</td><td>用户编号</td><td>用户昵称</td><td>手机号码</td><td>消费金额</td>"
				+ "<td>消费时间</td></tr>";
		 bootstr =  '<div class="col-md-3" id="xiaofei_user_info"></div><div class="col-md-9" id="xiaofei_user_nav"> </div>';
	}
	if (title == 5 ) {
		$('.out_excle_type').val('求租发布');
		fromheadstr = "<tr><td>用户昵称</td><td>用户电话</td><td>区域</td><td>类型</td><td>面积</td><td>价格</td>" +
				"<td>联系人</td><td>联系电话</td><td>更新时间</td><td><select class=qiuzuchange onchange=gethouseqiuzuchange()><option value=9>状态</option>" +
				"<option value=1>上架</option><option value=2>下架</option><option value=0>冻结</option></select></td></tr>";
		bootstr =  '<div class="col-md-3" id="qiuzu_user_info"></div><div class="col-md-9" id="qiuzu_user_nav"> </div>';
	}
	$('#manager_head').empty().append(fromheadstr);
	$('.boot').empty().append(bootstr);
	return userids;
}
function gethouseqiuzuchange() {
	var housestatus = $('.qiuzuchange').val();
	gethouseqizu (5);
	$('option[value="'+housestatus+'"]').attr('selected',true);
}
function gethousefabuchange () {
	var housestatus = $('.housechange').val();
	gethousefabu (1);
	$('option[value="'+housestatus+'"]').attr('selected',true);
}
function gethouseqizu(currentpage){
	var housestatus = $('.qiuzuchange').val();
	if (housestatus === undefined) {
		housestatus = '9';
	}
	var userids = setformhead ();
	
	$.ajax({
		data: {userids:userids,housestatus:housestatus ,currentpage:currentpage},
		url:'/Tenement/back/gethouseqiuzu',
		method:'POST',
		success :function (data) {
			// 创建分页条
			build_common_nav('qiuzu_user_nav',data);
			//显示分页数据
			build_common_page('qiuzu_user_info',data);
			build_gethouseqizu(data);
		}
	});
}

function build_gethouseqizu(data) {
	var form = $('#manager_alluser').empty();
	var users = data.obj.qiuzu;
	if (users) {
		$.each(users, function(index, value) {
			var time = setTime(value.update_time);
			var str = '<tr><td>'+value.user_name+'</td><td>'+value.telephone+'</td><td>'+value.trading+'</td>'+
			'<td>'+value.classification+'</td><td>'+value.areas+'</td><td>'+value.prices+'</td><td>'+value.contacts+'</td>'+
			'<td>'+value.contactstel+'</td><td>'+time+'</td><td>'+value.housestatus+'</td></tr>';
			form.append(str);
		});
	}
	
}
function gethousefabu (currentpage) {
	var housestatus = $('.housechange').val();
	if (housestatus === undefined) {
		housestatus = '9';
	}
	var userids = setformhead ();
	
	if (userids == '') {alert('选择用户');}
	$.ajax({
		data: {userids:userids,housestatus:housestatus ,currentpage:currentpage},
		url:'/Tenement/back/gethousefabu',
		method:'POST',
		success :function (data) {
			// 创建分页条
			build_common_nav('fangyuan_user_nav',data);
			//显示分页数据
			build_common_page('fangyuan_user_info',data);
			build_gethousefabu (data);
		}
	});
}

function build_gethousefabu (data){
	var form = $('#manager_alluser').empty();
	var users = data.obj.fangyuan;
	if (users) {
		$.each(users, function(index, value) {
			var time = setTime(value.update_time);
			var str = '<tr ><td >'+value.user_name+'</td><td>'+value.telephone+'</td><td>'+value.trading+'</td>'+
			'<td>'+value.villagename+'</td><td>'+value.building+'</td><td>'+value.prices+'</td>'+
			'<td>'+value.apartmentname+'</td><td>'+value.contacts+'</td><td>'+value.contactstel+'</td>'+
			'<td>'+time+'</td><td>'+value.housestatus+'</td></tr>';
			form.append(str);
		});
	}
}
function getmanagervipmonery(currentpage) {
	var userids = setformhead ();
	if (userids == '') {alert('选择用户');}
	$.ajax({
		data : {
			userids : userids ,
			currentpage:currentpage
		},
		url : '/Tenement/back/getmanageruservip',
		method : 'POST',
		success : function(data) {
			// 创建分页条
			build_common_nav('huiyuan_user_nav',data);
			//显示分页数据
			build_common_page('huiyuan_user_info',data);
			build_getmanagervipmonery (data);
		}
	});
}
function build_getmanagervipmonery (data) {
	var form = $('#manager_alluser').empty();
	var users = data.obj.huiyuan;
	if (users) {
		$.each(users, function(index, value) {
			var time = setTime(value.update_time);
			var str = '<tr><td>' + value.consume_id + '</td><td>'
					+ value.user_id + '</td><td>' + value.user_name
					+ '</td>' + '<td>' + value.telephone + '</td><td>'
					+ value.vipmonetary + '</td><td>' + time
					+ '</td></tr>';
			form.append(str);
		});
	}
}


function getmanageroutmonery(currentpage) {
	var userids = setformhead ();
	if (userids == '') {
		alert('选择用户');
	}
	
	$.ajax({
		data : {
			userids : userids ,
			currentpage:currentpage
		},
		url : '/Tenement/back/getmanageruserxiaofei',
		method : 'POST',
		success : function(data) {
			// 创建分页条
			build_common_nav('xiaofei_user_nav',data);
			//显示分页数据
			build_common_page('xiaofei_user_info',data);
			//填充数据
			build_getmanageroutmonery(data);
		}
	});
}
function build_getmanageroutmonery(data) {
	var form = $('#manager_alluser').empty();
	var users = data.obj.xiaofei
	if (users) {
		$.each(users, function(index, value) {
			var time = setTime(value.update_time);
			var str = '<tr><td>' + value.consume_id + '</td><td>'
					+ value.user_id + '</td><td>' + value.user_name
					+ '</td>' + '<td>' + value.telephone + '</td><td>'
					+ value.outmonetary + '</td><td>' + time
					+ '</td></tr>';
			form.append(str);
		});
	}
}

function getmanagerinmonery(currentpage) {
	var userids = setformhead();
	if (userids == '') {
		alert('请选择用户！');
		return;
	}
	
	$.ajax({
		data : {
			userids : userids ,
			currentpage:currentpage
		},
		url : '/Tenement/back/getmanageruserchongzhi',
		method : 'POST',
		success : function(data) {
			// 创建分页条
			build_common_nav('chongzi_user_nav',data);
			//显示分页数据
			build_common_page('chongzi_user_info',data);
			//加载数据
			build_getmanagerinmonery (data);
		}
	});
}

function build_getmanagerinmonery (data) {
	var form = $('#manager_alluser').empty();
	var users = data.obj.chongzi;
	if (users) {
		$.each(users, function(index, value) {
			var time = setTime(value.update_time);
			var str = '<tr><td>' + value.consume_id + '</td><td>'
					+ value.user_id + '</td><td>' + value.user_name
					+ '</td>' + '<td>' + value.telephone + '</td><td>'
					+ value.inmonetary + '</td><td>' + time
					+ '</td></tr>';
			form.append(str);
		});
	}
}

function add_manager_user(currentpage) {
	var userid = $('.setsearchuserid').val();
	var rolename = $('.setsearchrolename').val();
	var orderbyvalue = $('.orderbyvalue').val();
	$('.checkword').val('-1');
	//var form = $('#user_tobe_manager').empty();
	$('.manager_user_name').text(rolename);
	$('.manager_user_id').text(userid);
	$ .ajax({ data : {'userCustomer.userid':userid,orderinmonetary :orderbyvalue ,
					currentpage : currentpage
			},
		url : '/Tenement/back/alltobemanager',
		method : 'POST',
		success : function(data) {
			if(data.code == 200){
				// 显示分页数据
				buil_manager_user_list(data);
				// 创建分页条
				build_common_nav('manager_user_nav_area',data);
				//显示分页数据
				build_common_page('manager_user_info_area',data);
			}
		}
	});
}

function buil_manager_user_list (data) {
	var form = $('#user_tobe_manager').empty();
	var objuser = data.obj.users;
	$.each( objuser, function(index, value) {
	var str = '<tr><td>'+ value.userid+ '</td><td>'+ value.user_name+ '</td><td>'
				+ value.telephone+ '</td><td>'+ value.inmonetary+ '</td>'+ '<td>'
				+ value.vipmonetary+ '</td><td>'+ value.outmonetary+ '</td><td>'
				+ value.balance+ '</td><td>'+ value.fcount+ '</td><td>'+ value.qcount
				+ '</td><td>'+ value.scount+ '</td><td> <input name=managercheckuser value='
				+ value.userid+ ' type="checkbox"/></td></tr>';
	form.append(str);
	});
	
}

//查询想要添加的数据
function searchAddRole(currentpage) {
	var searchWhere = $('.role_searchWhere').val();
	$ .ajax({ 
		data : {currentpage:currentpage,searchWhere:searchWhere},
		url : '/Tenement/back/searchAddRole',
		method : 'POST',
		success : function(data) {
			if(data.code == 200){
				// 创建分页条
				build_common_nav('search_adduserrole_nav_area',data);
				//显示分页数据
				build_common_page('search_adduserrole_info_area',data);
				// 加载数据
				buil_searchAddRole_list(data);
				
				
				
			}
		}
	});
}

function buil_searchAddRole_list(data) {
	var form = $('#search_add_body').empty();
	var objuser = data.obj.userList;
	$.each( objuser, function(index, value) {
	var str = '<tr><td>'+ value.userid+ '</td><td>'+ value.user_name+ '</td><td>'
				+ value.telephone+ '</td><td>'+ value.realname+ '</td><td> <input name=role_checkd value='
				+ value.userid+ ' type="checkbox"/></td></tr>';
	form.append(str);
	});
}





function getpersion_history(){
	$('#exclesuccess').modal('hide');
	var editaddress = $('#historyexcle');
	var cssdisplay = editaddress.css('display');
	editaddress.siblings().hide();
	if (cssdisplay === 'none') {
		editaddress.show();
		
		gethistoryexclebyuserid();
	}
	if (cssdisplay === 'block') {
		editaddress.hide();
	}
	
}




