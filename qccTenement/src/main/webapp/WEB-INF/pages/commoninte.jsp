<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/commoninte.js"></script>
<title>Insert title here</title>
</head>
<body>

		
          <table id="commoninte_table" class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >金币主键</td>
				<td class ='visible-lg'  >事件名称</td>
				<td class ='visible-lg' >金币数量</td>
				<td class ='visible-lg' >每天频率</td>
				<td class ='visible-lg' >金币描述</td>
				<td >编辑</td>
			</tr>
			<tbody id="commoninte_body" >

			</tbody>
	</table>
	
	
	
	<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="commoninte_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改金币设置</h4>
            </div>
            <div class="modal-body">
			   				<input type="hidden" class="metro_metroid"/>
			 金币主键：	<input type="text" class="comm_commonid"  readonly="readonly"
			  > </br>
            	系统描述：	<input type="text" class="comm_typeword" readonly="readonly"
			  > </br>
            
          	 事件名称：	<input type="text" class="comm_typename"  
			  > </br>
          
            	金币数目：	<input type="number" class="comm_typecount" 
			  > </br>
			  每天频率：	<input type="number" class="comm_frequency" 
			  > </br>
			
           
            </div>
           
            <div class="modal-footer">
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="error_span"></span></div>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary comm_update">更新</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>