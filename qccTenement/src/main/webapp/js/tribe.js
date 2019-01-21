$(function() {
	$('.update_articletype').click(function() {
		var onetypeid = $('.typedetail_articleid').val();
		var typename = $('.typedetail_typename').val();
		var prename = $('.tribet_prename').val();
		obj = document.getElementsByName("paramlist");
		var codeids = '';
		for (k in obj) {
			if (obj[k].checked)
				codeids += obj[k].value + ",";
		}
		$.ajax({
			data : {
				onetypeid : onetypeid,
				typename : typename ,
				codeids : codeids
			},
			method : 'post',
			url : '/Tenement/tribe/editarticletype',
			success : function(data) {
				$('.error_span').text(data.msg);
				if (data.code == 200) {
					$('#tribe_detail_model').modal('hide');
					searchArticleTypeThing(data.obj , prename);
				}
			}

		});

	});
	
	$('.inser_alert_thing').click(function () {
		$('.tribet_typename').val('');
		$('.error_span_persion').text('');
	});
	
	$('.add_tribe_show').click(function () {
		$('.tribe_error').text('');
		$('.tribep_edit_typename').val('');
	});
	
	$('.update_tribe_persion').click(function () {
		var onetypeid = $('.tribep_onetypeid').val();
		var typename = $('.tribep_typename').val();
		var prename = $('.tribep_edit_prename').val();
		$.ajax({
			data : {
				onetypeid : onetypeid,
				typename : typename ,
				codeids : ''
			},
			method : 'post',
			url : '/Tenement/tribe/editarticletype',
			success : function(data) {
				$('.tribe_error').text(data.msg);
				if (data.code == 200) {
					$('#tribe_detail_persion').modal('hide');
					searchArticleTypePersion(data.obj , prename);
				}
			}

		});
		
	});
	
	$('.typedetail_in').click(function () {
		var articletypeid =	$('.typedetail_articleid').val();
		var typename = $('.typedetail_typename').val();
		var valuesubmit = $('.typedetail_submitval').val();
		$.ajax ({
			data : {
				'articletypeid' : articletypeid,
				'detailname':valuesubmit
			},
			type : 'POST',
			url : '/Tenement/tribe/addtypedetail',
			success : function (data) {
				$('.typedetail_submitval').val(data.msg);
			}
		});
	});
	
	$('.tribeaddress_in').click(function () {
		valsubmit = $('.tribeaddress_typename').val();
		valuebiaoqian = $('.tribeaddress_biaoqian').val();
		$.ajax({
			
			data : {
				'typename' : valsubmit,
				'initial':valuebiaoqian
			},
			type : 'POST',
			url : '/Tenement/tribe/createtribetype/1',
			success : function(data) {
				$('.tribe_error').text(data.msg);
				if (data.code == 200) {
					$('#tribe_c_model').modal('hide');
					tribeaddress ();
				}
			}
		});
		
	}) ;
	
	$('.add_tribe_show').click(function () {
		$('.tribe_error').text('');
		$('.tribep_typename').val('');
		$('.tribelove_typename').val('');
		$('.tribep_biaoqian').val('');
		$('.tribeaddress_typename').val('');
		$('.tribeaddress_biaoqian').val('');
		
	});
	
	$('.tribelove_in').click(function () {
		valsubmit = $('.tribelove_typename').val();
		valuebiaoqian = $('.tribep_biaoqian').val();
		$.ajax({
			
			data : {
				'typename' : valsubmit,
				'initial':valuebiaoqian
			},
			type : 'POST',
			url : '/Tenement/tribe/createtribetype/2',
			success : function(data) {
				$('.tribe_error').text(data.msg);
				if (data.code == 200) {
					$('#tribe_l_model').modal('hide');
				}
			}
		});
		
	});
	$('.add').click(function () {
		var article_typeid = $('.article_typeid').val();
		var typedetailid = $('.hidden_typedetailid').val();
		 obj = document.getElementsByName("isin");
		 var   check_val = '';
		    for(k in obj){
		        if(obj[k].checked)
		            check_val+=obj[k].value +",";
		    }
		   
		    $.ajax({
		    	data:{
		    		typeid : check_val,
		    		typedetailid : typedetailid
		    	},
				type : 'POST',
				url : '/Tenement/tribe/updatetyepdetail',
				success : function (data) {
					data = checkaccessexist(data);
					if (data.code ==200) {
						$('#change_guige').modal('hide');
						getdetailtype (article_typeid);
					}
				}
		    });
	});
	$('.searchallguige').click(function () {
		
	} );
	
})

