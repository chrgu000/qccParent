<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/Tenement/js/parerrule.js"></script>
<title>Insert title here</title>
</head>
<body>
     <table id="table " class = "table	table-hover	 ">
			<tr>
				<td >规则主键</td>
				<td  >规则描述</td>
				<td >操作</td>
			</tr>
			<tbody id="parerrule_body" >

			</tbody>
	</table>
</body>


<!-- 模态框（Modal） -->
<div style="margin-top: 10px;"  class="modal fade" id="update_parerrule" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" >
        <div class="modal-content" style="height:600px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title parar_name" id="myModalLabel" >规格维护</h4>
                <input  class="parar_id" type="hidden" value ="1">
            </div>
           <textarea style="height:440px;" class="form-control parar_pararuledetail" rows="3" name=textarea></textarea>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary parar_update">维护</button>
            </div>
        </div>
    </div>
</div>
</html>