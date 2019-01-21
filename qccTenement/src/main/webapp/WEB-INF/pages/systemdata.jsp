<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/systemdata.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	    <button  style="margin-top: 50px; type="button" class="btn btn-primary layout_sure">
			索引库地址
		</button>
		<button style="margin-top: 50px; type="button" class="btn btn-primary resetstart">
			重置开始
		</button>
		<button style="margin-top: 50px; type="button" class="btn btn-primary" onclick="makeSolrprePage('buil_solr_next')">
			上一组
		</button>
		<button style="margin-top: 50px; type="button" class="btn btn-primary"
		onclick="makeSolrNextPage('buil_solr_next')">
		 下一组</button>
		<div><h4>注意：导入单位万(起始位置指的是ID)</h4></div>
		  开始位置:<input class="buil_solr_next_start" type="text" value="0" readonly="readonly" style="width: 100px;"/>  
		结束结束:<input class="buil_solr_next_end" type="text" value="2" readonly="readonly"style="width: 100px;"/>
	<div style="margin-top: 10px;margin-left: 10px;">
		 
		
		<button style="margin-top: 10px; type="button" class="btn btn-primary buil_onekey_tosolr"
		data-toggle="modal" data-target="#solrTip">
		 楼栋索引库一键重构</button>
		 
	
	</div>
	
	<div style="margin-top: 10px;margin-left: 10px;">
		
		<button style="margin-top: 10px; type="button" class="btn btn-primary house_onekey_tosolr"
		data-toggle="modal" data-target="#solrTip">
		房源索引库一键重构</button>
	
	</div>
	
	<div style="margin-top: 10px;margin-left: 10px;">
	
		<button style="margin-top: 10px; type="button" class="btn btn-primary qiuzu_onekey_tosolr"
		data-toggle="modal" data-target="#solrTip">
			求租索引库一键重构
		</button>
	</div>
	
	
<!-- 模态框（Modal） -->
<div style="margin-top: 10px;"  class="modal fade" id="solrTip" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" >
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title  solrTiph4" id="myModalLabel "></h4>
            </div>
           <span></span>
            <div class="modal-footer tipDiv">
                <button type="button" class="btn btn-primary parar_update">确定维护</button>
            </div>
        </div>
    </div>
</div>
	
</body>
</html>