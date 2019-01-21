<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/14
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,user-scalable=0">
    <title>支付</title>
    <link rel="stylesheet"
          href="//cdn.bootcss.com/weui/1.1.1/style/weui.min.css">
    <link rel="stylesheet"
          href="//cdn.bootcss.com/jquery-weui/1.0.1/css/jquery-weui.min.css">
    <link rel="stylesheet" href="#(ctxPath)/static/css/demos.css">
</head>
<body>
<body ontouchstart>
<div>
    <div class="bd">
        <div class="page__bd">
            <header class='demos-header'>
                <h1 class="demos-title">支付支付支付！！！</h1>
            </header>
            <div class="weui-btn-area">
                <a href="#" class="weui-btn weui-btn_primary" onclick="gzhPay()">微信公众号支付</a>
            </div>

        </div>
    </div>
    <div class="header" style="visibility: hidden">
        <div class="container black">
            <div class="qrcode">
                <div class="littlecode">
                    <!-- 没有会报错ALI38173,可以将其隐藏 -->
                    <img width="16px" src="img/little_qrcode.jpg" id="licode">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</body>

<script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>
<script>
    /*公众号支付*/
    function gzhPay() {
    	var appID = 'wx37a5a7281317047a'
    	var secret='0949f5a62f702d5c5862b8478425e157'
        var url = 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid='+APPID+'&secret='+secret 
        window.location.href=url;
    }
</script>

</html>