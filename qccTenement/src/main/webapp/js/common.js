/**
 * Created by liuwei on 2017/10/16.
 */
/**
 * Created by liuwei on 2017/9/6.
 */
var ZFOBJ = {};
ZFOBJ.ServerUrl = "https://www.zzw777.com/Tenement";
ZFOBJ.HostUrl = 'https://www.zzw777.com';
ZFOBJ.LocalHost = 'https://localhost:8080/Tenement';
ZFOBJ.LocalUrl = "https://localhost:8080/zfweb";
//手机登录正则
ZFOBJ.checkTel = function (str) {
	return /^1[3|4|5|6|7|8|9][0-9]\d{4,8}$/.test(str);
}



function isLogin(){
	var userid = localStorage.userId;
	if(!userid){
		if(confirm('当前操作需要登录是否去登录页面')){
			window.location.href = ZFOBJ.HostUrl + "/pages/login.html";
			return -2;
		}else{
			return -1;
		}
	}else{
		return userid;
	}
	
}

function setTime(now) {
	var date = new Date(now);
	var date_value = date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
			+ date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes();// 格式化时间yyyy-MM-dd
	return date_value;
}


function setCommonDiv() {
	var div = $('.excle_export_comm_div').empty();
	var span = '<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>' +
               '<button type="button" class="btn btn-primary excle_usre_click">确定</button>' ;
	div.append(span);
}


//根据点击的按钮判断是select是哪个
function getprovince (attr) {
	var select = '';
	//根据传过来的attr 设置哪个form
	if (attr == 'editaddress') {select=$('#areaone').empty(); }//这里是四级联动测试的
	if (attr == 'qiuzu') {select = $('#qiuzu_1').empty();}     //求租的四级联动
	if (attr == 'village') {select = $('#v_1').empty();}			//这里是小区楼栋管理的四级联动
	if (attr == 'building') {select = $('#b_1').empty();}			//这里是楼栋发布统计四级联动
	if (attr == 'metro') {select = $('#metro_1').empty();}			//这里是地铁四级联动
	if (attr == 'export') {select = $('#export_1').empty();}
	if (attr == 'bd') {select = $('#bd_1').empty();
	}
	//这里吧select传入调出省一级的地址
	getprovinceajax(select);
}
//获得省地址一级的ajax
function getprovinceajax(select) {
	select.append('<option>请选择</option>');
	
	$.ajax({
		url : '/Tenement/area/getareabycode',
		success : function(a) {
			var obj = a.obj;
			$.each(obj, function(index, value) {
				var option = '<option   value = ' + value.code + '>'
						+ value.name + '</option>'
				select.append(option);
			})
		}
	})
}
//根据省一级的地址或者上级地址获取下一级地址的ajax
function getnextaddress(attr) {
	var select = attr.id;
	var selectValue = attr.value;
	select = $('#' + select);
	select.nextAll().empty();
	$.ajax({
		data : {
			'code' : selectValue
		},
		url : '/Tenement/area/getareabycode',
		success : function(a) {
			var obj = a.obj;
			select.next().append('<option>请选择</option>');
			$.each(obj, function(index, value) {
				var option = '<option  value = '+value.code+'>'
						+ value.name + '</option>'
				select.next().append(option);
			})
		}
	});
	
}

//存储主页
ZFOBJ.Userinfo = $('#userinfo').click(function () {
	window.location.href = ZFOBJ.HostUrl + "/pages/userinfo.html";
});
//跳转登录
ZFOBJ.islog = function () {
	if (!localStorage.userId || localStorage.userId === '') {
		window.location.href = ZFOBJ.HostUrl + "/pages/login.html";
	}
};
//定义rem的基础值
(function (doc,win) {
	var docEl = doc.documentElement,
		resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
		recalc = function () {
			var clientWidth = docEl.clientWidth;
			if(!clientWidth) return;
      docEl.style.fontSize = 20 * (clientWidth / 320) + "px";
		};
	if(!doc.addEventListener) return ;
	win.addEventListener(resizeEvt,recalc,false);
	doc.addEventListener('DOMContentLoaded',recalc,false);
})(document,window);

