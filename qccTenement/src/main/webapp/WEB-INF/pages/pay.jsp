<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/editaddress.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支付页面</title>
</head>

<body onload="pay()" >
<!-- <button class="testpay">测试付款</button>
<div class="housediv">
	<div class="housediv1"><span>房号:</span> <input name="house" />
	<span>楼层:</span> <input name="floor" />
	<button class="add">添加</button></div>
</div>

<button class="allsubmit">提交</button>
 --></body>
<script type="text/javascript">
/* var attAppp = [];
  $(function () {
	  $('.testpay').click(function () {
		  $.ajax({
			  type : 'POST',
			  data : {userid : 1} ,
			  url : '/Tenement/tixian' ,
			  success : function () {}
		  });
		  
	  });
	  var index = 1 ;
	
	  $('.add').click (function () {
		  
		  
		  
		  var test = {};
		  var houseInput = '.housediv' +index + " input[name='house']";
		  var floorInput = '.housediv' +index + " input[name='floor']";
		  var houseValue = parseInt( $(houseInput).val() );
		  var floorValue = parseInt( $(floorInput).val() );
		  index ++ ;
		  houseValue++;
		  var str = '<div class="housediv'+index+'"> <span>房号:</span> <input name="house"  value='+houseValue+'>'+
				'<span>楼层:</span> <input name="floor" value='+floorValue+'>' +
				'<button onclick=remove('+index+')>移除</button></div>'
		  $('.housediv').append(
				  str
		  );
		  
		  test.houseValue = houseValue;
		  test.floorValue = floorValue;
		  attAppp.push(test);
		 
	  });
	  
	  $('.allsubmit').click(function (){
		  
		  
		 
		  var success = '';
		  for (var i=0;i<attAppp.length;i++) {
			 success += attAppp[i].houseValue +'-' + attAppp[i].floorValue +',';
		  }
		  success = success.slice(0,success.length-1);
		  alert(success);
		  
	  });
	 
	 
	  
	  
  });
  
  function remove(index) {
	  var div = '.housediv' +index;
	  var housediv = $('.housediv').children('div');
	  for (var i=0;i<housediv.length;i++) {
		  var divclass =  '.'+housediv[i].getAttribute("class");
		  if (div === divclass) {
			  // 删除的集的索引
			  alert(i);
			  attAppp.splice(i);
			  $(div).remove();
			  return ;
		  }
		  
	  }
	 
  }
 */
 


     function pay(){
        if (typeof WeixinJSBridge == "undefined"){
            if( document.addEventListener ){
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            }else if (document.attachEvent){
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        }else{
            onBridgeReady();
        }
    }
    function onBridgeReady(){
        var appid="${appid}";
        var timestamp="${timeStamp}";
        var nocncestr="${nonceStr}";
        var package="${packageValue}";
        var paysign="${paySign}";
        WeixinJSBridge.invoke(
            'getBrandWCPayRequest', {
                "appId" : "${appid}",     //公众号名称，由商户传入
                "timeStamp": "${timeStamp}",         //时间戳，自1970年以来的秒数
                "nonceStr" : "${nonceStr}", //随机串
                "package" : "${packageValue}",
                "signType" : "MD5",         //微信签名方式:
                "paySign" : "${paySign}"    //微信签名
            },function(res){
                if(res.err_msg == "get_brand_wcpay_request:ok"){
                    window.location.href="https://www.zzw777.com/pages/balance.html";
                }else if(res.err_msg == "get_brand_wcpay_request:cancel"){
                    console.log("用户取消支付")
                }else{
                    alert("支付失败!");
                    location.href="fail.jsp";
                }
            });
    }
</script>

</html>
