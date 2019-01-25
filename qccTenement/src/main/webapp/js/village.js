$(function () {
	

	$('.village_v4').change(function () {
		tradingtovillage();
	});
	$('.bildingcount').click(function () {
		buildingcount();
	});
	$('.villagecount').click(function () {
		villagecount();
	});
	
	/*$('.building_building').focus(function () {
		$('.building_building').val('');
	});*/
	
	$('.testhtml').click(function () {
		$.ajax({
			url : '/Tenement/testhtml' ,
		    success : function (data) {
		    	alert(data.obj);
		    	$('#append').append(data.obj);
		    }
		});
		
	});
	
	$('.test').click(function () {
		var houseids = [1,2,3];
		var mails=[];
		for (var i=0;i<houseids.length;i++) {
			var hydcoal = {}
			hydcoal.warter = 1;
			hydcoal.houseid = houseids[i];
			mails.push(hydcoal);
		}
		
		$.ajax ({
		    data:  JSON.stringify(mails) ,
			type : 'POST',
			 dataType:"json",      
	         contentType:"application/json",   
			url : 'http://localhost:8081/managerclient/companion/createhydprices/1000525',
			headers:{'Accept': 'aplication/json','Authorization':'this is o token '},
			success : function (data) {
				alert(data.msg);
				if (data.code == 200) {
				}
			}
		});
	});
	
	
	$('.building_excle_upload').click(function () {
		var searchcode ='';
		var  c1 = $('#b_1').val();
		var c2 = $('#b_2').val();
		 var c3 = $('#b_3').val();
		 var c4 = $('#b_4').val();
		 if (c1 !=null && c1!='请选择') {
			 searchcode = c1;
		 } if (c2 !=null && c2!='请选择') {
			 searchcode = c2;
		 }if (c3 !=null && c3!='请选择') {
			 searchcode = c3;
		 } if (c4 !=null && c4!='请选择') {
			 searchcode = c4;
		 }
		var sessionid = $('.sessionuserid').val();
		
		$('#sure_excle_export').modal('show');
		// 确定导出EXCLE
		$('.default_exportname').val('');
		setCommonDiv() ;
		$('.excle_usre_click').click(function () {
			var descname = $('.default_exportname').val();
			$('#sure_excle_export').modal('hide');
			$.ajax ({
				data : {
					'code':searchcode,
				},
				type : 'POST',
				url : '/Tenement/back/exportexclebuildnguser',
				success : function (data) {
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
			});
			
		});
		
		/**
		
		**/
	});
	
	$('.metro_updatevillage').click(function () {
		var metroid = $('#metro_detail').val();
		var villageid = $('.metro_villageid').val();
		$.ajax ({
			data : {
				'metroid':metroid,
				'villageid':villageid
			},
			type : 'POST',
			url : '/Tenement/building/updateallmetro',
			success : function (data) {
				alert(data.msg);
				if (data.code == 200) {
					$('#metro_village').modal('hide');
				}
			}
		});
	});
	
	
	
	$('.metro_villagafinal').on('input propertychange',function () {
		var select = $('#numUnit');
		select.empty();
		var finalstop = $('.metro_villagafinal').val();
		var code = $('.metro_villagecode').val();
		var villageid = $('.metro_villageid').val();
		$.ajax ({
			data : {
				'code':code,
				'finalstop':finalstop
			},
			type : 'POST',
			url : '/Tenement/metro/searchbycodeandfinalstop',
			success : function (data) {
				var metrolist = data.obj;
				$.each(metrolist , function (index,value) {
					var option = '<option  value='+value.metroid+'>'+value.name+value.finalstop+'</option>';
					select.append(option);
				});
			}
		});
	});
	$('.building_update').click( function () {
		var brandid = $('.brandselect').val();
		var detailes = $('.building_detailes').val();
		var building = $('.building_building').val();
		var brand = $('.building_brand').val();
		var linkphone =$('.building_linkphone').val();
		var linkman =$('.building_linkman').val();
		var landphone =$('.building_landphone').val();
		var bnumber =$('.building_bnumber').val();
		var metroid = $('#metro_detail_2').val();
		var land =$('.building_land').val();
		var buildingid = $('.building_buildingid').val();
		var villageid = $('.building_villageid').val();
		var buildingcode = $('.building_num').val();
		$.ajax ( { 
			data : {
				'brandid':brandid,
				'building':building,
				'linkphone':linkphone,
				'landphone':landphone,
				'bnumber':bnumber,
				'metroid':metroid,
				'land':land,
				'buildingid':buildingid,
				'villageid':villageid,
				'detailes':detailes
				 
			},
			type : 'POST',
			url : '/Tenement/village/updatebuilding',
			success : function (data) {
				//var data = JSON.parse(res);
				//alert(data.code);
				data = checkaccessexist(data) ;
				 if (data.code ==200 ||data.code == 900) {
					 $('#building_edit').modal('hide');
					 getbuildinglist (villageid);
				 }
			}
		});
		
	});
	$('.st').click(function () {
		alert(11);
	})
	$('.building_brand').keyup(function () {
		var select = $('.brandselect');
		select.empty();
		select.append('<option value="" >请选择</option>');
		select.append('<option value="" >无品牌</option>');
		var valuename = $('.building_brand').val();
		var code = $('.building_code').val();
		$.ajax({
			data : {
				'likename' : valuename ,
				'code' : code
			},
			type : 'POST',
			url : '/Tenement/getlikebrand',
			success : function (data) {
				// 如果有数据在遍历集合
				if (data.obj) {
					$.each(data.obj ,function (index,value) {
						var option = '<option value = '+value.brandid+'>'+value.brand+'</option>';
						select.append(option);
					})
				} 
				
			}
		});
	});
	
	$('.village_update').click(function () {
		var code = $('.village_code').val();
		var villageid = $('.village_villageid').val();
		var keyword = $('.village_keyword').val();
		var villagename= $('.village_typename').val();
		var housecount= $('.village_housecount').val();
		var	comyear = $('.village_comyear').val();
		var carfree = $('.village_carfree').val();
		var company = $('.village_company').val();
		var comfree = $('.village_comfree').val();
		var comphone = $('.village_comphone').val();
		var carcount=$('.village_carcount').val();
		var comcount=$('.village_comcount').val();
		var devephone=$('.village_devephone').val();
		var	developer= $('.village_developer').val();
		var villagephone = $('.village_villagephone').val();
		$.ajax ({
			data : {
				'keyword':keyword,
				'company':company,
				'code':code,
				'villageid':villageid,
				'villagename':villagename,
				'housecount':housecount,
				'comyear':comyear,
				'carfree':carfree,
				'comfree':comfree,
				'comphone':comphone,
				'carcount':carcount,
				'comcount':comcount,
				'devephone':devephone,
				'developer':developer,
				'villagephone':villagephone
			},
			type : 'POST',
			url : '/Tenement/village/updatebyid',
			success : function (data) {
				checkaccessexist(data.code) ;
				$('.village_typename').val(data.msg)
				if (data.code == 200 || data.code==900) {
					$('#village_edit').modal('hide');
					tradingtovillage();
				}
			}
			
		});
		
	});
	
})

function metro_byname() {
	var code = $('#metro_byname').val();
	var name =$("#metro_byname option:selected").text(); 
	var select = $('#metro_detail');
	select.empty();
	$.ajax({
		data : {
			'code' : code,
			'name' : name
		},
		type : 'POST',
		url : '/Tenement/metro/metrodetail',
		success : function (data) {
			$.each(data.obj ,function (index,value) {
				var option = '<option value = '+value.metroid+'>'+value.finalstop+'</option>';
				select.append(option);
			})
		}
	});
}

function setchangebrand(){
	var brand =$(".brandselect option:selected").text(); 
	if ('请选择' === brand) {
		brand = '无品牌';
	}
	var brandid = $('.brandselect').val();
	$('.building_brandid').val(brandid);
	$('.building_brand').val(brand);
	
}

function metro_byname_2() {
	var code = $('#metro_byname_2').val();
	var name =$("#metro_byname_2 option:selected").text(); 
	var finalstop = $('.show_finalstop').val();
	var select = $('#metro_detail_2');
	select.empty();
	$.ajax({
		data : {
			'code' : code,
			'name' : name
		},
		type : 'POST',
		url : '/Tenement/metro/metrodetail',
		success : function (data) {
			$.each(data.obj ,function (index,value) {
				var option = '<option value = '+value.metroid+'>'+value.finalstop+'</option>';
				select.append(option);
				if (value.finalstop == finalstop) {
					 select.find("option:contains('"+finalstop+"')").attr("selected",true);
				}
			})
			
		}
	});
}

function getvillagedetail(villageid)  {
	$.ajax({
		data : {
			'villageid' : villageid
		},
		type : 'POST',
		url : '/Tenement/village/simplevillagedetail',
		success : function (data) {
			$('.village_keyword').val(data.obj.keyword);
			$('.village_code').val(data.obj.code);
			$('.village_villageid').val(data.obj.villageid);
			$('.village_typename').val(data.obj.villagename);
			$('.village_housecount').val(data.obj.housecount);
			$('.village_comyear').val(data.obj.comyear);
			$('.village_carfree').val(data.obj.carfree);
			$('.village_comfree').val(data.obj.comfree);
			$('.village_company').val(data.obj.company);
			$('.village_comphone').val(data.obj.comphone);
			$('.village_carcount').val(data.obj.carcount);
			$('.village_comcount').val(data.obj.comcount);
			$('.village_devephone').val(data.obj.devephone);
			$('.village_developer').val(data.obj.developer);
			$('.village_villagephone').val(data.obj.villagephone);
		}
	});
}

function buildingcount () {
	var headform = $('.cellhead').empty();
	var append = '<tr><td >用户ID</td><td  >用户昵称</td><td  >电话号码</td><td >本月</td><td >有联</td>'+
		'<td>无联</td><td >有房</td><td>无房</td><td>总计</td><td >有联</td><td>无联</td><td >有房</td>'+
		'<td>无房</td></tr>';
	headform.append(append);
	var searchcode ='';
	var  c1 = $('#b_1').val();
	var c2 = $('#b_2').val();
	 var c3 = $('#b_3').val();
	 var c4 = $('#b_4').val();
	 if (c1 !=null && c1!='请选择') {
		 searchcode = c1;
	 } if (c2 !=null && c2!='请选择') {
		 searchcode = c2;
	 }if (c3 !=null && c3!='请选择') {
		 searchcode = c3;
	 } if (c4 !=null && c4!='请选择') {
		 searchcode = c4;
	 }
	 var form = $('#building_list');
		form.empty();
	 $.ajax ( {
		 data : {
				'code' : searchcode
			},
			type : 'POST',
			url : '/Tenement/village/censusbuilding',
			success : function (data) {
				var buildings = data.obj.buildings;
				if (buildings.length== 0) {
					form.append('<option>暂无数据！</option>');
				}
				$.each(buildings,function(index, value) {
					var nowlinknout = value.bcount - value.nowlinkcount;
					var nowlandnout = value.bcount - value.nowlandcount;
					var linknout = value.tcount - value.linkcount;
					var landnout = value.tcount - value.landcount;
					var body_in ='<tr><td class ="visible-lg">'+value.userid+'</td><td>'+value.user_name+'</td>'+
					'<td class ="visible-lg">'+value.telephone+'</td><td>'+value.bcount+'</td>'+ 
					'<td> '+value.nowlinkcount+' </td>' + '<td>'+nowlinknout+'</td>'  +
					'<td>'+value.nowlandcount+'</td>' + '<td>'+nowlandnout+'</td>' +
					'<td>'+value.tcount+'</td>' + '<td>'+value.linkcount+'</td>' + 
					'<td>'+linknout+'</td>' + '<td>'+value.landcount+'</td>' + '<td>'+landnout+'</td>'
					+'</tr>';
					form.append(body_in);
				});
			}
	 });
	
}

function villagecount () {
	var headform = $('.cellhead').empty();
	var append = '<tr><td >用户ID</td><td  >用户昵称</td><td  >电话号码</td><td >本月</td>'+
		'<td>总计</td></tr>';
	headform.append(append);
	var searchcode ='';
	var  c1 = $('#b_1').val();
	var c2 = $('#b_2').val();
	 var c3 = $('#b_3').val();
	 var c4 = $('#b_4').val();
	 if (c1 !=null && c1!='请选择') {
		 searchcode = c1;
	 } if (c2 !=null && c2!='请选择') {
		 searchcode = c2;
	 }if (c3 !=null && c3!='请选择') {
		 searchcode = c3;
	 } if (c4 !=null && c4!='请选择') {
		 searchcode = c4;
	 }
	 var form = $('#building_list');
		form.empty();
	 $.ajax ( {
		 data : {
				'code' : searchcode
			},
			type : 'POST',
			url : '/Tenement/village/censusvillage',
			success : function (data) {
				var buildings = data.obj.buildings;
				if (buildings.length== 0) {
					form.append('<option>暂无数据！</option>');
				}
				$.each(buildings,function(index, value) {
					var body_in ='<tr><td class ="visible-lg">'+value.userid+'</td><td>'+value.user_name+'</td>'+
					'<td class ="visible-lg">'+value.telephone+'</td><td>'+value.bcount+'</td>'+ 
					'<td>'+value.tcount+'</td>' 
					+'</tr>';
					form.append(body_in);
				});
			}
	 });
	
}


function tradingtovillage(){
	var code = $('.village_v4').val();
	var form = $('#village_list');
	form.empty();
	$.ajax({
		data : {
			'code' : code
		},
		type : 'POST',
		url : '/Tenement/tribe/getvillagebycode',
		success : function (data) {
			if (data.obj.length ==0) {
				var td = '<tr><td>暂无小区数据！</td></tr>';
				form.append(td);
			}
			$.each(data.obj,function(index, value) {
				var body_in ='<tr><td >'+value.villageid+'</td><td>'+value.code+'</td>'+
				'<td>'+value.villagename+'</td><td><button class="btn btn-large btn-primary " onclick =getbuildinglist('+value.villageid+') >查询</button></td>'+ 
				'<td> <button onclick=getvillagedetail('+value.villageid+') class="btn btn-large btn-primary " data-toggle="modal" data-target="#village_edit">详情</button>  </td>'
				+'<td> <button onclick=metro_village('+value.villageid+  '\,\''+ value.code+ '\',\''+ value.villagename+ '\') class="btn btn-large btn-primary" data-toggle="modal" data-target="#metro_village"> 重构 </button> </td></tr>';
				
				form.append(body_in);
			});
		}
	});
};

function metro_village (villageid,code,villagename) {
	$('.metro_villageid').val(villageid);
	$('.metro_villagecode').val(code);
	$('.metro_villagename').val(villagename);
	$('#metro_detail').empty();
	var select = $('#metro_byname');
	select.empty();
	select.append('<option>请选择</option>');
	$.ajax ({
		data : {
			'code' : code
		},
		type : 'POST',
		url : '/Tenement/metro/metrobyname',
		success : function (data) {
			$.each (data.obj,function (index,value) {
				var option = '<option value = '+value.code+'> '+value.name+ '</option>';
				select.append(option);
			});
			
		}
	});
}

function metro_village_2 (villageid,code,villagename) {
	$('.metro_villageid').val(villageid);
	$('.metro_villagecode').val(code);
	$('.metro_villagename').val(villagename);
	var showname = $('.show_metroname').val();
	$('#metro_detail_2').empty();
	var select = $('#metro_byname_2');
	select.empty();
	select.append('<option>请选择</option>');
	$.ajax ({
		data : {
			'code' : code
		},
		type : 'POST',
		url : '/Tenement/metro/metrobyname',
		success : function (data) {
			$.each (data.obj,function (index,value) {
				var option = '<option value = '+value.code+'> '+value.name+ '</option>';
				select.append(option);
				if (value.name == showname) {
					 select.find("option:contains('"+showname+"')").attr("selected",true);	
					 metro_byname_2();
				}
			});
			
			
		}
	});
}


function getbuildinglist (villageid) {
	var form = $('#village_list');
	form.empty();
	$.ajax({
		data : {
			'villageid' : villageid
		},
		type : 'POST',
		url : '/Tenement/village/getbuildinglistbyvid',
		success : function (data) {
			$.each(data.obj.buildings,function(index, value) {	//('+ value.metroid+ '\,\''+ value.code+ '\',\''+ value.finalstop+ '\')
				var body_in ='<tr><td>'+value.buildingid+'</td><td>'+value.villagename+'</td> <td>'+
				value.building+'</td> <td> <button onclick=clearbuilding('+value.buildingid+'\,\''+value.villageid+ '\',\''+ value.building+
				'\') class="btn btn-large btn-primary " >删除</button></td> <td> <button onclick=getbuildingdetail('+value.buildingid+'\,\''+value.code+'\')  '
				+' class="btn btn-large btn-primary " data-toggle="modal" data-target="#building_edit">详情</button>'
				+'<td>'+value.name+value.finalstop+'</td></td></tr>';
				form.append(body_in);
			});
		}
	});
}

function clearbuilding(buildingid,villageid ,building) {
	
	
	// 封装提示的主干
	var tip = '[ 楼栋: '+ building+' ]';
	$('.delete_tip').text(tip);
	//如果没有分页参数自定义一个
	var currentpage = 0;
	//设置参数名称
	var param = 'buildingid';
	//执行删除的URL链接
	var deleteurl = '/Tenement/village/deletebuidilding';
	commondelete(param,  buildingid ,deleteurl , villageid);
	
	
	//if (confirm('你确定删除该楼栋吗，删除后对应的详情地址将删除 ?')) { 
	//	$.ajax({
	//		data : {
	//			'buildingid' : buildingid
	//		},
	//		type : 'POST',
	//		url : '/Tenement/village/deletebuidilding',
	//		success :function (data) {
	//			getbuildinglist (villageid);
	//		}
	//	});
	//}
}

function getbuildingdetail (buildingid,code) {
	$.ajax ( {
		data : {
			'buildingid' : buildingid
		},
		type : 'POST',
		url : '/Tenement/village/simplebuildingdetail',
		success : function (data) {
			$('.building_code').val(data.obj.code);
			$('.building_building').val(data.obj.building);
			$('.building_brand').val(data.obj.brand);
			$('.building_linkphone').val(data.obj.linkphone);
			$('.building_linkman').val(data.obj.linkman);
			$('.building_landphone').val(data.obj.landphone);
			$('.building_bnumber').val(data.obj.bnumber);
			$('.building_metro').val(data.obj.metro);
			$('.building_land').val(data.obj.land);
			$('.building_buildingid').val(data.obj.buildingid);
			$('.building_villageid').val(data.obj.villageid);
			$('.building_brandid').val(data.obj.brandid);
			$('.building_num').val(data.obj.buildingcode);
			$('.building_detailes').val(data.obj.detailes);
			$('.show_metroname').val(data.obj.metroname);
			$('.show_finalstop').val(data.obj.finalstop);
			metro_village_2(buildingid,code,buildingid);
			
		}
		
	});
	
	
}