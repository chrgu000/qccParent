<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/leftisshow.js"></script>
<title>左边</title>
</head>
<body>
<div class="panel-group left" id="accordion">
<c:if test="${not empty userback.access }">
<c:forEach items="${ userback.access}" var="li">

<c:if test="${li.accessid==1 }">
<div class="panel panel-default">
<div class="panel-heading"> <h4 class="panel-title"> <a href="#collapseOne" data-toggle="collapse" data-parent="#accordion">
		      系统管理 </a> </h4> </div>
<div id="collapseOne" class="panel-collapse collapse in">
<ul class="list-group">
	<li style="display:none;"  class="list-group-item systemdefaultstate" id="isshow15">
		<button type="button" class="btn btn-primary  systemstate">系统参数配置</button>
	</li>
	
	<li style="display:none;"  class="list-group-item " id="isshow34">
		<button type="button" class="btn btn-primary  parerrule">订房规则配置</button>
	</li>
	
	<!-- <li   class="list-group-item systemdefaultstate" >
		<button type="button" class="btn btn-primary  update_picture_domain">修改图片域名</button>
	</li> -->
	
	<li style="display:none;"  class="list-group-item" id="isshow30">
		<button type="button" class="btn btn-primary  commoninte">基本参数配置</button>
	</li>
	<li style="display:none;"  class="list-group-item" id="isshow31">
		<button type="button" class="btn btn-primary  percent">百分比数配置</button>
	</li>
	<li style="display:none;"  class="list-group-item" id="isshow28">
		<button type="button" class="btn btn-primary  systemdata" >系统数据维护</button>
	</li>
	<li   class="list-group-item" >
		<button type="button" class="btn btn-primary  livingset" >活动规则设置</button>
	</li>
	
</ul>
</div>
</div>
</c:if>
	
	
<c:if test="${li.accessid==2}">
<div class="panel panel-default">
<div class="panel-heading"> <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapseseven">
			个人管理</a> </h4> </div>
<div id="collapseseven" class="panel-collapse collapse">
<ul class="list-group">
	<li style="display:none;" class="list-group-item" id= "isshow16">
		<button type="button" class="btn btn-primary  historyexcle" >历史导出记录</button>
	</li>
	
	<li style="display:none;" class="list-group-item" id= "isshow17">
		<button type="button" class="btn btn-primary  mymanager_persion" >我的用户管理</button>
	</li>
	
	<li style="display:none;" class="list-group-item"  id= "isshow18">
		<button type="button" class="btn btn-primary  qiuzu_message" >求租群发短信</button>
	</li>
	
	<li style="display:none;" class="list-group-item"  id= "isshow102">
		<button type="button" class="btn btn-primary  update_test" >修改测试数据</button>
	</li>
	
</ul>
</div>
</div>
</c:if>
			
<c:if test="${li.accessid==3}">
<div class="panel panel-default"><div class="panel-heading">
<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#collapsefour"> 
			用户信息 </a></h4></div>
<div id="collapsefour" class="panel-collapse collapse">
<ul class="list-group">

	<li class="list-group-item">
		<button type="button" class="btn btn-primary  qiuzu" >求租发布统计</button>
	</li>
							
	<li style="display:none;" class="list-group-item" id="isshow19">
		<button type="button" class="btn btn-primary  suggess">用户意见反馈</button>
	</li>
							
	<li style="display:none;" class="list-group-item" id="isshow20">
		<button type="button" class="btn btn-primary  auth">房东发布委托</button>
	</li>
	<li style="display:none;" class="list-group-item" id="isshow29">
		<button type="button" class="btn btn-primary useraccount" >用户钱包统计</button>
	</li>
</ul>
</div>
</div>
</c:if>
			
			

<c:if test="${li.accessid==6}">
<div class="panel panel-default"><div class="panel-heading">
<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"> 
			部落管理 </a> </h4> </div>
