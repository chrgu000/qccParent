<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Tenement/js/village.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function getvl(){ 
	var file = $('#file');
	alert(file.val());
} 


</script>

<body>	

	<input name="" type="button" value="获取" onClick="getvl()">
	<span id="text"></span>
	<form name="Form2" id="tf" method="post" action="/Tenement/videoUpload" enctype="multipart/form-data">
		<input   type="file" multiple name="file"   id="file" width="50px">
		<!--< img  style="position: absolute;" src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2375920824,1229333302&fm=27&gp=0.jpg" alt="" />-->
		<button type="submit">提交视频</button>
	</form>
	
	<div id ="village_css">
				省 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(v_1)" id="v_1">
				</select>
				 市 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(v_2)" id="v_2">
				</select>
				 区 ：
				<select style="width: 110px; margin-top: 15px;"onchange="getnextaddress(v_3)" id="v_3">
				</select>
				 街 ：
				<select class="village_v4" style="width: 110px; margin-top: 15px;"id="v_4">
				</select>
				
			</div>	
			<table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >ID</td>
				<td class ='visible-lg'  >CODE</td>
				<td class ='visible-lg' >名称</td>
				<td >楼栋</td>
				<td>编辑</td>
				<td>地铁</td>
			</tr>
			<tbody id="village_list" >

			</tbody>
	</table>
	
	
	
	
	
	<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="village_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">小区编辑</h4>
            </div>
            <div class="modal-body building_set">
            		<input type="hidden" class="village_villageid"/>
            		<input type="hidden" class="village_code"/>
				<span>小区的名称：</span>		<input type="text" class=" village_typename" 
			  > </br>
			  
				<span>	房屋的总数：</span>	<input type="text" class=" village_housecount" 
			  > </br>
			   
			<span>  完成的年份：</span>		<input type="text" class=" village_comyear" 
			  > </br>
          
            
          	<span> 停车费用：</span>		<input type="text" class=" village_carfree" 
			  > </br>
          
            
            <span> 物业费用：</span>			<input type="text" class=" village_comfree" 
			  > </br>
            <span> 物业公司：</span>			<input type="text" class=" village_company" 
			  > </br>
            
            <span>	 物业电话：</span>		<input type="text" class=" village_comphone" 
			 > </br>
        
            
            <span>车位数：</span>			<input type="text" class=" village_carcount" 
			> </br>
          
            
            <span> 楼栋总数：</span>			<input type="text" class=" village_comcount" 
			 > </br>
          
            
         	<span>开发商电话：	</span>	   <input type="text" class=" village_devephone" 
			   > </br>
         
            
         	<span>开发商：</span>	   	<input type="text" class=" village_developer" 
			   > </br>
          
            
           <span>村委电话：</span>		<input type="text" class=" village_villagephone" 
			  > </br>
			  <span>关键字：</span>		<input type="text" class=" village_keyword" 
			  > </br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary village_update">更新</button>
            </div>
        </div>
    </div>
</div>






