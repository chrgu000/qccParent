<%@ page language="java" contentType="text/html; charset=urf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta name="format-detection" content="telephone=yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black-divanslucent" />
    <meta name="msapplication-tap-highlight" content="no" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/Tenement/css/base.css">
    <title>七彩巢</title>
   
      
</head>
<body onunload='less()'> 
<form name="Form2" action="/Tenement/uploadImg" method="post"  enctype="multipart/form-data">
<h1>采用multipart提供的file.transfer方法上传文件</h1>
<input type="file" name="file">
<input type="submit" value="upload"/>
</form>

    <td>商品图片</td>
   	<form id="form1" action="" enctype="multipart/form-data" method="post">
        <input type="file" name="image"/>
      </form>  
 
    <button class="btn btn-large   upload" >文件上传</button>
<script type="text/javascript">
	$(function () {
		$('.upload').click(function () {
		 	$.ajax ({
		 		 data:$("#form1").serialize(),
                 type:"post",
		 		url:'/Tenement/uploadImg'
		 	})
		});
		
	});
</script>

<form action="/Tenement/testupload" method="post" enctype="multipart/form-data">
  <input type="file" name="image"/>
  <button type="submit">水印测试</button>
</form>

<span id="hisunred">11 </span>
<button class="btn btn-large  notreadmess" >获取未读消息</button>
<table id="table " class = "table	table-hover	 ">
			<tr>
				<td class ='visible-lg'  >消息类型</td>
				<td class ='visible-lg'  >最后一条内容</td>
				<td class ='visible-lg' >用户头像</td>
				<td class ='visible-lg' >点击导出</td>
				<td >当前会话未读</td>
				<td >删除</td>
			</tr>
			<tbody id="messageshow" >

			</tbody>
	</table>
<script type="text/javascript">
function init(params, callbacks, modules){
    // 初始化  基本信息
    var appKey = params.appKey;
    var token = params.token;
    var navi = params.navi || "";
    modules = modules || {};
    var RongIMLib = modules.RongIMLib || window.RongIMLib;
    var RongIMClient = RongIMLib.RongIMClient;
    var protobuf = modules.protobuf || null;

    var config = {};

    //私有云切换navi导航，私有云格式 '120.92.10.214:8888'
    if(navi !== ""){
        config.navi = navi;
    }

    //私有云切换api,私有云格式 '172.20.210.38:81:8888'
    var api = params.api || "";
    if(api !== ""){
        config.api = api;
    }

    //support protobuf url + function
    if(protobuf != null){
        config.protobuf = protobuf;
    };


    RongIMLib.RongIMClient.init(appKey,null,config);

    var instance = RongIMClient.getInstance();

    // 连接状态监听器
    RongIMClient.setConnectionStatusListener({
        onChanged: function (status) {
            // console.log(status);
            switch (status) {
                case RongIMLib.ConnectionStatus["CONNECTED"]:
                case 0:
                    console.log("连接成功")
                    callbacks.getInstance && callbacks.getInstance(instance);
                    
                    break;

                case RongIMLib.ConnectionStatus["CONNECTING"]:
                case 1:
                    console.log("连接中")
                     RongIMClient.getInstance().getConversationList({
					    onSuccess: function(list) {
					     //获取消息列表
					     getmessagelist(list);
					    },
					    onError: function(error) {
					       // do something...
					    }
					  },null);
                    break;

                case RongIMLib.ConnectionStatus["DISCONNECTED"]:
                case 2:
                    console.log("当前用户主动断开链接")
                    break;

                case RongIMLib.ConnectionStatus["NETWORK_UNAVAILABLE"]:
                case 3:
                    console.log("网络不可用")
                    break;

                case RongIMLib.ConnectionStatus["CONNECTION_CLOSED"]:
                case 4:
                    console.log("未知原因，连接关闭")
                    break;

                case RongIMLib.ConnectionStatus["KICKED_OFFLINE_BY_OTHER_CLIENT"]:
                case 6:
                    console.log("用户账户在其他设备登录，本机会被踢掉线")
                    break;

                case RongIMLib.ConnectionStatus["DOMAIN_INCORRECT"]:
                case 12:
                    console.log("当前运行域名错误，请检查安全域名配置")
                    break;
            }
        }
    });

    /*
     文档：http://www.rongcloud.cn/docs/web.html#3、设置消息监听器

     注意事项：
     1：为了看到接收效果，需要另外一个用户向本用户发消息
     2：判断会话唯一性 ：conversationType + targetId
     3：显示消息在页面前，需要判断是否属于当前会话，避免消息错乱。
     4：消息体属性说明可参考：http://rongcloud.cn/docs/api/js/index.html
     */
  
    RongIMClient.setOnReceiveMessageListener({
        // 接收到的消息
        onReceived: function (message) {
        	getTotalUnreadCount();
        	getHistoryMessages()
            // 判断消息类型
            console.log("new"+message);
            console.log("新消息: " + message.targetId);
            console.log("内别"+message.conversationType);
            
            callbacks.receiveNewMessage && callbacks.receiveNewMessage(message);
        }
    });

    //开始链接
    console.log(token);
    RongIMClient.connect(token, {
    	
        onSuccess: function(userId) {
            callbacks.getCurrentUser && callbacks.getCurrentUser({userId:userId});
            console.log("链接成功，用户id：" + userId);
           // getHistoryMessages()
           
			
        },
        onTokenIncorrect: function() {
            console.log('token无效');
        },
        onError:function(errorCode){
            console.log(errorCode);
        }
    });
    
    		
}
</script>
<script src="/Tenement/js/common.js"></script>
<script src="//cdn.ronghub.com/RongIMLib-2.2.8.min.js"></script>
<script src="//cdn.ronghub.com/RongEmoji-2.2.5.min.js"></script>
<script type="text/javascript">
      var IMName,
        IMUserId1,
        IMNameImg,
        IMyImg,
        IMUserId = sessionStorage.otherUserid,
        appKEY = "8w7jv4qb8ckny",