<div id="collapseTwo" class="panel-collapse collapse">
<ul class="list-group">
	<li style="display:none;"  class="list-group-item " id="isshow10">
		<button type="button" class="btn btn-primary  tribep">部落找人发布</button>
	</li>
	<li style="display:none;" class="list-group-item " id="isshow11" >
		<button type="button" class="btn btn-primary  lovetribe">兴趣部落管理</button>
	</li>
	<li style="display:none;" class="list-group-item " id="isshow12">
		<button type="button" class="btn btn-primary  tribeaddress">地区部落管理</button>
	</li>
</ul>
</div>
</div>
</c:if>


<c:if test="${li.accessid==4}">
<div class="panel panel-default">
<div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"> 
			区域管理</a></h4></div>
<div id="collapseThree" class="panel-collapse collapse">
<ul class="list-group">

	<li style="display:none;"  class="list-group-item " id="isshow13">
		<button type="button" class="btn btn-primary  village">小区楼栋管理</button>
	</li>
	<li class="list-group-item">
		<button type="button" class="btn btn-primary exportbuildingandvillage ">导出小区楼栋</button>
	</li>
	<li  class="list-group-item" >
		<button type="button" class="btn btn-primary  building">楼栋发布统计</button>
	</li>
	<li style="display:none;"  class="list-group-item" id="isshow21">
		<button type="button" class="btn btn-primary  buildingsmap">楼栋地图分布</button>
	</li>
	<li style="display:none;" class="list-group-item " id = "isshow32">
		<button type="button" class="btn btn-primary  editaddress2">四级地址编辑</button>
	</li>
	<li style="display:none;" class="list-group-item" id = "isshow9">
		<button type="button" class="btn btn-primary  metro">热门城市地铁</button>
	</li>
</ul>
</div>
</div>
</c:if>

			
<c:if test="${li.accessid==5}">
<div class="panel panel-default">
<div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion"  href="#collapsefive"> 
			商品管理 </a> </h4> </div>
<div id="collapsefive" class="panel-collapse collapse">
<ul class="list-group">
	<li style="display:none;"  class="list-group-item" id="isshow22">
		<button type="button" class="btn btn-primary  tribet">部落物品发布</button>
	</li>
	<li style="display:none;"  class="list-group-item" id="isshow23">
		<button type="button" class="btn btn-primary  paramtype">规格参数管理</button>
	</li>
	<li class="list-group-item">Vestibulum at eros</li>
</ul>
</div>
</div>
</c:if>
	
<c:if test="${li.accessid==7}">
<div class="panel panel-default">
<div class="panel-heading"> <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapsesix">
			权限管理</a> </h4> </div>
<div id="collapsesix" class="panel-collapse collapse">
<ul class="list-group">
		<li style="display:none;"  class="list-group-item" id="isshow24" >
			<button type="button" class="btn btn-primary  access_to_url" >权限对应链接</button>
		</li>
		<li style="display:none;"  class="list-group-item" id="isshow25">
			<button type="button" class="btn btn-primary  role_to_access" >角色对应权限</button>
		</li>
		<li style="display:none;"  class="list-group-item" id="isshow26">
			<button type="button" class="btn btn-primary  user_to_role" >系统账号管理</button>
		</li>
		<li style="display:none;"   class="list-group-item" id="isshow27">
			<button type="button" class="btn btn-primary  manager_to_user" >管理对应用户</button>
		</li>
		
		<li style="display:none;"     class="list-group-item"  id="isshow35">
			<button type="button" class="btn btn-primary  app_update" >APP版本更新</button>
		</li>
		
		<li style="display:none;"  class="list-group-item">Vestibulum at eros</li>
</ul>
</div>
</div>
</c:if>
			

<c:if test="${li.accessid==8}">
<div class="panel panel-default">
<div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion"  href="#collapeight"> 
			审核管理</a> </h4> </div>
<div id="collapeight" class="panel-collapse collapse">
<ul class="list-group">
	<li style="display:none;"  class="list-group-item" id="isshow33" >
			<button type="button" class="btn btn-primary  landlord_examine" >房东入驻审核</button>
   </li>
