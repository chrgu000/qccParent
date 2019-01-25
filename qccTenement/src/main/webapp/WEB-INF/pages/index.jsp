<%@ page contentType="text/html;charset=utf-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>七彩巢后台管理系统</title>
<link href="/Tenement/css/bootstrap.min.css" rel="stylesheet">
<link href="/Tenement/css/comm.css" rel="stylesheet">
<script type="text/javascript" src="/Tenement/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/Tenement/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/Tenement/js/buildingsmap.js"></script>
<script type="text/javascript" src="/Tenement/js/common.js"></script>
</head>
<body background="./css/back.jpg">
	<div class="container-fluid">
	<input type="hidden" class="orderbyvalue">
	<input type="hidden" class="setsearchuserid">
	<input type="hidden" class="setsearchroleid">
	<input type="hidden" class="setsearchrolename">
	<input type="hidden" class="setsearchwhere" value="">
	<input type="hidden" class="typeword">
	<input type="hidden" class="hiddencurrentpage">
	<input type="hidden" class="checkword" value="-1">
	<c:if test="${not empty userback}">
		<input class="sessionuserid" type="hidden" value="${userback.userid }" />
		<input class="sessionroleid" type="hidden" value="${userback.roleid }" />
		<input class="sessionrolename" type="hidden" value="${userback.rolename }" />
	</c:if>
	
		<div style="margin-top: 40px;">
		<span style="margin-left: 500px;font-size: 20px; ">七彩巢后台管理系统 </span> 
		<span style="margin-left: 50px;"> ${userback.user_name}, [${userback.rolename}] <span style="font-size: 3px;" class="time"></span></span>
		<button style="margin-left: 1000px;" class="btn btn-primary" data-toggle="modal" data-target="#layout">注销</button> 
		</div>
		
		<form id="lay_out" action="layout"></form>
		<!-- 下部 -->
		<div class="row head">
			<!-- 左边 -->
			<div class="col-lg-2 ">
				<!-- 左侧导航 -->
				<jsp:include page="left.jsp"/>
			</div>
			<!-- 右边 -->
			<div class="col-lg-9 ">
				<!-- 弹出模态框4级联动地址的显示 -->
				<jsp:include page="panel.jsp"></jsp:include>
			</div>
		</div>
	</div>
	
	
	
	
	<!-- 模态框（Modal） -->
<div class="modal fade" id="accessnotinfull" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4  class="modal-title" id="myModalLabel">权限不足   
                	<span style="color: red;margin-left: 50px;" class="urlname"></span>
                </h4>
            </div>
            <div class="modal-body">
            		<h2 style="color: red;" >对不起，你没有该操作的权限!</h2>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
               
            </div>
        </div>
    </div>
</div>

	<!-- 模态框（Modal） -->
<div class="modal fade" id="layout" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4  class="modal-title" id="myModalLabel">退出警告</h4>
            </div>
            <div class="modal-body">
            		<h2 style="color: red;text-align: center;" >你确定要退出系统？</h2>
            </div>
            <div class="modal-footer">
                 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary layout_sure">确定</button>
            </div>
        </div>
    </div>
</div>



	<!-- 导出EXCLE-->
<div class="modal fade" id="exclesuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4  class="modal-title" id="myModalLabel">导出成功</h4>
            </div>
            <div class="modal-body download">
            		
            </div>
            <div class="modal-footer success_topersion">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>


	<!-- 导出EXCLE-->
<div class="modal fade" id="exclesuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4  class="modal-title" id="myModalLabel">导出成功</h4>
            </div>
            <div class="modal-body download">
            		
            </div>
            <div class="modal-footer success_topersion">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>



<!-- 删除文件时候通用的弹窗 -->
<div class="modal fade" id="common_delete_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">你确定要删除
                <span style="color: red;" class="delete_tip"></span>
                    ?
                </h4>
            </div>
            <div style="text-align: center;" class="modal-body common_delete_div">
                 
            	 	
            	 
            </div>
            <div class="modal-footer">
               
            </div>
        </div>
    </div>
</div>
</body>


<!-- 操作更新时候重要提示 -->
<div class="modal fade" id="common_update_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">你确定要把
                <span style="color: red;" class="update_tip"></span>
                    ?
                </h4>
            </div>
            <div style="text-align: center;" class="modal-body common_update_div">
 	
            	 
            </div>
            <div class="modal-footer">
               
            </div>
        </div>
    </div>
</div>
</body>



<!-- 删除文件时候通用的弹窗 -->
<div class="modal fade" id="sure_excle_export" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">EXCLE导出确定!
                </h4>
            </div>
            <div style="text-align: center;" class="modal-body ">
            	<input style="width: 400px;" type="text" class="form-control default_exportname  " placeholder="请给EXCLE取一个别名">
            </div>
            <div class="modal-footer excle_export_comm_div " >
              
            </div>
        </div>
    </div>
</div>
</body>

</html>