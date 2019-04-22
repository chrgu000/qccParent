<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <script type="text/javascript" src="/Tenement/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<form name="Form2" action="/Tenement/videoUpload" method="post"  enctype="multipart/form-data">
<input type="file" name="content">
<input type="submit" value="upload"/>
</form>
	<button id="button">JXMP</button>
	
	
	<div id="addree"></div>
	
	
	<button class="shouquan"> 微信授权 </button>

</body>



<script type="text/javascript">
 $(function () {
	 
	 $('.shouquan').click(function () {
		     var url = "https://www.zzw777.com/Tenement/oauth/oauth2AuthorizeController"; //注意此处的basePath是没有端口号的域名地址。如果包含:80,在提交给微信时有可能会提示 “redirect_uri参数错误” 。
	        //money为订单需要支付的金额
	        //state中存放的为商品订单号
	        console.log(url);
	        var state = "10001765";
	        var weixinUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx37a5a7281317047a&redirect_uri=" + encodeURI(url) + "&response_type=code&scope=snsapi_userinfo&state=state="+state+"#wechat_redirect";
	        location.href=encodeURI(weixinUrl);
		 
	 });
	 
	 
	 $('#button').click(function () {
		 
		 $.ajax({
				method : 'post',
				data :{userid:10001765},
				url : '/Tenement/houseModel/houseList',
				success : function(data) {
					var map = data.obj.address;
					var TopDiv = $('#addree').empty();
					for (var key in map) {  
						var ul = '<ul>'+key;
						
						$.each(map[key],function(index, value) {
							ul += '   <li ">'+value+'</li>';
						})
						ul +='</ul>';
						
						TopDiv.append(ul);
			            console.log("map["+key+"]"+map[key]);  
			        }  
				}
			});
	 });
 });

</script>
</html>