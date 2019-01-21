package cn.com.qcc.detailcommon;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Test {
	
	 public static void main(String[] args) {
	        //新增用户成功 - 推送微信消息
	        senMsg("oYQk1xOU_re4F2bIbTfRvSgTh42k");
	    }
	   static void senMsg(String openId){
	        //用户是否订阅该公众号标识 (0代表此用户没有关注该公众号 1表示关注了该公众号)
	        Integer  state= WX_UserUtil.subscribeState(openId);
	        // 绑定了微信并且关注了服务号的用户 , 注册成功-推送注册短信
	        if(state==1){
	            Map<String,TemplateData> param = new HashMap<>();
	            param.put("first",new TemplateData("恭喜您注册成功！","#696969"));
	            param.put("keyword1",new TemplateData("15618551533","#696969"));
	            param.put("keyword2",new TemplateData("2017年05月06日","#696969"));
	            param.put("remark",new TemplateData("祝投资愉快！","#696969"));
	            //注册的微信-模板Id
	            String regTempId =  "HzOAui_3iigZfaXLuvPPlm5iueTJC02w2j8BoLKcB7I";
	            //调用发送微信消息给用户的接口
	            WX_TemplateMsgUtil.sendWechatMsgToUser(openId,regTempId, "", "#000000", packJsonmsg(param));
	        }
	    }
	   /**
	     * 封装模板详细信息
	     * @return
	     */
	    public static JSONObject packJsonmsg(Map<String, TemplateData> param) {
	        JSONObject json = new JSONObject();
	        for (Map.Entry<String,TemplateData> entry : param.entrySet()) {
	            JSONObject keyJson = new JSONObject();
	            TemplateData  dta=  entry.getValue();
	            keyJson.put("value",dta.getValue());
	            keyJson.put("color", dta.getColor());
	            json.put(entry.getKey(), keyJson);
	        }
	        return json;
	    }


}
