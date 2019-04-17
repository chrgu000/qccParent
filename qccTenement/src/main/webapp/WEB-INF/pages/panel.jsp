<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/editaddress.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>四级联动地址编辑</title>
</head>
<body>

	<!-- 面板1,4级联动的显示 -->
	<div id="systemdata">
		<div class="panel panel-default">
			<div class="panel-heading">系统数据维护管理</div>
			<div class="panel-body">
				<jsp:include page="systemdata.jsp"></jsp:include>
			</div>
		</div>
	</div>
	
	<!-- 部落找人发布维护 -->
	<div id="tribep" >
		<div class="panel panel-default">
			<div class="panel-heading">部落找人分类发布维护</div>
			<div class="panel-body">
				<jsp:include page="tribep.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 部落找人发布维护 -->
	<div id="livingset" >
		<div class="panel panel-default">
			<div class="panel-heading">系统部分活动规则设置</div>
			<div class="panel-body">
				<jsp:include page="livingset.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 部落找人发布维护 -->
	<div id="tribet" >
		<div class="panel panel-default">
			<div class="panel-heading">部落物品分类发布维护</div>
			<div class="panel-body">
				<jsp:include page="tribet.jsp"/>
			</div>
		</div>
	</div>

	<!-- 兴趣部落管理-->
	<div id="lovetribe">
		<div class="panel panel-default">
			<div class="panel-heading">兴趣部落类型的维护</div>
			<div class="panel-body">
				<jsp:include page="lovetribe.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 4级联动地址编辑 -->
	<div id="editaddress2">
		<div class="panel panel-default">
			<div class="panel-heading">四级联动地址编辑</div>
			<div class="panel-body">
				<jsp:include page="editaddress.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 地区部落管理 -->
	<div id="tribeaddress">
		<div class="panel panel-default">
			<div class="panel-heading">地区部落类型以及热门城市的维护</div>
			<div class="panel-body">
				<jsp:include page="tribeaddress.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 小区管理 -->
	<div id="village">
		<div class="panel panel-default">
			<div class="panel-heading">小区的维护和管理</div>
			<div class="panel-body">
				<jsp:include page="village.jsp"/>
			</div>
		</div>
	</div>
	
	
	<!-- 导出小区楼栋 -->
	<div id=exportbuildingandvillage>
		<div class="panel panel-default">
			<div class="panel-heading">导出小区楼栋的EXCLE表格</div>
			<div class="panel-body">
				<jsp:include page="exportbuildingandvillage.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 统计发布的数量 -->
	<div id="building">
		<div class="panel panel-default">
			<div class="panel-heading">统计楼栋发布数量</div>
			<div class="panel-body">
				<jsp:include page="building.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 统计发布的数量 -->
	<div id="metro">
		<div class="panel panel-default">
			<div class="panel-heading">热门城市地铁维护</div>
			<div class="panel-body">
				<jsp:include page="metro.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 求租发布统计 -->
	<div id="qiuzu">
		<div class="panel panel-default">
			<div class="panel-heading">求租发布统计</div>
			<div class="panel-body">
				<jsp:include page="qiuzu.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 规格参数管理 -->
	<div id="paramtype">
		<div class="panel panel-default">
			<div class="panel-heading">物品发布规格参数</div>
			<div class="panel-body">
				<jsp:include page="paramtype.jsp"/>
			</div>
		</div>
	</div>
	
	
	
	<!-- 权限控制 -->
	<div id="access">
		<div class="panel panel-default">
			<div class="panel-heading">权限对应链接管理</div>
			<div class="panel-body">
				<jsp:include page="access.jsp"/>
			</div>
		</div>
	</div>
	
	<div id="updatetest">
		<div class="panel panel-default">
			<div class="panel-heading">修改测试数据</div>
			<div class="panel-body">
				<jsp:include page="update_test.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 角色对应权限-->
	<div id="role">
		<div class="panel panel-default">
			<div class="panel-heading">角色对应权限管理</div>
			<div class="panel-body">
				<jsp:include page="role.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 用户对应角色-->
	<div id="user_to_role">
		<div class="panel panel-default">
			<div class="panel-heading">用户对应角色管理</div>
			<div class="panel-body">
				<jsp:include page="user_to_role.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 管理对应用户-->
	<div id="manager_to_user">
		<div class="panel panel-default">
			<div class="panel-heading">管理对应用户管理</div>
			<div class="panel-body">
				<jsp:include page="manager_to_user.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 个人管理中心-->
	<div id="historyexcle">
		<div class="panel panel-default">
			<div class="panel-heading">历史导出记录</div>
			<div class="panel-body">
				<jsp:include page="historyexcle.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 个人管理中心-->
	<div id="solr_add">
		<div class="panel panel-default">
			<div class="panel-heading">索引库的维护</div>
			<div class="panel-body">
				<jsp:include page="solr_add.jsp"/>
			</div>
		</div>
	</div>
	
	<!-- 个人管理中心-->
	<div id="buildingsmap">
		<div class="panel panel-default">
			<div class="panel-heading">索引库的维护</div>
			<div class="panel-body">
				<jsp:include page="map.jsp"/>
			</div>
		</div>
	</div>
	
	
	<!--用户意见反馈-->
	<div id="suggess">
		<div class="panel panel-default">
			<div class="panel-heading">用户意见反馈</div>
			<div class="panel-body">
				<jsp:include page="suggess.jsp"/>
			</div>
		</div>
	</div>
	
	<!--房东发布委托-->
	<div id="auth">
		<div class="panel panel-default">
			<div class="panel-heading">房东发布委托</div>
			<div class="panel-body">
				<jsp:include page="auth.jsp"/>
			</div>
		</div>
	</div>
	
	<!--求租群发短信-->
	<div id="qiuzu_message">
		<div class="panel panel-default">
			<div class="panel-heading">求租群发短信</div>
			<div class="panel-body">
				<jsp:include page="qiuzu_message.jsp"/>
			</div>
		</div>
	</div>
	
		<!--系统参数配置页面-->
	<div id="searchuseraccount">
		<div class="panel panel-default">
			<div class="panel-heading">用户钱包统计</div>
			<div class="panel-body">
				<jsp:include page="useraccount.jsp"/>
			</div>
		</div>
	</div>
	
		<!--金币基本配置-->
	<div id="commoninte">
		<div class="panel panel-default">
			<div class="panel-heading">基本参数设置   [ 金币 \ 砍刀   ]  </div>
			<div class="panel-body">
				<jsp:include page="commoninte.jsp"/>
			</div>
		</div>
	</div>
	
	<!--房源预订规则配置-->
	<div id="parerrule">
		<div class="panel panel-default">
			<div class="panel-heading">订房规则配置</div>
			<div class="panel-body">
				<jsp:include page="parerrule.jsp"/>
			</div>
		</div>
	</div>
	
	
	<!--百分比数配置-->
	<div id="percent">
		<div class="panel panel-default">
			<div class="panel-heading">百分比数配置</div>
			<div class="panel-body">
				<jsp:include page="percent.jsp"/>
			</div>
		</div>
	</div>
	
	<!--系统参数配置页面-->
	<div id="update_picture_domain">
		<div class="panel panel-default">
			<div class="panel-heading">修改图片域名</div>
			<div class="panel-body">
				<jsp:include page="update_picture_domain.jsp"/>
			</div>
		</div>
	</div>
	
	<!--房东入驻审核-->
	<div id="landlord_examine">
		<div class="panel panel-default">
			<div class="panel-heading">房东审核管理</div>
			<div class="panel-body">
				<jsp:include page="landlord_examine.jsp"/>
			</div>
		</div>
	</div>
	
	<!--aPP版本管理-->
	<div id="bdmanager">
		<div class="panel panel-default">
			<div class="panel-heading">BD账号管理</div>
			<div class="panel-body">
				<jsp:include page="bd_manager.jsp"/>
			</div>
		</div>
	</div>
	
	
	<!--管理房东佣金-->
	<div id="defaultPercent">
		<div class="panel panel-default">
			<div class="panel-heading">房东佣金管理</div>
			<div class="panel-body">
				<jsp:include page="defaultPercent.jsp"/>
			</div>
		</div>
	</div>
	
	
	<!--aPP版本管理-->
	<div id="app_update">
		<div class="panel panel-default">
			<div class="panel-heading">APP管理</div>
			<div class="panel-body">
				<jsp:include page="app_update.jsp"/>
			</div>
		</div>
	</div>
	
	<%-- <div id="aa111111">
		<div class="panel panel-default">
			<div class="panel-heading">测试支付</div>
			<div class="panel-body">
				<jsp:include page="pay.jsp"/>
			</div>
		</div>
	</div>	   --%>
	
	<!--系统参数配置页面-->
	<div id="systemstate">
		<div class="panel panel-default">
			<div class="panel-heading">系统参数配置</div>
			<div class="panel-body">
				<jsp:include page="systemdate.jsp"/>
			</div>
		</div>
	</div>
	

	
		
	
	

	
	
	
</body>
</html>