// 部落添加分类
function addArticleType() {
	var valsubmit = $('.tribet_typename').val();
	var onetypeid = $('.tribet_onetypeid').val();
	var prename = $('.tribet_prename').val();
	$.ajax({
		data : {
			'typename' : valsubmit
		},
		type : 'POST',
		url : '/Tenement/tribe/intriebp/'+onetypeid,
		success : function(data) {
			data = checkaccessexist (data);
			$('.error_span_persion').text(data.msg);
			if (data.code == 200 || data.code==900) {
				$('#tribe_t_model').modal('hide');
				searchArticleTypeThing(onetypeid ,prename);
			}
		}
})	
}

//  添加找人分类
function addArticleTypePersion() {
	var valsubmit = $('.tribep_edit_typename').val();
	var onetypeid = $('.tribep_edit_onetypeid').val();
	var prename = $('.tribep_edit_prename').val();
	$.ajax({
		data : {
			'typename' : valsubmit
		},
		type : 'POST',
		url : '/Tenement/tribe/intriebp/'+onetypeid,
		success : function(data) {
			data = checkaccessexist (data);
			$('.tribe_error').text(data.msg);
			if (data.code == 200 || data.code==900) {
				$('#tribe_p_model').modal('hide');
				searchArticleTypePersion(onetypeid,prename);
			}
		}
})	
}
function editTribep(id,name) {
	var code = '.tribe_p' + id;
	valuesumbit = $(code).text();
	if (confirm('你确定要把  [  ' + name + '  ]  改成 [  '  + valuesumbit + '  ]  ?')) {
		$.ajax({
			data : {
				'onetypeid' : id,
				'typename' : valuesumbit
			},
			type : 'POST',
			url : '/Tenement/tribe/edittriebp',
			success : function(data) {
				data = checkaccessexist (data);
				if (data.code == 200) {
					gettribep();
				}
			}
		});
		
	}
}


function editTribet(id,name) {
	var code = '.tribe_t' + id;
	valuesumbit = $(code).text();
	if (confirm('你确定要把  [  ' + name + '  ]  改成 [  '  + valuesumbit + '  ]  ?')) {
		$.ajax({
			data : {
				'onetypeid' : id,
				'typename' : valuesumbit
			},
			type : 'POST',
			url : '/Tenement/tribe/edittriebp',
			success : function(data) {
				data = checkaccessexist (data);
				if (data.code == 200) {
					gettribet();
				}
			}
		});
		
	}
}



// 这里是物品相关
function searchArticleTypeThing(onetypeid ,typename) {
	setsearchArticleTypeThingHead(onetypeid);
	$('.tribet_onetypeid').val(onetypeid);
	$('.tribet_prename').val(typename);
	$.ajax({
		url : '/Tenement/tribe/getTribedetailtype/'+onetypeid,
		type : 'POST',
		success : function(a) {
			a = checkaccessexist(a);
			var obj = a.obj;
			var form = $("#tribe_t").empty();
				$.each(obj,function(index, value) {
			    var td = '<tr><td>'+value.onetypeid+'</td>' +
					'<td >'+value.typename+'</td><td>'+value.paramTypeNames+'</td>'
		        if (onetypeid == 6 ) {
		        	td = td + '<td><a onclick=searchArticleTypeThing('+
					value.onetypeid+'\,\''+value.typename+'\') href="javascript:void(0);" class="btn btn-default" >查看</a></td>';
		        }
			    td =td +'<td><button data-toggle="modal" onclick=articleEditSearch('+value.onetypeid+')  data-target="#tribe_detail_model">编辑 </button></td></tr>' ;
				form.append(td);
				})
		}
	})
}


// 这里是找人相关
function searchArticleTypePersion(onetypeid , typename) {
	setsearchArticleTypePersionHead(onetypeid);
	// 设置新增的参数
	$('.tribep_edit_onetypeid').val(onetypeid);
	$('.tribep_edit_prename').val(typename);
	$.ajax({
		url : '/Tenement/tribe/getTribedetailtype/'+onetypeid,
		type : 'POST',
		success : function(a) {
			a = checkaccessexist(a);
			var obj = a.obj;
			var form = $("#tribe_p").empty();
				$.each(obj,function(index, value) {
				$('.tribep_prename').val(value.typename);
			    var td = '<tr><td>'+value.onetypeid+'</td>' +
					'<td >'+value.typename+'</td>'
			    if (onetypeid == 7 ) {
			    	td = td + '<td><a onclick=searchArticleTypePersion('+
					value.onetypeid+'\,\''+value.typename+'\') href="javascript:void(0);" class="btn btn-default" >查看</a></td>';
			    }
			    td = td + '<td><button data-toggle="modal" onclick=articleEditSearchPersion('+
				value.onetypeid+'\,\''+value.typename+'\') data-target="#tribe_detail_persion">编辑 </button></td></tr>';
			    form.append(td);
				})
		}
	})
}


function articleEditSearchPersion (onetypeid , typename) {
	$('.tribep_onetypeid').val(onetypeid);
	$('.tribep_typename').val(typename);
	$('.tribe_error').text('');
}

