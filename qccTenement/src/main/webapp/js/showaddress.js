$(function() {
	
		window.setInterval("realSysTime()",1000); //实时获取并显示系统时间 

})




window.onload=function(){ 
	window.setInterval("realSysTime()",1000); //实时获取并显示系统时间 
	window.setInterval("deleteqiuzu()",1000*60*60); //每隔一天清理下求租里的脏数据
} 
function deleteqiuzu() {
	$.ajax ({
		url : '/Tenement/qiuzu/deleteqiuzu',
		success : function(a) {}
	});
}
function realSysTime(){ 
	var now=new Date(); //创建Date对象 
	var year=now.getFullYear(); //获取年份 
	var month=now.getMonth(); //获取月份 
	var date=now.getDate(); //获取日期 
	var day=now.getDay(); //获取星期 
	var hour=now.getHours(); //获取小时 
	var minu=now.getMinutes(); //获取分钟 
	var sec=now.getSeconds(); //获取秒钟 
	month=month+1; 
	var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 
	var week=arr_week[day]; //获取中文的星期 
	var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间 
	
	$('.time').text(time); //显示系统时间 
	} 
	