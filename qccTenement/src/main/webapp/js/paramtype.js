$(function () {
	$('.paramtype').click(function() {
		var editaddress = $('#paramtype');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			searchparamtype(0 ,'首级');
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
		
	});
	$('.article_add').click(function () {
		$('.error_span').text('');
		$('.add_thertypename').val('');
	});
	
	$('.edit_addone').click(function () {
		var codeid = $('.edit_typeid').val();
		var typename = $('.edit_typename').val();
		var prename = $('.param_type_prename').val();
		var fatherid = $('.param_type_codeid').val();
		$.ajax ({
			data : {codeid : codeid,typename:typename},
			type : 'POST',
			url : '/Tenement/release/editarticle',
			success : function (data) {
				$('.error_span').text(data.msg);
				if (data.code ==200) {
					$('#edit_article').modal('hide');
					searchparamtype(fatherid , prename);
				}
			}
		});
		
	});
	$('.add_othertype').click(function () {
		$('.error_span').text('');
		var typename = $('.add_thertypename').val();
		var codeid = $('.param_type_codeid').val();
		var fatherid = $('.param_type_codeid').val();
		var prename = $('.param_type_prename').val();
		$.ajax({
			data :{typename:typename,fatherid:codeid},
			type : 'POST',
			url : '/Tenement/release/addtypename',
			success : function (data) {
				data = checkaccessexist(data);
				$('.error_span').text(data.msg);
				if (data.code == 200) {
					$('#add_other').modal('hide');
					searchparamtype(fatherid , prename);
				}
			}
		});
	});
	
	
	$('.articlt_codename').focus(function () {
		$('.articlt_codename').val('');
	});
	$('.article_addone').click(function () {
		var typeid = $('.articlt_typeid').val();
		var codename = $('.articlt_codename').val();
		var typename = $('.articlt_typename').val();
		$.ajax ({
			data : {typeid : typeid,codename:codename,typename:typename},
			type : 'POST',
			url : '/Tenement/release/addarticle',
			success : function (data) {
				$('.articlt_codename').val(data.msg);
			}
		});
		
	});
	
	$('.edit_onecodename').click(function () {
		var typeid = $('.code_typeid').val();
		var codeid = $('.code_codeid').val();
		var codename = $('.code_codename').val();
		var typename = $('.code_typename').val();
		$.ajax ({
			data : {codeid : codeid,codename:codename,typename:typename},
			type : 'POST',
			url : '/Tenement/release/editcodenamebycodeid',
			success : function (data) {
				$('.code_codename').val(data.msg);
				if (data.code ==200) {
					$('#edit_codename').modal('hide');
					getcodename(typeid,typename)
				}
			}
		});
		
	});
	
})

function setsearchparamtypeHead (fatherid) {
	var thead = $('#article_table_thead');thead.empty();
	var appendData = '';
	if (fatherid == 0) {
		appendData = '<tr><td>参数主键</td><td>参数名称</td><td>查看</td><td>编辑</td></tr>';
	}else {
		appendData=  '<tr><td>参数主键</td><td>参数名称</td><td>编辑</td></tr>';
	}
	thead.append(appendData);
	
}

function searchparamtype(fatherid , typename){
	setsearchparamtypeHead(fatherid);
	
	var form = $('#article_tbody');
	form.empty();
	
	$('.param_type_codeid').val(fatherid);
	$('.param_type_prename').val(typename);
	
	$.ajax ({
		data : {fatherid :fatherid} ,
		type : 'POST',
		url : '/Tenement/release/searchparamtype',
		success : function (data) {
			data = checkaccessexist(data);
			var obj = data.obj;
			$.each(obj,function(index, value) {
				var td = '<tr><td>'+value.codeid+'</td><td>'+value.typename+'</td>';
				if (fatherid == 0) {
					td =td + '<td><a class="btn btn-default"  " onclick= searchparamtype('+
						value.codeid+'\,\''+value.typename+'\')>查看 </a></td>';
				}
				td = td + '<td><a class="btn btn-default" onclick= geteditarticle('+
				value.codeid+'\,\''+value.typename+'\') data-toggle="modal" data-target="#edit_article">编辑 </a></td></tr>';
				form.append(td);
			})
		}
	});
}
function geteditarticle (typeid,typename) {
	$('.edit_typeid').val(typeid);
	$('.edit_typename').val(typename);
	$('.error_span').text('');
}
function getarticlenext (typeid,typename) {
	$('.articlt_typeid').val(typeid);
	$('.articlt_typename').val(typename);
}
function getcodenamebyid(codeid,typeid,typename,codename){
	$('.code_codeid').val(codeid);
	$('.code_typeid').val(typeid);
	$('.code_typename').val(typename);
	$('.code_codename').val(codename);
}