// 编辑的查询
function articleEditSearch(onetypeid) {
	$('.error_span').text('');
	$.ajax({
		data:{onetypeid:onetypeid},
		url : '/Tenement/tribe/articleEditSearch',
		type : 'POST',
		success : function(data) {
			var articletype = data.obj.articletype;
			$('.typedetail_articleid').val(articletype.onetypeid);
			$('.typedetail_typename').val(articletype.typename);
			var paramList = data.obj.paramList;
			var form =$('.paramListThing').empty();
				$.each(paramList,function(index, value) {
					if (value.type == 1) {
						var tr = '<span style="color:black;" >'+ value.typename
						+ '</span><input style="margin-right:15px;" checked="true" type="checkbox" name=paramlist value='
						+ value.codeid + '> ';
					}
					if (value.type == 2) {
						var tr = '<span style="color:Gray;" >'+ value.typename+ '</span><input style="margin-right:15px;" type="checkbox" name=paramlist value='
						+ value.codeid + '> ';
					}
					form.append(tr);
				})
		}
	})
}

function setsearchArticleTypePersionHead (onetypeid) {
	
	var form = $('.tribe_persion_head').empty();
	var setData = '';
	if (onetypeid == 7) {
		setData = '<tr> <td >ID</td> <td >名称</td><td >查看</td><td >编辑</td></tr>';
	} else {
		setData = '<tr><td>ID</td><td>名称</td><td >编辑</td></tr>';
	}
	form.append(setData);
	
}


// 设置发布物品的表头
function setsearchArticleTypeThingHead(onetypeid ) {
	var form = $('#tribe_thing_head').empty();
	var setData = '';
	if (onetypeid == 6) {
		setData = '<tr> <td >ID</td> <td >名称</td><td>规格参数</td><td >查看</td><td >编辑</td>';
	} else {
		setData = '<tr><td>ID</td><td>名称</td><td>规格参数</td></tr>';
	}
	form.append(setData);
}





function editdetailtype (typedetailid,detailname) {
	var code = '.tribe_detail' + typedetailid;
	valuesumbit = $(code).text();
	if (confirm('你确定要把  [  ' + detailname + '  ]  改成 [  '  + valuesumbit + '  ]  ?')) { 
		$.ajax ({
			data : {
				'typedetailid' : typedetailid ,
				'detailname' : valuesumbit
			},
			url : '/Tenement/tribe/updatetypedetail',
			type : 'POST',
			success : function (data) {
				data = checkaccessexist(data);
			}
		});
	}
}


function getlovetribe() {
	var formt = $("#love_tribe");
	formt.empty();
	$.ajax({
		url : '/Tenement/tribe/avocation',
		type : 'POST',
		success : function(a) {
			var obj = a.obj.avocation;
			var form = $("#love_tribe");
				$.each(obj,function(index, value) {
			var td = '<tr><td>'+value.tribetypeid+'</td>' +'<td>'+value.initial+'</td>'+
					'<td class=tribe_love'+value.tribetypeid+' contentEditable="true"><span>'+value.typename+'</span>'+
					'</td><td><a class="btn btn-default"  href="javascript:void(0);" onclick= editlovetribe('+
					value.tribetypeid+'\,\''+value.typename+'\')>编辑 </a></td></tr>'
		form.append(td);
				})
		}
	})
	
}

function editlovetribe (tribetypeid , typename) {
	var code = '.tribe_love' + tribetypeid;
	valuesubmit =$(code).text();
	if (confirm('你确定要把  [  ' + typename + '  ]  改成 [  '  + valuesubmit + '  ]  ?')) {
		$.ajax({
			data : {
				'tribetypeid' : tribetypeid,
				'typename' : valuesubmit
			},
			type : 'POST',
			url : '/Tenement/tribe/edittype',
			success : function(data) {
				alert(data.msg);
				if (data.code == 200) {
					getlovetribe();
				}
			}
		});
	}
}

function tribeaddress () {
	var formt = $("#tribe_address");
	formt.empty();
	$.ajax({
		url : '/Tenement/tribe/city',
		type : 'POST',
		success : function(a) {
			var obj = a.obj;
			var form = $("#tribe_address");
				$.each(obj,function(index, value) {
			var td = '<tr><td>'+value.tribetypeid+'</td>' +'<td>'+value.initial+'</td>'+
					'<td class=tribe_love'+value.tribetypeid+' contentEditable="true"><span>'+value.typename+'</span>'+
					'</td><td><a class="btn btn-default"  href="javascript:void(0);" onclick= editlovetribe('+
					value.tribetypeid+'\,\''+value.typename+'\')>编辑 </a></td>  </tr>'
					form.append(td);
				})
		}
	})
	
}