package cn.com.qcc.service;

import weixin.util.WeChatMessage;

public interface WeChatMessageService {

	String checkSignature(WeChatMessage weChatMessage);

}