<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="building_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">楼栋编辑</h4>
            </div>
            <div class="modal-body">
            		<input type="hidden" class="building_code" value=""/>
            		<input type="hidden" class="show_finalstop" value=""/>
            		<input type="hidden" class="show_metroname" value=""/>
            		<input type="hidden" class="building_buildingid"/>
            		<input type="hidden" class="building_villageid"/>
            		<input type="hidden" class="building_brandid" value="-1"/>
					楼栋的名称：	<input type="text" class=" form-control building_building"  style="width:200px; display: inline-block;"
			  > <br>
			  	房屋的编码：	<input type="text" class="form-control building_num" style="width:200px; display: inline-block;" readonly="readonly"
			  > </br>
					
			 联系人名称：	<input type="text" class="form-control building_linkman" style="width:200px; display: inline-block;"
			  > </br>
          	 联系人电话：	<input type="text" class="form-control building_linkphone" style="width:200px; display: inline-block;"
			  > </br>
          
                         楼栋的房东：	<input type="text" class="form-control building_land" style="width:200px; display: inline-block;"
			   > </br>
            	 房东的电话：	<input type="text" class="form-control building_landphone" style="width:200px; display: inline-block;"
			 > </br>
        
           
            	 楼栋的门牌：	<input type="text" class=" form-control building_bnumber"style="width:200px; display: inline-block;"
			 > </br>
          
         	 
			      详情的地址：	<input type="text" class="form-control building_detailes" style="width:350px; display: inline-block;"
			   > </br>
          <div >
          	<div style="margin-top: 10px;"> 楼栋的品牌：</div>
        
		<div  style="position:relative;margin-left: 90px; margin-top: -10px;">  
              <select style="width:200px;  height: 30px;  "   class="brandselect"
                      onchange="setchangebrand()">  
              </select>  
              <input id="input" name="input" style="width: 180px;" value="无品牌" class="building_brand">  
        </div>  
			  
			  
			  <div style="margin-top: 10px;" >
			  	 附近地铁站：<select  id = "metro_byname_2"  onchange="metro_byname_2()" name="numUnit" class="form-control metro_byname" style="width:120px; display: inline-block;"></select>
     		<select  id="metro_detail_2"  name="numUnit" class="form-control " style="width: 120px; display: inline-block;"></select>
			  </div>
   			
   		</div>
         
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary building_update">更新</button>
            </div>
        </div>
    </div>
</div>


	<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="metro_village" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">小区一键地铁维护</h4>
                <h5 style="color:red;" class="modal-title" id="myModalLabel">* * * 进行此操作时候,该小区下面的楼栋。都统一到某一个地铁路线</h5>
            </div>
            <div class="modal-body">
            		<input type="hidden" class="metro_villageid"/>
					小区的编号：	<input type="text" class=" metro_villagecode" 
			  > </br>
			  
					小区的名称：	<input type="text" class=" metro_villagename" 
			  > </br>
            
          <!-- 	地铁的站点：	<input type="text" class=" metro_villagafinal" 
			  > </br>
        <select id="numUnit" name="numUnit" class="form-control" style="width: 120px;"></select> -->
   		<div style="margin-top: 10px;">
   			 附近地铁站：<select id="metro_byname"  onchange="metro_byname()" name="numUnit" class="form-control " style="width:120px; display: inline-block;"></select>
     		<select id ="metro_detail"  name="numUnit" class="form-control " style="width: 120px; display: inline-block;"></select>
   		</div>
    
         
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary metro_updatevillage">更新</button>
            </div>
        </div>
    </div>
</div>



<!-- 模态框（Modal） -->
<div  class="village_model modal fade  " id="getbrand" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">小区一键地铁维护</h4>
                <h5 style="color:red;" class="modal-title" id="myModalLabel">* * * 进行此操作时候,该小区下面的楼栋。都统一到某一个地铁路线</h5>
            </div>
            <div class="modal-body">
            		<input type="hidden" class="metro_villageid"/>
					小区的编号：	<input type="text" class=" metro_villagecode" 
			  > </br>
			  
					小区的名称：	<input type="text" class=" metro_villagename" 
			  > </br>
            
          <!-- 	地铁的站点：	<input type="text" class=" metro_villagafinal" 
			  > </br>
        <select id="numUnit" name="numUnit" class="form-control" style="width: 120px;"></select> -->
   		<div style="margin-top: 10px;">
   			 附近地铁站：<select id="metro_byname"  onchange="metro_byname()" name="numUnit" class="form-control " style="width:120px; display: inline-block;"></select>
     		<select id ="metro_detail"  name="numUnit" class="form-control " style="width: 120px; display: inline-block;"></select>
   		</div>
    
         
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary metro_updatevillage">更新</button>
            </div>
        </div>
    </div>
</div>


        <head>  
        <title>可编辑下拉框</title>  
        <meta charset="UTF-8" />  
        <style type="text/css">  
        /*input css*/  
        .building_brand{  
            position: absolute;  
            width: 99px;  
            height: 25px;  
            left: 1px;  
            top: 2px;  
            border-bottom: 0px;  
            border-right: 0px;  
            border-left: 0px;  
            border-top: 0px;  
        }  
        </style>  
    </head>

</body>
</html>