</ul>
</div>
</div>
</c:if>	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


<c:if test="${li.accessid==8}">
<script type="text/javascript"> $(function (){$('#isshow8').show();});</script></c:if>
<c:if test="${li.accessid==9}">
<script type="text/javascript"> $(function (){$('#isshow9').show();});</script></c:if>
<c:if test="${li.accessid==10}">
<script type="text/javascript"> $(function (){$('#isshow10').show();});</script></c:if>	
<c:if test="${li.accessid==11}">
<script type="text/javascript"> $(function (){$('#isshow11').show();});</script></c:if>	
<c:if test="${li.accessid==12}">
<script type="text/javascript"> $(function (){$('#isshow12').show();});</script></c:if>
<c:if test="${li.accessid==13}">
<script type="text/javascript"> $(function (){$('#isshow13').show();});</script></c:if>
<c:if test="${li.accessid==15}">
<script type="text/javascript"> $(function (){$('#isshow15').show();});</script></c:if>	
<c:if test="${li.accessid==16}">
<script type="text/javascript"> $(function (){$('#isshow16').show();});</script></c:if>
<c:if test="${li.accessid==17}">
<script type="text/javascript"> $(function (){$('#isshow17').show();});</script></c:if>					
<c:if test="${li.accessid==18}">
<script type="text/javascript"> $(function (){$('#isshow18').show();});</script></c:if>
<c:if test="${li.accessid==19}">
<script type="text/javascript"> $(function (){$('#isshow19').show();});</script></c:if>
<c:if test="${li.accessid==20}">
<script type="text/javascript"> $(function (){$('#isshow20').show();});</script></c:if>
<c:if test="${li.accessid==21}">
<script type="text/javascript"> $(function (){$('#isshow21').show();});</script></c:if>
<c:if test="${li.accessid==22}">
<script type="text/javascript"> $(function (){$('#isshow22').show();});</script></c:if>
<c:if test="${li.accessid==23}">
<script type="text/javascript"> $(function (){$('#isshow23').show();});</script></c:if>
<c:if test="${li.accessid==24}">
<script type="text/javascript"> $(function (){$('#isshow24').show();});</script></c:if>
<c:if test="${li.accessid==25}">
<script type="text/javascript"> $(function (){$('#isshow25').show();});</script></c:if>	
<c:if test="${li.accessid==26}">
<script type="text/javascript"> $(function (){$('#isshow26').show();});</script></c:if>	
<c:if test="${li.accessid==27}">
<script type="text/javascript"> $(function (){$('#isshow27').show();});</script></c:if>
<c:if test="${li.accessid==28}">
<script type="text/javascript"> $(function (){$('#isshow28').show();});</script></c:if>	
<c:if test="${li.accessid==29}">
<script type="text/javascript"> $(function (){$('#isshow29').show();});</script></c:if>
<c:if test="${li.accessid==30}">
<script type="text/javascript"> $(function (){$('#isshow30').show();});</script></c:if>	
<c:if test="${li.accessid==31}">
<script type="text/javascript"> $(function (){$('#isshow31').show();});</script></c:if>
<c:if test="${li.accessid==32}">
<script type="text/javascript"> $(function (){$('#isshow32').show();});</script></c:if>		
<c:if test="${li.accessid==33}">
<script type="text/javascript"> $(function (){$('#isshow33').show();});</script></c:if>
<c:if test="${li.accessid==34}">
<script type="text/javascript"> $(function (){$('#isshow34').show();});</script></c:if>		
<c:if test="${li.accessid==102}">
<script type="text/javascript"> $(function (){$('#isshow102').show();});</script></c:if>
<c:if test="${li.accessid==35}">
<script type="text/javascript"> $(function (){$('#isshow35').show();});</script></c:if>													
	
	
</c:forEach>
</c:if>
</div>
</body>
</html>