$(function () {
	
	//隐藏或者打开意见反馈的页面
	$('.suggess').click(function() {
		var editaddress = $('#suggess');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			getallsuggess();
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	$('.picture_shanxuan').change(function () {
		getallsuggess(1);
	});
	$('.message_shanxuan').change(function () {
		getallsuggess(1);
	});
	
	
	
	
});
//上一页
function getpregetallsuggess (currentpage) {
	var page = Number(currentpage) - 1;
	getallsuggess(page);
}
function getfirstgetallsuggess() {
	getallsuggess(1);
}
function getnowgetallsuggess(currentpage) {
	getallsuggess(currentpage);
}
function getendgetallsuggess (currentpage){
	getallsuggess(currentpage);
}
function getnextgetallsuggess (currentpage){
	var page = Number(currentpage) + 1;
	getallsuggess(page);
}
//获取所有的反馈
function getallsuggess(currentpage) {
	var pictureshanxuan = $('.picture_shanxuan').val();
	var messageshanxuan =$('.message_shanxuan').val();
	var pagequerylist = $('.suggesspagequery_list').empty();
	$.ajax({
		data :{pictureshanxuann:pictureshanxuan,messageshanxuan:messageshanxuan,currentpage:currentpage
			,pagesize:7},
		method : 'post',
		url : '/Tenement/sugges/suggeslist',
		success : function(data) {
			build_common_nav('suggess_nav_area',data);
			build_common_page('suggess_info_area' , data) ;
			//加载数据
			build_getallsuggess(data);
			
		}
	});
}

function build_getallsuggess(data){
	var from =$('#suggess_body').empty();
	$('.suggess_title').val();
	$.each( data.obj.sugges,function(index, value) {
		var time = setTime(value.update_time);
		var picture = '有图片';
		if (value.picture == -1) {picture= '无图片'}
		var td = '<tr><td>'+value.userid+'</td><td>'+value.user_name+'</td><td>'+value.title+'</td>'+
		'<td>'+value.mescount+'</td><td>'+picture+'</td><td>'+time+'</td><td>'+
		'<button onclick=suggessdetail('+value.suggesid+') class="btn btn-large btn-primary" data-toggle="modal" data-target="#suggess_detail"> 详情</button></td></tr>' 
		from.append(td);
	})
	
}
function suggessdetail (suggesid){
	$.ajax({
		data :{suggesid:suggesid},
		method : 'post',
		url : '/Tenement/sugges/detail',
		success : function(data) {
			var suggess = data.obj;
			$('.suggess_title').text("标题：" +suggess.title);
			var ps= [];
			if (suggess.picture) {
				ps = suggess.picture.split(",");
				var image = $('#imags').empty();
				for (var i=0 ;i<ps.length;i++) {
					
					if (ps[i] != -1) {
					image.append('<img style="width:140px;height:140px;" alt="1" src="'+ps[i]+'">');
					}else {
						image.append('<h3>无图片</h3>');
					}
				}
			}
		} 
	});
	$('#message_sugges').empty();
	$.ajax({
		data :{house_id:suggesid},
		type : 'POST',
		url : '/Tenement/messages/findMessagesByHouse/10',
		success : function(data) {
			 var msgList = data.obj.list;
			  var reply_list = '';
	          msgList.forEach(function (item,index) {
	            reply_list = item.messagereply;
	            var date = new Date(item.update_time);
	            var date_value=date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
	            $('#message_sugges').append(
	              '<div class="question-come-bake">'+
	              '<div class="question-come-bake-div" data-userId="'+item.user_id+'" data-msgId="'+item.messagesid+'" data-msgName="'+item.user_name+'" >'+
	              '<div class="come-back-content">'+
	              
	              '<div style="line-height:30px;" class="back-person">'+
	              '<img style="width:15px;height:15px;" src="'+item.avatar+'" alt="">'+
	              '<span>'+item.user_name+'：</span>'+
	              '<span>'+item.mes+'</span>'+
	              '<span  style="float:right;"> 时间：'+date_value+'</span>'+
	              '</div>'+
	            
	            
	             
	              '<div class="back-time">'+
	            
	              '</div>'+
	              '</div>'+
	              '</div>'+
	              '<div class="quertion-come-back-div-one'+index+' quertion-come-back-div-one">'+
	              '</div>'+
	              '</div>'
	            );
	            var msgClass = '.quertion-come-back-div-one'+index;
	            if(reply_list){
	              reply_list.forEach(function (item,index) {
	                var date = new Date(item.update_time);
	                var date_value=date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
	                $(msgClass).append(
	                  '<div class="come-back-content" data-userId="'+item.uid+'" data-msgId="'+item.messagesid+'" data-msgName="'+item.uname+'" data-msgIds="'+item.messagesreplyid+'"  >'+
	                  '<div class="back-person">'+
	                  '<span>'+item.uname+'</span>'+
	                  '<i>@</i>'+
	                  '<span>'+item.fname+'：</span>'+
	                  '<span>'+item.reply+'</span>'+
	                  '<span style="float: right;"> 时间：'+date_value+'</span>'+
		                
	                  '</div>'+
	                 
	                
	          
	                  '</div>'
	                );
	              })
	            }
	          });
		} 
	});
	
}