//      appKEY = "mgb7ka1nmw5lg",
        token = "EVsC2WPxRoneW9Y90jUFg4nWxWlw7T13zmayle4HI0/4FRbDLbYJFdWZfFa4SlAYy537fTB0CeY6l0vTeI/+0JXR/a0eLZCK";
</script>

<form action="/Tenement/uploadImg" method="post" enctype="multipart/form-data">
  <input type="file" name="image"/>
  <button type="submit">七牛云上传</button>
</form>
<script type="text/javascript">
  function less(){
          getDeital();
     // 定义消息类型
    }
    // 初始化
    startInit(); 
    // 发送
    $('#postMeg').on('click',function(){
      $(this).css({"background-color": "red"});
      setTimeout('$("#postMeg").css({"background-color": "#26AA1C"})',300);
      getMessage();
   });
   
    //点击放回
    $(".back").on('click', function () {
       

        window.history.back();
    });
    
    $('#goDetail').on('click',function(){
    	location.href='./UserDetail.html';
    })

      function getDeital(){
            console.log(IMUserId1);
        $.post(ZFOBJ.ServerUrl +'/group/syncpcmsg',{userid:IMUserId1,followUserId:localStorage.userId,content:sessionStorage.jilus},function(res){
        })
      }
  
    function registerMessage(type){
        var messageName = type; // 消息名称。
        var objectName = "s:" + type; // 消息内置名称，请按照此格式命名 *:* 。
        var mesasgeTag = new RongIMLib.MessageTag(true,true); //true true 保存且计数，false false 不保存不计数。
        var propertys = ["name","age","gender"]; // 消息类中的属性名。

        RongIMClient.registerMessageType(messageName, objectName, mesasgeTag, propertys);
    }
    
    // 进行初始化
    function startInit(user,targetId){
        var params = {
            appKey : '8w7jv4qb8ckny',
            token : 'EVsC2WPxRoneW9Y90jUFg4nWxWlw7T13zmayle4HI0/4FRbDLbYJFdWZfFa4SlAYy537fTB0CeY6l0vTeI/+0JXR/a0eLZCK',
            navi : ""
        };
        var userId = "";

        var callbacks = {
            getInstance : function(instance){
                RongIMLib.RongIMEmoji.init();
                registerMessage("PersonMessage");
            },
            getCurrentUser : function(userInfo){
                console.log(userInfo.userId);
                userId = userInfo.userId;
                // alert("链接成功；userid=" + userInfo.userId);
                getTotalUnreadCount();
              //  cleanmess ();
                getHistoryMessages(); 
            },
            receiveNewMessage : function(message){
                //判断是否有 @ 自己的消息
                var mentionedInfo = message.content.mentionedInfo || {};
                var ids = mentionedInfo.userIdList || [];
                for(var i=0; i < ids.length; i++){
                    if( ids[i] == userId){
                        alert("有人 @ 了你！");
                    }
                }
                showResult("#imLibList",message);
                    $('.flImg').on('click', function () {
             	console.log(IMUserId1);
	          sessionStorage.otherUserid = IMUserId1;
	          location.href = './userpage.html'
	        })
                // messageOutput(message);
            }
        };

        init(params,callbacks);
    }
    function getValue(id){
        return document.getElementById(id).value;
    }

    function cleanmess () {
    	 console.log('tt');
    	  var clearUnreadCount = RongIMClient.getInstance().clearUnreadCount;

    	    clearUnreadCount('1', '10000525', {

    	        onSuccess: function () {
    	        	console.log('cett');
    	        },

    	        onError: function (errorCode) {
    	        	console.log('1cett');
    	        }

    	    });
    }
    function getTotalUnreadCount(){
		/*
			阅读时间戳缓存在 localStorage 中，消息状态根据发送时间和阅读时间戳对比判断
			每次接受新消息后通过重新调用此方法计算
		 */
		var start = new Date().getTime();
		RongIMClient.getInstance().getTotalUnreadCount({
		  onSuccess:function(count){
			  $('#hisunred').text(count);
		       console.log("获取总未读数成功--", count, start);
		  },
		  onError:function(error){
		        console.log("获取总未读数失败", error, start);
		  }
		});
	}
    //此方法可以在列表页面中拿到最后一条消息的内容列表
    function getmessagelist(list){
  	  console.log('--------------');
      var from = $('#messageshow').empty();
        console.log(list);
      $.each(list,function(index, value) {
    	  var type = value.conversationType
    	  var extra = value.latestMessage.content.extra;
    	  if (type == 3) {
    		  extra = extra.split(',')[1];
    	  }
    	  var unread = value.unreadMessageCount;
   	   		//value.latestMessage.content.extra 这里是获得用户头像和，昵称 最后一条消息
   	   		//value.latestMessage.content.content 这里是获得聊天内容           最后一条消息
   		   var str = '<tr><td>'+type+'</td><td>'+value.latestMessage.content.content+'</td>'+
   		   '<td>'+extra+'</td><td>'+value.latestMessage.sentTime+'</td><td>'+unread+'<td></tr>';
   		   from.append(str);
   	  
   	   console.log(value.conversationType);
      });
   	  console.log('--------------');
    }
    
    // $('#postMeg').click(function () {
    //     getMessage();
    // }) 
    // 获取历史聊天记录
    //请确保单群聊消息云存储服务开通，且开通后有过收发消息记录
    function getHistoryMessages(){
    	 console.log('获取历史消息中...');
       var conversationType = '6' ;//单聊,其他会话选择相应的消息类型即可。
       var targetId1 = '10000209'; // 想获取自己和谁的历史消息，targetId 赋值为对方的 Id。
       console.log(targetId1);
       var timestrap = null; // 默认传 null，若从头开始获取历史消息，请赋值为 0 ,timestrap = 0;
       var count = 20; // 每次获取的历史消息条数，范围 0-20 条，可以多次获取。
       RongIMClient.getInstance().getHistoryMessages(conversationType, targetId1, timestrap, count, {
      	onSuccess: function(list, hasMsg) {
      	console.log(list);
      },
      onError: function(error) {
      console.log("GetHistoryMessages,errorcode:" + error);
                    }
              });
     }

</script>
</body>
</html>