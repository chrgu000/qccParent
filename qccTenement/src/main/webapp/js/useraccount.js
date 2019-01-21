$(function () {
	$('.setsearchcommonval').click(function () {
		var common = $(this).children().eq(0).text();
		 $(this).addClass("active");
		 $(this).siblings().removeClass('active');
		$('.commonmx').val(common);
		searchcommonmx(1);
		
	});
	
	
	$(document).on("click",".account_checkeset",function(){
		//判断当前选择中的元素是否5个
		var flag = $(".account_checkeset:checked").length==$(".account_checkeset").length;
		$(".set_useraccout_check").prop("checked",flag);
	});
	
	$('.set_useraccout_check').click(function () {
		
		var boolean = $('.set_useraccout_check').is(":checked");
		$(".account_checkeset").prop("checked",boolean);
		
	});
	$('.expert_all_user_excle').click(function () {
		var ordervalue = $('.orderbyvalue').val();
		var searchwhere = $('.searchwhere').val();
		var number = $('expert_all_user_number').val();
		var sessionid = $('.sessionuserid').val();
		var descname = $('.expert_all_descname').val();
		$.ajax({
			data: {pagesize:number,
					  enorder:ordervalue,
					  searchwhere :searchwhere},
			url:'/Tenement/back/getalluserburseexcle',
			method:'POST',
			success:function (data) {
				if (data.code == 200) {
					
					$('#export_alluser_bure').modal('hide');
					var successstr = '<h2 style="color: red;" ><a href="'+data.obj+'">文件导出成功，请点击下载</a></h2>';
					var topersionstr = '<button onclick=getpersion_history() class="btn btn-large btn-primary " >进入历史导出</button>';
					var historyexcleurl = data.obj;
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
	
	
	
	$('.useraccount').click(function () {
		
		
		var editaddress = $('#searchuseraccount');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			$('.orderbyvalue').val('');
			getalluseraccount(1);
			editaddress.show();
			$('.user_shouyi').text('收益↓');
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	$('.user_shouyi').click(function () {
		common_orderbywords('user_shouyi' ,'收益','account');
	});
	
	$('.user_cishu').click(function () {
		common_orderbywords('user_cishu' ,'求租次数','count');
	});
	
	$('.user_jinbi').click(function () {
		common_orderbywords('user_jinbi' ,'金币','inteconn.count');
	});
	
	$('.user_qicaibi').click(function () {
		common_orderbywords('user_qicaibi' ,'七彩币','balance');
	});
	$('.user_hongbi').click(function () {
		common_orderbywords('user_hongbi' ,'红币','masonryconn.count');
	});
	
	
	
	
});

function orderbyword(type ,value,ordername) {
	
	var searchvalue = $('.'+type+'').text();
	if (searchvalue === ''+value+'↓') {
		$('.orderbyvalue').val('order by '+ordername+' asc');
		$('.'+type+'').text(''+value+'↑');
		getalluseraccount(1);
		
	}else if (searchvalue === value){
		$('.orderbyvalue').val('order by '+ordername+' desc');
		$('.'+type+'').text(''+value+'↓');
		getalluseraccount(1);
	} else {
		$('.orderbyvalue').val('order by '+ordername+' desc');
		$('.'+type+'').text(''+value+'↓');
		getalluseraccount(1);
	}
	if ('user_hongbi' !=type) {
		$('.user_hongbi').text('红币');
	}
	if ('user_jinbi' != type) {
		$('.user_jinbi').text('金币');
	}
	if ('user_qicaibi' != type) {
		$('.user_qicaibi').text('七彩币');
	}
	if ('user_cishu' !=type) {
		$('.user_cishu').text('求租次数');
	}
	if ('user_shouyi' != type) {
		$('.user_shouyi').text('收益');
	}
}

function build_head(type){
	var headdiv = $('#useraccount_head').empty();
	var tablehead = $('.useraccount_tablehead').empty();
	var headstr = '';
	var tableheadstr = ''
	var searchwhere = '';
	
	if (type == 0 ) {
		searchwhere = $('.setsearchwhere').val();
		headstr = '<input style="width: 200px;margin-top: 0px;" type="text" value="'+searchwhere+'" class="form-control searchwhere "  placeholder="昵称/电话/真实姓名" /> '+
		'<button style="margin-left: 230px;margin-top: -20px;" type="button" class="btn btn-primary make_sure_search">确定</button>'+
		'<button data-toggle="modal" data-target="#export_alluser_bure"  class="btn btn-default export_alluser_bure" style="margin-left: 250px;margin-top: -22px;">导出文件 </button>';
		
	}
	
	
	headdiv.append(headstr);
	
	$('.make_sure_search').click(function () {getalluseraccount(1);});
	
};

function getalluseraccount(currentpage) {
	var ordervalue = $('.orderbyvalue').val();
	var searchwhere = $('.searchwhere').val();
	var number = $('expert_all_user_number').val();
	$.ajax({
		data: {currentpage:currentpage,
			pagesize:number,
			enorder:ordervalue,
			searchwhere :searchwhere},
		url:'/Tenement/back/getalluserburse',
		method:'POST',
		success:function (data) {
			data = checkaccessexist(data);
			if (data.code == 200) {
				 // 解析显示数据
				build_user_list(data);
				
				//显示分页信息
				build_common_page('page_info_area' , data);
				
				//3、解析显示分页条数据
				build_common_nav('page_nav_area' , data);
				
			}
		}
	});
}

//这里解析显示的数据
function build_user_list(data) {
	
	var from = $("#all_user_account").empty();
	var userlist = data.obj.userlist;
	$.each(userlist,function(index,item){
		var checkBoxTd = $("<td><input value='"+item.user_id+"' checked='checked' type='checkbox' class='account_checkeset' name='check_item'/></td>");
		var userid = $("<td></td>").append(item.user_id);
		var account = $("<td></td>").append(item.account);
		var balance = $("<td></td>").append(item.balance);
		var telephone = $("<td></td>").append(item.telephone);
		var username = $("<td></td>").append(item.username);
		var count = $("<td></td>").append(item.count);
		var mascount = $("<td></td>").append(item.mascount);
		var intecount = $("<td></td>").append(item.intecount);
		var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
		.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
		$("<tr></tr>")
		.append(telephone)
		.append(username)
		.append(account)
		.append(mascount)
		.append(intecount).append(balance)
		.append(count).append(checkBoxTd)
		.appendTo(from);
	});
	from.append('<tr>  <td colspan=8  ><button  data-toggle="modal" data-target="#detail_all_account"  style="float:right;"   class="btn btn-default"  onclick=useraccount_detail()>更多详情</button></td></tr>');
	
}
function useraccount_detail () {
	obj = document.getElementsByName("check_item");
	var userids = '';
	for (k in obj) { if (obj[k].checked) userids += obj[k].value + ","; }
	$('.setsearchuserid').val(userids);
	$('.commonmx').next().addClass('active');
	$('.commonmx').next().siblings().removeClass('active');
	searchcommonmx(1);
}

function build_usermxsomething(type) {
	var pagequerydiv = $('#usermx').empty();
	var querystring = '<div class="col-md-3" id="user_'+type+'_info"></div>' +
					  '<div class="col-md-9" id="user_'+type+'_nav"> </div>';
	pagequerydiv.append(querystring);
}

function searchcommonmx(currentpage) {
	var commonmx = $('.commonmx').val();
	if (currentpage == 1) {build_usermxsomething(commonmx);}
	var userids = $('.setsearchuserid').val();
	$.ajax( {
		data : {currentpage:currentpage,userids:userids},
		url:'/Tenement/back/'+commonmx+'',
		success : function (data) {
			//显示分页的数据信息
			build_common_page('user_'+commonmx+'_info' , data);
			//显示分页条
			build_common_nav('user_'+commonmx+'_nav',data);
			//查询金币明细渲染数据
			build_searchcommonmx(data) ;
		}
		
	});
}
function build_searchcommonmx(data) {
	var form = $('#user_jbmx').empty();
	var commonmx = data.obj.commonmx;
	$.each(commonmx,function(index,item){
		var state =item.type == 2 ? '支出':'收入';
		var time = setTime(item.update_time);
		var appendstr = '<tr><td>'+item.userid+'</td><td>'+item.username+'</td><td>'+item.telephone+'</td>'+
		'<td>'+item.count+'</td><td>'+state+'</td><td>'+item.event+'</td><td>'+time+'</td></tr>';
		form.append(appendstr);
	});
	
}

