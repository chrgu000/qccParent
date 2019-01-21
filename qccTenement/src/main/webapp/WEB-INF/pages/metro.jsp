<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<title>热门城市地址维护</title>
</head>
<body>

		<div id ="metro_css">
				省 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(metro_1)" id="metro_1">
					
				</select>
				 市 ：
				<select style="width: 110px; margin-top: 15px;" id="metro_2">
				</select>
		</div>
	
		<input class="selectcode" type="hidden" value = "1">
		<div style="margin-left: 300px;margin-top: -30px;">
			<button class="btn btn-large  metro_search" type="button" >查询</button>
			<button class="btn btn-large metro_add" type="button" data-toggle="modal" data-target="#me_add">新增</button>
		</div>
		
		
		
		
		<table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >城市CODE</td>
				<td class ='visible-lg'  >城市名称</td>
				<td class ='visible-lg' >地铁名称</td>
				<td >站点名称</td>
				<td >编辑</td>
				<td >删除</td>
			</tr>
			<tbody id="metro_table" >

			</tbody>
	</table>


	<!-- 显示分页信息 -->
	<div class="row">
		<div class="col-md-3" id="metro_info_area"></div>
		<div class="col-md-9" id="metro_nav_area"> </div>
	 </div>


<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="me_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">城市地铁维护</h4>
            </div>
            <div class="modal-body">
			   				<input type="hidden" class="metro_metroid"/>
			  城市的编号：	<input type="text" class="metro_code"  readonly="readonly"
			  > </br>
          
            
          	 城市的名称：	<input type="text" class="metro_city"  readonly="readonly"
			  > </br>
          
            	地铁的名称：	<input type="text" class="metro_name" 
			  > </br>
           
            	地铁的站点：	<input type="text" class="metro_stop" 
			 > </br>
            </div>
            
            <div class="modal-footer">
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="error_span"></span></div>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary metro_insert">更新</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>