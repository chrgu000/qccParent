$(function () {
	
	$('.systemdata').click(function() {
		var editaddress = $('#systemdata');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		editaddress.show();
	});
	$('.resetstart').click(function () {
		$('.buil_solr_next_start').val('0');
		$('.buil_solr_next_end').val('2');
	});
	$('.prepage').click(function () {
		
	});
	// 楼栋一键导入索引库
	$('.buil_onekey_tosolr').click(function () {
		var start = $('.buil_solr_next_start').val();
		var end = $('.buil_solr_next_end').val();
		var tipDiv =$('.tipDiv').empty();
		$('.solrTiph4').text('你确定要维护 [楼栋] : '+start+"万 到  " +end +'万 ?');
		tipDiv.append('<button type="button" class="btn btn-primary" onclick=buildingToSolr()>确定维护</button>');

	});
	$('.qiuzu_onekey_tosolr').click(function () {
		var start = $('.buil_solr_next_start').val();
		var end = $('.buil_solr_next_end').val();
		var tipDiv =$('.tipDiv').empty();
		$('.solrTiph4').text('你确定要维护 [求租] : '+start+"万 到  " +end +'万 ?');
		tipDiv.append('<button type="button" class="btn btn-primary" onclick=qiuzuToSolr()>确定维护</button>');
		
	});
	
	$('.house_onekey_tosolr').click(function () {
		var start = $('.buil_solr_next_start').val();
		var end = $('.buil_solr_next_end').val();
		var tipDiv =$('.tipDiv').empty();
		$('.solrTiph4').text('你确定要维护 [房源] : '+start+"万 到  " +end +'万 ?');
		tipDiv.append('<button type="button" class="btn btn-primary" onclick=houseToSolr()>确定维护</button>');
	});
	$('.village_onekey_tosolr').click(function () {
		var start = $('.buil_solr_next_start').val();
		var end = $('.buil_solr_next_end').val();
		var tipDiv =$('.tipDiv').empty();
		$('.solrTiph4').text('你确定要维护 [小区] : '+start+"万 到  " +end +'万 ?');
		tipDiv.append('<button type="button" class="btn btn-primary" onclick=villageToSolr()>确定维护</button>');
	});
	
	
});

function villageToSolr() {
	var start = $('.buil_solr_next_start').val() * 10000;
	var end = $('.buil_solr_next_end').val() * 10000;
	var tipDiv =$('.tipDiv').empty();
	tipDiv.append('<h3>数据同步中... , 请耐心等待 !!!</h3>');
	$.ajax ({
		data:{
			start:start,
			end:end
		},
		type : 'POST',
		url : '/Tenement/addvillagetosolr',
		success : function (data) {
			tipDiv.empty().append('<h3>'+data.msg+'</h3>');
			setTimeout(function(){$('#solrTip').modal('hide')},3000);
		}
	});
	
}

function houseToSolr() {
	var start = $('.buil_solr_next_start').val() * 10000;
	var end = $('.buil_solr_next_end').val() * 10000;
	var tipDiv =$('.tipDiv').empty();
	tipDiv.append('<h3>数据同步中... , 请耐心等待 !!!</h3>');
	$.ajax ({
		data:{
			start:start,
			end:end
		},
		type : 'POST',
		url : '/Tenement/house/addtosolr',
		success : function (data) {
			tipDiv.empty().append('<h3>'+data.msg+'</h3>');
			setTimeout(function(){$('#solrTip').modal('hide')},3000);
		}
	});
	
}

function buildingToSolr() {
	var start = $('.buil_solr_next_start').val() * 10000;
	var end = $('.buil_solr_next_end').val() * 10000;
	var tipDiv =$('.tipDiv').empty();
	tipDiv.append('<h3>数据同步中... , 请耐心等待 !!!</h3>');
	$.ajax ({
		data:{
			start:start,
			end:end
		},
		type : 'POST',
		url : '/Tenement/addbuildingtosolr',
		success : function (data) {
			tipDiv.empty().append('<h3>'+data.msg+'</h3>');
			setTimeout(function(){$('#solrTip').modal('hide')},3000);
		}
	});
	
}


function qiuzuToSolr() {
	var start = $('.buil_solr_next_start').val() * 10000;
	var end = $('.buil_solr_next_end').val() * 10000;
	var tipDiv =$('.tipDiv').empty();
	tipDiv.append('<h3>数据同步中... , 请耐心等待 !!!</h3>');
	$.ajax ({
		data:{
			start:start,
			end:end
		},
		type : 'POST',
		url : '/Tenement/qiuzu/qiuzuaddtosolr',
		success : function (data) {
			tipDiv.empty().append('<h3>'+data.msg+'</h3>');
			setTimeout(function(){$('#solrTip').modal('hide')},3000);
		}
	});
	
}

function makeSolrNextPage(attr) {
	var classStartTab =  "." + attr + "_start";
	var classEndTab = "." + attr + "_end";
	var startValue = $(classStartTab).val(); 
	var endValue = $(classEndTab).val();
	$(classStartTab).val(startValue*1+2 );
	$(classEndTab).val(endValue*1+2);
}
function makeSolrprePage(attr){
	var classStartTab =  "." + attr + "_start";
	var classEndTab = "." + attr + "_end";
	var startValue = $(classStartTab).val(); 
	var endValue = $(classEndTab).val();
	startValue = startValue*1-2 ;
	endValue = endValue*1-2;
	if (startValue < 0 ) {startValue = 0 ;}
	if (endValue < 2 ) {endValue = 2 ;}
	$(classStartTab).val(startValue );
	$(classEndTab).val(endValue);
}