$(function () {
	
	$('.app_update').click(function() {
		var editaddress = $('#app_update');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			getAllverion();
			editaddress.show();
		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	$('.app_show').click(function () {
		 $(".app_err_span").text('非开发人员勿随意添加版本');
		 $('.app_insert').show();
		
	});
	
	$('.app_insert').click(function () {
		var form = new FormData(document.getElementById("app_insert_form"));
		// 上传过程中提示
		 $(".app_err_span").text('正在努力上传中......');
		 $('.app_insert').hide();
		 $.ajax({
             url:"/Tenement/app/versionadd",
             type:"post",
             data:form,
             processData:false,
             contentType:false,
             success:function(data){
            	 data = checkaccessexist(data);
                 $(".app_err_span").text(data.msg);
                 $('.app_insert').show();
                 if (data.code ==200) {
                	 getAllverion();
                	 $('#app_add').modal('hide');
                 }
             },
         });        
	});
	
	
	
})

function deleteapp(versionid) {
	// 封装提示的主干
	var tip = '[ 版本===='+ versionid+']';
	$('.delete_tip').text(tip);
	//如果没有分页参数自定义一个
	var currentpage = 1;
	//设置参数名称
	var param = 'versionid';
	//执行删除的URL链接
	var deleteurl = '/Tenement/app/delete';
	commondelete(param,versionid,deleteurl,currentpage) ;
}

function getAllverion() {
	 $.ajax({
         url:"/Tenement/app/allversion",
         type:"post",
         success:function(data){
        	 var form = $('#app_all_body').empty();
        	 var list = data.obj;
        	 if (list) {
        		 $.each(list,function(index, value) {
        			 var time = setTime(value.updatetime);
        			 var appendTo = '<tr><td>'+value.versionid+'</td><td>'+value.type+'</td>' +
        			 '<td>'+time+'</td><td>'+value.url+'</td><td><button onclick=deleteapp(\"' + value.versionid + '\")  class="btn btn-large btn-primary">删除</button></td></tr>';
        			 
        			 form.append(appendTo);
        		 });
        	 }else {
        		 
        	 }
        	
         },
     });        
	
}
