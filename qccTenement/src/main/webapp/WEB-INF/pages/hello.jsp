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
	
	
	
	
	
	<button class="shouquan"> å¾®ä¿¡ææ </button>
	
	输入页码：<input value="1" class="page">
	<button type="button" class="clickBtn">CLICK</button>
	
	<div id="addree"></div>

</body>



<script type="text/javascript">
 $(function () {
	 
	 $('.clickBtn').click(function () {
		 var pagesize = $('.page').val();
		 alert(pagesize);
		 $.ajax({
				method : 'post',
				data :{userid:10006381 ,pagesize:pagesize},
				url : 'https://www.zzw777.com/Tenement/user/belogin/album',
				success : function(data) {
					var map = data.obj.detailList;
					var TopDiv = $('#addree').empty();
					$.each(map,function(index, value) {
						var body_in = '<tr><td>'+value.houseid+'</td><td>'+value.picture.split(',')[0]+'</td><td>'+
						'<image src='+value.picture.split(',')[0]+' /></td></tr>';
						TopDiv.append(body_in);
					});
				}
		});
		 
	 });
	 
	 
	 $('.shouquan').click(function () {
		     var url = "https://www.zzw777.com/Tenement/oauth/oauth2AuthorizeController"; //æ³¨ææ­¤å¤çbasePathæ¯æ²¡æç«¯å£å·çååå°åãå¦æåå«:80,å¨æäº¤ç»å¾®ä¿¡æ¶æå¯è½ä¼æç¤º âredirect_uriåæ°éè¯¯â ã
	        //moneyä¸ºè®¢åéè¦æ¯ä»çéé¢
	        //stateä¸­å­æ¾çä¸ºååè®¢åå·
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