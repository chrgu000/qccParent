package cn.com.qcc.detailcommon;

import com.alibaba.fastjson.JSONObject;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PayCommonConfig;
import weixin.util.MD5Util;

public class WX_UserUtil {
	
	 //private static Logger log = LoggerFactory.getLogger(WX_UserUtil.class);
	    /**
	     * 根据微信openId 获取用户是否订阅
	     * @param openId 微信openId
	     * @return 是否订阅该公众号标识
	     */
	    public static Integer subscribeState(String openId , String ACCESS_TOKEN){
	    	
	    	if (CheckDataUtil.checkisEmpty(openId)
	    			|| CheckDataUtil.checkIsEmaile(ACCESS_TOKEN)) {
	    		return -1;
	    	}
	        String tmpurl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ ACCESS_TOKEN +"&openid="+openId;
	        JSONObject result = WX_HttpsUtil.httpsRequest(tmpurl, "GET",null);
	        JSONObject resultJson = new JSONObject(result);
	        String errmsg = (String) resultJson.get("errmsg");
	        if(errmsg==null){
	            //用户是否订阅该公众号标识（0代表此用户没有关注该公众号 1表示关注了该公众号）。
	            Integer subscribe = (Integer) resultJson.get("subscribe");
	            return subscribe;
	        }
	        return -1;
	    }

}