// 时间戳转换
function formatDate (date, fmt) {
  if(/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
  }
  var o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  };
  for (var k in o) {
    if (new RegExp('(' + k + ')').test(fmt)) {
      var str = o[k] + '';
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
    }
  }
  return fmt;
}

function padLeftZero (str) {
  return ('00' + str).substr(str.length);
}
//后台传过来的日期转换
var formatDateTime = function (date) {
  var y = date.getFullYear();
  var m = date.getMonth() + 1;
  m = m < 10 ? ('0' + m) : m;
  var d = date.getDate();
  d = d < 10 ? ('0' + d) : d;
  var h = date.getHours();
  var minute = date.getMinutes();
  minute = minute < 10 ? ('0' + minute) : minute;
  var second = date.getSeconds();
  second= second < 10 ? ('0' + second) : second;
  return y + '-' + m + '-' + d+' '+h+':'+minute+':' + second;
};
//返回按钮
var webBack = function (){
        window.history.go(-1);
    };
var webback = function (){
	window.history.back();
};
   
//--------------------------------
//省市区街道4级联动下拉选择
function getAddress() {
	$.ajax({
		url : ZFOBJ.HostUrl+'/Tenement/area/getareabycode',
		success : function(a) {
			var obj = a.obj;
			var select = $('#province');
			select.append(
			'<option class="" >请选择</option>'
			)
			$.each(obj, function(index, value) {
				var option = '<option   value = '+value.code+'>'
					+ value.name + '</option>'
				select.append(option);
			})
		}
	})
}
function searchOne(attr) {
	var select = attr.id;
	var selectValue = attr.value;
	console.log(selectValue);
	$('#village').val('');
	$('#building').val('');
	select = $('#' + select);
	select.next().nextAll().empty();   //这个地方是问题
	$('#city').empty();
	$('#district').empty();
	$('#street').empty();
	$.ajax({
		data : {
			'code' : selectValue
		},
		url : ZFOBJ.HostUrl+'/Tenement/area/getareabycode',
		success : function(res) {
			console.log(res);
			var obj = res.obj;
			$('#city').append(
			'<option class="" >请选择</option>'
			)
			$.each(obj, function(index, value) {
				var option = '<option  value = '+value.code+'>'
					+ value.name + '</option>'
				$('#city').append(option);
			})
		}
	});
};
function searchTwo(attr) {
	var select = attr.id;
	var selectValue = attr.value;
	console.log(selectValue);
	$('#village').val('');
	$('#building').val('');
	select = $('#' + select);
	select.next().nextAll().empty();   //这个地方是问题
	$('#district').empty();
	$('#street').empty();
	$.ajax({
		data : {
			'code' : selectValue
		},
		url : ZFOBJ.HostUrl+'/Tenement/area/getareabycode',
		success : function(res) {
			console.log(res);
			var obj = res.obj;
			$('#district').append(
			'<option class="" >请选择</option>'
			)
			$.each(obj, function(index, value) {
				var option = '<option  value = '+value.code+'>'
					+ value.name + '</option>'
				$('#district').append(option);
			})
		}
	});
};
function searchThree(attr) {
	var select = attr.id;
	var selectValue = attr.value;
	console.log(selectValue);
	$('#village').val('');
	$('#building').val('');
	select = $('#' + select);
	select.next().nextAll().empty();   //这个地方是问题
	$('#street').empty();
	$.ajax({
		data : {
			'code' : selectValue
		},
		url : ZFOBJ.HostUrl+'/Tenement/area/getareabycode',
		success : function(res) {
			console.log(res);
			var obj = res.obj;
			$('#street').append(
			'<option class="" >请选择</option>'
			)
			$.each(obj, function(index, value) {
				var option = '<option  value = '+value.code+'>'
					+ value.name + '</option>'
				$('#street').append(option);
			})
		}
	});
};

function searchFires(attr) {
	$('#village').val('');
	$('#building').val('');

};

function build_common_page(type , data) {
	$("#"+type+"").empty();
	var pagequery = data.obj.pagequery;
	$("#"+type+"").append("当前"+pagequery.currentpage+"页,总"+
			pagequery.totalpage+"页,总"+
			pagequery.totalcount+"条");
}

