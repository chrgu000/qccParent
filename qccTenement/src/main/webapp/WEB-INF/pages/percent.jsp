<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/percent.js"></script>
<title>Insert title here</title>
</head>
<body>

       <div id ="percent_css">
				选择参数类型 ：
				<select style="width: 110px; margin-top: 15px;"onchange="search_percent_bytype()" id="percent_type">
					
				</select>
				<!-- 按钮触发模态框 -->
        <button class="btn btn-sm btn-primary percent_add " 
        
        style="margin-left: 15px;">添加</button>
		</div>
		
		

	<table id="commoninte_table" class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >参数主键</td>
				<td class ='visible-lg'  >百分比数</td>
				<td class ='visible-lg' >类别名称</td>
				<!--<td class ='visible-lg' >编辑</td>  -->
				<td class ='visible-lg' >删除</td>
				
			</tr>
			<tbody id="percent_body" >

			</tbody>
	</table>
	
	
	<!-- 模态框（Modal） -->
<div class="modal fade" id="notcheck_percent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加百分比</h4>
            </div>
            <div class="modal-body" >
            		<label  for="name">选择类型 :</label>
					<select id="perent_add_show">
					</select>  &nbsp; 	&nbsp; 
            		<label for="name">输入百分比:</label>
						<input  type="number"   
			   				class="percent_nub"	placeholder="输入0--100"> %
			   					
            </div>
            <div class="modal-footer">
            
            	<div style="margin-right: 350px;color: red;" class="error_metro"><span id="percent_error_span">ddd</span></div>
                 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                 <button type="button" class="btn btn-primary " onclick="percent_add()">确定</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>