<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <link href="/Tenement/css/font-awesome.min.css"  rel="stylesheet">

      <link rel="stylesheet" type="text/css" media="all" href="/Tenement/css/daterangepicker-bs3.css" />

      <script type="text/javascript" src="/Tenement/js/moment.js"></script>
      <script type="text/javascript" src="/Tenement/js/daterangepicker.js"></script>
</head>


 <body>
 				<input id="start" type="hidden" value = ""/>
 				<input id="end" type="hidden" value = ""/>
		
               <form class="form-horizontal">

                 <fieldset>

                  <div class="control-group">

                    <div class="controls">

                     <div class="input-prepend input-group">

                       <span class="add-on input-group-addon">
                       <i class="glyphicon glyphicon-calendar fa fa-calendar"></i></span>
                       <input type="text" readonly style="width: 200px" name="reservation" id="reservation" class="form-control" value="请选择一个日期" /> 
						
                     </div>

                    </div>

                  </div>

                 </fieldset>
				
               </form>
            总计：  <span id="qiuzu_count">0</span>
		 <button style="margin-left: 500px;margin-top: -22px;" class="btn btn-large btn-primary sendmess_search" type="button" >
		 查询</button>
		 <button style="margin-top: -23px;" data-toggle="modal" data-target="#qiuzu_data"   class="btn btn-large btn-primary sendmess_out" type="button" >
		 群发短信</button>
               <script type="text/javascript">
               $(document).ready(function() {
                  $('#reservation').daterangepicker(null, function(start, end, label) {
                	  $("#start").val(start.toISOString());
                	  $("#end").val(end.toISOString());
                    console.log(start.toISOString(), end.toISOString(), label);
                  });

               });

               </script>



         
 	 <table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >用户主键</td>
				<td class ='visible-lg'  >用户昵称</td>
				<td class ='visible-lg' >联系人</td>
				<td >联系电话</td><td >发布时间</td>
			</tr>
			<tbody id="qiuzu_sendmess" >

			</tbody>
	</table>



<!-- 模态框（Modal） -->
<div class="modal fade" id="qiuzu_data" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">群发短信</h4>
            </div>
            <div class="modal-body">
            		
            		<label for="name">数目</label>
						<input type="text" class="form-control qiuzu_count"  
			   					placeholder="请输入需要群发的用户数量" > 
			   					<label for="name">内容</label>
						<input type="text" class="form-control qiuzu_content" 
			   					placeholder="请输入要群发的内容"> 
            </div>
            <div class="modal-footer">
            	<span id="sendresult" style="margin-right: 150px;color: red;" >*群发短信前，请先编辑好参数</span>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary sendqiuzu_out">群发</button>
            </div>
        </div>
    </div>
</div>
          
   </body>


</html>