function dopage(type,searchpage) {
	if ('land_nav_area' === type) {  getlandlordbystate(searchpage); }
	if ('manager_user_nav_area' === type) {  add_manager_user(searchpage); }
	if ('user_role_nav' === type ) { getallmanager_user(searchpage);}
	if ('totaluser_role_nav' === type) { searchmanager_in_user(searchpage)}
	if ('chongzi_user_nav' === type) { getmanagerinmonery(searchpage)}
	if ('xiaofei_user_nav' === type) { getmanageroutmonery(searchpage)}
	if ('huiyuan_user_nav' === type) { getmanagervipmonery(searchpage)}
	if ('fangyuan_user_nav' === type) { gethousefabu (searchpage)}
	if ('qiuzu_user_nav' === type) {  gethouseqizu(searchpage)}
	if ('search_adduserrole_nav_area' === type) {  searchAddRole(searchpage)}
	if ('page_nav_area' === type) { getalluseraccount(searchpage) }
	if ('user_role_nav_area' === type) {getalluser_role(searchpage)}
	if ('access_url_nav_area' === type) {getallaccess(searchpage)}
	if ('hisexcle_role_nav_area' === type ) { gethistoryexclebyuserid (searchpage)}
	if ('suggess_nav_area' === type) { getallsuggess(searchpage)}
	if ('metro_nav_area' === type) { getmetrolist(searchpage)}
	if ('user_searchjbmx_nav' === type || 'user_searchsymx_nav' === type || 'user_searchhbmx_nav' === type ||
			 'user_searchhymx_nav' === type || 'user_searchxfmx_nav' === type
	) { searchcommonmx(searchpage)}
}

function build_common_nav(type,data){
	$("#"+type+"").empty();
	var ul = $("<ul style='margin:0 -10px;' ></ul>").addClass("pagination");
	var pagequery = data.obj.pagequery;
	if (pagequery.totalpage == 0 ) {return ;}
	//构建元素
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
	
	// 查询的页面
	var searchpage =  1;
	
	
	//为元素添加点击翻页的事件
	firstPageLi.click(function(){
		dopage(type,searchpage) ;
	});
	prePageLi.click(function(){
		searchpage = pagequery.currentpage -1 ;
		dopage(type,searchpage) ;
	});
	
	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
	ul.append(firstPageLi).append(prePageLi);
	$.each(pagequery.cadence,function(index,item){
		
		var numLi = $("<li></li>").append($("<a></a>").append(item));
		if(pagequery.currentpage == item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			searchpage = item;
			dopage(type,searchpage) ;
		});
		ul.append(numLi);
	});
	
	
	var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
	
	
	nextPageLi.click(function(){
		searchpage = pagequery.currentpage +1;
		dopage(type,searchpage) ;
	});
	lastPageLi.click(function(){
		searchpage = pagequery.totalpage ;
		dopage(type,searchpage) ;
	});
	
	
	
	
	//添加下一页和末页 的提示
	ul.append(nextPageLi).append(lastPageLi);
	//把ul加入到nav
	var navEle = $("<nav></nav>").append(ul);
	navEle.appendTo("#"+type+"");
	
	
}

//  通用排序
function common_orderbywords(type ,value,ordername) {
	var searchvalue = $('.'+type+'').text();
	if (searchvalue === ''+value+'↓') {
		$('.orderbyvalue').val('order by '+ordername+' asc');
		$('.'+type+'').text(''+value+'↑');
	}else if (searchvalue === value){
		$('.orderbyvalue').val('order by '+ordername+' desc');
		$('.'+type+'').text(''+value+'↓');
	} else {
		$('.orderbyvalue').val('order by '+ordername+' desc');
		$('.'+type+'').text(''+value+'↓');
	}
	
	if (type.indexOf("manager")==0) {
		if ('manager_user_leijichongzhi' !=type) {
			$('.manager_user_leijichongzhi').text('累计充值');
		}
		if ('manager_user_huiyuanchongzhi' !=type) {
			$('.manager_user_huiyuanchongzhi').text('会员充值');
		}
		if ('manager_user_leijixiaofei' != type) {
			$('.manager_user_leijixiaofei').text('累计消费');
		}
		if ('manager_user_fangyufabu' != type) {
			$('.manager_user_fangyufabu').text('房源发布');
		}
		if ('manager_user_qiuzufabu' != type) {
			$('.manager_user_qiuzufabu').text('求租发布');
		}
		if ('manager_user_yijianfankui' != type) {
			$('.manager_user_yijianfankui').text('意见反馈');
		}
		if  ('manager_user_keyongyue' != type) {
			$('.manager_user_keyongyue').text('可用余额');
		}
		add_manager_user(1); 
	}
	if (type.indexOf("user")==0) {
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
		getalluseraccount(1);
	}
	
	if (type.indexOf("order")==0) {
		if ('order_ljcz' !=type) {
			$('.order_ljcz').text('累计充值');
		}
		if ('order_hycz' !=type) {
			$('.order_hycz').text('会员充值');
		}
		if ('order_ljxf' !=type) {
			$('.order_ljxf').text('累计消费');
		}
		if ('order_kyye' !=type) {
			$('.order_kyye').text('可用余额');
		}
		if ('order_fyfb' !=type) {
			$('.order_fyfb').text('房源发布');
		}
		if ('order_qzfb' !=type) {
			$('.order_qzfb').text('求租发布');
		}
		if ('order_yjfk' !=type) {
			$('.order_yjfk').text('意见反馈');
		}
		searchmanager_in_user(1);
		
	}
	
}

