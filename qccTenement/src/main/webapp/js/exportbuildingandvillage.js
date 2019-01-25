$(function () {
	
	$('.exportbuildingandvillage').click(function() {
		var editaddress = $('#exportbuildingandvillage');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			editaddress.show();
			getprovince('export');
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
     });
	
	
	
	$('.export_building').click(function () {
		var searchcode ='';
		var  c1 = $('#export_1').val();
		var c2 = $('#export_2').val();
		var c3 = $('#export_3').val();
		var c4 = $('#export_4').val();
		if (c1 !=null && c1!='请选择') {
			 searchcode = c1;
		} if (c2 !=null && c2!='请选择') {
			 searchcode = c2;
		}if (c3 !=null && c3!='请选择') {
			 searchcode = c3;
		} if (c4 !=null && c4!='请选择') {
			 searchcode = c4;
		}
		if (searchcode == '') {
			alert('请选择区域');
			return ;
		}
		var sessionid = $('.sessionuserid').val();
		var type = $('.export_select').val();
		$('#sure_excle_export').modal('show');
		// 确定导出EXCLE
		$('.default_exportname').val('');
		setCommonDiv();
		$('.excle_usre_click').click(function () {
			var descname = $('.default_exportname').val();
			$('#sure_excle_export').modal('hide');
			$.ajax ({
				data : {
					'code':searchcode,
					'type' : type
				},
				type : 'POST',
				url : '/Tenement/back/buildingupload',
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
		
	});
	
	
	
	
})