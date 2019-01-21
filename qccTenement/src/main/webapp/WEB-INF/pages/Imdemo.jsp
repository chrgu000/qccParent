<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
    <h1>ä</h1>
    <div>
    <p>
        <span>APPKEY:</span>
    <input type="text" id="appkey" value="00481cb45c031fe722c155d3f321dac0">
    </p>
    <p>
        <span>ACCOUNT:</span>
        <input type="text" id="account" value="10001713">
    </p>
    <p>
        <span>TOKEN:</span>
        <input type="text" id="token" value="b09ef1d9c98212f37bb852b2193508e9">
    </p>
    <p>
        <button id="connect-sdk">SDK</button>
    </p>
    </div>
    <script src="//yx-web.nos.netease.com/official/websdk/NIM_Web_SDK_v4.8.0.js"></script>
	
</body>
<script>
	
function connectSDK () {
  var appkey = document.getElementById('appkey').value
  var account = document.getElementById('account').value
  var token = document.getElementById('token').value
  window.nim = SDK.NIM.getInstance({
    appKey: appkey,
    account: account,
    token: token,
    onconnect: function () {
      alert('success')
      // è¿æ¥æååæè½åæ¶æ¯
      window.nim.sendText({
        scene: 'p2p',
        to: 'account',
        text: 'hello',
        done: function sendMsgDone (msg) {
        }
      })
    },
    ondisconnect: function (obj) {
      console.log('SDK è¿æ¥æ­å¼', obj)
    },
    onerror: function (error) {
      console.log('SDK è¿æ¥å¤±è´¥', error)
    }
  })
}

document.getElementById('connect-sdk').addEventListener('click', function () {
  connectSDK()
})
</script>
</html>