// 通用删除方法
function commondelete (param , deleteid ,deleteurl ,currentpage) {
	// 显示删除窗口
	$('#common_delete_alert').modal('show');
	var commondiv = $('.common_delete_div').empty();
	// 设置内部
	var commondiv_inbody = 
	'<button style="margin-right: 100px;" type="button" class="btn btn-default delete_cloded" data-dismiss="modal"><h1>取消</h1></button>'+
	'<button  type="button" class="btn btn-default delete_sure" ><h1>确认</h1></button>';
	commondiv.append(commondiv_inbody);
	var dataParams = {};
	dataParams[param] = deleteid;	
	// 这里点击了确定按钮
	$('.delete_sure').click(function () {
		$.ajax ({
			data:dataParams,
			url : deleteurl,
			method:'POST',
			success : function (data) {
				data = checkaccessexist(data);
				if (data.code == 200) {
					refurbishdate(param , currentpage);
				}
				$('#common_delete_alert').modal('hide');
			}
		});
	});
}

//这里做刷新数据
function refurbishdate(param ,currentpage){
	// 这里是刷新 系统参数百分比
	if (param === 'percentid') {
		searchpercenttype ();
	}
	//app版本的回调
	if (param === 'versionid') {
		getAllverion() ;
	}
	//地铁的回调
	if (param === 'metroid') {
		getmetrolist(currentpage);
	}
	//删除个人EXCLE 回调
	if (param === 'historyexclid') {
		gethistoryexclebyuserid (currentpage);
		
	}
	// 删除管理对应用户回调
	if (param === 'userid_deleteid') {
		searchmanager_in_user(currentpage);
	}
	//删除楼栋回调
	if (param === 'buildingid') {
		getbuildinglist (currentpage);
	}
	if (param === 'livingid') {
		searchLivingByTypeId(currentpage);
	}
	// 删除角色的回显
	if (param === 'userroleid') {
		getalluser_role(currentpage);
	}
}


//通用删除方法
function commonupdate (updateid ,state , updateurl ,currentpage ,param) {
	// 显示删除窗口
	$('#common_update_alert').modal('show');
	var commondiv = $('.common_update_div').empty();
	// 设置内部
	var commondiv_inbody = 
	'<button style="margin-right: 100px;" type="button" class="btn btn-default delete_cloded" data-dismiss="modal"><h1>取消</h1></button>'+
	'<button  type="button" class="btn btn-default update_sure" ><h1>确认</h1></button>';
	commondiv.append(commondiv_inbody);
	// 这里点击了确定按钮
	$('.update_sure').click(function () {
		$.ajax ({
			data:{updateid :updateid , state :state },
			url : updateurl,
			method:'POST',
			success : function (data) {
				data = checkaccessexist(data);
				if (data.code == 200) {
					refurbish_uddate(param , currentpage);
				}
				$('#common_update_alert').modal('hide');
			}
		});
	});
}

function refurbish_uddate (param ,currentpage) {
	if (param === 'updatelanduser') {
		getlandlordbystate(currentpage);
	}
	
}












