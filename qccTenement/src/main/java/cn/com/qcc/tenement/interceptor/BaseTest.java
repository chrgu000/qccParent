package cn.com.qcc.tenement.interceptor;

import io.rong.messages.BaseMessage;

public class BaseTest  extends BaseMessage{
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "type";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "string";
	}

}
