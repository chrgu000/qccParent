$(function() {
	$('.buildingsmap').click(function() {
		var editaddress = $('#buildingsmap');
		var cssdisplay = editaddress.css('display');
		editaddress.siblings().hide();
		if (cssdisplay === 'none') {
			var centerOne = [114.277113, 22.693319];
			var center = $('.centerone').val();
			var zoom = $('.zoom').val();
			if (zoom == '') {
				zoom = 14;
			}
			if (center !='') {
				centerOne = center.split(",");
			}
			var map = new AMap.Map('allmap', {
				resizeEnable: true,
				zoom: zoom,
				center: centerOne
			});
			 gaodemap (centerOne[1],centerOne[0],map);
			
			
			map.on('mouseup', function(e) {
				var lat = e.lnglat.lat;
				var lng = e.lnglat.lng;
			
				$('.centerone').val(e.lnglat);
				gaodemap (lat,lng,map);
			})
			map.on('click', function(e) {
				var lat = e.lnglat.lat;
				var lng = e.lnglat.lng;

				$('.centerone').val(e.lnglat);

				
				
			})
			
			
			
			
			editaddress.show();

		}
		if (cssdisplay === 'block') {
			editaddress.hide();
		}
	});
	
	
	function gaodemap (one ,two,map) {
		
		$.post( '/Tenement/village/fingbuildsmaps', {
			currentLatude:one ,currentLongitude:two
		}, function(res) {
			var buildingList = res.obj.buildings;
			
			var markers = []; // provinces见Demo引用的JS文件
			
			var marker ;
			var latandlog = "114.277113, 22.693319";
			var content="1";
			for(var i = 0; i < buildingList.length; i += 1) { 
					latandlog= buildingList[i].longitude + ','+buildingList[i].latitude ;
					content= "<div class = 'contents' style='display:block;color:red;width:100px;position:absoult;left:-50px;top:-50px' >" + buildingList[i].building + "</div>";
					marker = new AMap.Marker({
						position:latandlog.split(","),
						title: buildingList[i].building,
						map: map,
					});
					baodao = new AMap.Marker({
						content: content,
						position: latandlog.split(','),
						title: buildingList[i].building,
						offset: new AMap.Pixel(0, 0),
						map: map
					});
				markers.push(marker);
			}
			
			
			
		});	
	}
});





function commonmap() {
	// 百度地图API功能
	var map = new BMap.Map("allmap"); // 创建Map实例
	map.centerAndZoom(new BMap.Point(114.275202, 22.693987), 16); // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl()); // 添加地图类型控件
	map.addControl(new BMap.NavigationControl({
		enableGeolocation : true
	}));
	map.addControl(new BMap.OverviewMapControl());
	map.setCurrentCity("深圳"); // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放
	var markers = [];
	// ===================

	var geolocation = new BMap.Geolocation();

	geolocation.getCurrentPosition(function(r) {
		var mk = new BMap.Marker(r.point);
		if (this.getStatus() == BMAP_STATUS_SUCCESS) {
			map.addOverlay(mk);
			map.panTo(r.point);

			map.addEventListener('ondragging', function() {
				mk.setPosition(map.getCenter());
			});
			// 地图停止移动后获取mk经纬度
			map.addEventListener('moveend', function() {
				var pos = mk.getPosition();
				getbuidingsmap(pos.lat, pos.lng)
				// 创建地址解析对象
				var geoc = new BMap.Geocoder();
				geoc.getLocation(pos, function(rs) {
					var addComp = rs.addressComponents;
					console.log(addComp);

				});

			})
			getbuidingsmap(r.point.lat, r.point.lng)

		} else {
			alert('failed' + this.getStatus());
		}

	});

	function getbuidingsmap(lat, lng) {
		var pt = null;
		

		$.ajax({
			data : {
				currentLatude : lat,
				currentLongitude : lng
			},
			url : '/Tenement/village/fingbuildsmaps',
			success : function(data) {
				$.each(data.obj.buildings, function(index, value) {
					pt = new BMap.Point(value.longitude, value.latitude);
					// 创建图标对象
					var myIcon = new BMap.Icon(
							"http://api.map.baidu.com/img/markers.png",
							new BMap.Size(23, 25), {
								offset : new BMap.Size(10, 25), // 指定定位位置
								imageOffset : new BMap.Size(0, 0 - index * 25)
							// 设置图片偏移
							});
					var label = new BMap.Label(value.building, {
						offset : new BMap.Size(30, -10)
					});
					var marker = new BMap.Marker(pt, {
						
						
					});
					marker.setLabel(label);
					
					map.addOverlay(marker);

				});

				
			}

		});

	}

}
