<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <script type="text/javascript" src="/Tenement/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<form name="Form2" action="/Tenement/orcPictureUpload" method="post"  enctype="multipart/form-data">
<input type="file" name="orcPicture">
<input type="text" name="user_id">
<input type="submit" value="upload"/>
</form>
	<button id="button">JXMP</button>
	
	
	<div id="addree"></div>

</body>



<script type="text/javascript">
 $(function () {
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