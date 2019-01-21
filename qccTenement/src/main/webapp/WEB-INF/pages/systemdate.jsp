<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/systemdate.js"></script>
<title>Insert title here</title>
</head>
<body>

<table id="table " class = "table	table-hover ">
			<tr>
				<td class ='visible-lg'  >参数主键</td>
				<td class ='visible-lg'  >参数描述</td>
				<td class ='visible-lg' >当前状态</td>
				<td class ='visible-lg' >状态描述</td>
				<td class ='visible-lg' >关键字</td>
				<td >维护</td>
			</tr>
			<tbody id="systembody" >

			</tbody>
	</table>

</body>


<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="searchsystemstatedetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">参数维护
                 
                 <span style="margin-left: 150;color:red;" >[只容许填写提示框里面的值]</span>
                 
                 </h4>
            </div>
            <input type="hidden" class="systemstate_systemid" > </br>
            <div class="modal-body systemstate_set">
            <span >	 参数描述：</span>		<input type="text" class="systemstate_descname" > </br>
        
            
            <span >设置状态：</span>			<input  type="number" class=" systemstate_state" 
			> </br>
     
            </div>
            <div class="modal-footer">
            	<span style="margin-right: 150;color:red;" class="systemstate_about">11</span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary systemstate_update">更新</button>
            </div>
        </div>
    </div>
</html>