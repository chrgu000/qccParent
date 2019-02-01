$(function () {
	$('.livingset').click(function (){
		var editaddress = $('#livingset');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			searchLivingByTypeId(0);
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	$('.living_father_update').click(function () {
		var keyword = $('.father_keyword').val();
		var content = $('.father_content').val();
		var livingid = $('.father_livingid').val();
		$.ajax({
			data : {  keyword:keyword , content:content ,livingid:livingid},
			method : 'post',
			url : '/Tenement/living/add',
			success : function(data) {
				if (data.code == 200) {
					$('#living_father_update').modal('hide');
					$('#head_tip').text('当前位置: 首级位置 ' );
					searchLivingByTypeId(0) ;
				}
				
			}

		});
		
	});
	
	$('.living_add_or_update').click(function () {
		$('#living_select').val('');
		$('.living_keyword').val('');
		$('.living_content').val('');
		$('.living_livingid').val('');
		getAllSelect(null);
	});
	
	$('.living_add').click(function () {
		var typeid = $('#living_select').val();
		var keyword = $('.living_keyword').val();
		var content = $('.living_content').val();
		var livingid = $('.living_livingid').val();
		if (typeid < 0 ) {$('#living_error').text('选择一个分类');;return ;}
		$.ajax({
			data : { typeid : typeid , keyword:keyword , content:content ,livingid:livingid},
			method : 'post',
			url : '/Tenement/living/add',
			success : function(data) {
				if (data.code == 200) {
					$('#living_add_update').modal('hide');
					$('#head_tip').text('当前位置: ' + data.obj.content);
					searchLivingByTypeId(typeid) ;
				}
				
			}

		});
	});
});

function getAllSelect(selectId) {
	$.ajax({
		data : { typeid : 0 },
		method : 'post',
		url : '/Tenement/living/searchByTypeId',
		success : function(data) {
			var select = $('#living_select').empty();
			select.append('<option value=-1>请选择</option>');
			$.each(data.obj,function(index, value) {
				var option = '<option value='+value.livingid+'>'+value.content+'</option>';
				if (selectId == value.livingid) {
					 option = '<option selected="true" value='+value.livingid+'>'+value.content+'</option>';
				}
				select.append(option);
			})
		}

	});
}


function searchLivingByTypeId(typeid) {
	// 发送ajax请求
	$.ajax({
		data : { typeid : typeid },
		method : 'post',
		url : '/Tenement/living/searchAllByTypeId',
		success : function(data) {
			// 设置表头
			setLiving_head(data,typeid);
			// 解析回调数据
			setLiving_body(data,typeid);
		}

	});
	
}

function setLiving_body(data , typeid) {
	var from_body = $('#living_body').empty();
	var append_body='<span>暂无数据</span>';
	if (data.obj.list.length > 0 ) {
		$.each(data.obj.list,function(index, value) {
			//var state = value.state == 1 ? '正常':'停用';
			var stateTip = ['停用' , '正常'];
			var textTip  = ['恢复' , '下架'];
			//var textTip = value.state == 1 ? '下架':'恢复';
			if (typeid == 0) {
				append_body = '<tr><td>'+value.livingid+'</td><td>'+value.keyword+'</td><td>'+value.content+'</td>'
				+'<td><button class="btn btn-primary" onclick=searchLivingByTypeId('+
				value.livingid+')>详情</button ><button onclick="searchFather('+value.livingid+')" data-toggle="modal" data-target="#living_father_update" style="margin-left: 15px" class="btn btn-primary">编辑</button></td></tr>';
			} else {
				append_body = '<tr><td>'+value.livingid+'</td><td>'+value.keyword+'</td><td>'+value.orderasc+'</td><td>'+stateTip[value.state]+'</td>'
				+'<td><button onclick="livingSearchOne('+value.livingid+')" style="margin-left: 15px" class="btn btn-primary"  data-toggle="modal" data-target="#living_add_update">编辑</button>'+
				'<button onclick = livingUp('+ value.livingid+'\,\''+value.typeid+'\') style="margin-left:15px" class="btn btn-primary">上移</button><button style="margin-left: 15px" class="btn btn-primary"'
				+'onclick=livingChange('+ value.livingid+'\,\''+value.state+'\')>'+textTip[value.state]+'</button>'+
				'<button style="margin-left: 15px" class="btn btn-primary" onclick=deleteLiving('+ value.livingid+'\,\''+value.typeid+'\')>删除</button ></td></tr>';
			}
			from_body.append(append_body);
		})
	}else {
		from_body.append(append_body);
	}
}

function searchFather(livingid ) {
	$.ajax({
		data : { livingid : livingid },
		method : 'post',
		url : '/Tenement/living/searchOne',
		success : function (data) {
			if (data.code == 200) {
				// $('#living_select').val(data.obj.content);
				$('.father_keyword').val(data.obj.keyword);
				$('.father_content').val(data.obj.content);
				$('.father_livingid').val(data.obj.livingid);
			}
		}
		
	});
	
}

function deleteLiving (livingid ,typeid) {
	//如果没有分页参数自定义一个
	var currentpage = typeid;
	var tip = '';
	$('.delete_tip').text(tip);
	//设置参数名称
	var param = 'livingid';
	//执行删除的URL链接
	var deleteurl = '/Tenement/living/delete';
	commondelete(param,livingid,deleteurl,currentpage) ;
}

function livingSearchOne (livingid) {
	$.ajax({
		data : { livingid : livingid },
		method : 'post',
		url : '/Tenement/living/searchOne',
		success : function (data) {
			if (data.code == 200) {
				// $('#living_select').val(data.obj.content);
				$('.living_keyword').val(data.obj.keyword);
				$('.living_content').val(data.obj.content);
				$('.living_livingid').val(data.obj.livingid);
				getAllSelect(data.obj.typeid);
				
			}
		}
		
	});
}

function livingChange (livingid ,state) {
	state = state == 1 ? 0 : 1 ;
	$.ajax({
		data : { livingid : livingid , state : state},
		method : 'post',
		url : '/Tenement/living/livingChange',
		success : function (data) {
			if (data.code == 200) {
				searchLivingByTypeId(data.obj) ;
			}
		}
		
	});
}


function livingUp(livingid , typeid) {
	$.ajax({
		data : { typeid : typeid , livingid : livingid},
		method : 'post',
		url : '/Tenement/living/up',
		success : function (data) {
			if (data.code == 200) {
				searchLivingByTypeId(typeid) ;
			}
		}
		
	});
	
}


function setLiving_head(data ,typeid) {
	// 获取表头
	var form_head =$('#living_head').empty();
	content = '当前位置 : ' +data.obj.father.content;
	var head_tip = $('#head_tip').text(content);
	var append_head = '';
	if (typeid == 0 ) {
		append_head = '<tr><td>主键</td><td>关键字</td><td>描述</td><td>操作</td></tr>';
	} else {
		append_head = '<tr><td>主键</td><td>关键字</td><td>排序</td><td>状态</td><td>操作</td></tr>';
	}
	form_head.append(append_head);
	
}